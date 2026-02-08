import java.util.ArrayList;
import java.util.Scanner;

public class OyunOzellik {

    private final ArrayList<String> oyunlar = new ArrayList();
    private final Scanner scanner = new Scanner(System.in);


    public void oyunEkle(String isim){
        oyunlar.add(isim);
        System.out.println("Oyununuz eklenmiştir. İsmi: " + isim + "\n" +
                "Oyununuzun index numarası: " + oyunlar.indexOf(isim));
    }

    public void oyunSil(int sayi){
        System.out.println("Girmiş olduğunuz index numarasındaki oyun listeden siliniyor: ");
        oyunlar.remove(sayi-1);

        System.out.println("Oyun listeden silindi...");
    }

    public void oyunListe(){
        for (int i = 0; i < oyunlar.size(); i++){
            System.out.println((i+1) + ". Oyun: " + oyunlar.get(i));
        }
    }

    public void oyunDegistirme(String isim, int sayi){
        System.out.println("Değiştirme işlemi gerçekleştiriliyor...");
        oyunlar.set(sayi-1,isim);

        System.out.println("Güncelleme işlemi tamamlandı...");
        System.out.println("Güncelleme Özeti: " + "\n" +
                "Sıra No: " + sayi + "\n" +
                "Oyun Adı: " + isim);
    }

    public void oyunBilgi(int index){
        System.out.println("Bilgiler Getiriliyor...");
        System.out.println("Oyun Sıra No: " + (index+1) + "\n" +
                "Oyun Adı: " +  oyunlar.get(index-1));
    }
}
