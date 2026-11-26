package com.modirk.command;

import com.modirk.config.ModConfigs;
import com.modirk.race.Race;
import com.modirk.race.RaceData;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

/**
 * {@code /race} komut ağacı.
 *
 * <ul>
 *   <li>{@code /race} — kendi ırkını gösterir.</li>
 *   <li>{@code /race get <oyuncu>} — başka bir oyuncunun ırkını gösterir.</li>
 *   <li>{@code /race set <oyuncu> <ırk>} — yetkili: ırk atar.</li>
 *   <li>{@code /race clear <oyuncu>} — yetkili: ırkı siler.</li>
 *   <li>{@code /race list} — geçerli ırk kimliklerini listeler.</li>
 * </ul>
 *
 * <p>Normal oyuncu ırkını yalnızca ritüelle alır; komutlar yönetici/test içindir.</p>
 */
public final class RaceCommand {
    private static final String ARG_PLAYER = "player";
    private static final String ARG_RACE = "race";

    private RaceCommand() {
    }

    public static void onRegisterCommands(RegisterCommandsEvent event) {
        register(event.getDispatcher());
    }

    private static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("race")
                .executes(context -> showSelf(context.getSource()))
                .then(Commands.literal("get")
                        .executes(context -> showSelf(context.getSource()))
                        .then(Commands.argument(ARG_PLAYER, EntityArgument.player())
                                .executes(context -> showTarget(
                                        context.getSource(),
                                        EntityArgument.getPlayer(context, ARG_PLAYER)))))
                .then(Commands.literal("set")
                        .requires(RaceCommand::canManage)
                        .then(Commands.argument(ARG_PLAYER, EntityArgument.player())
                                .then(Commands.argument(ARG_RACE, StringArgumentType.word())
                                        .suggests((context, builder) ->
                                                SharedSuggestionProvider.suggest(Race.playableIds(), builder))
                                        .executes(context -> setRace(
                                                context.getSource(),
                                                EntityArgument.getPlayer(context, ARG_PLAYER),
                                                StringArgumentType.getString(context, ARG_RACE))))))
                .then(Commands.literal("clear")
                        .requires(RaceCommand::canManage)
                        .then(Commands.argument(ARG_PLAYER, EntityArgument.player())
                                .executes(context -> clearRace(
                                        context.getSource(),
                                        EntityArgument.getPlayer(context, ARG_PLAYER)))))
                .then(Commands.literal("list")
                        .executes(context -> listRaces(context.getSource()))));
    }

    private static boolean canManage(CommandSourceStack source) {
        return source.hasPermission(permissionLevel());
    }

    private static int permissionLevel() {
        try {
            return ModConfigs.COMMAND_PERMISSION_LEVEL.get();
        } catch (IllegalStateException ignored) {
            return 2;
        }
    }

    private static int showSelf(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        Race race = RaceData.get(player);
        source.sendSuccess(() -> Component.translatable("command.modirk.race.self", race.getDisplayName()), false);
        return race.isPlayable() ? 1 : 0;
    }

    private static int showTarget(CommandSourceStack source, ServerPlayer target) {
        Race race = RaceData.get(target);
        source.sendSuccess(() -> Component.translatable("command.modirk.race.other",
                target.getDisplayName(), race.getDisplayName()), false);
        return race.isPlayable() ? 1 : 0;
    }

    private static int setRace(CommandSourceStack source, ServerPlayer target, String rawRace) {
        Race race = Race.byId(rawRace);
        if (race == null || !race.isPlayable()) {
            source.sendFailure(Component.translatable("command.modirk.race.unknown", rawRace, Race.playableIdList()));
            return 0;
        }

        Race previous = RaceData.get(target);
        if (previous == race) {
            source.sendSuccess(() -> Component.translatable("command.modirk.race.already",
                    target.getDisplayName(), race.getDisplayName()), false);
            return 0;
        }

        RaceData.set(target, race);
        source.sendSuccess(() -> Component.translatable("command.modirk.race.set",
                target.getDisplayName(), race.getDisplayName()), false);

        if (announceRaceChange()) {
            target.server.getPlayerList().broadcastSystemMessage(
                    Component.translatable("command.modirk.race.announce",
                            target.getDisplayName(), race.getDisplayName()), false);
        }
        return 1;
    }

    private static int clearRace(CommandSourceStack source, ServerPlayer target) {
        if (!RaceData.hasRace(target)) {
            source.sendSuccess(() -> Component.translatable("command.modirk.race.none",
                    target.getDisplayName()), false);
            return 0;
        }

        RaceData.clear(target);
        source.sendSuccess(() -> Component.translatable("command.modirk.race.cleared",
                target.getDisplayName()), false);
        return 1;
    }

    private static int listRaces(CommandSourceStack source) {
        source.sendSuccess(() -> Component.translatable("command.modirk.race.list", Race.playableIdList()), false);
        return Race.PLAYABLE.size();
    }

    private static boolean announceRaceChange() {
        try {
            return ModConfigs.ANNOUNCE_RACE_CHANGE.get();
        } catch (IllegalStateException ignored) {
            return true;
        }
    }
}
