package task1;

public class ArctanCalculator {
    public static double arctan(double x) {
        if (Math.abs(x) > 1) {
            throw new IllegalArgumentException("Значение x должно быть в диапазоне [-1, 1]");
        }

        double result = 0;
        int n = 100;
        for (int i = 0; i < n; i++) {
            double term = Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / (2 * i + 1);
            result += term;
        }

        return result;
    }
}