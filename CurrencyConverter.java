import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    // Mock exchange rates for simplicity
    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        // Assuming exchange rates with respect to USD
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 73.0);
        // Add more currencies as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Display available currencies
        System.out.println("Available Currencies: " + exchangeRates.keySet());

        // Step 2: Get user input
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the source currency: ");
        String fromCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the target currency: ");
        String toCurrency = scanner.next().toUpperCase();

        // Step 3: Convert currency
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

        // Step 4: Display result
        if (convertedAmount != -1) {
            System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, toCurrency);
        } else {
            System.out.println("Invalid currency input.");
        }

        scanner.close();
    }

    private static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            return -1; // Return -1 for invalid currency codes
        }

        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        // Convert amount to USD and then to the target currency
        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }
}