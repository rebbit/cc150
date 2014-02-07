// implement an algorithm to determine if a string has all unique characters. 
// what if you cannot use additional data structures?
class cc1_1 {
    public static final int MAX_LENGTH = 256;
    public static void main(String[] args) {
	for (String s : args) {
	    //	    System.out.println(isUniqueCharsByArray(s) ? "true" : "false");
	    System.out.println(isUniqueCharsBySingleInt(s) ? "true" : "false");
	    System.out.println();
	}
    }

    public static boolean isUniqueCharsByArray(String str) {
	if (str.length() > MAX_LENGTH) return false;
	boolean[] char_set = new boolean[MAX_LENGTH];
	for (int i = 0; i < str.length(); i++) {
	    int val = str.charAt(i);
	    if(char_set[val]) return false;
	    char_set[val] = true;
	}
	return true;
    }

    public static boolean isUniqueCharsBySingleInt(String str) {
	// by using only one integer, the input is limited to a-z instead!
	if (str.length() > MAX_LENGTH) return false;
	int checker = 0;
	for (int i = 0; i < str.length(); i++) {
	    int val = str.charAt(i);
	    System.out.println(val);
	    if ((checker & (1 << val)) > 0) return false;
	    checker |= (1 << val);
	}
	return true;
    }
}