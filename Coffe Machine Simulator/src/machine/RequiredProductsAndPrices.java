package machine;

public enum RequiredProductsAndPrices {
    ESPRESSO(250,0,16,4),
    LATTE(350,75,20,7),
    CAPPUCCINO(200,100,12,6);

    private final int water;
    private final int milk;
    private final int bean;
    private final int price;

    RequiredProductsAndPrices(int water, int milk, int bean, int price){
        this.water = water;
        this.milk = milk;
        this.bean = bean;
        this.price = price;
    }

    public int getWater() {return this.water;}
    public int getMilk() {return this.milk;}
    public int getBean() {return this.bean;}
    public int getPrice() {return this.price;}
}
