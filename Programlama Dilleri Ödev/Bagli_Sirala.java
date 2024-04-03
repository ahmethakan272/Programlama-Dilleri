import java.io.File;               // Ahmet Hakan Yılmaz 
import java.io.FileNotFoundException; // 02210224022
import java.util.Scanner;

public class Bagli_Sirala {
    public static void main(String[] args) {
        // Klavyeden dosya adını al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adini giriniz: ");
        String dosyaAdi = scanner.nextLine();

        try {
            File dosya = new File(dosyaAdi);
            Scanner dosyaOkuyucu = new Scanner(dosya);

            // Dosyadaki satır sayısını bul
            int satirSayisi = 0;
            while (dosyaOkuyucu.hasNextLine()) {
                dosyaOkuyucu.nextLine();
                satirSayisi++;
            }
            dosyaOkuyucu.close();

            // Dizi oluştur ve dosyadaki verileri diziye ekle
            int[] sayilar = new int[satirSayisi];
            String[] adresler = new String[satirSayisi];
            dosyaOkuyucu = new Scanner(dosya);
            int index = 0;
            while (dosyaOkuyucu.hasNextLine()) {
                String[] satir = dosyaOkuyucu.nextLine().split(" ");
                int sayi = Integer.parseInt(satir[0]); // İlk veriyi al (sayı)
                String adres = satir[1]; // İkinci veriyi al (adres)
                sayilar[index] = sayi;
                adresler[index] = adres;
                index++;
            }
            dosyaOkuyucu.close();

            // Dosyadan alındığı şekilde yazdır
            System.out.println("Siralanmamis Liste:");
            for (int i = 0; i < satirSayisi; i++) {
                System.out.println(sayilar[i] + " " + adresler[i]);
            }

            // Adresleri kopyala
            String[] kopyaAdresler = new String[satirSayisi];
            for (int i = 0; i < satirSayisi; i++) {
                kopyaAdresler[i] = adresler[i];
            }

            // Sayıları Buuble sort algoritmasıyla sırala
            for (int i = 0; i < satirSayisi - 1; i++) {
                for (int j = 0; j < satirSayisi - i - 1; j++) {
                    if (sayilar[j] > sayilar[j + 1]) {
                        // Sayıları yer değiştir
                        int tempSayi = sayilar[j];
                        sayilar[j] = sayilar[j + 1];
                        sayilar[j + 1] = tempSayi;
                    }
                }
            }

            // Sıralanmış sayıları ve sabit adresleri ekrana yazdır
            System.out.println("\nSiralanmiş Liste:");
            for (int i = 0; i < satirSayisi; i++) {
                System.out.println(sayilar[i] + " " + kopyaAdresler[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi.");
            e.printStackTrace();
        }
    }
}  

