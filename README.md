# Races (modirk)

> **Status: early development (M0 complete).** The project builds and loads, but only the three spirit items exist right now. Gameplay features are not implemented yet.

Races is a [NeoForge](https://neoforged.net/) mod for **Minecraft 1.21.1**. Three bosses have seized the castles of the Nether. Defeat them, claim their **Spirit Stones**, and perform a demanding ritual in the Nether to bind one of their powers to yourself.

## What is Races?

You do not simply craft a race. You earn it.

1. Find and conquer one of the three Nether fortresses.
2. Defeat its boss and take the **Spirit Stone** and the boss's themed sword.
3. Build the ritual site yourself, in the Nether.
4. Complete the ritual: offerings, time and weather conditions, experience, guardian waves, and an uninterrupted channel.
5. Bind the boss's power and become one of three races.

Every boss is repeatable: new fortresses generate, so new Spirit Stones can be obtained.

## Planned races

| Race | Identity | Weakness |
|---|---|---|
| **Redstone Engineer** | **Spirit Pocket** — a bound redstone inventory. Items can only be placed, never stored, dropped, or crafted. Broken bound blocks return to the owner's pocket. | **Corrupted Hearts** — starts with 2 corrupted hearts. Depleting item limits earns seals; 2 seals cleanse 1 heart permanently. The pocket only refills through a light ritual with a new Spirit Stone. |
| **Builder** | **Natural block reward** — breaking naturally generated building blocks has a 15% chance to drop 3–4 extra items. | −15% PvP damage. |
| **PvP Fighter** | **Adrenaline** — attack speed scales with missing health. | Every successful hit before the weapon's vanilla cooldown consumes hunger. |

## Planned content

- Three Nether fortress variants (Nether-fortress style, partially corrupted by each boss's spirit): **Signal Sovereign**, **Grand Architect**, **Blood Warden**.
- Three animated bosses (GeckoLib), two phases each.
- Three themed boss swords; combine all three with a Nether Star to forge the **Spirit Breaker**, which resets your race.
- Player-built ritual multiblock (altar, three pedestals, four pillars), Nether-only.
- Spirit Pocket UI, HUD, advancements, English and Turkish localization.
- The three spirit items will later become **3D GeckoLib animated items**; modeling is planned for a later milestone.

## Current state

| Area | State |
|---|---|
| NeoForge 1.21.1 project, Gradle build | ✅ Working |
| Three spirit items + creative tab | ✅ Working |
| Tooltips, English and Turkish localization | ✅ Working |
| Mod logo | ✅ Added |
| Races, rituals, bosses, fortresses | ❌ Not implemented |
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
├── item/RaceSpiritItem.java spirit item with tooltip
└── registry/                items and creative tab

src/main/resources/
├── META-INF/neoforge.mods.toml
├── pack.mcmeta
├── logo.png
└── assets/modirk/
    ├── lang/                en_us, tr_tr
    ├── models/item/
    └── textures/item/
```

## Roadmap

- [x] **M0** — NeoForge 1.21.1 skeleton, clean repository, working build
- [ ] **M1** — race data (attachment), `/race` commands, config, keep-on-death
- [ ] **M2** — Spirit Stone, altar, ritual multiblock, ritual tablet
- [ ] **M3** — Nether fortress variants, bosses, loot, themed swords
- [ ] **M4** — Spirit Pocket, Builder bonus, Adrenaline + hunger cost, Spirit Ward
- [ ] **M5** — animations, Spirit Breaker, advancements, HUD/GUI
- [ ] **M6** — localization polish, balance, release

## Contributing

This is a personal project in early development. Issues and suggestions are welcome on the [issue tracker](https://github.com/ege-kilavuz/modirk/issues). Please keep in mind that the design is intentionally opinionated; see [`DESIGN.md`](DESIGN.md).

## License

MIT. See [`LICENSE`](LICENSE).

---

## Türkçe özet

**Races**, Minecraft 1.21.1 (NeoForge) için geliştirilen bir moddur. Nether kalelerini ele geçirmiş üç bossu yenersin, düşen **Ruh Taşı** ile Nether'da kendi kurduğun ritüel alanında bir ırkla bağ kurarsın.

Şu an **M0 tamamlanmış** durumda: proje derleniyor, oyuna yükleniyor ve üç ruh eşyası görünüyor. Irk, ritüel, boss ve kale sistemleri henüz eklenmedi.

Ruh eşyaları ileride **GeckoLib ile 3D animasyonlu item** olacak; modelleme sonraki aşamada yapılacak.

Tasarımın tamamı [`DESIGN.md`](DESIGN.md) dosyasındadır.
