# Races (modirk) — Tasarım Dokümanı

> Durum: **Tasarım kilitli v1.3 (hikaye + ritüel + texture rehberi)** · Son güncelleme: 2026-11-26
> Platform: NeoForge 1.21.1 · Java 21
> Mod adı: **Races** · Mod id: **modirk** · Paket: `com.modirk`
> Öncelik: tek oyunculu deneyim, public mod uyumlu

## 1. Hikaye ve Vizyon

Nether'in uçsuz bucaksız diyarlarında **üç düşmüş muhafız**, kalelerini ele geçirmiştir. Oyuncu kaleleri keşfeder, muhafızları yener, düşen **Ruh Taşı** ile Nether'da kendi ritüel alanını kurar ve muhafızın gücünü (ırkını) miras alır.

> **Ton:** karanlık mitoloji. Ruhlar bir para birimidir; güç her zaman bir şeyden alınır. Bosslar kötü değil, **düşmüş**tür.

Amaç: "Muhafızı yen, gücünü al, kalenin sırrını çöz."

### 1.1 Dünya: ruhlar ve Nether

Nether'da ölenlerin ruhları havada dolaşır. Yoğunlaştıkları yerlerde kristalleşir ve **Ruh Taşı**'na dönüşür. Bu taşlar büyük güç taşır ama bedavadır sayılmaz: her taş birinin ruhundan kopmuş bir parçadır.

Nether'ın kendisi bu ruhları yutar; bu yüzden ruhlar Overworld'de dağılır, Nether'da kalır.

### 1.2 Düşmüş Muhafızlar

Üçü de bir zamanlar Nether kalelerinin **Muhafızları**'ydı; kalelerdeki ruhları korumakla yeminliydiler. Yüzyıllar boyunca korudukları ruhları yavaş yavaş tükettiler ve kendileri birer tiranlaştı:

- **Sinyal Efendisi** — kalenin redstone mekanizmalarına hükmetti. Bedeni artık devre ve lambalardan oluşur; bağlı olan her şeyi görür. Koruduğu ruhları kendi devrelerine akıtıp ölümsüzleşti.
- **Mimar-ı Azam** — kaleleri o inşa etti. Artık durmadan inşa eder; canlıları yapıya, savaşı moloza çevirir. Kalelerin surları onun yemininin taşlaşmış hali.
- **Kanlı Muhafız** — cellat. Savaşta beslendikçe güçlenir, kanadıkça hızlanır. Kendi ölümünü bile bir ziyafet olarak görür.

Kaleleri mühürlediler ve Ruh Taşları'nı hazinelerinde tutuyorlar. Onları yenmek kaleyi susturmaz: **bir muhafızın ruhu kalesine bağlıdır.** Ruh Taşı, bu bağdan taşan kısımdır; beden yok olsa da kale, kalan ruh izinden muhafızı yeniden örer. Bu yüzden bosslar tekrar edilebilir — ve oyuncu, her tazelemede bir muhafızın ruhundan bir parça harcar.

### 1.3 Ruh Kâhinleri

Bir zamanlar **Ruh Kâhinleri** adlı bir tarikat vardı; **Ruh Bağı** ritüelini bilen tek topluluk. Muhafızlar tarikata saldırdı, çoğunu yok etti. Geriye kalelerde dağılmış **Ritüel Tabletleri** ve yarım kalmış notlar kaldı.

Oyuncu bu tabletleri bulup ritüeli öğrenir. Ritüelin amacı muhafızı yok etmek değil; **onun alanını miras almak**.

### 1.4 Ruh Bağı

Ritüel, bir muhafızın ruh parçasını oyuncuya bağlar. Ruh parçası direnir; bağ kurulunca muhafızın iradesi oyuncunun içinde yaşamaya devam eder. **Irkların zayıflıkları bu yüzden vardır:**

- Redstone'da **yozlaşmış kalpler** — Sinyal Efendisi'nin eti devreye çevirme arzusu.
- PvP'de **açlık bedeli** — Kanlı Muhafız'ın doymak bilmezliği.
- Builder'da **-PvP hasarı** — Mimar-ı Azam'ın savaşı değersiz görmesi.

Ritüelin koşulları (adaklar, Lanetli Taş, muhafız dalgaları, kanallama) ruh parçasını "ikna etme" sürecidir; eksik koşulda parça dağılır ve Ruh Taşı boşa gider.

**Neden sunak elle yapılmalı:** Ritüel bir **niyet çapası** ister. Sadece kendi elinle kurduğun yapı niyet taşır; muhafızların bıraktığı sunaklar mühürlüdür ve yeni bağ kabul etmez.

**Neden sadece Nether'da:** Overworld'de ruh yoğunluğu yetmez; kanal tamamlanmadan ruh parçası dağılır.

### 1.5 Ruh Kırıcı

Her muhafızın kılıcı sadece silah değil; ruhunu alanına bağlayan bir **yemin** taşır. Beden ölse de yemin kalır; kılıç parçalanır ve parçaları kaleye dağılır. Parçalar **Ruh Dövme Masası**'nda birleştirilince yemin yeniden tamamlanır.

Üç kılıç bir araya gelince üç yemin birbirleriyle çelişir ve **her ruh bağını kesebilen** bir bıçak doğar: **Ruh Kırıcı**. Muhafızlar kendi silahlarının bir gün birleştirileceğini hiç düşünmedi.

Ruh Kırıcı hikayede bir **final seçimi değildir**; oyuncunun kendi bağını koparıp yeniden seçmesini sağlayan bir sıfırlama aracıdır.

### 1.6 Hikaye–mekanik bağlantısı

| Mekanik | Hikaye gerekçesi |
|---|---|
| Sunak elle yapılmalı | "Niyet çapası": yalnızca kendi emeğinle kurduğun yapı bağ kurabilir. |
| Sadece Nether'da çalışır | Ruh yoğunluğu; Overworld'de parça dağılır. |
| Ruh Taşı bosslardan | Her taş, bir muhafızın taşan ruh parçası. |
| Kılıç parçaları kalede/boss'ta | Muhafızın yemini bedenle birlikte parçalanır; parçalar kaleye dağılır. |
| Lanetli Taş | Kılıç parçalarına ırk malzemesi katılınca yemin "yozlaşır"; ritüelin ortamını hazırlar. |
| 5 dakikalık Yozlaşma Evresi | Yozlaşma kısa ömürlüdür; süre dolarsa ruh parçası dağılır. |
| Bosslar tekrar doğar | Muhafızın ruhu kaleye bağlı; kale onu yeniden örer. |
| Cep tazelemesi yeni Ruh Taşı ister | Ruh Cebi, Sinyal Efendisi'nin hazine-ruhundan bir parça; redstone yaratmak için ruh enerjisi harcar. |
| 2 mühür = 1 kalp | Cebi tükettikçe Sinyal Efendisi'nin yozlaşması yanar; kalp geri gelir. |
| Ruh Kırıcı | Üç çelişen yeminin kesişimi; her ruh bağını keser. |

### 1.7 Anlatım yolları

- **Ritüel Tableti** — ritüelin koşullarını ve inşa pattern'ini anlatan lore item'ı.
- **Kale kalıntıları** — muhafızların düşüşünü anlatan kısa notlar/tabletler (M3).
- **Advancement metinleri** — her boss ve her ırk için kısa hikaye cümleleri.
- **Eşya lore'u** — Ruh Taşı ve kılıçların tooltip'leri.

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

- Her kalede: boss arenası, loot sandıkları, 1 **Ritüel Tableti**.
- Sandıklarda rastgele **kılıç parçaları** çıkar (loot table).
- Kaleler birden fazla kez doğar; bosslar tekrar edilebilir (aynı türden yeni kale = yeni boss).
- Boss drop'u: **Ruh Taşı** + **kılıç parçası** + tema malzemeleri.
- **Ruh Taşı ayrıca** Nether'daki nadir sandıklarda çok düşük şansla bulunur (boss dışı alternatif yol).
- Bossun kılıcı doğrudan düşmez; **3 kılıç parçası Ruh Dövme Masası'nda** dövülür.
- Bossların giriş, saldırı ve ölüm animasyonları **GeckoLib** ile yapılır.
- **Ruh eşyaları** ileride GeckoLib ile **3D animasyonlu item** olacak; modelleme sonraki aşamada yapılacak (şimdilik 2D item).

## 3. Bosslar

### 3.1 Kanlı Muhafız → PvP'ci

- Hızlı, agresif; oyuncunun Adrenalin mekaniğine benzer bir "can azaldıkça hızlanma" kullanır.
- Dash, combo ve kısa süreli dokunulmazlık gibi hareketler.
- Drop: **PvP Ruh Taşı** + **kılıç parçası** (Kızıl Kılıç parçalardan dövülür).

### 3.2 Sinyal Efendisi → Redstone Mühendisi

- Arenayı piston, dispenser, observer ve redstone tuzaklarıyla döşer.
- Oyuncuyu yönlendiren lazer/sinyal desenleri, elektrik hasarı.
- Drop: **Redstone Ruh Taşı** + **kılıç parçası** (Devre Kılıcı parçalardan dövülür).

### 3.3 Mimar-ı Azam → Builder

- Savaş sırasında duvar örer, blok fırlatır, zemini değiştirir.
- Oyuncunun kaçış yollarını kapatır; "yapı" ile hapseder.
- Drop: **Builder Ruh Taşı** + **kılıç parçası** (Mimarın Kılıcı parçalardan dövülür).

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
  - 2 mühür = 1 kalp temizlenir (4 limit = 4 mühür = 2 kalp).
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
2. **Lanetli Taş** sunağa yerleştirilir; Ruh Taşı, taşın malzemesinin ruhuyla yozlaşır ve **5 dakikalık Yozlaşma Evresi** başlar. Bu süre içinde ritüel tamamlanmalıdır. **Zaman/hava koşulu yoktur.**
3. Irka özel **3 adak** kaidelere yerleştirilir.
4. Oyuncu en az **30 XP seviyesi**ne sahiptir (başarıda tükenir).
5. Muhafızın "kalıntıları" dalgalar halinde doğar; temizlenmeden ritüel ilerlemez.
6. Oyuncu sunağın 3 blok yakınında **15 saniye** kesintisiz durur. Hasar alır veya uzaklaşırsa ritüel sıfırlanır.
7. Başarı: ırk atanır, advancement açılır, particle/ses; Ruh Taşı ve Lanetli Taş tükenir.
8. Başarısızlık: adaklar iade edilir, **Ruh Taşı ve Lanetli Taş tükenir**, cep yenilenmez.

**Önerilen adaklar:**

| Irk | Adaklar |
|---|---|
| Redstone | Redstone Block, 16 Amethyst Shard, 1 Comparator |
| Builder | 64 Smooth Stone, 16 Scaffolding, 1 Diamond Pickaxe |
| PvP | 1 Shield, 8 Ender Pearl, 1 Iron Sword (Sharpness II) |

### 5.3 Lanetli Taş ve Yozlaşma Evresi

**Ruh Dövme Masası:** Kılıç parçalarının dövüldüğü özel blok/masa.

- **3 kılıç parçası** → boss kılıcı (savaş + Ruh Kırıcı malzemesi).
- **3 kılıç parçası + ırk malzemesi** → **Lanetli Taş** (ritüel anahtarı).

**Lanetli Taş tarifleri:**

| Irk | Malzeme |
|---|---|
| Redstone | 1 Redstone Block |
| Builder | 1 Quartz Block |
| PvP | 1 Netherite Sword |

- **Malzeme eşleşmesi:** Lanetli Taş'ın malzemesi, Ruh Taşı'nın ırkıyla eşleşmelidir (Redstone Ruh Taşı + Redstone Block gibi). Yanlış malzeme ritüeli başlatmaz; taş ve malzeme harcanmaz.
- Lanetli Taş sunağa konunca Ruh Taşı, malzemenin ruhuyla yozlaşır ve **5 dakikalık Yozlaşma Evresi** başlar.
- Evre boyunca **zararlı moblara** ırka göre etki uygulanır:

| Irk | Zararlı moblara etki |
|---|---|
| Redstone | **Slowness** (devre kilidi) — oyuncuya yardım |
| Builder | **Weakness** (yapı çözülmesi) — oyuncuya yardım |
| PvP | **Speed + Strength** (kan çılgınlığı) — ritüeli zorlaştırır |

- 5 dakika dolduğunda ritüel tamamlanmadıysa: **Ruh Taşı ve Lanetli Taş tükenir**; adaklar iade edilir.

### 5.4 Cep Tazeleme Ritüeli

- Redstone Mühendisi için **hafif ritüel**: Ruh Taşı + 10 sn kanallama.
- Adak, XP ve muhafız dalgası yok.
- Her tazeleme **yeni bir Ruh Taşı** gerektirir; sunak kalıcıdır, tükenmiş görünümden yeniden aktifleşir.

## 6. Ruh Kırıcı

- Boss kılıcı doğrudan düşmez; her boss kılıcı için **3 kılıç parçası** Ruh Dövme Masası'nda dövülür (toplam 3 kılıç).
- Her kılıç, kendi ırkının mekaniğinden bir parça taşır:
  - **Kızıl Kılıç (PvP):** Can azaldıkça saldırı hızı artar (Adrenalin'in küçük versiyonu).
  - **Devre Kılıcı (Redstone):** İsabet eden hedefe kısa süreli "devre kilidi" uygular (hareket/beceri kısıtı).
  - **Mimarın Kılıcı (Builder):** İsabette hedefin altındaki zemini kısa süreliğine kaldırır/bozar.
- 3 bossun özel kılıcı birleştirilerek **Ruh Kırıcı** yapılır; ırk bağını koparır.
- **Tarif:** 3 boss kılıcı + 1 **Nether Star**, smithing table'da birleşir.
- Hikaye: üç kılıcın taşıdığı çelişen yeminlerden doğar; **final seçimi değil**, sıfırlama aracıdır.
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
- **Ruh Dövme Masası:** özel blok + `Menu`/`Screen` veya özel recipe type; kılıç parçaları → kılıç / Lanetli Taş
- **Yeni eşyalar:** Ruh Taşı, kılıç parçası, Lanetli Taş, 3 boss kılıcı, Ruh Kırıcı, Ritüel Tableti
- **Lanetli Taş:** 5 dk zamanlayıcı + mob effect uygulama (sunucu tarafı)
- Bağımlılık: **GeckoLib** (NeoForge 1.21.1 sürümü)
- Test: manuel + temel gametest

## 8. Yol Haritası

- **M0 (tamamlandı):** NeoForge 1.21.1 iskeleti, temiz repo (README, LICENSE, .gitignore, build/ temizliği), çalışan build
- **M1:** Irk verisi, `/race` komutları, config, ölümde koruma
- **M2:** Ruh Taşı, Sunak, ritüel multiblock, Ritüel Tableti, Ruh Dövme Masası, Lanetli Taş (boss olmadan test)
- **M3:** Nether kalesi varyantları, bosslar, kılıç parçaları, loot, özel kılıçlar
- **M4:** Ruh Cebi, Builder bonusu, Adrenalin + açlık bedeli, Ruh Sığı
- **M5:** Animasyonlar, Ruh Kırıcı, advancement'lar, HUD/GUI, ruh eşyalarının 3D GeckoLib modelleri
- **M6:** Dil, README, denge, sürüm

## 9. Açık Sorular (yalnızca tuning)

> Tasarım kararları tamamlandı. Aşağıdakiler kod yazılırken sayısal olarak ayarlanacak.

- [ ] Boss saldırı setlerinin sayısal detayları ve hasar değerleri
- [ ] Kale spawn sıklığı ve minimum mesafe
- [ ] Ruh Taşı nadir sandık şansı
- [ ] Kılıç parçası drop oranları (sandık + boss); ritüel + boss kılıcı için toplam 6 parça gerektiğini hesaba kat
- [ ] Ruh Dövme Masası'nın mekaniği (custom recipe mi, Menu/Screen mi?)
- [ ] Adak listelerinin sadeleştirilmesi (ırk malzemesi artık Lanetli Taş'ta)
- [ ] Public mod için config ile gevşetme seçenekleri

## 10. Sanat Yönü ve Texture Rehberi

> Bu bölüm her texture'ın **ne anlatması** ve **nasıl görünmesi** gerektiğini tanımlar. İlk sürümdür; beğenmediğin maddeleri söyle, birlikte revize edelim.

### 10.1 Genel kurallar

- **Çözünürlük:** itemler ve bloklar **16×16**; GUI **256×256**; bosslar **128×128** (gerekirse 256×256 atlas).
- **Stil:** vanilla'ya yakın, net piksel sanat. **Anti-aliasing yok, blur yok, gradient yok.**
- **Dış hat:** her sprite'ta **1 px koyu hat** (`#14101A`).
- **Işık:** sol üstten; gölge sağ altta. Tüm set aynı ışığı kullanır.
- **Renk sayısı:** item başına **8–14 renk**; aynı rampanın 2–4 tonu.
- **Arka plan:** şeffaf. Gölge sadece dış hat; yumuşak gölge yok.
- **Silüet önce:** 16×16'da bile ne olduğu anlaşılmalı. Uzaktan bakınca kılıç kılıç, taş taş gibi okunmalı.
- **Renk körlüğü:** ayrım sadece renkle değil, **şekille** de yapılır (eğri/düz/geniş bıçak, farklı çatlak deseni).
- **Metin yok:** sadece rune, çentik, devre izi gibi soyut işaretler.
- **Test:** her sprite oyun içinde vanilla itemlerle yan yana kontrol edilir; fazla parlak veya fazla detaylı olan sadeleştirilir.

### 10.2 Ortak palet

| Rol | Renk | Hex |
|---|---|---|
| Boşluk / dış hat | Void black | `#14101A` |
| Derin gölge | Deep purple-black | `#241A2B` |
| Nether tuğlası | Koyu kızıl kahve | `#3A1F1F` |
| Nether tuğlası (açık) | Sıcak kahve | `#5A2E2A` |
| Bazalt | Soğuk gri | `#3B3B44` |
| Bazalt (açık) | Açık gri | `#5A5A66` |
| Blackstone | Kömür siyahı | `#2A2A32` |
| Kemik | Kirli beyaz | `#D8D0C0` |
| Kül | Nötr gri | `#8A8178` |
| Ruh mavisi | Soul blue | `#3FA7D6` |
| Ruh parlaması | Soul glow | `#8FE8F5` |
| Kor turuncusu | Ember | `#E17055` |
| Kor parlaması | Ember glow | `#FFB86B` |
| Altın | Gold | `#C9A227` |
| Kan | Blood | `#8E2A2A` |
| Kan (parlak) | Blood bright | `#C0392B` |
| Redstone | Redstone red | `#D63031` |
| Redstone parlaması | Redstone glow | `#FF5A4E` |
| Bakır | Copper | `#B87333` |
| Kuvars | Quartz | `#F0E6D2` |
| Kumtaşı | Sandstone | `#D9B98A` |
| Amber | Builder amber | `#E08A3C` |
| Amber parlaması | Amber glow | `#FFC46B` |
| Yozlaşma | Corrupted purple | `#5B2A6E` |

### 10.3 Irk görsel dili

| Irk | Ana renk | İkincil | Parlama | Motif | Şekil dili |
|---|---|---|---|---|---|
| **Redstone** | `#D63031` | Bakır `#B87333`, siyah `#14101A` | `#FF5A4E` | Devre izi, lehim noktası, lamba | Keskin, açılı, ince |
| **Builder** | Amber `#E08A3C` | Kumtaşı `#D9B98A`, kuvars `#F0E6D2` | `#FFC46B` | Tuğla, keski, iskele, geometri | Bloklu, kalın, sağlam |
| **PvP** | Kan `#8E2A2A` | Ruh mavisi `#3FA7D6`, blackstone `#2A2A32` | `#8FE8F5` | Bıçak, zincir, kan damlası | Sivri, düzensiz, agresif |

**Ortak kural:** üç ırkın eşyaları aynı "kararmış metal + renkli çekirdek" ailesine ait görünür. Sadece renk değil, **çekirdek şekli** de değişir:

- Redstone: kare/dikdörtgen çekirdek, devre çizgileri.
- Builder: prizma/kesme taş çekirdek, geometrik çatlak.
- PvP: damla/yıldız çekirdek, organik çatlak.

### 10.4 Mevcut ruh eşyaları (M0 — yenilenecek)

Şu anki üç texture **geçici ve bulanık**; hedef aşağıdaki gibidir. Üçü de aynı boyutta, aynı dış hat kalınlığında ve aynı "yüzen parça" kompozisyonunda olacak.

| Eşya | Silüet | Gövde | Çekirdek | Detay |
|---|---|---|---|---|
| **Redstone Ruhu** | Eğik eşkenar dörtgen devre parçası | Siyah/ koyu bakır kart | Kırmızı kare çekirdek | İki bakır pin, ince devre izleri, küçük lehim noktaları |
| **Builder Ruhu** | Bir köşesi kırık küp | Kuvars/kumtaşı blok | Amber prizma | Yüzeyde keski izi, küçük tuğla deseni, toz parçacığı |
| **PvP Ruhu** | Çapraz hançer/kan damlası | Blackstone kabza, koyu çelik | Ruh mavisi damla | Kırmızı kan kenarı, küçük zincir halkası |

- **Kompozisyon:** eşya 16×16'nın ortasına oturur; kenarlarda 1–2 px boşluk kalır.
- **Parlama:** çekirdekte 2 px açık ton + 1 px beyaz nokta; fazlası "çiğ" durur.
- **Yeniden çizim:** mevcut PNG'ler silinip bu tarifle 16×16 olarak yeniden üretilecek.

### 10.5 Ritüel ve zanaat eşyaları (M2)

#### Ruh Taşı (3 varyant)

- **Boyut:** 16×16.
- **Silüet:** 5–7 yüzlü, hafif eğik kristal; tek başına "değerli taş" gibi okunmalı.
- **Gövde:** dumanlı siyah/derin mor (`#241A2B`), yüzeyde 2–3 çatlak.
- **Çekirdek:** ırk renginde iç ışık; kristalin merkezinden dışarı doğru yayılan 3–4 çizgi.
- **Varyantlar:**
  - **Redstone:** kırmızı çekirdek, devre benzeri çatlaklar, bakır bir kıvrım.
  - **Builder:** amber çekirdek, geometrik/prizmatik çatlaklar, kuvars tozu.
  - **PvP:** ruh mavisi çekirdek, kırmızı damar, hafif kan sızıntısı.
- **His:** boss'un kendi ruhu; karanlık, ağır, hafif "canlı" duran bir taş.

#### Kılıç Parçası (tek tip)

- **Boyut:** 16×16.
- **Silüet:** kırık bıçak ucu; sapı sarılı, ucu kırılmış, tek başına işe yaramaz.
- **Renk:** koyu çelik (`#3B3B44`), kemik/deri sap (`#D8D0C0`), hafif ruh mavisi kenar.
- **Detay:** 2–3 çentik, bir tarafta testere izi; "3 tanesi birleşince kılıç olur" hissi.
- **Not:** tek tip olduğu için ırk rengi **kullanılmaz**; nötr görünmeli.

#### Lanetli Taş (3 varyant)

- **Boyut:** 16×16.
- **Silüet:** düzensiz, köşeli siyah taş; ortasında tek bir "göz" veya çığlık çatlağı.
- **Gövde:** blackstone (`#2A2A32`) + derin gölge; yüzeyde ırk renginde parlayan çatlaklar.
- **Varyantlar:**
  - **Redstone:** kırmızı devre çatlakları, küçük kare göz.
  - **Builder:** amber geometrik çatlaklar, prizma göz.
  - **PvP:** mavi ruh çatlağı + kırmızı damar, damla göz.
- **His:** yasak, kirli, "kullanılmaması gereken" bir taş. Fazla parlak olmayacak; parlama sadece çatlaklarda.

#### Ritüel Tableti

- **Boyut:** 16×16.
- **Silüet:** üstü yuvarlak, altı düz taş tablet; bir köşesi kopmuş.
- **Renk:** nether tuğlası/blackstone, kirli kemik kenar.
- **Detay:** mavi rune satırları, küçük sunak+kaide diyagramı, çatlak.
- **His:** yüzyıllardır kalelerde durmuş, okunmaya çalışılmış bir kayıt.

#### Sunak (blok)

- **Texture'lar:** `sunak_top`, `sunak_side`, `sunak_bottom` (16×16).
- **Gövde:** nether tuğlası + blackstone; köşelerde kemik/rune kakma.
- **Üst:** ortada sığ bir ruh çanağı; çanakta ırk renginde sıvı/ışık.
- **Durumlar:**
  - **Boş:** sönük çanak, nötr gri.
  - **Aktif:** çanakta ırk rengi parlama, rune'lar yanar.
  - **Tükenmiş:** çatlak gövde, sönmüş çanak, kül izi.
- **Model:** `cube_bottom_top` + `facing`; aktif/tükenmiş için blockstate varyantı.

#### Adak Kaidesi

- **Texture'lar:** `adak_kaidesi_top`, `adak_kaidesi_side` (16×16).
- **Silüet:** küçük, alçak sütun; üstte adak yuvası.
- **Renk:** nether tuğlası gövde, blackstone üst, kemik rune.
- **Detay:** yuvada hafif çukur gölge; adak konunca üstte küçük ırk rengi halka.

#### Sütun

- **Texture'lar:** `sutun_top`, `sutun_side` (16×16).
- **Silüet:** 2–3 blok yüksekliğinde ritüel sütunu.
- **Renk:** nether tuğlası/bazalt; dikey rune kabartmaları.
- **Detay:** üstte ve altta kemik halka; gövdede tek renk rune.

#### Ruh Dövme Masası (blok)

- **Texture'lar:** `ruh_dovme_masasi_top`, `_side`, `_front` (16×16).
- **Silüet:** örs + ocak karışımı; ağır, alçak, endüstriyel.
- **Gövde:** blackstone/bazalt; köşelerde bakır perçin.
- **Ön:** kırmızı-sıcak ocak ağzı (`#E17055` → `#FFB86B`), üstte 3 parça yuvası.
- **Durumlar:** **sönük** (soğuk ocak) ve **aktif** (ocak yanıyor, parçalar parlıyor).
- **Model:** `orientable` + `facing`; aktiflik blockstate ile.

### 10.6 Boss kılıçları ve Ruh Kırıcı (M3/M5)

| Silah | Silüet | Gövde | Sap/Balçak | Çekirdek | Karakter |
|---|---|---|---|---|---|
| **Kızıl Kılıç** | Geniş, eğri pala | Kararmış çelik, kan oluğu | Kemik sap, kırmızı taş topuz | Kan kırmızısı | Vahşi, kısa, ağır |
| **Devre Kılıcı** | Düz, ince, sivri | Çelik + devre gravürü | Bakır balçak, siyah sap | Redstone kırmızısı | Hassas, teknik, soğuk |
| **Mimarın Kılıcı** | Kalın, kısa, keski uçlu | Taş/kuvars kaplama | Kuvars balçak, deri sap | Amber | Ağır, inşaatçı, bloklu |
| **Ruh Kırıcı** | Üç bıçağın kaynaşması, testere kenar | Üç renkli damar, çatlak çelik | Nether Star çekirdek, siyah sap | Üç renk aynı anda | Kaotik, endgame, ürkütücü |

- **Ortak kural:** üç boss kılıcı aynı "kararmış çelik" tabanını kullanır; sadece silüet, balçak ve çekirdek rengi değişir.
- **Ruh Kırıcı:** 16×16'da bile "üç kılıç birleşmiş" okunmalı; üç renk damarı birbirine dolaşır, Nether Star merkezde parlar.
- **Animasyon notu:** GeckoLib 3D modelde kılıç ayrı bir kemik olacak; 2D texture sadece envanter/GUI ikonu.

### 10.7 Bosslar (GeckoLib, M3/M5)

| Boss | Silüet | Palet | Ana özellik | Emissive | Faz 2 |
|---|---|---|---|---|---|
| **Sinyal Efendisi** | Uzun, ince, havada süzülen | Siyah devre, bakır, redstone kırmızısı | Lamba kafası, tek büyük göz, kablo kolları | Kırmızı çekirdek + devre izleri | Gövde çatlar, çekirdek açığa çıkar, daha parlak |
| **Mimar-ı Azam** | İri, geniş, ağır | Bazalt, kuvars, amber | Taş zırh, keski eller, omuzda iskele | Amber çekirdek + çatlaklar | Zırh kırılır, amber magma çatlakları |
| **Kanlı Muhafız** | Zırhlı düellocu, atletik | Blackstone, kan kırmızısı, ruh mavisi | Testere pala, zincir, pelerin | Mavi gözler + kırmızı aura | Zırh parçalanır, kan aurasi, hızlanır |

- **Teknik:** kafa, gövde, kollar, bacaklar, pelerin ve silah **ayrı kemikler**; animasyonda bağımsız hareket eder.
- **Emissive:** parlayan kısımlar ayrı `_glow` texture katmanında; GeckoLib emissive renderer ile.
- **Boyut:** minimum 128×128; ayrı parçalar çoksa 256×256 atlas.
- **Ortak his:** hepsi "bir zamanlar muhafızdı" — zırh kalıntıları, yorgun ama tehditkâr duruş.
- **Kale blokları:** kaleler vanilla paletiyle (nether brick, basalt, blackstone, crimson, quartz) inşa edilir; özel kale texture'ı üretilmez. Özel görünüm boss arenasındaki dekoratif bloklar ve partiküllerle sağlanır.

### 10.8 Arayüz, HUD ve partiküller (M4)

#### Ruh Cebi GUI

- **Boyut:** 256×256.
- **Panel:** koyu blackstone çerçeve, iç yüzey `#241A2B`; köşelerde ince redstone devre deseni.
- **Slotlar:** 9×3, vanilla envanteriyle aynı boyut (18×18).
- **Limit çubukları:** her slotun altında ince, ırk renginde dolum çubuğu.
- **Sekmeler:** üstte küçük ikonlar (tümü / bloklar / redstone / arama).
- **Bağlı eşya işareti:** envanterde eşyanın köşesinde küçük ruh bağı ikonu (kilit/rune) ve ince mor dış hat; eşyanın atılamadığını/konamadığını görsel olarak belli eder.
- **His:** "ruhun içine açılan" karanlık bir panel; parlak GUI değil.

#### HUD

- **Yozlaşmış kalp:** koyu kalp silüeti, kırmızı çatlak, hafif mor gölge.
- **Mühür:** küçük rune/çentik ikonu; 2 mühür = 1 kalp göstergesi.
- **Adrenalin:** küçük kılıç/şimşek ikonu; can azaldıkça dolar.
- **Ruh Sığı:** kalkan ikonu + cooldown çemberi.
- **Ritüel:** dairesel rune halkası, 5 dk geri sayım, dalga sayacı, kanallama çubuğu.

#### Partiküller

- **Boyut:** 4×4 veya 8×8.
- **Stil:** yumuşak parlama, sert kenar yok; additive blend.
- **Türler:**
  - `redstone_spark` — kırmızı kıvılcım.
  - `builder_dust` — amber toz.
  - `soul_flame` — mavi ruh alevi.
  - `corruption` — siyah-mor çekirdek + ırk rengi kenar.
- **Kullanım:** boss saldırıları, ritüel, bağlı blok kırılması, cep açılışı.

### 10.9 Dosya adlandırma ve klasörler

```text
src/main/resources/assets/modirk/
├── textures/
│   ├── item/            ruh_tasi_redstone.png, kilic_parcasi.png, ...
│   ├── block/           sunak_top.png, sunak_side.png, ...
│   ├── entity/          sinyal_efendisi.png, mimar_i_azam.png, ...
│   ├── gui/             ruh_cebi.png, icons/...
│   └── particle/        redstone_spark.png, ...
├── models/
│   ├── item/            <esya>.json
│   └── block/           <blok>.json
├── blockstates/         <blok>.json
└── lang/                en_us.json, tr_tr.json
```

- Dosya adları **registry id ile birebir** aynı olacak (`snake_case`).
- 3D GeckoLib modelleri `geo/` ve `animations/` altında; texture'lar model başına ayrı dosya.
- Emissive katmanlar `_glow` sonekiyle.
- GUI ikonları `gui/icons/` altında; 16×16 veya 9×9.

### 10.10 Üretim tablosu

| Texture | Yol | Boyut | Milestone | Durum | Kısa tarif |
|---|---|---|---|---|---|
| Redstone Ruhu | `item/redstone_ruhu.png` | 16×16 | M0 | ♻️ Yenilenecek | Siyah devre parçası, kırmızı kare çekirdek |
| Builder Ruhu | `item/builder_ruhu.png` | 16×16 | M0 | ♻️ Yenilenecek | Kırık kuvars küp, amber prizma |
| PvP Ruhu | `item/pvp_ruhu.png` | 16×16 | M0 | ♻️ Yenilenecek | Kan damlası hançer, mavi çekirdek |
| Logo | `logo.png` | 128×128 | M0 | ✅ Final | Kullanıcı görseli |
| Ruh Taşı (Redstone) | `item/ruh_tasi_redstone.png` | 16×16 | M2 | ⬜ Planlı | Kristal, kırmızı devre çatlağı |
| Ruh Taşı (Builder) | `item/ruh_tasi_builder.png` | 16×16 | M2 | ⬜ Planlı | Kristal, amber geometrik çatlak |
| Ruh Taşı (PvP) | `item/ruh_tasi_pvp.png` | 16×16 | M2 | ⬜ Planlı | Kristal, mavi ruh + kırmızı damar |
| Kılıç Parçası | `item/kilic_parcasi.png` | 16×16 | M2 | ⬜ Planlı | Kırık çelik uç, deri sap |
| Lanetli Taş (Redstone) | `item/lanetli_tas_redstone.png` | 16×16 | M2 | ⬜ Planlı | Siyah taş, kırmızı devre çatlağı |
| Lanetli Taş (Builder) | `item/lanetli_tas_builder.png` | 16×16 | M2 | ⬜ Planlı | Siyah taş, amber geometri |
| Lanetli Taş (PvP) | `item/lanetli_tas_pvp.png` | 16×16 | M2 | ⬜ Planlı | Siyah taş, mavi çatlak + kırmızı damar |
| Ritüel Tableti | `item/rituel_tableti.png` | 16×16 | M2 | ⬜ Planlı | Kırık taş tablet, mavi rune |
| Sunak | `block/sunak_*.png` | 16×16 | M2 | ⬜ Planlı | Nether tuğlası + ruh çanağı |
| Adak Kaidesi | `block/adak_kaidesi_*.png` | 16×16 | M2 | ⬜ Planlı | Küçük sütun, adak yuvası |
| Sütun | `block/sutun_*.png` | 16×16 | M2 | ⬜ Planlı | Rune kabartmalı sütun |
| Ruh Dövme Masası | `block/ruh_dovme_masasi_*.png` | 16×16 | M2 | ⬜ Planlı | Örs + ocak, 3 parça yuvası |
| Kızıl Kılıç | `item/kizil_kilic.png` | 16×16 | M3 | ⬜ Planlı | Eğri pala, kan oluğu |
| Devre Kılıcı | `item/devre_kilici.png` | 16×16 | M3 | ⬜ Planlı | Düz bıçak, devre gravürü |
| Mimarın Kılıcı | `item/mimar_kilici.png` | 16×16 | M3 | ⬜ Planlı | Kalın keski bıçak, kuvars balçak |
| Sinyal Efendisi | `entity/sinyal_efendisi.png` | 128+ | M3 | ⬜ Planlı | Devre gövde, lamba kafa |
| Mimar-ı Azam | `entity/mimar_i_azam.png` | 128+ | M3 | ⬜ Planlı | Taş zırh, amber çekirdek |
| Kanlı Muhafız | `entity/kanli_muhafiz.png` | 128+ | M3 | ⬜ Planlı | Blackstone zırh, kan pelerin |
| Ruh Cebi GUI | `gui/ruh_cebi.png` | 256×256 | M4 | ⬜ Planlı | Koyu panel, redstone köşe |
| HUD ikonları | `gui/icons/*.png` | 9–16 | M4 | ⬜ Planlı | Kalp, mühür, adrenalin, kalkan |
| Partiküller | `particle/*.png` | 4–8 | M4 | ⬜ Planlı | Kıvılcım, toz, ruh alevi, yozlaşma |
| Ruh Kırıcı | `item/ruh_kirici.png` | 16×16 | M5 | ⬜ Planlı | Üç bıçak, üç renk, Nether Star |
| 3D item texture'ları | `item/3d/*.png` | 32–64 | M5 | ⬜ Planlı | GeckoLib model parçaları |

### 10.11 Kalite kontrol listesi

- [ ] 16×16, şeffaf arka plan, anti-aliasing yok.
- [ ] 1 px koyu dış hat; sol üst ışık.
- [ ] En fazla 14 renk; aynı rampanın tonları.
- [ ] Silüet 16×16'da okunuyor; 2× büyütmede bozulmuyor.
- [ ] Vanilla itemlerle yan yana koyunca fazla parlak/kontrastlı değil.
- [ ] Üç ırk eşyası aynı setin parçası gibi duruyor.
- [ ] Renk körlüğü testi: şekiller ayırt edilebiliyor.
- [ ] Blok texture'ları dört yönde de sorunsuz dönüyor.
- [ ] Emissive katmanlar karanlıkta parlak, gündüzde göz yormuyor.
