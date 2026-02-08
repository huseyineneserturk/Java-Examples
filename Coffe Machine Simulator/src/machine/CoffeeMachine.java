package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final String AVAILABLE_OPTIONS = "Write action (buy, fill, take, clean, remaining, exit):";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;

        loopLabel:
        while (true){
            System.out.println(AVAILABLE_OPTIONS);
            userInput = sc.next();

            switch (userInput) {
                case "buy":
                    if (CoffeeMachineFunctionalities.cleanStatus == 10){
                        System.out.println("I need cleaning!");
                        break;
                    } else {
                        CoffeeMachineFunctionalities.buyFunction(sc);
                        break;
                    }
                case "fill":
                    CoffeeMachineFunctionalities.fillFunction(sc);
                    break;
                case "take":
                    CoffeeMachineFunctionalities.takeFunction();
                    break;
                case "clean":
                    CoffeeMachineFunctionalities.cleanFunction();
                    break;
                case "remaining":
                    CoffeeMachineFunctionalities.getTotalResources();
                    break;
                case "exit":
                    break loopLabel;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
}