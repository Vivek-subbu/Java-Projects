package com.tsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Reader {
	private static BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(System.in));

	// Read integer values from console
	public static int readInt(String paramString, int paramInt1, int paramInt2) {
		int i = 0;
		int j;
		do {
			j = 1;
			System.out.print(paramString);
			try {
				i = Integer.parseInt(bufferedReader.readLine());
			} catch (IOException localIOException) {
				j = 0;
			} catch (NumberFormatException localNumberFormatException) {
				j = 0;
			}
			if ((j != 0) && ((i < paramInt1) || (i > paramInt2))) {
				j = 0;
			}
			if (j == 0) {
				if ((paramInt2 == Integer.MAX_VALUE)
						&& (paramInt1 == -2147483647)) {
					System.out
							.format("ERROR: Input must be an integer in [-infinity, infinity]!\n\n",
									new Object[0]);
				} else if (paramInt2 == Integer.MAX_VALUE) {
					System.out
							.format("ERROR: Input must be an integer in [%d, infinity]!\n\n",
									new Object[] { Integer.valueOf(paramInt1) });
				} else if (paramInt1 == -2147483647) {
					System.out
							.format("ERROR: Input must be an integer in [-infinity, %d]!\n\n",
									new Object[] { Integer.valueOf(paramInt2) });
				} else {
					System.out.format(
							"ERROR: Input must be an integer in [%d, %d]!\n\n",
							new Object[] { Integer.valueOf(paramInt1),
									Integer.valueOf(paramInt2) });
				}
			}
		} while (j == 0);
		return i;
	}

	// Read double values from console
	public static double readDouble(String paramString, double paramDouble1,
			double paramDouble2) {
		double d = 0.0D;
		int i;
		do {
			i = 1;
			System.out.print(paramString);
			try {
				d = Double.parseDouble(bufferedReader.readLine());
			} catch (IOException localIOException) {
				i = 0;
			} catch (NumberFormatException localNumberFormatException) {
				i = 0;
			}
			if ((i != 0) && ((d < paramDouble1) || (d > paramDouble2))) {
				i = 0;
			}
			if (i == 0) {
				if ((paramDouble2 == Double.MAX_VALUE)
						&& (paramDouble1 == -1.7976931348623157E308D)) {
					System.out
							.format("ERROR: Input must be a real number in [-infinity, infinity]!\n\n",
									new Object[0]);
				} else if (paramDouble2 == Double.MAX_VALUE) {
					System.out
							.format("ERROR: Input must be a real number in [%.2f, infinity]!\n\n",
									new Object[] { Double.valueOf(paramDouble1) });
				} else if (paramDouble1 == -1.7976931348623157E308D) {
					System.out
							.format("ERROR: Input must be a real number in [-infinity, %.2f]!\n\n",
									new Object[] { Double.valueOf(paramDouble2) });
				} else {
					System.out
							.format("ERROR: Input must be a real number in [%.2f, %.2f]!\n\n",
									new Object[] {
											Double.valueOf(paramDouble1),
											Double.valueOf(paramDouble2) });
				}
			}
		} while (i == 0);
		return d;
	}

	// Read String values from console
	public static String readString(String paramString) {
		System.out.print(paramString);
		paramString = "";
		try {
			paramString = bufferedReader.readLine();
		} catch (IOException localIOException2) {
			localIOException2.printStackTrace();
		}
		return paramString;
	}
}