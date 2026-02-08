import java.util.ArrayList;
import java.util.Scanner;

public class OyunMain {
    private static final OyunOzellik oyun = new OyunOzellik();
    private static final Scanner scann = new Scanner(System.in);

    public static void islemler(){
        System.out.println("*************************************\n" +
                "(1) Oyun Listesi\n" +
                "(2) Oyun Arama\n" +
                "(3) Oyun Ekle\n" +
                "(4) Oyun Sil\n" +
                "(5) Oyun Değiştir\n" +
                "(q) Çıkış\n" +
                "*************************************");
    }

    public static void main(String[] args){
        System.out.println("Sistemimize hoşgeldiniz....");
        System.out.println("Lütfen Yapmak istediğiniz işlemi seçiniz...");

        while (true){
            islemler();
            String islem = scann.nextLine();

            if (islem.equals("1")){
                oyun.oyunListe();
                continue;
            } else if (islem.equals("2")) {
                System.out.println("Lütfen arama yapmak istediğiniz oyunun sıra nosunu giriniz: ");
                int sıra = scann.nextInt();
                scann.nextLine();
                oyun.oyunBilgi(sıra);
                continue;
            } else if (islem.equals("3")) {
                System.out.println("Lütfen eklemek istediğiniz oyunun ismini giriniz: ");
                String oyunAd = scann.nextLine();
                oyun.oyunEkle(oyunAd);
                continue;
            } else if (islem.equals("4")) {
                System.out.println("Lütfen silmek istediğiniz oyunun index numarasını giriniz. Eğer index nolarını hatırlamıyorsanız (9) yazınız.");
                int index = scann.nextInt();
                if (index == 9){
                    oyun.oyunListe();
                    System.out.println("Lütfen sıra no giriniz :");
                    int index1 = scann.nextInt();
                    oyun.oyunSil(index1);
                    break;
                } else {
                    oyun.oyunSil(index);
                }
            } else if (islem.equals("5")) {
                System.out.println("Lütfen değiştirmek istediğiniz oyunun sıra nosunu giriniz. Sıra nosunu bilmiyorsanız (9) değeri giriniz.");
                int index = scann.nextInt();
                if (index == 9){
                    oyun.oyunListe();
                    System.out.println("Lütfen sıra no giriniz :");
                    int index1 = scann.nextInt();
                    scann.nextLine();
                    System.out.println("Lütfen yeni oyunun ismini giriniz: ");
                    String isim = scann.nextLine();
                    oyun.oyunDegistirme(isim,index1);
                    break;
                } else {
                    System.out.println("Lütfen yeni oyunun ismini giriniz: ");
                    String isim1 = scann.nextLine();
                    oyun.oyunDegistirme(isim1,index);
                }
            } else if (islem.equals("q")) {
                System.out.println("Sistemden çıkılıyor. Tekrardan bekleriz...");
                System.out.println("B");
                System.out.println("B");
                break;
            } else {
                System.out.println("Geçersiz İşlem Girdiniz işlemlere geri dönülüyor...");
                System.out.println(".........");
                System.out.println(".........");
                continue;
            }
        }
    }
}
