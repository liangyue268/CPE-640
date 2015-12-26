/**
 * Created by yue on 2/22/2015.
 */
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    private Stack<BigDecimal> numbers = new Stack<BigDecimal>();

    private Stack<Character> chs = new Stack<Character>();

    /**
     * Comparing the priority of the upcoming operator and the top stack element.
     *
     * @return true represents a higher priority than top stack element, false for lower priority
     */
    private boolean compare(char str) {
        if (chs.empty()) {
            return true;
        }
        else{
            char last = chs.lastElement();
            switch (str) {
                case '*': {
                    if (last == '+' || last == '-')
                        return true;
                    else
                        return false;
                }
                case '/': {
                    if (last == '+' || last == '-')
                        return true;
                    else
                        return false;
                }
                case '+':
                    return false;
                case '-':
                    return false;
                default:
                    return true;
            }
        }
    }

    //put expression elements into right stack and ready for calculate
    public BigDecimal calculate(String st) {
        StringBuffer sb = new StringBuffer(st);
        StringBuffer num = new StringBuffer();//temporary place for incomplete digits of a number
        String temp;
        char next;
        while (sb.length() > 0) {
            temp = sb.substring(0, 1);//the first character in this string
            sb.delete(0, 1);
            if (isNum(temp)) {
                num.append(temp);//adding to num if it is a number
            }
            else {

                //when the character collected is not one digit of a number, which means it must be a operator and stack num is a complete number
                //eg: dealing with 123+1, 123 forms a number when we capture the operator "+"
                if (num.length() > 0 && !"".equals(num.toString().trim())) {
                    BigDecimal bd = new BigDecimal(num.toString().trim());
                    numbers.push(bd);
                    num.delete(0, num.length());
                }

                //calculating when we have operator
                if (!chs.isEmpty()) {
                    //do calculate while the upcoming operator priority is lower or equal to the top stack element
                    //eg: 1*2+3, "+" has lower priority than "*", so we can compute 1*2 and make the expression become 2+3
                    while (!compare(temp.charAt(0))) {
                        calculate();
                    }
                }
                //special case: the first number is a negative number
                if (numbers.isEmpty()) {
                    num.append(temp);
                }
                else {
                    chs.push(new Character(temp.charAt(0)));
                }
                //special case: an operator comes with a negative number
                //eg: 1*2*(-5), removing braces by another function, we have to know that "-" is not a operator
                next = sb.charAt(0);
                if (next == '-') {
                    num.append(next);
                    sb.delete(0, 1);
                }

            }
        }
        //dealing with the last number
        BigDecimal bd = new BigDecimal(num.toString().trim());
        numbers.push(bd);
        //final calculation
        while (!chs.isEmpty()) {
            calculate();
        }
        return numbers.pop();
    }

    //real calculation work
    private void calculate() {
        BigDecimal b = numbers.pop();//second number
        BigDecimal a = numbers.pop();//first number
        char ope = chs.pop();
        BigDecimal result;//the result after calculation
        switch (ope) {
            case '+':
                result = a.add(b);
                numbers.push(result);
                break;
            case '-':
                result = a.subtract(b);
                numbers.push(result);
                break;
            case '*':
                result = a.multiply(b);
                numbers.push(result);
                break;
            case '/':
                result = a.divide(b, 5, BigDecimal.ROUND_HALF_UP);
                numbers.push(result);
                break;
        }
    }

    private boolean isNum(String num) {
        return num.matches("[0-9]") || num.charAt(0) == (char)46;
    }

    //tackle with braces
    public BigDecimal parse(String st) {
        int first, end;
        StringBuffer sts = new StringBuffer(st);
        //extract the expression covered by innermost braces to calculate
        while ((end = sts.indexOf(")")) > 0) {
            first = sts.lastIndexOf("(", end);
            BigDecimal value = calculate(sts.substring(first + 1, end));
            sts.replace(first, end + 1, value.toString());
        }
        return calculate(sts.toString());
    }

    public static void main(String[] args) {
        String expression;
        System.out.print("Input: ");
        Scanner in = new Scanner(System.in);
        expression = in.nextLine();
        Calculator cal = new Calculator();
        System.out.print(expression+" = ");
        System.out.println(cal.parse(expression));
    }
}