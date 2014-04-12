package com.practicaljava.unit_10.url;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Static methods for getting stock quotes as a single CSV line,
 * split it into single values and print them out.
 */
public class StockQuote {

	// For replacing the "s=%s" parameter with "s=IBM" (for example).
	public static String URL_PATTERN = "http://quote.yahoo.com/d/quotes.csv?s=%s&f=sl1d1t1c1ohgv&e=.csv";

	public static void printStockQuote(String symbol) {
		URL url = null;
		try {
			url = new URL(String.format(URL_PATTERN, symbol));
		} catch (MalformedURLException e) {
			System.err.println("Wrong URL! Please check it.");
			System.exit(1);
		}

		// * try-with-resources
		// * openStream() is a shorthand for openConnection().getInputStream()
		try (Scanner sc = new Scanner(new InputStreamReader(url.openStream()))) {

			sc.useDelimiter(","); // Splits input strings with comma

			String ticker = sc.next();
			String price = sc.next();
			String tradeDate = sc.next();
			String tradeTime = sc.next();

			System.out.println("Symbol: " + ticker + " Price: " + price
					+ " Date: " + tradeDate + " Time: " + tradeTime);

		} catch (IOException e) {
			System.err.println("Can't read from the URL: " + e);
			System.exit(1);
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Sample usage: java StockQuote IBM");
			System.exit(1);
		}

		printStockQuote(args[0]);

		// Test:
		//printStockQuote("IBM");

		System.out.println("All done!");
	}
}
