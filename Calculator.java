import java.util.*;

class Operation {

    double currentNumber = 0.0;

    public void add(double newNumber) {
        this.currentNumber += newNumber;
    }

    public void subtract(double newNumber) {
        this.currentNumber -= newNumber;
    }

    public void multiply(double newNumber) {
        this.currentNumber *= newNumber;
    }

    public void divide(double newNumber) {
        if (newNumber == 0) {
            this.currentNumber = 0.0;
            return;
        }
        this.currentNumber /= newNumber;
    }

    public void cancel() {
        this.currentNumber = 0.0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.currentNumber);
    }

}

public class Calculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Operation op = new Operation();
        while (true) {
            String[] inputArr = in.nextLine().split(" ");
            String[] operationList = {"add", "subtract", "multiply", "divide"};
            String command = inputArr[0];
            double newNumber = 0.0;

            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            if (command.equalsIgnoreCase("cancel")) {
                op.cancel();
            }
            if (Arrays.stream(operationList).anyMatch(x -> x.equalsIgnoreCase(command)) && inputArr.length == 2) {
                newNumber = Double.parseDouble(inputArr[1]);
                switch (command) {
                    case "add":
                        op.add(newNumber);
                        break;
                    case "subtract":
                        op.subtract(newNumber);
                        break;
                    case "multiply":
                        op.multiply(newNumber);
                        break;
                    case "divide":
                        op.divide(newNumber);
                        break;
                }
            }
            System.out.println(op.toString());
        }
    }
}
