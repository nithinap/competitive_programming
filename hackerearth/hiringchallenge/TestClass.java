package hackerearth.hiringchallenge;

import java.util.Scanner;
import java.lang.Exception;

class TestClass {
	static void solve(int arr[]) throws Exception {
		int ans = 0;

		for (int i = 0; i < 10; i++)
			for (int j = i + 1; j < 10; j++)
				ans += arr[i] / arr[j];

		throw new MyException(ans);
	}

	public static void main(String args[]) {
		try {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int[] arr = new int[n];
			in.nextLine();

			for (int i = 0; i < 10; i++)
				arr[i] = Integer.parseInt(in.nextLine());

			String s = in.nextLine();
			System.out.println(s.charAt(10));

			solve(arr);
		} catch (Exception e) {
			processException(e);
		}
	}

	private static void processException(Exception e) {
		String ex = e.getClass().getName();
		if (ex.contains("ArithmeticException")) {
			System.out.println(new MyException("Invalid division").getMessage());
			System.exit(0);
		} else if (ex.contains("ArrayIndexOutOfBoundsException")) {
			System.out.println(new MyException("Array index is invalid").getMessage());
		} else if (ex.contains("StringIndexOutOfBoundsException")) {
			System.out.println(new MyException("Index is invalid").getMessage());
		} else if (ex.contains("InputMismatchException")) {
			System.out.println(new MyException("Format mismatch").getMessage());
		} else {
			System.out.println("Exception encountered");
		}
			
		/*
		catch (ArithmeticException e) {
//			System.out.println(new MyException("Invalid division").getMessage());
			processException(e);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(new MyException("Array index is invalid").getMessage());

		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(new MyException("Index is invalid").getMessage());

		} catch (java.util.InputMismatchException e) {
			System.out.println(new MyException("Format mismatch").getMessage());

		} */
		
	}
}

class MyException extends Exception {

	public MyException(int ans) {
		System.out.println("MyException[" + ans + "]");
		System.out.println("Exception Handling Completed");
	}

	public MyException(String message) {
		super(message);
		System.out.println("Exception Handling Completed");
	}
}
