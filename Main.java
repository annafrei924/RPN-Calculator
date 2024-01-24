/**
 * This program evaluates RPN expression
 * @source user input of RPN expression, evaluate class
 * @result evaulation of RPN expression
 * @author Anna Freiman
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an RPN expression or enter to quit: ");
            String expression = s.nextLine();

            //ends the program
            if (expression.equals("")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            String result = Calculator.evaluate(expression);
             System.out.println(result);

        }
    }

}