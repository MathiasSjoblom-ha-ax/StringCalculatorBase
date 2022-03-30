import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Scanner;

public class StringCalculator implements Logger{

    private final Logger logger;

    public StringCalculator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(Integer number) {
        logger.log(number);
    }

    public int Add(String s) {
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
            if (Character.isDigit(ch)) {
                temp += ch;
                if (Integer.parseInt(temp) > 1000) {
                    log(Integer.parseInt(temp));
                    System.out.println("Number bigger than 1000 detected");
                }
            } else {
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }

    public void main(String[] args) {
        System.out.println("Enter numbers to add them together or nothing to quit \n");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println("Enter your numbers: ");
            String input = scanner.nextLine();
            if (input != "") {
                System.out.println("The result is " + Add(input) + "\n");
            }
        }
    }
}
