package search;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

interface ISearchOperations{
    void searchOperation(ArrayList<String> peopleList, Map<String, List<Integer>> invertedIndex, String wordToBeFound);
}

class SearchOperations{
    private ISearchOperations iSearchOperations;

    public void setSearchOperation(ISearchOperations iSearchOperations){
        this.iSearchOperations = iSearchOperations;
    }

    public void searchOperation(ArrayList<String> peopleList, Map<String, List<Integer>> invertedIndex, String wordToBeFound){
        this.iSearchOperations.searchOperation(peopleList, invertedIndex, wordToBeFound);
    }
}

class AllIncludedSearchOperation implements ISearchOperations{
    @Override
    public void searchOperation(ArrayList<String> peopleList, Map<String, List<Integer>> invertedIndex, String wordToBeFound) {
        String[] queryWords = wordToBeFound.toLowerCase().split("\\s+");
        Set<Integer> resultSet = null;

        for (String word : queryWords) {
            if (!invertedIndex.containsKey(word)) {
                System.out.println("No matching people found.");
                return;
            }
            Set<Integer> wordSet = new HashSet<>(invertedIndex.get(word));
            if (resultSet == null) {
                resultSet = wordSet;
            } else {
                resultSet.retainAll(wordSet);
            }
        }

        if (resultSet == null || resultSet.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(resultSet.size() + " persons found:");
            for (int index : resultSet) {
                System.out.println(peopleList.get(index));
            }
        }
    }
}

class AnyIncludedSearchOperation implements ISearchOperations{
    @Override
    public void searchOperation(ArrayList<String> peopleList, Map<String, List<Integer>> invertedIndex, String wordToBeFound) {
        String[] queryWords = wordToBeFound.toLowerCase().split("\\s+");
        Set<Integer> resultSet = new LinkedHashSet<>();

        for (String word : queryWords) {
            if (invertedIndex.containsKey(word)) {
                resultSet.addAll(invertedIndex.get(word));
            }
        }

        if (resultSet.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(resultSet.size() + " persons found:");
            for (int index : resultSet) {
                System.out.println(peopleList.get(index));
            }
        }
    }
}

class NoIncludedSearchOperation implements ISearchOperations{
    @Override
    public void searchOperation(ArrayList<String> peopleList, Map<String, List<Integer>> invertedIndex, String wordToBeFound) {
        String[] queryWords = wordToBeFound.toLowerCase().split("\\s+");
        Set<Integer> excludedSet = new HashSet<>();

        for (String word : queryWords) {
            if (invertedIndex.containsKey(word)) {
                excludedSet.addAll(invertedIndex.get(word));
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < peopleList.size(); i++) {
            if (!excludedSet.contains(i)) {
                result.add(peopleList.get(i));
            }
        }

        if (result.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(result.size() + " persons found:");
            for (String person : result) {
                System.out.println(person);
            }
        }
    }
}

public class Main {
    private static final String MENU_LIST = "=== Menu ===\n" +
            "1. Find a person\n" +
            "2. Print all people\n" +
            "0. Exit";

    public static void main(String[] args) {
        String path = "";
        for (int i = 0; i < args.length; i++) {
            if ("--data".equals(args[i]) && i + 1 < args.length) {
                path = args[i + 1];
            }
        }

        if (path.isEmpty()) {
            System.out.println("Error: No file specified. Use --data filename.txt");
            return;
        }

        File file = new File(path);
        ArrayList<String> peopleList = new ArrayList<>();

        try(Scanner readFile = new Scanner(file)) {
            while (readFile.hasNextLine()){
                peopleList.add(readFile.nextLine());
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return;
        }

        Map<String, List<Integer>> invertedIndex = new HashMap<>();
        for (int i = 0; i < peopleList.size(); i++) {
            String[] words = peopleList.get(i).split("\\s+");
            for (String word : words) {
                String lowerCaseWord = word.toLowerCase();
                invertedIndex.putIfAbsent(lowerCaseWord, new ArrayList<>());
                invertedIndex.get(lowerCaseWord).add(i);
            }
        }

        Scanner scanner = new Scanner(System.in);
        menuOperations(scanner, peopleList, invertedIndex);
        scanner.close();
    }

    private static void menuOperations(Scanner scanner, ArrayList<String> peopleList, Map<String, List<Integer>> invertedIndex){
        int input = -1;

        while (true){
            System.out.println(MENU_LIST);
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e){
                input = -1;
            }

            switch (input){
                case 1:
                    searchQueries(peopleList, invertedIndex, scanner);
                    break;
                case 2:
                    printAllPeople(peopleList);
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }

    private static void searchQueries(ArrayList<String> peopleList, Map<String, List<Integer>> invertedIndex, Scanner scanner) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategy = scanner.nextLine().trim().toUpperCase();

        System.out.println("Enter a name or email to search all suitable people.");
        String wordToBeFound = scanner.nextLine();

        SearchOperations searchOperations = new SearchOperations();

        switch (strategy) {
            case "ALL":
                searchOperations.setSearchOperation(new AllIncludedSearchOperation());
                break;
            case "ANY":
                searchOperations.setSearchOperation(new AnyIncludedSearchOperation());
                break;
            case "NONE":
                searchOperations.setSearchOperation(new NoIncludedSearchOperation());
                break;
            default:
                System.out.println("Unknown strategy.");
                return;
        }

        searchOperations.searchOperation(peopleList, invertedIndex, wordToBeFound);
    }

    private static void printAllPeople(ArrayList<String> peopleList){
        for (String s : peopleList) {
            System.out.println(s);
        }
    }
}