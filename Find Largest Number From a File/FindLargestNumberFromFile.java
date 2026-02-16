import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FindLargestNumberFromFile{
    public static void main (String[] args){
        String path = "C:\\Users\\husey\\Downloads\\dataset_91007.txt";
        File file = new File(path);
        
        int bigNumber = Integer.MIN_VALUE;
        int currentNumber = 0;


        try( Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextInt()){
                currentNumber = scanner.nextInt();
               if (currentNumber > bigNumber){
                bigNumber  = currentNumber;
               }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File is not found.");
        }
        System.out.println(bigNumber);
    }
}