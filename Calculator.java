import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * This program evaluates RPN expressions using a Stack
 * @result String evaulation of RPN expression
 * @author Anna Freiman
 */
public class Calculator {
    public static String evaluate (String expression) {
        String[] arr = null;
        Stack<Double> stacks = new Stack<>();
        arr = expression.split("\s+");

        //list of all possible valid Operands
        final String[] operands = {"+", "-", "*", "/", "^"};
        final List<String> operandsList = Arrays.asList(operands);

        //loops through array
        for (int arrchar = 0; arrchar < arr.length; arrchar++) {

            //if it is a double, push to stack
            try {
                stacks.push(Double.valueOf(arr[arrchar]));
            } catch (NumberFormatException e) {
                Double a, b;

                //handle it if it is an operand
                if (operandsList.contains(arr[arrchar])) {
                    if (stacks.isEmpty()) {
                        return "Syntax Error";
                    } else {
                        a = stacks.pop();
                    }
                    if (stacks.isEmpty()) {
                        return "Syntax Error";
                    } else {
                        b = stacks.pop();
                    }

                    switch (arr[arrchar]) {
                        case "+":
                            stacks.push(b + a);
                            break;
                        case "-":
                            stacks.push(b - a);
                            break;
                        case "*":
                            stacks.push(b * a);
                            break;
                        case "/":
                            stacks.push(b / a);
                            break;
                        case "^":
                            stacks.push(Math.pow(b, a));
                            break;
                    }

                    //other illegal input
                } else {
                    return "Syntax Error";
                }


            }
        }

        //trashes extra doubles in the stack
        if(stacks.isEmpty() == false) {
            System.out.println("Extra junk removed.");
        }
        return stacks.pop().toString();
    }
}
