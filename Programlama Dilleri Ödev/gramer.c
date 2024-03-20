#include <stdio.h>  // Ahmet Hakan YILMAZ
#include <string.h>  // 02210224022

 main() {
	
	// Özne,Nesne ve Yüklem dizileri
     char *oznedizisi[] = {"Ben", "Sen", "Hasan", "Nurþah", "Elif", "Abdulrezzak", "Þehribanu", "Zeynelabidin", "Naki"};
     char *nesnedizisi[] = {"Bahçe", "Okul", "Park", "Sýnýf", "Yarýn", "Pazartesi", "Salý", "Çarþamba", "Perþembe","Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneþ", "Beydaðý"};
     char *yuklemdizisi[] = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};
	
    char cumle[100];
    printf("Bir Cumle Girin: ");
    fgets(cumle, sizeof(cumle), stdin);

    // Cümlenin sonunda eklenen newline karakterini kaldýrýyoruz
    cumle[strcspn(cumle, "\n")] = '\0';

    // Cümledeki boþluk karekterlerinden kurtul
    char *kelime = strtok(cumle, " ");
    char *kelimeler[3];
    int kelimesayisi = 0;

    while (kelime != NULL && kelimesayisi < 3) { // ozne, nesne ve yuklem kelimeler dizisine ayrýlýr
        kelimeler[kelimesayisi++] = kelime;
        kelime = strtok(NULL, " ");
    }

    // Özne, Nesne ve Yüklem olarak ayrýlmýþ kelimeleri alýyoruz
    char *ozne = kelimeler[0];
    char *nesne = kelimeler[1];
    char *yuklem = kelimeler[2];

    // Özne, Nesne ve Yüklem dizisinde mi kontrol ediyoruz
    if (kontrol(ozne, oznedizisi, 9) && kontrol(nesne, nesnedizisi, 18) && kontrol(yuklem, yuklemdizisi, 6)) {
        printf("EVET");
    }
	 else {
        printf("HAYIR");
    }

    return 0;
}

// Bir kelimenin dizi içinde olup olmadýðýný kontrol eder
int kontrol(char *kelime, char **kume, int diziboyutu) {
	int i=0;
    for ( i = 0; i<diziboyutu ; ++i) {
        if (strcmp(kelime, kume[i]) == 0) {
            return 1; // Kelime kümede bulundu
        }
    }
    return 0; // Kelime kümede bulunamadý
}
