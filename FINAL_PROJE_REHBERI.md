# Final Proje Rehberi - Adım Adım

Bu rehber, Final projesi için gerekli tüm adımları detaylı olarak açıklar.

---

## 📋 İçindekiler

1. [Test Coverage'ı %100'e Çıkarma](#1-test-coverageı-100e-çıkarma)
2. [Final Raporu Hazırlama](#2-final-raporu-hazırlama)
3. [Presentation Hazırlama](#3-presentation-hazırlama)
4. [GitHub'da Kontrol](#4-githubda-kontrol)

---

## 1. Test Coverage'ı %100'e Çıkarma

### Adım 1.1: Mevcut Coverage'ı Kontrol Etme

1. **GitHub Actions'dan Coverage Raporunu İndirme:**
   - GitHub repository'nize gidin: https://github.com/Sumeytm/Pomodoro-Timer
   - **Actions** sekmesine tıklayın
   - En son başarılı workflow çalışmasına tıklayın
   - Sayfanın en altında **Artifacts** bölümünü bulun
   - **coverage-reports** artifact'ını indirin
   - ZIP dosyasını açın
   - `index.html` dosyasını tarayıcıda açın
   - Hangi sınıfların coverage'ı düşük görün

2. **Yerel Olarak Coverage Kontrolü (Eğer Maven yüklüyse):**
   ```bash
   cd pomodorotimertimertimer-app
   mvn clean test jacoco:report
   ```
   Sonra `target/site/jacoco/index.html` dosyasını tarayıcıda açın

### Adım 1.2: Eksik Testleri Belirleme

Coverage raporunda:
- **Kırmızı/Yellow** renkli sınıflar: Düşük coverage
- **Yeşil** renkli sınıflar: Yüksek coverage

Her sınıf için:
1. Hangi metodlar test edilmemiş?
2. Hangi branch'ler (if/else) test edilmemiş?
3. Edge case'ler test edilmiş mi?

### Adım 1.3: Eksik Testleri Yazma

Örnek: `DoubleLinkedList.java` için eksik testler varsa:

1. `DoubleLinkedListTest.java` dosyasını açın
2. Eksik senaryoları ekleyin:

```java
@Test
public void testEdgeCase1() {
    // Eksik test senaryosu
}

@Test
public void testEdgeCase2() {
    // Başka bir eksik test senaryosu
}
```

### Adım 1.4: Coverage'ı %100'e Ayarlama

1. `pom.xml` dosyasını açın
2. Şu satırları bulun (yaklaşık satır 216-230):

```xml
<limit>
    <counter>LINE</counter>
    <value>COVEREDRATIO</value>
    <minimum>0.80</minimum>  <!-- Burayı değiştir -->
</limit>
```

3. Tüm `minimum` değerlerini `1.0` yapın:

```xml
<limit>
    <counter>LINE</counter>
    <value>COVEREDRATIO</value>
    <minimum>1.0</minimum>  <!-- %100 için -->
</limit>
<limit>
    <counter>BRANCH</counter>
    <value>COVEREDRATIO</value>
    <minimum>1.0</minimum>  <!-- %100 için -->
</limit>
<limit>
    <counter>METHOD</counter>
    <value>COVEREDRATIO</value>
    <minimum>1.0</minimum>  <!-- %100 için -->
</limit>
<limit>
    <counter>CLASS</counter>
    <value>COVEREDRATIO</value>
    <minimum>1.0</minimum>  <!-- %100 için -->
</limit>
```

4. Değişiklikleri kaydedin ve commit edin:
```bash
git add pom.xml
git commit -m "Set coverage requirement to 100%"
git push
```

### Adım 1.5: Coverage'ı Doğrulama

1. GitHub Actions'da yeni workflow çalışmasını bekleyin
2. Coverage check adımının başarılı olduğunu kontrol edin
3. Eğer başarısız olursa, hangi sınıfların eksik olduğunu kontrol edin
4. Eksik testleri ekleyin ve tekrar push edin

---

## 2. Final Raporu Hazırlama

### Adım 2.1: Rapor Şablonunu İndirme

1. GitHub'dan şablonu indirin:
   - https://github.com/rteu-ceng/rteu-ceng-project-homework-report-template
   - **Code > Download ZIP** ile indirin
   - Veya `git clone` ile klonlayın

2. Şablonu projenize kopyalayın veya referans alın

### Adım 2.2: Rapor İçeriğini Hazırlama

Rapor şu bölümleri içermeli:

#### A. Proje Özeti
- Proje adı: Pomodoro Timer - Data Structures Project
- Amaç: 12 veri yapısı ve algoritmanın Java implementasyonu
- Kullanılan teknolojiler: Java, Maven, JUnit 5, JaCoCo

#### B. Algoritma Açıklamaları
Her algoritma için:
1. **Algoritma Adı** (örn: Double Linked List)
2. **Açıklama**: Ne işe yarar, nasıl çalışır
3. **Karmaşıklık Analizi**: Big-O notasyonu
4. **Kullanım Senaryosu**: Gerçek hayat örneği
5. **Implementasyon Detayları**: Önemli kod parçaları

#### C. Test Stratejisi
- Test framework: JUnit 5
- Coverage: %100 (veya mevcut coverage)
- Test senaryoları: Her algoritma için test edilen durumlar

#### D. Sonuçlar ve Analiz
- Test sonuçları
- Coverage raporları
- Performans analizi (varsa)

#### E. Zorluklar ve Çözümler
- Karşılaşılan zorluklar
- Çözüm yaklaşımları

### Adım 2.3: Ekran Görüntüleri Ekleme

1. **Coverage Raporu:**
   - GitHub Actions'dan coverage raporunu indirin
   - `index.html` dosyasını açın
   - Ekran görüntüsü alın (Windows: Win+Shift+S)

2. **Test Sonuçları:**
   - GitHub Actions'da test adımının loglarını gösterin
   - Ekran görüntüsü alın

3. **Javadoc:**
   - Javadoc HTML'ini açın
   - Önemli sınıfların dokümantasyonunu gösterin
   - Ekran görüntüsü alın

### Adım 2.4: Raporu PDF'e Dönüştürme

1. Word/LaTeX ile hazırladıysanız:
   - **File > Export > Create PDF**

2. Markdown kullanıyorsanız:
   - Pandoc kullanın: `pandoc report.md -o report.pdf`
   - Veya online araçlar kullanın (örn: https://www.markdowntopdf.com/)

---

## 3. Presentation Hazırlama

### Adım 3.1: Sunum Yapısı

1. **Giriş (1-2 slide)**
   - Proje adı
   - Takım üyeleri
   - Proje amacı

2. **Proje Genel Bakış (2-3 slide)**
   - 12 algoritma listesi
   - Kullanılan teknolojiler
   - Proje yapısı

3. **Algoritma Sunumları (12 slide)**
   Her algoritma için:
   - Algoritma adı
   - Kısa açıklama
   - Karmaşıklık analizi
   - Demo/Örnek (opsiyonel)

4. **Test ve Coverage (2-3 slide)**
   - Test stratejisi
   - Coverage sonuçları
   - Test örnekleri

5. **CI/CD Pipeline (1-2 slide)**
   - GitHub Actions
   - Otomatik testler
   - Otomatik dokümantasyon

6. **Sonuç (1 slide)**
   - Öğrenilenler
   - Zorluklar
   - Gelecek çalışmalar

### Adım 3.2: Sunum Araçları

- **PowerPoint**: Klasik seçenek
- **Google Slides**: Online, işbirliği kolay
- **Canva**: Modern tasarım
- **Prezi**: İnteraktif sunum

### Adım 3.3: Demo Hazırlama (Opsiyonel)

1. **Kod Demo:**
   - Eclipse/IntelliJ'de projeyi açın
   - Bir algoritmanın nasıl çalıştığını gösterin
   - Test çalıştırın

2. **GitHub Demo:**
   - Repository'yi gösterin
   - Actions sekmesini gösterin
   - Coverage raporunu gösterin

---

## 4. GitHub'da Kontrol

### Adım 4.1: Repository Kontrolü

1. **README.md güncel mi?**
   - Proje açıklaması var mı?
   - Kurulum talimatları var mı?
   - Kullanım örnekleri var mı?

2. **Kod kalitesi:**
   - Tüm dosyalar commit edilmiş mi?
   - Gereksiz dosyalar `.gitignore`'da mı?

### Adım 4.2: GitHub Actions Kontrolü

1. **Actions sekmesi:**
   - Son workflow başarılı mı?
   - Tüm adımlar yeşil mi?

2. **Artifacts:**
   - Coverage raporları yükleniyor mu?
   - Javadoc yükleniyor mu?

### Adım 4.3: Son Kontroller

1. **Test Coverage:**
   ```bash
   # Eğer Maven yüklüyse
   cd pomodorotimertimertimer-app
   mvn clean test jacoco:report
   # target/site/jacoco/index.html dosyasını kontrol edin
   ```

2. **Javadoc:**
   ```bash
   mvn javadoc:javadoc
   # target/javadoc/index.html dosyasını kontrol edin
   ```

3. **Build:**
   ```bash
   mvn clean package
   # target/ klasöründe JAR dosyası oluşmalı
   ```

---

## 📝 Önemli Notlar

### Coverage %100 Zorunlu mu?

PDF'de %100 coverage gereksinimi var ama:
- **Minimum %80** ile başlayabilirsiniz
- Sonra eksik testleri ekleyerek %100'e çıkarabilirsiniz
- **Önemli**: Kritik algoritmalar (Huffman, B+, KMP, File Ops) için %100 olmalı

### Final Rapor Formatı

Rapor şu formatta olmalı:
- **PDF formatında**
- **Türkçe veya İngilizce**
- **En az 10-15 sayfa**
- **Kod örnekleri, ekran görüntüleri, grafikler içermeli**

### Presentation Süresi

Genellikle:
- **10-15 dakika** sunum
- **5 dakika** soru-cevap
- Her takım üyesi konuşmalı

---

## ✅ Final Checklist

Sunumdan önce kontrol edin:

- [ ] Tüm 12 algoritma implement edilmiş
- [ ] Tüm testler çalışıyor
- [ ] Coverage en az %80 (tercihen %100)
- [ ] Javadoc oluşturulmuş
- [ ] GitHub Actions başarılı
- [ ] Final raporu hazır
- [ ] Presentation hazır
- [ ] Demo hazır (opsiyonel)
- [ ] Kod GitHub'da güncel
- [ ] README.md güncel

---

## 🆘 Yardım

Sorun yaşarsanız:
1. GitHub Issues kullanın
2. Hoca ile iletişime geçin
3. Takım arkadaşlarınızla görüşün

**Başarılar! 🎉**

