package machine;

import java.util.Scanner;

public class CoffeeMachineFunctionalities {
    private static int totalWater = 400;
    private static int totalMilk = 540;
    private static int totalBeans = 120;
    private static int totalCups = 9;
    private static int totalMoney = 550;
    public static int cleanStatus = 0;

    public static void buyFunction(Scanner sc){
        final String orderQuestion = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";
        System.out.println(orderQuestion);
        String orderInput = sc.next();

        if (!orderInput.equals("back")){
            checkResourceAvailability(orderInput);
        }
    }

    public static void fillFunction(Scanner sc){
        System.out.println("Write how many ml of water you want to add:");
        totalWater += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        totalMilk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        totalBeans += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        totalCups += sc.nextInt();
    }

    public static void takeFunction(){
        System.out.println("I gave you $" + totalMoney);
        totalMoney = 0;
    }

    public static void getTotalResources (){
        String totalResourcesOutput = "The coffee machine has:\n" +
                totalWater + " ml of water\n" +
                totalMilk  + " ml of milk\n" +
                totalBeans + " g of coffee beans\n" +
                totalCups  + " disposable cups\n" +
                "$" + totalMoney + " of money\n";

        System.out.println(totalResourcesOutput);
    }

    public static void fixResourceAmount(String orderNumber){
        switch (orderNumber){
            case "1" :
                totalWater -= RequiredProductsAndPrices.ESPRESSO.getWater();
                totalBeans -= RequiredProductsAndPrices.ESPRESSO.getBean();
                totalMoney += RequiredProductsAndPrices.ESPRESSO.getPrice();
                totalCups -= 1;
                break;
            case "2" :
                totalWater -= RequiredProductsAndPrices.LATTE.getWater();
                totalMilk -= RequiredProductsAndPrices.LATTE.getMilk();
                totalBeans -= RequiredProductsAndPrices.LATTE.getBean();
                totalMoney += RequiredProductsAndPrices.LATTE.getPrice();
                totalCups -= 1;
                break;
            case "3" :
                totalWater -= RequiredProductsAndPrices.CAPPUCCINO.getWater();
                totalMilk -= RequiredProductsAndPrices.CAPPUCCINO.getMilk();
                totalBeans -= RequiredProductsAndPrices.CAPPUCCINO.getBean();
                totalMoney += RequiredProductsAndPrices.CAPPUCCINO.getPrice();
                totalCups -= 1;
                break;
            default:
                break;
        }
    }

    public static void checkResourceAvailability (String inputOrder){
        int[] checkResourceStatus;
        switch (inputOrder) {
            case "1" -> {
                checkResourceStatus = new int[]{(totalWater - RequiredProductsAndPrices.ESPRESSO.getWater()), (totalBeans - RequiredProductsAndPrices.ESPRESSO.getBean())};
                checkResourceStatusMethod(checkResourceStatus, inputOrder);
            }
            case "2" -> {
                checkResourceStatus = new int[]{(totalWater - RequiredProductsAndPrices.LATTE.getWater()), (totalBeans - RequiredProductsAndPrices.LATTE.getBean()), (totalMilk - RequiredProductsAndPrices.LATTE.getMilk())};
                checkResourceStatusMethod(checkResourceStatus, inputOrder);
            }
            case "3" -> {
                checkResourceStatus = new int[]{(totalWater - RequiredProductsAndPrices.CAPPUCCINO.getWater()), (totalBeans - RequiredProductsAndPrices.CAPPUCCINO.getBean()), (totalMilk - RequiredProductsAndPrices.CAPPUCCINO.getMilk())};
                checkResourceStatusMethod(checkResourceStatus, inputOrder);
            }
        }
    }

    public static void checkResourceStatusMethod(int[] checkResourceStatus,String inputOrder){

        for (int i = 0; i < checkResourceStatus.length-1;i++){
            if (checkResourceStatus[i] < 0 && i == 0){
                System.out.println("Sorry, not enough water!");
                return;
            } else if (checkResourceStatus[i] < 0 && i == 1) {
                System.out.println("Sorry, not enough beans!");
                return;
            } else if (checkResourceStatus[i] < 0 && i == 2){
                System.out.println("Sorry, not enough milk!");
                return;
            }
        }
        System.out.println("I have enough resources, making you a coffee!");
        cleanStatus += 1;
        fixResourceAmount(inputOrder);
    }

    public static void cleanFunction(){
        cleanStatus = 0;
        System.out.println("I have been cleaned!");
    }
}
