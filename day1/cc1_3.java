// given two string, write a method to decide if one is a permutation 
// of the other.
// first assume this is case sensitive and whitespace is significant.

class cc1_3 {

    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("two inputs are required!");
	    return;
	}
	System.out.println(args[0]);
	System.out.println(args[1]);
	//	System.out.println(isPermutation(args[0], args[1]) ? "true" : "false");
	System.out.println(isPermutationBySort(args[0], args[1]) ? "true" : "false");
	System.out.println();
    }

    public static boolean isPermutation(String str1, String str2) {
	// 1. first check if length of two strings are different, return false
	if (str1.length() != str2.length()) return false;
	// 2. define an array with length of 256 (assumption)
	// and use it as the counter for each chars in the string
	int[] counts = new int[256];
	for (int i = 0; i < str1.length(); i++) {
	    counts[str1.charAt(i)]++;
	}
	for (int i = 0; i < str2.length(); i++) {
	    if (--counts[str2.charAt(i)] < 0) return false;
	}

	return true;
    }

    public static boolean isPermutationBySort(String str1, String str2) {

	if (str1.length() != str2.length()) return false;
	return sort(str1).equals(sort(str2));
    }

    public static String sort(String str) {
	char[] content = str.toCharArray();
	java.util.Arrays.sort(content);
	return new String(content);
    }


}