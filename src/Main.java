import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("Auto");     // - 0
        wordList.add("Banane");   // - 1
        wordList.add("Computer"); // - 2
        wordList.add("Drache");   // - 3
        wordList.add("Elefant");  // - 4
        wordList.add("Fabelhaft");  // - 5
        wordList.add("Garten");  // - 6
        wordList.add("Himmel");  // - 7
        wordList.add("Insel");  // - 8
        wordList.add("Jalousie");  // - 9
        wordList.add("Katze");  // - 10
        wordList.add("Lachs");   // - 11
        wordList.add("Montag");  // - 12
        wordList.add("Notfall"); // - 13
        wordList.add("Operation"); // - 14
        wordList.add("Pirat"); // - 15

        Random random = new Random();
        int randomNumb = random.nextInt(16);
        //--- System.out.println(randomNumb + " - Zufällige Zahl von 0 bis 16");


        String randomWord = wordList.get(randomNumb);
        int lengthList = randomWord.length();
        //--- System.out.println(randomWord + " - das passende Wort aus der ArrayList");
        //--- System.out.println(lengthList + " - die Länge des Wortes");


        for (int i = 0; i < lengthList; i++) {
            System.out.print("_ ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        char[] charArray = new char[lengthList];
        int mistakes = 0;

        do {
            System.out.println("Geben Sie einen Buchstaben ein: ");
            String input = scanner.nextLine();
            char inputChar = input.charAt(0);

            boolean found = randomWord.contains(input);

            if (found) {
                printStatus(inputChar, randomWord, charArray);
            } else {
                System.out.println("Falscher Input!");
                mistakes++;
                System.out.println("Falsch geraten: " + mistakes);
                System.out.println();
            }


        } while (!winCon(charArray) && mistakes <= 4);


        if (winCon(charArray)) {
            System.out.println("Wort richtig erraten!");
        } else {
            System.out.println("Game Over - 5 Fehler erreicht!");
        }

    }

    public static void printStatus(Character inputChar, String randomWord, char[] charArray) {

        System.out.println("Richtig geraten: " + inputChar);

        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == inputChar) {
                charArray[i] = inputChar;
                System.out.println(charArray);
                System.out.println();

            }
        }

    }

    public static boolean winCon(char[] charArray) {
        for (char c : charArray) {
            if (c == '\u0000') {
                return false;
            }
        }
        return true;
    }


}