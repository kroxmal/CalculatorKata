public class RomanCalculator {
    public static boolean isRoman(String firstNumberStr, String secondNumberStr) {
        boolean isFirstRoman = true;
        boolean isSecondRoman = true;
        try {
            NumbersRoman.valueOf(firstNumberStr);
        } catch (IllegalArgumentException e) {
            isFirstRoman = false;
        }
        try {
            NumbersRoman.valueOf(secondNumberStr);
        } catch (IllegalArgumentException e) {
            isSecondRoman = false;
        }
        if (isFirstRoman && isSecondRoman) {
            return true;
        } else if (!isFirstRoman && !isSecondRoman) {
            return false;
        } else {
            throw new RuntimeException("Нельзя использовать одновременно разные системы счисления.");
        }
    }

    public static String convert(int number) {
        String romanOnes = toRomanDigit(number % 10, "I", "V", "X");
        number /= 10;
        String romanTens = toRomanDigit(number % 10, "X", "L", "C");
        number /= 10;
        String romanHundreds = toRomanDigit(number % 10, "C", "", "");

        return romanHundreds + romanTens + romanOnes;
    }

    private static String toRomanDigit(int n, String one, String five, String ten) {
        return switch (n) {
            case 1 -> one;
            case 2 -> one + one;
            case 3 -> one + one + one;
            case 4 -> one + five;
            case 5 -> five;
            case 6 -> five + one;
            case 7 -> five + one + one;
            case 8 -> five + one + one + one;
            case 9 -> one + ten;
            default -> "";
        };
    }

    public static String calculate(String firstNumberStr, String secondNumberStr, String operation) {
        int first = NumbersRoman.valueOf(firstNumberStr).ordinal() + 1;
        int second = NumbersRoman.valueOf(secondNumberStr).ordinal() + 1;
        int result = 0;
        switch (operation) {
            case "+" -> result = first + second;
            case "-" -> result = first - second;
            case "*" -> result = first * second;
            case "/" -> result = first / second;
        }
        if (result < 1) {
            throw new RuntimeException("В римской системе нет отрицательных чисел.");
        }
        return convert(result);
    }
}
