package finbarre.Easy_Balance_Checking;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EasyBal {
	public static String balance(String book) {
		book = book.replaceAll("[^A-Za-z0-9.\\n ]", "");
		book = book + "\n";
		String newBook = "";
		double originalBalance = 0;
		double balance = 0;
		int previousNewLinePosition = 0;
		double total = 0;
		List<Double> averageList = new ArrayList<>();
		DecimalFormat decimalFormat = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));

		for (int i = -1; (i = book.indexOf("\n", i + 1)) != -1; i++) {
			int beginning = 0;
			int countDigits = 0;
			String amountStr = "";
			double amount = 0;

			for (int j = i; j > 0; j--) {
				if (j == 1) {
					amountStr = Character.toString(book.charAt(0));
					while (countDigits > 0) {
						amountStr = amountStr + Character.toString(book.charAt(beginning - 1));
						beginning++;
						countDigits--;
					}
					amount = amount + Double.parseDouble(amountStr);
					originalBalance = amount;
					balance = originalBalance;
					newBook = "Original Balance: " + amountStr + "\\r\\n";
					previousNewLinePosition = i;
					break;
				}

				if (Character.isDigit(book.charAt(j - 1)) || Character.toString(book.charAt(j - 1)).equals(".")) {
					beginning = j;
					countDigits++;
				} else {

					for (int p = previousNewLinePosition + 1; p < beginning - 1; p++) {
						newBook = newBook + Character.toString(book.charAt(p));
					}

					while (countDigits > 0) {
						amountStr = amountStr + Character.toString(book.charAt(beginning - 1));
						beginning++;
						countDigits--;
					}
					amount = amount + Double.parseDouble(amountStr);

					balance = balance - amount;
					total = total + amount;
					previousNewLinePosition = i;
					averageList.add(amount);
					double rounded = Math.round(balance * 100.0) / 100.0;
					newBook = newBook + decimalFormat.format(amount) + " Balance " + decimalFormat.format(rounded)
							+ "\\r\\n";
					break;
				}

			}
		}
		newBook = newBook + "Total expense  " + decimalFormat.format(Math.round(total * 100.0) / 100.0) + "\\r\\n"
				+ "Average expense  "
				+ Math.round(averageList.stream().mapToDouble(val -> val).average().orElse(0.0) * 100.0) / 100.0;

		return newBook;
	}
}
