public class ArabicCalculator {
    public static String calculate(String firstNumberStr, String secondNumberStr, String operation) {
        try{
            int numberOne = Integer.parseInt(firstNumberStr);
            int numberTwo = Integer.parseInt(secondNumberStr);
            if (numberOne > 10 || numberOne < 1 || numberTwo > 10 || numberTwo < 1){
                throw new RuntimeException("Нельзя вводить значение больше 10 и меньше 1.");
            }
            int result = 0;
            switch (operation){
                case "+" -> result = numberOne + numberTwo;
                case "-" -> result = numberOne - numberTwo;
                case "*" -> result = numberOne * numberTwo;
                case "/" -> result = numberOne / numberTwo;
            }
            return result + "";
        } catch (NumberFormatException e){
            throw new RuntimeException("Можно использовать только римские или арабские числа от 1 до 10.");
        }
    }
}
