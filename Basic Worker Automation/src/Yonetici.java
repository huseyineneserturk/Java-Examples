public class Yonetici extends Calisanlar {
    private String isimY;
    private String soyIsimY;
    private int yasY;
    private int gecenYilY;
    private int maasY;
    private int sifreY;


    public Yonetici() {
        super("Yönetici","Bob", "Marley", 43,20,35000,1187);
    }
    public boolean kontrol(int sifre){
        return super.kontrol(sifre);
    }
    public void yardimciEkle(String isim, String soyIsim, int yas, int gecenYil, int maas, int sifre1) {
        this.isimY = isim;
        this.soyIsimY = soyIsim;
        this.yasY = yas;
        this.gecenYilY = gecenYil;
        this.maasY = maas;
        this.sifreY = sifre1;

        yardimciBilgi();
    }

    public void yardimciBilgi() {
        System.out.println("Yardımcının İsmi: " + isimY + "\n" +
                "Yardımcının Soyismi: " + soyIsimY + "\n" +
                "Yardımcının Şirket Konumu: " + "Yardımcı" + "\n" +
                "Yardımcının Yaşı: " + yasY + "\n" +
                "Yardımcının Şirkette Geçen Yılı: " + gecenYilY + "\n" +
                "Yardımcının Aldığı Maaş: " + maasY +"\n" +
                "Yardımcınızın Şifresi : " + sifreY);
    }

    public void maasDuzenleme(int maas) {
        this.maasY = maas;
        System.out.println("Yardımcınızın yeni maaşı: " + maasY);
    }

    public void calisanBilgi(){
        super.calisanBilgi();
    }

    public String getIsimY() {
        return isimY;
    }

    public void setIsimY(String isimY) {
        this.isimY = isimY;
    }

    public String getSoyIsimY() {
        return soyIsimY;
    }

    public void setSoyIsimY(String soyIsimY) {
        this.soyIsimY = soyIsimY;
    }

    public int getYasY() {
        return yasY;
    }

    public void setYasY(int yasY) {
        this.yasY = yasY;
    }

    public int getGecenYilY() {
        return gecenYilY;
    }

    public void setGecenYilY(int gecenYilY) {
        this.gecenYilY = gecenYilY;
    }

    public int getMaasY() {
        return maasY;
    }

    public void setMaasY(int maasY) {
        this.maasY = maasY;
    }

    public int getSifreY() {
        return sifreY;
    }

    public void setSifreY(int sifreY) {
        this.sifreY = sifreY;
    }
}