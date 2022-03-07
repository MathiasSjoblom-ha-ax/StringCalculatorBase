public class StringCalculator {
    public static int Add(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        String temp = "0";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-') {
                throw new IllegalArgumentException("Only postive numbers allowed");
            }
            if (Character.isDigit(ch))
                temp += ch;
            else {
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }
}
