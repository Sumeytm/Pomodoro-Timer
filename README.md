# CEN207-CE205 Veri Yapıları ve Algoritmalar Final Projesi

## Proje Özeti

Bu proje, Recep Tayyip Erdoğan Üniversitesi CEN207-CE205 dersi kapsamında geliştirilmiş 12 veri yapısı ve algoritmanın Java implementasyonunu içermektedir.

## Proje Bilgileri

- **Ders:** CEN207-CE205 Veri Yapıları ve Algoritmalar
- **Dönem:** 2025-2026 Güz Dönemi
- **Proje Tipi:** Final Projesi (Java Implementasyonu)
- **Test Framework:** JUnit 5
- **Dokümantasyon:** Javadoc

## Geliştiriciler

- **sumeyye** - sumeyye_yetim23@erdogan.edu.tr
- **selen** - selen_demirci23@erdogan.edu.tr
- **sudenur** - sudenur_demir22@erdogan.edu.tr
- **kaan** - RTEU

## İmplementasyonlar

### 1. Double Linked List
- **Dosya:** `DoubleLinkedList.java`
- **Test:** `DoubleLinkedListTest.java`
- **Açıklama:** Çift yönlü bağlı liste implementasyonu

### 2. XOR Linked List
- **Dosya:** `XORLinkedList.java`
- **Test:** `XORLinkedListTest.java`
- **Açıklama:** Bellek verimli XOR bağlı liste implementasyonu

### 3. Sparse Matrix
- **Dosya:** `SparseMatrix.java`
- **Test:** `SparseMatrixTest.java`
- **Açıklama:** Seyrek matris implementasyonu (HashMap tabanlı)

### 4. Stack
- **Dosya:** `Stack.java`
- **Test:** `StackQueueTest.java`
- **Açıklama:** LIFO (Last In First Out) yığın yapısı

### 5. Queue
- **Dosya:** `Queue.java`
- **Test:** `StackQueueTest.java`
- **Açıklama:** FIFO (First In First Out) kuyruk yapısı

### 6. Min Heap
- **Dosya:** `MinHeap.java`
- **Test:** `HeapTest.java`
- **Açıklama:** Minimum yığın (heap) veri yapısı

### 7. Heap Sort
- **Dosya:** `HeapSort.java`
- **Test:** `HeapTest.java`
- **Açıklama:** Yığın sıralama algoritması

### 8. Graph (BFS/DFS)
- **Dosya:** `Graph.java`
- **Test:** `GraphTest.java`
- **Açıklama:** Graf veri yapısı ve BFS/DFS algoritmaları

### 9. Hash Table
- **Dosya:** `HashTable.java`
- **Test:** `HashTableTest.java`
- **Açıklama:** Hash tablosu (chaining ile çakışma çözümü)

### 10. Strongly Connected Components (SCC)
- **Dosya:** `StronglyConnectedComponents.java`
- **Test:** `StronglyConnectedComponentsTest.java`
- **Açıklama:** Kosaraju algoritması ile güçlü bağlı bileşenler

### 11. KMP Algorithm
- **Dosya:** `KMPAlgorithm.java`
- **Test:** `KMPAlgorithmTest.java`
- **Açıklama:** Knuth-Morris-Pratt desen eşleştirme algoritması

### 12. Huffman Coding
- **Dosya:** `HuffmanCoding.java`
- **Test:** `HuffmanCodingTest.java`
- **Açıklama:** Huffman kodlama ile metin sıkıştırma/açma

### 13. B+ Tree
- **Dosya:** `BPlusTree.java`
- **Test:** `BPlusTreeTest.java`
- **Açıklama:** B+ ağaç yapısı (dosya indeksleme için)

### 14. File Operations
- **Dosya:** `FileOperations.java`
- **Test:** `FileOperationsTest.java`
- **Açıklama:** Linear probing ile hash tablosu kullanan dosya işlemleri

## Proje Yapısı

```
pomodorotimer-app/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── pomodorotimer/
│   │               └── pomodorotimer/
│   │                   ├── DoubleLinkedList.java
│   │                   ├── XORLinkedList.java
│   │                   ├── SparseMatrix.java
│   │                   ├── Stack.java
│   │                   ├── Queue.java
│   │                   ├── MinHeap.java
│   │                   ├── HeapSort.java
│   │                   ├── Graph.java
│   │                   ├── HashTable.java
│   │                   ├── StronglyConnectedComponents.java
│   │                   ├── KMPAlgorithm.java
│   │                   ├── HuffmanCoding.java
│   │                   ├── BPlusTree.java
│   │                   └── FileOperations.java
│   └── test/
│       └── java/
│           └── com/
│               └── pomodorotimer/
│                   └── pomodorotimer/
│                       ├── DoubleLinkedListTest.java
│                       ├── XORLinkedListTest.java
│                       ├── SparseMatrixTest.java
│                       ├── StackQueueTest.java
│                       ├── HeapTest.java
│                       ├── GraphTest.java
│                       ├── HashTableTest.java
│                       ├── StronglyConnectedComponentsTest.java
│                       ├── KMPAlgorithmTest.java
│                       ├── HuffmanCodingTest.java
│                       ├── BPlusTreeTest.java
│                       └── FileOperationsTest.java
├── pom.xml
└── README.md
```

## Gereksinimler

- **Java:** JDK 1.8 veya üzeri
- **Maven:** 3.6.0 veya üzeri
- **IDE:** Eclipse veya IntelliJ IDEA (önerilir)

## Kurulum ve Çalıştırma

### 1. Projeyi İndirin

```bash
git clone https://github.com/Sumeytm/Pomodoro-Timer.git
cd Pomodoro-Timer/pomodorotimertimertimer-app
```

### 2. Eclipse'te Açma

1. Eclipse'i açın
2. `File > Import > Existing Maven Projects`
3. `pomodorotimertimertimer-app` klasörünü seçin
4. `Finish` tıklayın

### 3. Testleri Çalıştırma

**Eclipse'te:**
- Projeye sağ tıklayın
- `Run As > JUnit Test` seçin

**Maven ile:**
```bash
mvn test
```

### 4. Javadoc Oluşturma

**Eclipse'te:**
1. Projeye sağ tıklayın
2. `Export > Java > Javadoc` seçin
3. `Next > Next > Finish` tıklayın
4. `doc` klasöründe HTML dosyaları oluşacaktır

**Maven ile:**
```bash
mvn javadoc:javadoc
```

Javadoc dosyaları `target/site/apidocs` klasöründe oluşacaktır.

## Test Sonuçları

Tüm testler başarıyla geçmektedir:
- ✅ 12 test dosyası
- ✅ Tüm algoritmalar için kapsamlı testler
- ✅ JUnit 5 kullanılmaktadır

## Dokümantasyon

Tüm sınıflar ve public metodlar Javadoc ile dokümante edilmiştir. Javadoc oluşturulduktan sonra `target/site/apidocs/index.html` dosyasından erişilebilir.

## Lisans

Bu proje eğitim amaçlı geliştirilmiştir.

## İletişim

Sorularınız için GitHub Issues kullanabilirsiniz.
