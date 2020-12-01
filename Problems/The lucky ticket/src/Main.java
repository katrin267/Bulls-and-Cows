import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        int firstPart = 0;
        int secondPart = 0;
        int len = str.length();

        for (int i = 0; i < len; i++) {
            if (i <= len / 2 - 1) {
                firstPart += Character.getNumericValue(str.charAt(i));
            }
            if (i > len / 2 - 1) {
                secondPart += Character.getNumericValue(str.charAt(i));
            }
        }

        if (firstPart == secondPart) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }


    }
}