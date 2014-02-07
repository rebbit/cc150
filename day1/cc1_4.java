
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
	    replacedStr = replaceSpaces(args[0]);
	    System.out.println("string before replacement: " + args[0]);
	    System.out.println("string after replacement: " + replacedStr);
	    System.out.println();
	    break;
	}
    }

    public static String replaceSpaces(String str) {
	return "test";
    }



}