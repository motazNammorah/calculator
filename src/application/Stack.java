package application;

public class Stack {

	static CaursorLinked cursor = new CaursorLinked();

	
	
	public Stack() {

	}
	

	
	public static boolean push(String obj) {
		if (cursor.find(cursor.Header) > cursor.spaceSize) {
			System.out.println("out of memory");
			return false;
		} else {
			cursor.insert(obj, cursor.Header);

			return true;
		}

	}

	public static Object pop() {
		if (cursor.Header == 0) {
			System.out.println("out of meomry");
			return null;
		} else {
			int cursorindex = cursor.find(cursor.Header);
			return cursor.remove(cursor.cursorSpace[cursorindex].elemnt, cursor.Header);
			
			

		}
	}

	public static void print() {
		cursor.printList(cursor.Header);
	}

	public static Object peek() {
		int index = cursor.find(cursor.Header);

		Object ma = cursor.cursorSpace[index].elemnt;
		return ma;
	}

	public static String infexToPostFix(String[] Expression) {
		int counter = 0;
		for (int i = 0; i < Expression.length; i++) {
			if (Expression[i].equals("(") || Expression[i].equals(")")) {
				counter++;
			}
		}

		if (counter % 2 != 0) {
			return " Error";
		}

		String sum = "";

		for (int i = 0; i < Expression.length; i++) {

			boolean is = isNumber(Expression[i]);

			if (is == true) {

				sum = sum + Expression[i] + " ";
			} else if (Expression[i].equals(" ")) {
				continue;
			} else if (Expression[i].equals("(")) {

				push(Expression[i]);

			} else if (Expression[i].equals(")")) {

				Object v = peek();

				while (!v.equals("(")) {

					sum = sum + v + " ";

					Object p = pop();

					v = peek();
				}
				pop();

			} else {

				int d = delete(Expression[i]);

				while (peek() != null && d <= delete(peek())) {

					sum = sum + peek() + " ";
					pop();

				}

				push(Expression[i]);

			}

		}

		Object p = peek();
		while (p != null) {
			sum = sum + p + " ";
			pop();
			p = peek();
		}
		return sum;
	}

	public static boolean isNumber(String EX) {

		if (EX.equals(" ")) {

			return false;
		}
		for (int i = 0; i < EX.length(); i++) {
			int n = EX.charAt(i) - 48;

			if (n >= 0 && n <= 9) {

				continue;
			} else if (EX.charAt(i) == '.') {
				continue;
			} else if (EX.charAt(i) == ' ') {

				return false;
			} else {

				return false;
			}
		}
		return true;
	}

	public static int delete(Object x) {
		if (x.equals('-') || x.equals('+') || x.equals("+") || x.equals("-")) {

			return 1;
		} else if (x.equals('/') || x.equals('*') || x.equals("*") || x.equals("/")) {

			return 2;
		} else if (x.equals('^') || x.equals("^")) {
			return 3;
		} else {
			return 0;
		}
	}

	public static double postFixedToEvaluiton(String Expression) {

		double sum = 0, x, y;
		String[] array = Expression.split(" ");
		for (int i = 0; i < array.length; i++) {
			boolean is = isNumber(array[i]);

			if (is == true) {

				push(array[i]);
			} else {

				if (array[i].equals(" ")) {
					continue;
				}

				else if (array[i].equals("+")) {

					x = Double.parseDouble((String) peek());

					pop();
					y = Double.parseDouble((String) peek());
					pop();
					sum = y + x;
					push(sum + "");
				} else if (array[i].equals("-")) {
					x = Double.parseDouble((String) peek());

					pop();
					y = Double.parseDouble((String) peek());
					pop();
					sum = y - x;
					push(sum + "");
				} else if (array[i].equals("*")) {
					x = Double.parseDouble((String) peek());

					pop();
					y = Double.parseDouble((String) peek());
					pop();
					sum = y * x;
					push(sum + "");
				} else if (array[i].equals("/")) {
					x = Double.parseDouble((String) peek());

					pop();
					y = Double.parseDouble((String) peek());
					pop();
					sum = y / x;
					push(sum + "");
				} else if (array[i].equals("^")) {
					x = Double.parseDouble((String) peek());

					pop();
					y = Double.parseDouble((String) peek());
					pop();
					sum = Math.pow(y, x);
					push(sum + "");
				}

			}
		}

		return Double.parseDouble((String) peek());
	}


}
