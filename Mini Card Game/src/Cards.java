public class Cards {
    private char kardGoster;
    private boolean kartTahmin = false;

    public Cards(char kart) {
        this.kardGoster = kart;
    }


    public char getKardGoster() {
        return kardGoster;
    }

    public void setKardGoster(char kardGoster) {
        this.kardGoster = kardGoster;
    }

    public boolean isKartTahmin() {
        return kartTahmin;
    }

    public void setKartTahmin(boolean kartTahmin) {
        this.kartTahmin = kartTahmin;
    }
}