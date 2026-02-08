public class Yardimci extends Yonetici{
    private String isimI;
    private String soyIsimI;
    private int yasI;
    private int gecenYilI;
    private int maasI;
    private int sifreI;
    public void calisanBilgi(){
        super.yardimciBilgi();
    }

    public void maasSorgu(){
        System.out.println("Maaşınız: " + getMaasY());
    }
    public void isciEkle(String isim, String soyIsim, int yas, int gecenYil, int maas, int sifre) {
        this.isimI = isim;
        this.soyIsimI = soyIsim;
        this.yasI = yas;
        this.gecenYilI = gecenYil;
        this.maasI = maas;
        this.sifreI = sifre;

        isciBilgi();
    }

    public void isciBilgi() {
        System.out.println("İşçinizin İsmi: " + isimI + "\n" +
                "İşçinizin Soyismi: " + soyIsimI + "\n" +
                "İşçinizin Şirket Konumu: " + "İşçi" + "\n" +
                "İşçinizin Yaşı: " + yasI + "\n" +
                "İşçinizin Şirkette Geçen Yılı: " + gecenYilI + "\n" +
                "İşçinizin Aldığı Maaş: " + maasI + "\n" +
                "İşçinizin Şifresi :" + sifreI);
    }

    public void maasDuzenleme(int maas) {
        this.maasI = maas;
        System.out.println("Yardımcınızın yeni maaşı: " + maasI);
    }

    public String getIsimI() {
        return isimI;
    }

    public void setIsimI(String isimI) {
        this.isimI = isimI;
    }

    public String getSoyIsimI() {
        return soyIsimI;
    }

    public void setSoyIsimI(String soyIsimI) {
        this.soyIsimI = soyIsimI;
    }

    public int getYasI() {
        return yasI;
    }

    public void setYasI(int yasI) {
        this.yasI = yasI;
    }

    public int getGecenYilI() {
        return gecenYilI;
    }

    public void setGecenYilI(int gecenYilI) {
        this.gecenYilI = gecenYilI;
    }

    public int getMaasI() {
        return maasI;
    }

    public void setMaasI(int maasI) {
        this.maasI = maasI;
    }

    public int getSifreI() {
        return sifreI;
    }

    public void setSifreI(int sifreI) {
        this.sifreI = sifreI;
    }
}
