# Races (modirk) — Tasarım Dokümanı

> Durum: **Tasarım v1.7 (oynanış detaylandırıldı, sanat yönü brief oldu)** · Son güncelleme: 2026-11-26
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

### 1.8 Oyuncu yolculuğu (hedef akış)

| Aşama | Oyuncunun yaptığı | Öğrendiği |
|---|---|---|
| Keşif | Nether'da kale arar, kalıntıları okur | Üç muhafız, üç kale, Ruh Taşı |
| İlk boss | Bir kaleyi temizler, bossu yener | Kale tekrar doğar; parçalar toplanır |
| Zanaat | 3 parçayı Dövme Masası'nda birleştirir | Kılıç ve Lanetli Taş yolu |
| Hazırlık | Sunak, kaideler, sütunlar, adaklar | Ritüel alanı ve adak listesi |
| Ritüel | 5 dakikalık Yozlaşma Evresi'ni tamamlar | Irk kazanılır |
| Ustalık | Zayıflığıyla yaşar; cep, kalp, adrenalin yönetir | Irkın kimliği |
| Sıfırlama | 3 kılıcı + Nether Star'ı birleştirir | Ruh Kırıcı ile yeniden seçim |

**Hedef süre:** ilk ırk ~2–4 saat; ikinci ırk daha hızlı (oyuncu artık ritüeli ve kaleleri biliyor).

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

### 2.1 Kale akışı

Her kale aynı iskeleti kullanır; tema odaları değişir:

1. **Dış sur ve köprü** — kaleye giriş; tema bloğu ve tuzaklar.
2. **Mahzen koridoru** — sandıklar, kılıç parçası şansı, ruh izleri.
3. **Tema odası** — bossun gücünü gösteren mekanik (redstone devresi / inşaat iskelesi / kan arenası).
4. **Bozulmuş bölüm** — palet değişir, partikül yoğunlaşır, ses değişir.
5. **Boss arenası** — taht/sunak merkezde; kenarlarda boss mekaniğine bağlı bloklar.

- Arenaya girişte boss uyanır (GeckoLib giriş animasyonu + ses).
- Arena sınırları bellidir; oyuncu kaçarsa boss sıfırlanır (can yenilenir, arenaya dönünce yeniden uyanır).
- Kale içinde **1 Ritüel Tableti** ve **en az 2 loot sandığı** garanti.
- Kaleler birbirinden bağımsız doğar; aynı türden birden fazla kale olabilir.

### 2.2 Loot ve ipuçları

- Sandık tabloları: tema malzemesi + nadir kılıç parçası + çok nadir Ruh Taşı.
- Kılıç parçaları **tek tip**; hangi kaleden çıktığı önemli değil, 3 tanesi bir kılıç olur.
- Boss drop'u: Ruh Taşı (1) + kılıç parçası (1–2) + tema malzemesi.
- Kale kalıntıları bossun düşüşünü anlatır; oyuncu ritüelin nedenini burada öğrenir.
- Sandıklar oyuncu başına değil, dünya başına bir kez açılır (yeniden doğan kalelerde yenilenir).

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

### 3.4 Arena etkileşimleri

| Boss | Arenada ne değişir | Oyuncu ne yapmalı |
|---|---|---|
| **Sinyal Efendisi** | Zemin devre plakalarına dönüşür; bazıları yüklenince patlar | Plakaları oku, güvenli aralıklarda vur |
| **Mimar-ı Azam** | Duvarlar yükselir, zemin katmanları kayar | Boşlukları oku, keski vuruşundan kaç |
| **Kanlı Muhafız** | Ruh ateşi halkaları daralır, kan havuzları yavaşlatır | Halkaları zamanla, dash'i cezalandır |

- Arenadaki mekanikler **ırk oyuncusuna avantaj** verir (Redstone tuzakları sökebilir, Builder zemini yeniden kurabilir, PvP dash'i cezalandırır).
- Hiçbir mekanik oyuncuyu kalıcı olarak kilitlemez; her tuzak bir çıkış bırakır.

### 3.5 Faz geçişi ve tekrar edilebilirlik

- Faz 2 eşiği: can **%50**. Geçişte kısa "kükreme" animasyonu, arena değişimi ve yardımcı mob dalgası.
- Boss ölünce kale söner ama yıkılmaz; bir süre sonra aynı türden **yeni kale** doğar.
- **Zorluk ölçeklenmez**: boss her zaman aynı güçte; oyuncu ırkla güçlenir.
- Boss tekrar dövüşü aynı drop'u verir; oyuncu her tazelemede bir Ruh Taşı harcar.

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

### 4.4 Irk etkileşimleri ve uç durumlar

- **Irk değiştirme:** yalnızca Ruh Kırıcı ile. `/race set` yönetici/test içindir.
- **Ölüm:** varsayılan olarak ırk korunur; `keepRaceOnDeath` ile kapatılabilir.
- **Boyut değişimi (Nether/End):** ırk ve cep verisi taşınır; bekleyen iadeler kuyrukta kalır.
- **Çoklu oyuncu:** bağlı bloklar sahibine aittir; başka oyuncu kırarsa eşya sahibine döner.
- **Sunucu yeniden başlatma:** cep, bekleyen iadeler ve ritüel durumu `SavedData` ile korunur.
- **Yeniden doğma:** cep içeriği, limitler ve mühürler korunur.
- **Config:** limitler, yüzdeler, cooldown'lar ve drop şansları config'e taşınır; public sunucular için "gevşetme" profili.

## 5. Ritüel

### 5.1 Ritüel Alanı (oyuncu inşası)

- Worldgen tapınak yok; oyuncu kendi ritüel alanını **elle inşa eder**.
- Multiblock: 5×5 platform, merkezde **Sunak**, 3 **Ruh Kaidesi**, 4 sütun.
- **Ruh Kaidesi** aynı zamanda sergileme bloğudur: üstüne konan tek eşyayı havada döndürerek gösterir (adaklar ve ruh eşyaları için).
- **Ritüel Tableti** inşa pattern'ini ve koşulları gösterir.
- Alan **Nether'da** kurulur; Overworld'de çalışmaz.
- **Sunak yerinde kalır**, ritüel sonrası "tükenmiş" görünüme geçer ve **yeni bir Ruh Taşı** ile tekrar kullanılabilir. Tekrar inşa gerekmez; gerçek sınır Ruh Taşı'dır.

### 5.2 Ruh Bağı Ritüeli

1. Sunağa **Ruh Taşı** (boss drop'u) konur.
2. **Lanetli Taş** sunağa yerleştirilir; Ruh Taşı, taşın malzemesinin ruhuyla yozlaşır ve **5 dakikalık Yozlaşma Evresi** başlar. Bu süre içinde ritüel tamamlanmalıdır. **Zaman/hava koşulu yoktur.**
3. Irka özel **3 adak** Ruh Kaidelerine yerleştirilir; kaide üstünde havada sergilenir.
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

### 5.5 Ritüel durum makinesi

| Durum | Giriş | Çıkış |
|---|---|---|
| `IDLE` | Sunak boş | Ruh Taşı konunca `STONE_SET` |
| `STONE_SET` | Ruh Taşı var | Doğru Lanetli Taş konunca `CORRUPTING` |
| `CORRUPTING` | 5 dk sayaç başlar | Adaklar + XP + dalgalar tamamlanınca `CHANNELING` |
| `CHANNELING` | 15 sn kesintisiz | Süre dolarsa `SUCCESS` |
| `SUCCESS` | Irk atanır | Sunak `EXHAUSTED` |
| `FAILED` | Süre/koşul ihlali | Adaklar iade, taşlar tükenir, `IDLE` |
| `EXHAUSTED` | Yeni Ruh Taşı bekler | Yeni taş konunca `STONE_SET` |

- Her durum geçişi **ses + partikül + action bar** mesajıyla bildirilir.
- Dalga sayısı ve mob türü ırka göre değişir; dalgalar arenanın dışından gelir.
- Oyuncu sunağa 3 bloktan fazla uzaklaşırsa kanallama sıfırlanır (süre baştan başlar).
- Sunak kırılırsa ritüel iptal olur; adaklar ve taşlar iade edilir (ceza yok).

### 5.6 Geri bildirim

- **Sunak:** durumuna göre çanak rengi (boş / aktif / tükenmiş).
- **Sayaç:** action bar'da 5:00 geri sayım; son 30 sn kırmızı yanıp söner.
- **Dalga:** ekranın üstünde "Muhafızın kalıntıları: 2/3" sayacı.
- **Kanallama:** sunağın etrafında dolanan rune halkası + yükselen ruh partikülleri.
- **Başarı:** advancement, ırk rengi patlaması, boss temalı ses.

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

### 7.1 Paket yapısı (hedef)

```
com.modirk
├── Modirk
├── block/            sunak, kaide, sütun, dövme masası
├── block/entity/
├── client/           renderer, screen, HUD
├── command/
├── config/
├── item/             ruh eşyaları, ruh taşı, parçalar, kılıçlar
├── race/             Race, RaceData, RaceEvents, ırk mekanikleri
├── registry/
└── world/            kale yapıları, loot, SavedData
```

### 7.2 Veri ve ağ

- **Attachment:** oyuncu ırkı, cep içeriği, mühür sayısı, kill sayacı.
- **SavedData:** bağlı bloklar (boyut + pozisyon → sahip + eşya), oyuncunun yerleştirdiği bloklar, bekleyen iadeler, aktif ritüeller.
- **Ağ:** cep UI senkronizasyonu, HUD sayaçları, ritüel durumu; istemci asla otorite değil.
- **Olaylar:** blok kırma/yerleştirme, hasar, ölüm, boyut değişimi, oyuncu giriş/çıkış.
- **Kayıt uyumu:** tüm kalıcı veriler sürümlenebilir olmalı (ileride alan eklenince eski dünyalar bozulmasın).

## 8. Yol Haritası

- **M0 (tamamlandı):** NeoForge 1.21.1 iskeleti, temiz repo (README, LICENSE, .gitignore, build/ temizliği), çalışan build
- **M1 (tamamlandı):** Irk verisi, `/race` komutları, config, ölümde koruma
- **M2 (devam ediyor):** Ruh Kaidesi tamam; Ruh Taşı, Sunak, ritüel multiblock, Ritüel Tableti, Ruh Dövme Masası, Lanetli Taş
- **M3:** Nether kalesi varyantları, bosslar, kılıç parçaları, loot, özel kılıçlar
- **M4:** Ruh Cebi, Builder bonusu, Adrenalin + açlık bedeli, Ruh Sığı
- **M5:** Animasyonlar, Ruh Kırıcı, advancement'lar, HUD/GUI, ruh eşyalarının 3D GeckoLib modelleri
- **M6:** Dil, README, denge, sürüm

## 9. Açık Sorular (yalnızca tuning)

> Tasarım kararları tamamlandı. Aşağıdakiler kod yazılırken sayısal olarak ayarlanacak.

- [ ] Boss can/hasar değerleri, faz 2 eşiği ve yardımcı mob sayıları
- [ ] Boss saldırı setlerinin sayısal detayları (cooldown, menzil, hasar)
- [ ] Kale spawn sıklığı ve minimum mesafe
- [ ] Ruh Taşı nadir sandık şansı
- [ ] Kılıç parçası drop oranları (sandık + boss); ritüel + boss kılıcı için toplam 6 parça gerektiğini hesaba kat
- [ ] Ritüel dalga sayısı, mob türleri ve XP maliyeti
- [ ] Adak listelerinin sadeleştirilmesi ve netleştirilmesi
- [ ] Redstone cep limitleri ve mühür/kalp eşiği
- [ ] Builder ekstra drop şansı ve kapsam listesi
- [ ] Adrenalin formülü, açlık bedeli ve Ruh Sığı cooldown'ı
- [ ] Ruh Dövme Masası'nın mekaniği (custom recipe mi, Menu/Screen mi?)
- [ ] Public mod için config ile gevşetme seçenekleri

## 10. Sanat Yönü (tasarımcı brief'i)

> Bu bölüm **reçete değil, yön** verir. Somut formlar, kompozisyon ve detay tasarımcıya bırakılmıştır. Aşağıdaki teknik kısıtlar ve ton bağlayıcıdır; gerisi hayal gücüne açıktır.

### 10.1 Ton ve his

- **Karanlık mitoloji:** eski, ağır, ritüelistik. Parıldayan fantastik mücevher değil; yıllardır toprak altında kalmış, üzerinde yemin taşıyan bir kalıntı.
- **Düşmüş muhafız izi:** her eşya "bir zamanlar bir muhafıza aitti" hissi vermeli. Kırık, aşınmış, tamamlanmamış.
- **Nether:** sıcak ama ölü; kor, kül, bazalt, ruh ateşi. Yumuşak mavi gökyüzü yok.
- **Vanilla'ya yakınlık:** Minecraft'ın görsel diliyle konuşmalı; başka bir oyundan import edilmiş gibi durmamalı.

**Tek cümlelik yön:** *"Nether'ın altında yüzyıllardır bekleyen, içinde hâlâ bir ruhun yandığı muhafız kalıntıları."*

### 10.2 Ruh eşyaları baştan tasarlanacak

- Şu anki üç ruh eşyası (**Redstone / Builder / PvP**) **geçicidir** ve **baştan tasarlanacak**.
- Mevcut formlar (kalp, tokmak, kırık kılıç) **öneri**dir; tasarımcı daha iyi bir silüet bulursa serbestçe değiştirebilir.
- Değişmeyecek olan: üçünün **aynı setin parçası** gibi durması, ırkın kimliğini taşıması ve envanterde okunması.

### 10.3 Teknik kısıtlar (bağlayıcı)

| Öğe | Boyut | Not |
|---|---|---|
| Item | 64×64 | Envanterde 16×16'ya ölçeklenir |
| Blok | 16×16 | Dört yönde sorunsuz dönmeli |
| GUI | 256×256 | Slotlar vanilla ölçüsünde |
| Boss / 3D model | 128×128+ | Gerekirse 256×256 atlas |
| Partikül | 4×4 – 8×8 | Yumuşak parlama |

- Şeffaf arka plan, anti-aliasing yok, blur yok.
- Piksel sanat; envanter boyutuna küçültüldüğünde dağılmamalı.
- Işık yönü tüm sette aynı (üst-sol).

### 10.4 Renk dünyası

Kesin hex zorunlu değil; aşağıdaki **aileler** yön verir:

| Aile | Hissi | Kullanım |
|---|---|---|
| Boşluk / is / indigo | Derinlik, yokluk | Dış hat, gövde gölgesi |
| Kemik / kuvars | Yaşlılık, taş | Muhafız zırhı, kaide, tablet |
| Bakır / patina | Oksitlenmiş makine | Redstone, mekanik parçalar |
| Kor / amber | İç ısı | Builder çekirdeği, ocak |
| Kan / kızıl | Şiddet | PvP, yemin, hasar |
| Ruh camgöbeği | Ölüm sonrası | PvP çekirdeği, ruh ateşi |

Her ırk **bir ana + bir vurgu** rengi taşır; üçü yan yana gelince aynı aile olduğu anlaşılmalı.

### 10.5 Silüet ve okunabilirlik

- Önce siyah silüette okunmalı: uzaktan bakınca "kalp mi, alet mi, silah mı" anlaşılmalı.
- Üç ırk sadece renkle değil **şekille** ayrılmalı (renk körlüğü).
- Detay silüetin içinde kalmalı; dış hattı bozan kılçıklar/parçacıklar sadeleştirilmeli.
- Envanterde 16×16'ya küçültülünce ana kütle ve çekirdek hâlâ görünmeli.

### 10.6 Ortak dil

- Aynı dünyaya ait olsunlar: benzer dış hat kalınlığı, aynı ışık, benzer aşınma dili.
- Her eşya aynı şablon olmak zorunda değil; kompozisyon özgür.
- Çekirdek/parlama tek odakta kalsın; her yer parlarsa "çiğ" durur.

### 10.7 Çizilecekler (kontrol listesi)

> Formlar serbest; yalnızca "ne anlatmalı" yazılı.

- **Ruh eşyaları (3):** Redstone, Builder, PvP — **baştan tasarım**.
- **Ruh Taşı (3 varyant):** muhafızın taşan ruhu; ırk renginde iç ışık.
- **Kılıç Parçası:** kırık, tek başına işe yaramaz, nötr.
- **Lanetli Taş (3):** yasak, kirli, çatlaklarında ırk rengi.
- **Ritüel Tableti:** okunmaya çalışılmış, yıpranmış kayıt.
- **Sunak:** ritüelin kalbi; boş / aktif / tükenmiş durumları.
- **Ruh Kaidesi:** sergileme; eşya üstünde durur.
- **Sütun:** ritüel çerçevesi.
- **Ruh Dövme Masası:** örs + ocak; parçaların birleştiği yer.
- **Boss kılıçları (3):** her biri sahibinin karakterini taşır.
- **Ruh Kırıcı:** üç yeminin kesişimi.
- **Bosslar (3):** düşmüş muhafız; zırh kalıntısı, yorgun ama tehditkâr.
- **Ruh Cebi GUI, HUD, partiküller.**

### 10.8 Dosya düzeni

```
assets/modirk/textures/
├── item/         64×64
├── block/        16×16
├── entity/       128+
├── gui/
└── particle/
```

- Dosya adları registry id ile birebir (`snake_case`).
- Emissive katmanlar `_glow` sonekiyle.
- 3D modeller `geo/` + `animations/` altında.

### 10.9 Teslim ve kalite kontrolü

- [ ] Doğru boyut, şeffaf arka plan.
- [ ] Envanter boyutunda okunuyor.
- [ ] Vanilla itemlerle yan yana "yabancı" durmuyor.
- [ ] Üç ırk eşyası aynı setin parçası gibi.
- [ ] Bloklar dört yönde dönüyor.
- [ ] Emissive katman gece/gündüz dengeli.

---

## 11. Oynanış Döngüsü ve İlerleme

### 11.1 Kısa döngü (5–15 dk)

- Kale temizliği → sandık/parça → Dövme Masası → kılıç veya Lanetli Taş.
- Nether'da malzeme toplama (adaklar) → ritüel alanını tamamlama.

### 11.2 Uzun döngü (2–4 saat)

- İlk boss → ilk Lanetli Taş → ilk ritüel → ilk ırk.
- Irkla oynanış: cep/kalp yönetimi, adrenalin, builder ekonomisi.
- İkinci/üçüncü kale → ikinci ırk veya Ruh Kırıcı için kılıçlar.

### 11.3 İlerleme eksenleri

| Eksen | Kaynak | Nereye harcanır |
|---|---|---|
| Ruh Taşı | Boss, nadir sandık | Irk ritüeli, cep tazeleme |
| Kılıç parçası | Kale sandığı, boss | Boss kılıcı, Lanetli Taş |
| Mühür | Redstone limitleri | Kalıcı kalp temizleme |
| Kill sayacı | PvP oynanışı | Ruh Sığı kilidi |
| Advancement | Keşif/başarı | Rehberlik |

### 11.4 Denge ilkeleri

- Irk güçlü ama **bedelli**: her ırkın bir kaynak tüketimi var.
- Zayıflık oyuncuyu cezalandırmaz; **oyun tarzını şekillendirir**.
- Bosslar ırkla kolaylaşır, ırksız da yenilebilir kalır.
- Grind değil **hazırlık**: ritüel için toplanan şeyler anlamlı olmalı.

## 12. UX, Erişilebilirlik ve Geri Bildirim

- Tüm kritik durumlar action bar + ses + partikül ile bildirilir.
- Renk körlüğü: ırklar şekil ve ikonla da ayrılır.
- Tuş atamaları: cep, Ruh Sığı, ritüel iptali — hepsi keybind/config.
- Tooltip'ler kısa; lore ayrı satırda ve italik.
- HUD ölçeklenebilir; GUI scale 1'de bile okunur.
- Tüm sunucu mesajları çeviri anahtarıyla (TR/EN).

## 13. Test ve Kalite

### 13.1 Manuel test matrisi

- Yeni dünya → ilk boss → ritüel → ırk (üç ırk için ayrı ayrı).
- Ölüm, yeniden doğma, boyut değişimi.
- Sunucu yeniden başlatma (cep, iade kuyruğu, ritüel durumu).
- Çoklu oyuncu: bağlı blok, iade, ritüel çakışması.
- Config aç/kapa: `keepRaceOnDeath`, limitler, drop şansı.

### 13.2 Otomatik testler

- Gametest: ritüel multiblock doğrulama, Lanetli Taş tarifi, cep limitleri.
- Birim: Adrenalin formülü, mühür/kalp hesabı, drop oranı hesaplayıcı.

### 13.3 Yayın öncesi

- Log'da uyarı yok; eksik çeviri yok.
- Jar boyutu makul; client/server ayrımı doğru.
- README ve DESIGN sürümleri eşleşiyor.
