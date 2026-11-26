# Races (modirk)

> **Status: early development (M1 complete, M2 in progress).** The race data layer and the first ritual block — the Spirit Pedestal — exist; rituals, bosses and fortresses are still being built.

Races is a [NeoForge](https://neoforged.net/) mod for **Minecraft 1.21.1**. Three fallen guardians have seized the castles of the Nether. Defeat them, claim their **Spirit Stones**, and perform a demanding ritual in the Nether to inherit one of their powers.

## What is Races?

You do not simply craft a race. You earn it.

1. Find and conquer one of the three Nether fortresses.
2. Defeat its boss and take the **Spirit Stone**; sword pieces drop from the boss and its chests.
3. Forge a **Cursed Stone** at the **Spirit Forge Table** from 3 sword pieces and your race's material.
4. Build the ritual site yourself, in the Nether.
5. Complete the ritual: Spirit Stone, Cursed Stone, offerings, experience, guardian waves, and an uninterrupted channel. There is no time or weather requirement; the Cursed Stone starts a 5-minute **Corruption Phase** instead.
6. Bind the guardian's power and become one of three races.

Every boss is repeatable: new fortresses generate, so new Spirit Stones can be obtained.

## Commands

`/race` exists for administration and testing. Normal players receive a race only through the ritual.

| Command | Permission | Description |
|---|---|---|
| `/race` | everyone | Show your own race |
| `/race get <player>` | everyone | Show another player's race |
| `/race set <player> <race>` | level 2 (configurable) | Assign `redstone`, `builder`, or `pvp` |
| `/race clear <player>` | level 2 (configurable) | Remove the player's race |
| `/race list` | everyone | List valid race ids |

## Configuration

The server config is written to `config/modirk-server.toml` (per world).

| Key | Default | Description |
|---|---|---|
| `race.keepRaceOnDeath` | `true` | Keep the race after death. When `false`, dying resets the race and the ritual must be repeated. |
| `race.announceRaceChange` | `true` | Announce race changes in chat. |
| `commands.permissionLevel` | `2` | Permission level required for `/race set` and `/race clear`. |

## Planned races

| Race | Identity | Weakness |
|---|---|---|
| **Redstone Engineer** | **Spirit Pocket** — a bound redstone inventory. Items can only be placed, never stored, dropped, or crafted. Broken bound blocks return to the owner's pocket. | **Corrupted Hearts** — starts with 2 corrupted hearts. Depleting item limits earns seals; 2 seals cleanse 1 heart permanently. The pocket only refills through a light ritual with a new Spirit Stone. |
| **Builder** | **Natural block reward** — breaking naturally generated building blocks has a 15% chance to drop 3–4 extra items. | −15% PvP damage. |
| **PvP Fighter** | **Adrenaline** — attack speed scales with missing health. | Every successful hit before the weapon's vanilla cooldown consumes hunger. |

## Planned content

- Three Nether fortress variants (Nether-fortress style, partially corrupted by each guardian's spirit): **Signal Sovereign**, **Grand Architect**, **Blood Warden**.
- Three animated bosses (GeckoLib), two phases each.
- **Sword pieces** from boss and fortress loot; forge them into themed boss swords at the **Spirit Forge Table**.
- **Cursed Stone** — 3 sword pieces plus a race material (Redstone Block / Quartz Block / Netherite Sword); starts the 5-minute Corruption Phase and applies race-specific effects to hostile mobs.
- Combine the three forged boss swords with a Nether Star to forge the **Spirit Breaker**, which resets your race.
- Player-built ritual multiblock (altar, three **Spirit Pedestals**, four pillars), Nether-only.
- **Spirit Pedestal** — displays a single item floating and slowly rotating above it; used for offerings and for showing off spirit relics.
- Spirit Pocket UI, HUD, advancements, English and Turkish localization.
- The three spirit items will later become **3D GeckoLib animated items**; modeling is planned for a later milestone.

## Current state

| Area | State |
|---|---|
| NeoForge 1.21.1 project, Gradle build | ✅ Working |
| Three spirit items + creative tab | ✅ Working |
| Tooltips, English and Turkish localization | ✅ Working |
| Spirit item textures (64×64 pixel art) | ✅ Final |
| Mod logo | ✅ Added |
| Race data (attachment), `/race` commands, config, keep-on-death | ✅ Working |
| Spirit Pedestal (block, block entity, floating display) | ✅ Working |
| Races mechanics, rituals, bosses, fortresses | ❌ Not implemented |
| 3D animated item models | ❌ Planned (GeckoLib) |

## Requirements

- Minecraft **1.21.1**
- NeoForge **21.1.x**
- [GeckoLib](https://www.curseforge.com/minecraft/mc-mods/geckolib) **4.7+** (required at runtime)
- **JDK 21** to build from source

## Installation (players)

1. Install Minecraft 1.21.1 with NeoForge 21.1.x.
2. Put the Races jar and GeckoLib into your `mods/` folder.
3. Launch the game.

## Building from source

The Gradle wrapper downloads Gradle automatically. JDK 21 is required.

```powershell
# Windows (finds JDK 21 automatically)
.\build.ps1

# Windows (classic)
.\gradlew.bat build

# Linux / macOS (finds JDK 21 automatically)
./build.sh

# Linux / macOS (classic)
./gradlew build
```

The built jar is placed in `build/libs/`.

Run the client in a development environment:

```powershell
.\build.ps1 runClient
# or
.\gradlew.bat runClient
```

## Project structure

```
src/main/java/com/modirk/
├── Modirk.java              mod entry point
├── block/                   Spirit Pedestal block + block entity
├── client/                  block entity renderer
├── command/RaceCommand.java /race command tree
├── config/ModConfigs.java   server config (keep-on-death, permissions)
├── race/                    Race enum, RaceData helpers, RaceEvents
├── item/RaceSpiritItem.java spirit item with tooltip
└── registry/                items, blocks, block entities, creative tab, attachments

src/main/resources/
├── META-INF/neoforge.mods.toml
├── pack.mcmeta
├── logo.png
└── assets/modirk/
    ├── blockstates/
    ├── lang/                en_us, tr_tr
    ├── models/block/        block models
    ├── models/item/
    └── textures/
        ├── block/
        └── item/
```

## Roadmap

- [x] **M0** — NeoForge 1.21.1 skeleton, clean repository, working build
- [x] **M1** — race data (attachment), `/race` commands, config, keep-on-death
- [ ] **M2** — Spirit Stone, altar, ritual multiblock, ritual tablet, Spirit Forge Table, Cursed Stone
- [ ] **M3** — Nether fortress variants, bosses, sword pieces, loot, forged boss swords
- [ ] **M4** — Spirit Pocket, Builder bonus, Adrenaline + hunger cost, Spirit Ward
- [ ] **M5** — animations, Spirit Breaker, advancements, HUD/GUI
- [ ] **M6** — localization polish, balance, release

## Contributing

This is a personal project in early development. Issues and suggestions are welcome on the [issue tracker](https://github.com/ege-kilavuz/modirk/issues). Please keep in mind that the design is intentionally opinionated; see [`DESIGN.md`](DESIGN.md). Art direction and the per-texture guide live in `DESIGN.md` §10.

## License

MIT. See [`LICENSE`](LICENSE).

---

## Türkçe özet

**Races**, Minecraft 1.21.1 (NeoForge) için geliştirilen bir moddur. Nether kalelerini ele geçirmiş üç düşmüş muhafızı yenersin, düşen **Ruh Taşı** ve kılıç parçalarıyla Nether'da kendi kurduğun ritüel alanında bir ırkla bağ kurarsın. Ritüel için **Ruh Dövme Masası**'nda dövülen **Lanetli Taş** ve 5 dakikalık Yozlaşma Evresi gerekir.

Şu an **M1 tamamlanmış** durumda: proje derleniyor, oyuna yükleniyor, üç ruh eşyası görünüyor ve ırk verisi (`/race` komutları, config, ölümde koruma) çalışıyor. Irk mekanikleri, ritüel, boss ve kale sistemleri henüz eklenmedi.

Ruh eşyaları ileride **GeckoLib ile 3D animasyonlu item** olacak; modelleme sonraki aşamada yapılacak.

Tasarımın tamamı [`DESIGN.md`](DESIGN.md) dosyasındadır.
