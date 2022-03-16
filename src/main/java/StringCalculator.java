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
        boolean OnOrOff = true;
        while (OnOrOff) {
            System.out.printf("Enter two numbers to add them together or nothing to quit \n");
            Scanner input = new Scanner(System.in);
            String numbers = "";
            numbers = input.nextLine();
            if (numbers != "") {
                System.out.println("The result is " + Add(numbers));
            } else {
                OnOrOff = false;
            }
        }
        System.out.println("Quitting the program");
    }
}
