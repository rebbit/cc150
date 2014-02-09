class cc1_5 {

    public static void main(String[] args) {
	if (args.length < 1) {
	    System.out.println("input required!");
	    System.out.println("Usage: java cc1_5 [OPTIONS] STRING_TO_COMPRESS]...");
	    return;
	}

	switch(args[0]) {
	case "--help":
	case "-h":
	    System.out.println("Implement a method to perform basic string compression using ");
	    System.out.println("the counts of repeated characters. For example, the string ");
	    System.out.println("aabcccccaaa would become a2b1c5a3. If the compressed string would ");
	    System.out.println("not become smaller than the original string, your method should ");
	    System.out.println("return the original string.");
	    System.out.println("Usage: java cc1_5 [OPTIONS] STRING_TO_COMPRESS]...");
	    break;
	case "--optimized":
	case "-o":
	    System.out.println("string before compression: " + args[1]);
	    System.out.println("string after compression: " + compressBetter(args[1]));
	    System.out.println();
	    break;
	default:
	    System.out.println("string before compression: " + args[0]);
	    System.out.println("string after compression: " + compressString(args[0]));
	    System.out.println();
	    break;
	}
    }

    public static String compressString(String str) {
	// this code doesn't handle the case when the compressed string is longer than the 
	// original one. Also the runtime for this routine would be O(n + k^2), where n is 
	// is the length of the original string, and k is the number of character sequences. 
	char last = str.charAt(0);
	String compressedStr = "";
	int count = 1;
	for (int i = 1; i < str.length(); i++) {
	    if (last == str.charAt(i)) count++;
	    else {
		compressedStr = compressedStr + last + Integer.toString(count);
		last = str.charAt(i);
		count = 1;
	    }
	}
	return compressedStr + last + Integer.toString(count);
    }

    public static String compressBetter(String str) {
	// check if compression will result equal or longer length of string
	if(countCompressedString(str) >= str.length()) {
	    System.out.println("Compressed string will have same or even longer length (" + countCompressedString(str) + ")");
	    return str;
	}
	StringBuffer sb = new StringBuffer();
	char last = str.charAt(0);
	int count = 1;
	for (int i = 1; i < str.length(); i++) {
	    if (str.charAt(i) == last) count++;
	    else {
		sb.append(last);
		sb.append(count);
		last = str.charAt(i);
		count = 1;
	    }
	}
	sb.append(last);
	sb.append(count);
	return sb.toString();
    }

    public static int countCompressedString(String str) {
	if (str == null || str.isEmpty()) return 0;
	int count = 1;
	char last = str.charAt(0);
	int size = 0;
	for (int i = 1; i < str.length(); i++){
	    if (last == str.charAt(i)) count++;
	    else {
		size += 1 + String.valueOf(count).length();
		last = str.charAt(i);
		count = 1;
	    }
	}
	size += 1 + String.valueOf(count).length();
	return size;
    }
}