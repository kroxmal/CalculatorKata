import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input){
        String[] str = input.split(" ");
        if (str.length == 1){
            throw new RuntimeException("Строка не является математической операцией.");
        } else if (str.length != 3){
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
        }
        String firstNumberStr = str[0];
        String operation = str[1];
        String secondNumberStr = str[2];
        boolean isRoman = RomanCalculator.isRoman(firstNumberStr, secondNumberStr);
        if (isRoman) {
            return RomanCalculator.calculate(firstNumberStr, secondNumberStr, operation);
        } else {
            return ArabicCalculator.calculate(firstNumberStr, secondNumberStr, operation);
        }
    }
}
