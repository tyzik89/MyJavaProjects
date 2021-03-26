

import java.util.Scanner;
import java.util.stream.IntStream;

public class MKAD {

    private static int MKAD_LENGTH = 109;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        scanner.nextLine();
        int t = scanner.nextInt();

        System.out.println(evaluateDistance(v, t));
    }

    protected static int evaluateDistanceOld (int v, int t) {
        //Путь, пройденный Васей
        int s = Math.abs(v * t);

        //Генерируем массив километровых отметок МКАДА
        int[] mkadMarks = IntStream.range(0, 110).toArray();

        int result = 0;
        if (v > 0) {
            for (int i = 0, k = 0; i < s; i++, k++) {
                if (k >= mkadMarks.length - 1) k = 0;
                result = k + 1;
            }
        } else if (v < 0) {
            for (int i = 0, k = 0; i < s; i++, k++) {
                if (k >= mkadMarks.length - 1) k = 0;
                result = 109 - k - 1;
            }
        }
        return result;
    }

    protected static int evaluateDistance (int v, int t) {
        int result = (v * t) % MKAD_LENGTH;
        return result >= 0 ? result : (MKAD_LENGTH + result);
    }
}
