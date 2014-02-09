
class cc1_4 {

    public static void main(String[] args) {
	if (args.length < 1 || args.length > 2) {
	    System.out.println("one input required!");
	    return;
	}

	switch(args[0]) {
	case "--help":
	case "-h":
	    System.out.println("write a method to replace all spaces in a string with '%20'.");
	    System.out.println("You may assume that the string has sufficient space at the end ");
	    System.out.println("of the string to hold the addtional characters, and that you are ");
	    System.out.println("given the 'true' length of the string. ");
	    break;
	default:
	    String replacedStr = "";
	    int length = args[0].length();
	    char[] strArray = new char[length * 3];
	    for (int i = 0; i < length; i++) {
		strArray[i] = new Character(args[0].charAt(i));
	    }
	    replaceSpaces(strArray, length);
	    System.out.println("string before replacement: " + args[0]);
	    System.out.println("string after replacement: " + (new String(strArray)));
	    System.out.println();
	    break;
	}
    }

    public static void replaceSpaces(char[] strArray, int length) {
	// 1. first scan the string and get the counts of spaces inside
	int counter = 0;
	for (char c : strArray) {
	    if (c == ' ') counter++;
	}
	// 2. then increase the length of the char array by 2 * counter
	int newLength = length + 2 * counter;
	strArray[newLength] = '\0';
	// 3. copy over the replaced character backwards
	for (int i = length - 1; i >= 0; i--) {
	    if (strArray[i] == ' ') {
		strArray[newLength - 1] = '0';
		strArray[newLength - 2] = '2';
		strArray[newLength - 3] = '%';
		newLength = newLength - 3;
	    } else {
		strArray[newLength - 1] = strArray[i];
		newLength = newLength - 1;
	    }
	}
    }



}