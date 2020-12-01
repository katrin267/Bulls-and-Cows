import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        while (!scanner.hasNext("0")) {
            try {
                inputStr = scanner.nextLine();
                int i = Integer.parseInt(inputStr);
                System.out.println(i * 10);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + inputStr);
            }
        }
    }
}