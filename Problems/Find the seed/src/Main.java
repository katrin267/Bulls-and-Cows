import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int max;
        int minOfMaxes = Integer.MAX_VALUE;
        int seed = a;

        for (int i = a; i <= b; i++) {
            Random random = new Random(i);
            max = 0;
            for (int j = 0; j < n; j++) {
                int temp = random.nextInt(k);
                if (max < temp) {
                    max = temp;
                }
            }
            if (minOfMaxes > max) {
                minOfMaxes = max;
                seed = i;
            }
        }

        System.out.println(seed);
        System.out.println(minOfMaxes);
    }
}