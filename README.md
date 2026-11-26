# Races (modirk)

> **Status: early development (M0).** Only the base project skeleton and the three spirit items exist right now. Gameplay features are not implemented yet.

Races is a NeoForge mod for **Minecraft 1.21.1**. Three bosses have seized the castles of the Nether. Defeat them, claim their **Spirit Stones**, and perform a demanding ritual in the Nether to bind one of their powers to yourself.

## The idea

You do not simply craft a race. You earn it.

1. Find and conquer one of the three Nether fortresses.
2. Defeat its boss and take the **Spirit Stone** and the boss's themed sword.
3. Build the ritual site yourself, in the Nether.
4. Complete the ritual: offerings, time/weather, experience, guardian waves, and an uninterrupted channel.
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

## Requirements

- Minecraft **1.21.1**
- NeoForge **21.1.x**
- [GeckoLib](https://www.curseforge.com/minecraft/mc-mods/geckolib) **4.7+** (required at runtime)

## Building from source

Requires **JDK 21**. The Gradle wrapper downloads Gradle automatically.

```bash
# Windows
gradlew.bat build

# Linux / macOS
./gradlew build
```

The built jar is placed in `build/libs/`.

Run the client in a development environment:

```bash
gradlew.bat runClient
```

## Design document

All locked design decisions live in [`DESIGN.md`](DESIGN.md) (Turkish). It is the source of truth for mechanics, balance, and the roadmap.

## License

MIT. See [`LICENSE`](LICENSE).

---

## Türkçe özet

**Races**, Minecraft 1.21.1 (NeoForge) için geliştirilen bir moddur. Nether kalelerini ele geçirmiş üç bossu yenersin, düşen **Ruh Taşı** ile Nether'da kendi kurduğun ritüel alanında bir ırkla bağ kurarsın.

Şu an **erken geliştirme (M0)** aşamasındadır: yalnızca proje iskeleti ve üç ruh eşyası mevcuttur. Oynanış özellikleri henüz eklenmemiştir.

Tasarımın tamamı [`DESIGN.md`](DESIGN.md) dosyasındadır.
