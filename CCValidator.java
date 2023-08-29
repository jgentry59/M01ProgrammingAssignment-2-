import java.util.Scanner;

public class CCValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a credit card number to validate: ");
        long ccNumber = Long.parseLong(scanner.nextLine());
        scanner.close();
        System.out.println("The credit card number you provided is " + (isValid(ccNumber) ? "valid." : "not valid."));
    }
    public static boolean isValid(long number) {
        int totalSum = 0;
        String numStr = Long.toString(number);
        for (int i = numStr.length() - 1, j = 1; i >= 0; i--, j++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            if (j % 2 == 0) {
                totalSum += getSingleDigitSum(digit * 2);
            } else {
                totalSum += digit;
            }
        }
        return (totalSum % 10 == 0) && (matchesPrefix(number, 4) || matchesPrefix(number, 5) ||
                matchesPrefix(number, 37) || matchesPrefix(number, 6)) &&
                (numStr.length() >= 13 && numStr.length() <= 16);
    }
    public static boolean matchesPrefix(long number, int prefix) {
        return Long.toString(number).startsWith(Integer.toString(prefix));
    }
    public static int getSingleDigitSum(int number) {
        return (number < 10) ? number : (number % 10 + number / 10);
    }
}