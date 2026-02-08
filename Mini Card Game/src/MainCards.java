import java.util.Scanner;

public class MainCards {
    private static final Cards[][] kart = new Cards[4][4];

    public static void oyunTahtasi() {
        System.out.println("-------------------");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (kart[i][j].isKartTahmin()) {
                    System.out.print(" |" + kart[i][j].getKardGoster() + "| ");
                } else {
                    System.out.print(" | | ");
                }
            }
            System.out.println();
            System.out.println("-------------------");
        }
    }
    public static void tahmin(){
        Scanner scanner = new Scanner(System.in);

        int skor = 0;

        while(!oyunBitis()){
            oyunTahtasi();
            System.out.print("Lütfen tahmin yürütmek istediğiniz i ve j değerlerini bir boşluk bırakarak giriniz: ");
            int i1 = scanner.nextByte();
            int j1 = scanner.nextByte();
            kart[i1][j1].setKartTahmin(true);
            oyunTahtasi();

            System.out.print("Lütfen eşleştirmek istediğiniz i ve j değerlerini aralarında bir boşluk bırakarak giriniz: ");
            int i2 = scanner.nextByte();
            int j2 = scanner.nextByte();

            if (kart[i1][j1].getKardGoster() == kart[i2][j2].getKardGoster()){
                kart[i2][j2].setKartTahmin(true);
                skor += 50;
                System.out.println("*********************");
                System.out.println("SKORUNUZ : " + skor);
                System.out.println("*********************");
            } else {
                kart[i1][j1].setKartTahmin(false);
                System.out.println("Yanlış seçim yaptınız...");
            }
        }
        System.out.println("**************************************************");
        System.out.println(" ************************************************ ");
        System.out.println(":):):):)TEBRİKLER OYUNU BİTİRDİNİZ(:(:(:(:");
        System.out.println(" ************************************************ ");
        System.out.println("**************************************************");
    }
    public static boolean oyunBitis() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!kart[i][j].isKartTahmin()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

        kart[0][0] = new Cards('A');
        kart[0][1] = new Cards('B');
        kart[0][2] = new Cards('C');
        kart[0][3] = new Cards('D');
        kart[1][0] = new Cards('E');
        kart[1][1] = new Cards('F');
        kart[1][2] = new Cards('G');
        kart[1][3] = new Cards('H');
        kart[2][0] = new Cards('A');
        kart[2][1] = new Cards('B');
        kart[2][2] = new Cards('C');
        kart[2][3] = new Cards('D');
        kart[3][0] = new Cards('E');
        kart[3][1] = new Cards('F');
        kart[3][2] = new Cards('G');
        kart[3][3] = new Cards('H');

        tahmin();
    }
}



