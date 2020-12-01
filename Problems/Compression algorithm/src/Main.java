import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        str += " ";

        StringBuilder resStr = new StringBuilder(new String(""));

        int numOfSameChars = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                numOfSameChars++;
            } else {
                resStr.append(str.charAt(i)).append(numOfSameChars);
                numOfSameChars = 1;
            }
        }

        System.out.println(resStr);

    }
}