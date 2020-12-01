import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        str = str.toLowerCase();
        int indexOfThe = 0;

        indexOfThe = str.indexOf("the");

        System.out.println(indexOfThe);

    }
}