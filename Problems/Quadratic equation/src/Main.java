import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double d = b * b - 4 * a * c;

        if (d > 0) {
            double x1 = (b * -1 + Math.sqrt(d)) / (2 * a);
            double x2 = (b * -1 - Math.sqrt(d)) / (2 * a);
            if (x1 <= x2) {
                System.out.println(x1 + " " + x2);
            } else {
                System.out.println(x2 + " " + x1);
            }
        } else if (d == 0) {
            double x1 = b * -1 / (2 * a);
            System.out.println(x1);
        } else {
            System.out.println("no roots");
        }

    }
}