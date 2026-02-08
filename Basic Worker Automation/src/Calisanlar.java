public class Calisanlar {
    private String calisanKonum;
    private String isim;
    private String soyIsim;
    private int yas;
    private int gecenYil;
    private int maas;
    private int sifre;

    public Calisanlar(String calisanKonum, String isim, String soyIsim, int yas, int gecenYil, int maas, int sifre){
        this.calisanKonum = calisanKonum;
        this.isim = isim;
        this.soyIsim = soyIsim;
        this.yas = yas;
        this.gecenYil = gecenYil;
        this.maas = maas;
        this.sifre = sifre;
    }

    public void calisanBilgi(){
        System.out.println("Çalışanın İsmi: " + isim + "\n" +
                "Çalışanın Soyismi: " + soyIsim + "\n" +
                "Çalışanın Şirket Konumu: " + calisanKonum + "\n" +
                "Çalışanın Yaşı: " + yas + "\n" +
                "Çalışanın Şirkette Geçen Yılı: " + gecenYil + "\n" +
                "Çalışanın Aldığı Maaş: " + maas);
    }

    public boolean kontrol(int sifre){
        return this.sifre == sifre;
    }



    public String getCalisanKonum() {
        return calisanKonum;
    }

    public void setCalisanKonum(String calisanKonum) {
        this.calisanKonum = calisanKonum;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public int getGecenYil() {
        return gecenYil;
    }

    public void setGecenYil(int gecenYil) {
        this.gecenYil = gecenYil;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getSifre() {
        return sifre;
    }

    public void setSifre(int sifre) {
        this.sifre = sifre;
    }
}
