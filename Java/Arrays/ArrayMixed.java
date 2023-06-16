import java.util.Arrays;

public class ArrayMixed {

	public static void main(String[] args) {
		//Beispiel:
		System.out.println("[Test join]");
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", join(";", new String[]{"A", "B", "Horst"}), "A;B;Horst");
		System.out.println("[Test splitt]");
		System.out.printf(join("-", (split(";", "A;B;Horst"))) + '\n');
		String[] arr = {"Abc", "D", "Ef"};
		System.out.println('\n' + "[Test sort]");
		System.out.println(Arrays.toString(arr));
		sortByLength(arr);
		System.out.println(Arrays.toString(arr) + '\n');
		System.out.println("[Test sort]");
		String[] arr_2 = {"AAAAA", "Aaaaaa", "AHA!"};
		System.out.println(Arrays.toString(arr_2));
		sortByOcc('A', arr_2);
		System.out.println(Arrays.toString(arr_2) + '\n');
		System.out.println("[Test reverse]");
		String str = "Das Wetter ist schön.";
		System.out.println(str);
		System.out.println(joinReverse(" " , "Das Wetter ist schön."));


	}

	public static String join(String delim, String[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if (i != array.length - 1) {
				sb.append(delim);
			}
			if (array.length == 1) {
				sb.append(delim);
			}
		}
		String result = sb.toString();
		return result;
	}

	public static String[] split(String delim, String str) {
		int count = 0;
		int startIndex = 0;
		int endIndex;
		String[] splitt = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (((str.charAt(i)) == delim.charAt(0)) || ((i == (str.length() - 1)) && str.charAt(i) != delim.charAt(0))) {
					endIndex = i - 1;
				if (i == (str.length() - 1) && str.charAt(i) != delim.charAt(0)) {
					endIndex = i;
				}
				splitt[count] = str.substring(startIndex, endIndex + 1);
				startIndex = i + 1;
				count++;
			}
		}
		String[] result = new String[count];
		for (int i = 0; i < count; i++) {
			result[i] = splitt[i];
		}

		return result;
	}

	public static void sortByLength(String[] array) {
		String temp;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].length() > array[i + 1].length()) {
				temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}
	}

	public static void sortByOcc(char c, String[] array) {
		Arrays.sort(array, (str1, str2) -> countOccurrences(str1, c) - countOccurrences(str2, c));
	}

	public static int countOccurrences(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public static String joinReverse(String c, String str) {
		String[] arr =split(c,str);
		String[] b = new String[arr.length];
		int j = arr.length;
		for (int i = 0; i < arr.length; i++) {
			b[j - 1] = arr[i];
			j = j - 1;
		}
		return join(c, b);
	}
}