# Races (modirk) — Tasarım Dokümanı

> Durum: **Tasarım kilitli v1.0** · Son güncelleme: 2026-11-24
> Platform: NeoForge 1.21.1 · Java 21
> Mod adı: **Races** · Mod id: **modirk** · Paket: `com.modirk`
> Öncelik: tek oyunculu deneyim, public mod uyumlu

## 1. Vizyon

Nether'in uçsuz bucaksız diyarlarında **3 boss**, Nether kalelerini ele geçirmiştir. Oyuncunun PvP, redstone ve build yetenekleri iyi olabilir; ama bu bosslar kadar iyi değildir. Oyuncu kaleleri keşfeder, bossları yener, düşen **Ruh Taşı** ile kendi ritüel alanını kurar ve bossun gücünü (ırkını) kazanır.

Amaç: "Bossu yen, gücünü al, daha güçlü bossa hazırlan."

## 2. Dünya: Nether Kaleleri

Nether'da 3 kale varyantı doğar; her varyantın kendi bossu, teması ve loot'u vardır.

| Kale | Biyom | Tema | Boss |
|---|---|---|---|
| **Redstone Kalesi** | Basalt Deltas | Redstone lamp, observer, dispenser, piston tuzakları | **Sinyal Efendisi** |
| **Builder Kalesi** | Crimson Forest | Crimson plank, scaffolding, surlar, tuzaklar | **Mimar-ı Azam** |
| **PvP Kalesi** | Soul Sand Valley / Nether Wastes | Blackstone arena, soul fire, kum saati | **Kanlı Muhafız** |

**Layout:** Kaleler **Nether kalesi (fortress) tarzında** inşa edilir; kalenin bir bölümü bossun ruhu tarafından **ele geçirilmiş/bozulmuş** görünür. Boss, bozulmuş bölümün merkezindeki taht/sunak alanında bekler.

**Üretim:** Kendi fortress yapımız (NBT template + structure). Vanilla Nether Fortress'lere dokunulmaz; çakışma olmaz.

**Bozulmuş palet (tema blokları):**

| Kale | Taban | Bozulmuş bölüm |
|---|---|---|
| Redstone | Nether brick, basalt | Redstone block/lamp, observer, dispenser, piston; kırmızı partikül |
| Builder | Nether brick, crimson plank | Crimson stem/plank, scaffolding, tuğla; turuncu partikül |
| PvP | Nether brick, blackstone | Blackstone, soul fire/lantern, gilded blackstone; mavi ruh partikülü |

- Her kalede: boss arenası, loot sandıkları, 1 **Ruh Taşı**, 1 **Ritüel Tableti**.
- Kaleler birden fazla kez doğar; bosslar tekrar edilebilir (aynı türden yeni kale = yeni boss).
- Boss drop'u: **Ruh Taşı** + **özel kılıç** + tema malzemeleri.
- **Ruh Taşı ayrıca** Nether'daki nadir sandıklarda çok düşük şansla bulunur (boss dışı alternatif yol).
- Bossların giriş, saldırı ve ölüm animasyonları **GeckoLib** ile yapılır.

## 3. Bosslar

### 3.1 Kanlı Muhafız → PvP'ci

- Hızlı, agresif; oyuncunun Adrenalin mekaniğine benzer bir "can azaldıkça hızlanma" kullanır.
- Dash, combo ve kısa süreli dokunulmazlık gibi hareketler.
- Drop: **PvP Ruh Taşı** + **Kızıl Kılıç** (özel kılıç).

### 3.2 Sinyal Efendisi → Redstone Mühendisi

- Arenayı piston, dispenser, observer ve redstone tuzaklarıyla döşer.
- Oyuncuyu yönlendiren lazer/sinyal desenleri, elektrik hasarı.
- Drop: **Redstone Ruh Taşı** + **Devre Kılıcı** (özel kılıç).

### 3.3 Mimar-ı Azam → Builder

- Savaş sırasında duvar örer, blok fırlatır, zemini değiştirir.
- Oyuncunun kaçış yollarını kapatır; "yapı" ile hapseder.
- Drop: **Builder Ruh Taşı** + **Mimarın Kılıcı** (özel kılıç).

> Animasyon: **GeckoLib** (giriş, saldırı, ölüm).
> **Her boss 2 fazlıdır:** Faz 1 normal saldırı seti; can %50'ye inince Faz 2 (özel mekanik + yardımcı moblar). Sayısal denge ayarları tuning aşamasında netleşir.

## 4. Irklar

### 4.1 Redstone Mühendisi

**Kimlik: Ruh Cebi.** Irka özel, keybind ile açılan sanal redstone envanteri.

- Cep bir depo değil, kaynaktır: item yalnızca cebe **çekilir**, cebe konmaz.
- Her eşyanın ayrı limiti vardır (eşya başına limit).
- Çekilen eşya **bağlı** olur:
  - atılamaz (Q engellenir),
  - sandığa/shulker'a konamaz,
  - craft, fırın, örs, takas gibi alanlarda kullanılamaz,
  - sadece blok olarak yerleştirilebilir.
- Bağlı blok kırılınca (kim kırarsa kırsın) eşya **koyan oyuncunun Ruh Cebi'ne** döner.
- Sahip çevrimdışıysa iade kuyruğa girer, girişte teslim edilir.
- Bağlı bloklar pistonla taşınamaz (ruh bağı direnci).
- Patlama davranışı: **açık** (yok olmaz / iade / normal drop).

**Limitler (config'e taşınır):**

| Eşya | Limit |
|---|---|
| Redstone dust | 64 |
| Redstone torch | 16 |
| Repeater | 8 |
| Comparator | 8 |
| Observer | 8 |
| Piston | 8 |
| Sticky piston | 8 |
| Dispenser | 4 |
| Hopper | 4 |
| Lever / button | 8 |
| Target block | 4 |

- Pasif: **redstone bloklarında** +%25 kırma/yerleştirme hızı.
- Zayıflık: **Yozlaşmış Kalpler.** 2 yozlaşmış kalp (max HP -4) ile başlar.
  - Her eşya limiti tamamen tükendiğinde 1 "yozlaşma mührü" kazanılır.
  - 2 mühür = 1 kalp temizlenir (4 limit = 2 kalp).
  - Arınma **kalıcıdır**; temizlenen kalpler geri gelmez.
  - Cep limitleri **her seferinde yeni bir Ruh Taşı** ile yapılan hafif tazeleme ritüeliyle yenilenir.
  - Başarısız tazeleme cebi yenilemez; Ruh Taşı tükenir.

### 4.2 Builder

**Kimlik: Doğal blok ödülü.** Doğada oluşmuş yapı bloğunu kırınca **%15 şansla 3–4 ekstra drop**.

- Doğal/oyuncu bloğu ayrımı: oyuncunun yerleştirdiği konumlar `SavedData`'da tutulur; listede olmayan blok doğal sayılır.
- Blok kapsamı: taş, deepslate, tuff, kireçtaşı, toprak, çim, kum, çakıl, kütük, plank, tuğla, taş tuğla, kumtaşı, beton vb.
- **Hariç:** ore'lar, sandıklar, fırınlar, makineler, block entity'li bloklar.
- Ekstra drop normal loot tablosuyla (oyuncunun aletiyle) hesaplanır.
- Sadece hayatta kalma modunda ve oyuncu kırarken.
- Fortune etkisi: yok; ekstra droplar sabit 3–4 adet.
- Pasif: +1 blok reach, +%20 kırma hızı.
- Zayıflık: PvP hasarı -%15.

### 4.3 PvP'ci

**Kimlik: Adrenalin.** Can azaldıkça saldırı hızı artar.

- Formül: `bonus = %30 × (1 - can / maxCan)` → 1 kalpte yaklaşık +%28.
- Sadece kılıç ve balta; mace, trident, yay/arbalet etkilenmez.
- **Açlık bedeli (Yorum A):** Vanilya cooldown'ı dolmadan yapılan her isabetli vuruş açlık tüketir. Adrenalin sayesinde erken tam güçle vurmak da bedellidir. Vanilya cooldown'ı dolduktan sonraki vuruşlar ücretsizdir.
  - Erken vuruş başına `1.0 exhaustion` (yaklaşık 4 vuruş = 1 açlık puanı), config'e taşınır.
  - "Normal cooldown" = silahın Adrenalin bonusu **olmadan** sahip olduğu vanilya cooldown'ı.
- **Ruh Sığı (ikincil, ileri seviye):** Ölümcül hasarda 1 HP ile hayatta kalma + 2 sn dokunulmazlık; 5 dk cooldown. 100 kill advancement'ı ile açılır.
- Pasif: **açık** (öneri: yok; kimlik Adrenalin + Ruh Sığı).
- Zayıflık: açlık bedeli.

## 5. Ritüel

### 5.1 Ritüel Alanı (oyuncu inşası)

- Worldgen tapınak yok; oyuncu kendi ritüel alanını **elle inşa eder**.
- Multiblock: 5×5 platform, merkezde **Sunak**, 3 adak kaidesi, 4 sütun.
- **Ritüel Tableti** inşa pattern'ini ve koşulları gösterir.
- Alan **Nether'da** kurulur; Overworld'de çalışmaz.
- **Sunak yerinde kalır**, ritüel sonrası "tükenmiş" görünüme geçer ve **yeni bir Ruh Taşı** ile tekrar kullanılabilir. Tekrar inşa gerekmez; gerçek sınır Ruh Taşı'dır.

### 5.2 Ruh Bağı Ritüeli

1. Sunağa **Ruh Taşı** (boss drop'u) konur.
2. Irka özel **3 adak** kaidelere yerleştirilir.
3. Zaman/hava koşulu sağlanır (Redstone: gece; Builder: gündüz; PvP: yağmur).
4. Oyuncu en az **30 XP seviyesi**ne sahiptir (başarıda tükenir).
5. Bossun "kalıntıları" dalgalar halinde doğar; temizlenmeden ritüel ilerlemez.
6. Oyuncu sunağın 3 blok yakınında **15 saniye** kesintisiz durur. Hasar alır veya uzaklaşırsa ritüel sıfırlanır.
7. Başarı: ırk atanır, advancement açılır, particle/ses; Ruh Taşı ve Sunak tükenir.
8. Başarısızlık: adaklar iade edilir, **Ruh Taşı tükenir**, cep yenilenmez.

**Önerilen adaklar:**

| Irk | Adaklar |
|---|---|
| Redstone | Redstone Block, 16 Amethyst Shard, 1 Comparator |
| Builder | 64 Smooth Stone, 16 Scaffolding, 1 Diamond Pickaxe |
| PvP | 1 Shield, 8 Ender Pearl, 1 Iron Sword (Sharpness II) |

### 5.3 Cep Tazeleme Ritüeli

- Redstone Mühendisi için **hafif ritüel**: Ruh Taşı + 10 sn kanallama.
- Adak, XP ve muhafız dalgası yok.
- Her tazeleme **yeni bir Ruh Taşı** gerektirir; sunak kalıcıdır, tükenmiş görünümden yeniden aktifleşir.

## 6. Ruh Kırıcı

- Her boss kendi temalı **özel kılıcını** düşürür (3 kılıç).
- Her kılıç, kendi ırkının mekaniğinden bir parça taşır:
  - **Kızıl Kılıç (PvP):** Can azaldıkça saldırı hızı artar (Adrenalin'in küçük versiyonu).
  - **Devre Kılıcı (Redstone):** İsabet eden hedefe kısa süreli "devre kilidi" uygular (hareket/beceri kısıtı).
  - **Mimarın Kılıcı (Builder):** İsabette hedefin altındaki zemini kısa süreliğine kaldırır/bozar.
- 3 bossun özel kılıcı birleştirilerek **Ruh Kırıcı** yapılır; ırk bağını koparır.
- **Tarif:** 3 boss kılıcı + 1 **Nether Star**, smithing table'da birleşir.
- Irkı sıfırlar; oyuncu yeni bir Ruh Taşı ile yeniden seçim yapabilir.
- Kullanımda kırılmaz/tükenmez; tek seferlik değil, her sıfırlamada kullanılabilir (denge tuning'de netleşir).

## 7. Teknik Mimari

- NeoForge 1.21.1, Java 21, ModDevGradle 2.x, Gradle 8.x
- `META-INF/neoforge.mods.toml`
- Irk verisi: Data Attachment (`AttachmentType`), ölümde korunur
- Dünya verisi: `SavedData` (bağlı bloklar, oyuncu yerleştirmeleri, bekleyen iadeler)
- Client senkronizasyon: `PayloadRegistrar` / `CustomPacketPayload`
- Ruh Cebi UI: `Menu` + `Screen`, sunucu doğrulamalı
- Denge: `ModConfigSpec`
- Nether kalesi: kendi fortress yapımız, NBT template + structure type; 3 varyant (Basalt Deltas / Crimson Forest / Soul Sand Valley + Nether Wastes)
- Bosslar: özel entity + attribute + goal/attack AI (2 faz); animasyonlar **GeckoLib** ile client-side
- Bağımlılık: **GeckoLib** (NeoForge 1.21.1 sürümü)
- Test: manuel + temel gametest

## 8. Yol Haritası

- **M0:** NeoForge 1.21.1 iskeleti, temiz repo (README, LICENSE, .gitignore, build/ temizliği), çalışan build
- **M1:** Irk verisi, `/race` komutları, config, ölümde koruma
- **M2:** Ruh Taşı, Sunak, ritüel multiblock, Ritüel Tableti (boss olmadan test)
- **M3:** Nether kalesi varyantları, bosslar, loot, özel kılıçlar
- **M4:** Ruh Cebi, Builder bonusu, Adrenalin + açlık bedeli, Ruh Sığı
- **M5:** Animasyonlar, Ruh Kırıcı, advancement'lar, HUD/GUI
- **M6:** Dil, README, denge, sürüm

## 9. Açık Sorular (yalnızca tuning)

> Tasarım kararları tamamlandı. Aşağıdakiler kod yazılırken sayısal olarak ayarlanacak.

- [ ] Boss saldırı setlerinin sayısal detayları ve hasar değerleri
- [ ] Kale spawn sıklığı ve minimum mesafe
- [ ] Ruh Taşı nadir sandık şansı
- [ ] Public mod için config ile gevşetme seçenekleri
