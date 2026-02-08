import java.util.Scanner;

public class Ana {
    public static void main(String[] args){
        Scanner scann = new Scanner(System.in);
        Yonetici yonetici = new Yonetici();
        Yardimci yardimci = new Yardimci();
        Isci isci = new Isci();
        Calisanlar calisan = new Calisanlar(null,null,null,0,0,0,0);
        int ilkIslem = 1;
        int hak = 4;


        while (true || ilkIslem == 1){
            hak = 4;
            System.out.println("Şirket Otomasyonuna Hoşgeldiniz...");
            System.out.println("Lütfen Erişmek İstediğiniz Kategoriyi Giriniz: \n" +
                    "***************************** \n" +
                    "(1) Yönetici \n" +
                    "(2) Yardımcı \n" +
                    "(3) İşçi\n" +
                    "(q) Çıkış\n" +
                    "*****************************");
            System.out.print("İşlem: ");
            String islem = scann.nextLine();

            if (islem.equals("1")){
                while (hak > 0){
                    System.out.print("Lütfen Yönetici Şifresini Giriniz: ");
                    int sifre = scann.nextInt();
                    scann.nextLine();

                    if (yonetici.kontrol(sifre)){
                        while (true){
                            System.out.println("Lütfen yapmak istediğiniz işlemi giriniz: \n" +
                                    "--------------------------------\n" +
                                    "(1) Bilgi Sorgula\n" +
                                    "(2) Yardımcı Ekleme\n" +
                                    "(3) Yardımcı Maaş Düzenleme\n" +
                                    "(q) Çıkış" + "\n" +
                                    "--------------------------------");
                            System.out.print("İşlem : ");
                            String sorgu = scann.nextLine();

                            if (sorgu.equals("1")){
                                yonetici.calisanBilgi();
                                continue;
                            } else if (sorgu.equals("2")) {
                                System.out.print("Lütfen Yardımcının ismini giriniz: ");
                                String isim = scann.nextLine();
                                System.out.print("Lütfen Yardımcınızın soyadını giriniz: ");
                                String soyad = scann.nextLine();
                                System.out.print("Lütfen yardımcınızın yaşını giriniz: ");
                                int yas = scann.nextInt();
                                System.out.print("Lütfen yardımcınızın şirketteki toplam yılını giriniz: ");
                                int yil = scann.nextInt();
                                System.out.print("Lütfen yardımcınızın aldığı maaşı giriniz: ");
                                int maas = scann.nextInt();
                                System.out.print("Lütfen yardımcınızın şifresini yalnızca sayısal değer olarak giriniz: ");
                                int sifre1 = scann.nextInt();
                                scann.nextLine();

                                yonetici.yardimciEkle(isim,soyad,yas,yil,maas, sifre1);
                                continue;
                            } else if (sorgu.equals("3")) {
                                System.out.print("Lütfen yardımcınızın yeni maaşını giriniz: ");
                                int maas = scann.nextInt();

                                yonetici.maasDuzenleme(maas);
                                continue;
                            } else if (sorgu.equals("q")) {
                                System.out.println("Hesabınızdan Çıkılıyor.....");
                                System.out.println("Üst menüye geçiliyor.....");
                                hak = 0;
                                break;
                            } else {
                                System.out.println("Geçersiz işlem lütfen tekrar deneyiniz...");
                                continue;
                            }
                        }
                    } else {
                        System.out.println("Şifreyi yanlış girdiniz lütfen tekrar deneyiniz...");
                        hak -= 1;
                        System.out.println("Kalan Hak : " + hak);
                    }
                }

            } else if (islem.equals("2")) {
                while (hak > 0){
                    System.out.print("Lütfen Yardımcı Şifresini Giriniz: ");
                    int sifre = scann.nextInt();
                    scann.nextLine();

                    if (yonetici.getSifreY() == sifre){
                        while (true){
                            System.out.println("Lütfen yapmak istediğiniz işlemi giriniz: \n" +
                                    "--------------------------------\n" +
                                    "(1) Bilgi Sorgula\n" +
                                    "(2) İşçi Ekleme\n" +
                                    "(3) İşçi Maaş Düzenleme\n" +
                                    "(4) Maaş Sorgu \n" +
                                    "(q) Çıkış" + "\n" +
                                    "--------------------------------");
                            System.out.print("İşlem : ");
                            String sorgu = scann.nextLine();

                            if (sorgu.equals("1")){
                                yardimci.calisanBilgi();
                                continue;
                            } else if (sorgu.equals("2")) {
                                System.out.print("Lütfen İşçinin ismini giriniz: ");
                                String isim = scann.nextLine();
                                System.out.print("Lütfen İşçinin soyadını giriniz: ");
                                String soyad = scann.nextLine();
                                System.out.print("Lütfen İşçinin yaşını giriniz: ");
                                int yas = scann.nextInt();
                                System.out.print("Lütfen İşçinin şirketteki toplam yılını giriniz: ");
                                int yil = scann.nextInt();
                                System.out.print("Lütfen İşçinin aldığı maaşı giriniz: ");
                                int maas = scann.nextInt();
                                System.out.print("Lütfen İşçinin şifresini yalnızca sayısal değerler olarak giriniz: ");
                                int sifre1 = scann.nextInt();
                                scann.nextLine();

                                yardimci.isciEkle(isim,soyad,yas,yil,maas, sifre1);
                                continue;
                            } else if (sorgu.equals("3")) {
                                System.out.print("Lütfen İşçinin yeni maaşını giriniz: ");
                                int maas = scann.nextInt();

                                yonetici.maasDuzenleme(maas);
                                continue;
                            } else if (sorgu.equals("4")) {
                                yardimci.maasSorgu();
                            } else if (sorgu.equals("q")) {
                                System.out.println("Hesabınızdan Çıkılıyor.....");
                                System.out.println("Üst menüye geçiliyor.....");
                                hak = 0;
                                break;
                            } else {
                                System.out.println("Geçersiz işlem lütfen tekrar deneyiniz...");
                                continue;
                            }
                        }

                    } else {
                        System.out.println("Şifreyi yanlış girdiniz lütfen tekrar deneyiniz...");
                        hak -= 1;
                        System.out.println("Kalan Hak : " + hak);
                    }
                }
            } else if (islem.equals("3")){
                while (hak > 0){
                    System.out.print("Lütfen İşçi Şifresini Giriniz: ");
                    int sifre = scann.nextInt();
                    scann.nextLine();

                    if (yardimci.getSifreI() == sifre){
                        while (true) {
                            System.out.println("Lütfen yapmak istediğiniz işlemi giriniz: \n" +
                                    "--------------------------------\n" +
                                    "(1) Bilgi Sorgula\n" +
                                    "(2) Maaş Sorgu \n" +
                                    "(q) Çıkış" + "\n" +
                                    "--------------------------------");
                            System.out.print("İşlem : ");
                            String sorgu = scann.nextLine();

                            if (sorgu.equals("1")) {
                                isci.calisanBilgi();
                                continue;
                            } else if (sorgu.equals("2")) {
                                isci.maasSorgu();
                            } else if (sorgu.equals("q")) {
                                System.out.println("Hesabınızdan Çıkılıyor.....");
                                System.out.println("Üst menüye geçiliyor.....");
                                hak = 0;
                                break;
                            } else {
                                System.out.println("Geçersiz işlem lütfen tekrar deneyiniz...");
                                continue;
                            }
                        }
                    }  else {
                        System.out.println("Şifreyi yanlış girdiniz lütfen tekrar deneyiniz...");
                        hak -= 1;
                        System.out.println("Kalan Hak : " + hak);
                    }
                }
            } else if (islem.equals("q")){
                System.out.println("Sistemden çıkılıyor yeniden görüşmek dileğiyle.");
                ilkIslem = 0;
                break;
            } else {
                System.out.println("Yanlış terim kullandınız. Lütfen tekrar deneyiniz...");
                continue;
            }

            if (ilkIslem == 1){
                continue;
            }
        }
    }
}
