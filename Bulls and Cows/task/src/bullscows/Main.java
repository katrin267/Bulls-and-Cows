package bullscows;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    static int numberOfNums;
    static int[] enteredNum;
    static int turnNumber = 1;
    static int cows;
    static int bulls;
    static int[] secretCode;

    public static void main(String[] args) {

        generateCode();
        do {
            checkInput();
            grade();
            printGrade();
        } while (bulls < numberOfNums);
        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static void fillSecretCodeArr(int numberOfSymbols, int numberOfPossibleSymbols) {
        int[] possibleSymbols = new int[numberOfPossibleSymbols];
        int numberOfDigits;
        int numberOfChars;
        if (numberOfPossibleSymbols <= 10) {
            numberOfDigits = numberOfPossibleSymbols;
            numberOfChars = 0;
        } else {
            numberOfDigits = 10;
            numberOfChars = numberOfPossibleSymbols - 10;
        }
        for (int i = 0; i < numberOfDigits; i++) {
            possibleSymbols[i] = i + 48;
        }
        for (int i = 0; i < numberOfChars; i++) {
            possibleSymbols[i + numberOfDigits] = i + 97;
        }

        boolean[] existedNumbers = new boolean[numberOfPossibleSymbols];
        Random random = new Random();
        int i = 0;
        while (i < numberOfSymbols) {
            int randomNumber = random.nextInt(numberOfPossibleSymbols);
            if (!existedNumbers[randomNumber]) {
                secretCode[i] = possibleSymbols[randomNumber];
                existedNumbers[randomNumber] = true;
                i++;
            }
        }
    }

    private static void printError(String errString) {
        System.out.println("Error: " + errString);
        System.exit(0);
    }

    private static int checkForValidNumber(String inputStr) {
        try {
            return Integer.parseInt(inputStr);
        } catch (Exception e) {
            printError("\"" + inputStr + "\" isn't a valid number.");
            return -1;
        }
    }

    private static void generateCode() {
        System.out.println("Please, enter the secret code's length:");
        int numberOfSymbolsInCode = checkForValidNumber(scanner.nextLine());

        System.out.println("Input the number of possible symbols in the code:");

        int numberOfPossibleSymbols = checkForValidNumber(scanner.nextLine());

        if (numberOfSymbolsInCode > numberOfPossibleSymbols) {
            printError(String.format("it's not possible to generate a code with a length of %d with %d unique symbols.", numberOfSymbolsInCode, numberOfPossibleSymbols));
        }
        if (numberOfSymbolsInCode <= 0) {
            printError("length of the secret code must be greater than zero.");
        }
        if (numberOfPossibleSymbols > 36) {
            printError("maximum number of possible symbols in the code is 36 (0-9, a-z).");
        }


        secretCode = new int[numberOfSymbolsInCode];

        fillSecretCodeArr(numberOfSymbolsInCode, numberOfPossibleSymbols);

        enteredNum = new int[numberOfSymbolsInCode];
        numberOfNums = numberOfSymbolsInCode;

        StringBuilder stringBuilder = new StringBuilder("The secret is prepared: ");
        stringBuilder.append("*".repeat(numberOfSymbolsInCode));
        stringBuilder.append(" (0-9");
        if (numberOfPossibleSymbols - 10 > 0) {
            stringBuilder.append(", a-").append((char) (96 + numberOfPossibleSymbols - 10));
        }
        stringBuilder.append(").");
        System.out.println(stringBuilder);

        System.out.println("Okay, let's start a game!");
    }


    private static void checkInput() {
        System.out.println("Turn " + turnNumber + ":");
        String str = scanner.nextLine();
        for (int i = 0; i < numberOfNums; i++) {
            enteredNum[i] = str.charAt(i);
        }
        turnNumber++;
    }

    private static void grade() {
        bulls = 0;
        cows = 0;
        for (int i = 0; i < numberOfNums; i++) {
            if (enteredNum[i] == secretCode[i]) {
                bulls++;
            }
        }

        int[] copyOfSecretCode = Arrays.copyOf(secretCode, numberOfNums);

        for (int i = 0; i < numberOfNums; i++) {
            for (int j = 0; j < numberOfNums; j++) {
                if (enteredNum[i] == copyOfSecretCode[j]) {
                    cows++;
                    copyOfSecretCode[j] = -1;
                }
            }
        }

        cows = cows - bulls;
    }

    private static void printGrade() {
        StringBuilder stringBuilder = new StringBuilder("Grade: ");
        if (bulls != 0 || cows != 0) {
            if (bulls > 0) {
                stringBuilder.append(bulls).append(" bull(s)");
                if (cows > 0) {
                    stringBuilder.append(" and ");
                }
            }
            if (cows > 0) {
                stringBuilder.append(cows).append(" cow(s)");
            }
        } else {
            stringBuilder.append("None");
        }

        System.out.println(stringBuilder);
    }

}
