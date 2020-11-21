package eg.edu.alexu.csd.datastructure.stack.cs28;

import java.lang.Integer;

public class ExpressionEvaluator implements IExpressionEvaluator {
    @Override
    public String infixToPostfix(String expression) {
        Stack expStack = new Stack();
        expression = expression.replaceAll("\\s+", ""); //remove white spaces
        StringBuilder postfix = new StringBuilder();
        int flag = -1;
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (Character.isLetterOrDigit(current)) {
                flag=0;
                postfix.append(expression.charAt(i));
                if (i+1<expression.length()&&Character.isLetter(expression.charAt(i+1)))
                    throw new IllegalArgumentException("Invalid expression !");
                while (i+1<expression.length()&&Character.isDigit(expression.charAt(i+1))){
                    postfix.append(expression.charAt(i+1));
                    i++;
                }
                    postfix.append(" ");
            }
            else if (current == '(') {
                if (flag == 0)
                    throw new IllegalArgumentException("Invalid expression !");
                expStack.push('(');
            }
            else if (current == ')') {
                while (!expStack.isEmpty() && !expStack.peek().equals('('))
                    postfix.append(expStack.pop()).append(" ");
                if (!expStack.isEmpty())
                    expStack.pop();
                else
                    throw new IllegalArgumentException("Invalid expression !");
            flag=0;
            } else {
                if(flag!=1&&!postfix.toString().isEmpty()){
                    //means that prev is an operator
                    if (expStack.isEmpty() || compareOperators(current) > compareOperators((Character) expStack.peek())) {
                        expStack.push(current);
                        flag = 1;
                    }
                    else {
                        postfix.append(expStack.pop()).append(" ");
                        i--;
                    }
                }
                else if(current=='-'&&Character.isLetterOrDigit(expression.charAt(i+1))){
                    postfix.append(0).append(" ");
                     while(i+1<expression.length()&&Character.isLetterOrDigit(expression.charAt(i+1)))  {
                         postfix.append(expression.charAt(i+1));
                         i++;
                     }
                     postfix.append(" ").append(current).append(" ");
                     flag = 0;
                }
                else if(current=='-'&&expression.charAt(i+1)=='-'&&postfix.toString().isEmpty())
                    i++;
                else
                    throw new IllegalArgumentException("Invalid expression !");

            }
        }
        while (!expStack.isEmpty())
            postfix.append(expStack.pop()).append(" ");
        if (postfix.indexOf("(") != -1)
            throw new IllegalArgumentException("Invalid expression !");
        if (postfix.toString().isEmpty())
            throw new IllegalArgumentException("Empty expression !");
        return postfix.toString().trim();
    }

    @Override
    public int evaluate(String expression) {

        Stack result = new Stack();
        boolean flag = false;
        if (expression.isEmpty())
            throw new IllegalArgumentException("Empty expression !");
        String[] split = expression.trim().split("\\s+");
        for (String s : split) {
            if (s.matches("-?\\d+(\\.\\d+)?")) {
                result.push(Integer.parseInt(s));
            } else if (s.matches("[-/+*]")) {
                result.push(evaluateOperator(result.pop(), s, result.pop()));
                flag=true;
            }
            else {
                throw new IllegalArgumentException("Expression contains unknowns..");
            }
        }
        if (result.isEmpty())
            throw new IllegalArgumentException("Empty expression !");
        if(!flag)
            throw new IllegalArgumentException("No operators found !");
        if(result.size!=1)
            throw new IllegalArgumentException("Invalid expression !");
        return ((Float) result.pop()).intValue();
    }

    /**
     * Compares precedence of operators
     *
     * @param opr Operator
     * @return An integer indicating its precedence
     */
    public int compareOperators(char opr) {
        switch (opr) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '(':
                return -1;
            default:
                throw new IllegalArgumentException("Invalid expression !");
        }
    }

    /***
     *Evaluates a single arithmetic operation
     * @param obj1
     * First number
     * @param opr
     * Operator
     * @param obj2
     * Second Number
     * @return Result of arithmetic operation
     */
    public float evaluateOperator(Object obj1, String opr, Object obj2) {
        float num1;
        float num2;
        //Casting numbers
        if (obj1 instanceof Integer)
            num1 = ((Integer) obj1).floatValue();
        else num1 = (float) obj1;
        if (obj2 instanceof Integer)
            num2 = ((Integer) obj2).floatValue();
        else num2 = (float) obj2;
        switch (opr) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "/":
                if(Float.isInfinite(num2/num1))
                    throw new ArithmeticException("Division by zero .. value is INFINITY ");
                return num2 / num1;
            case "*":
                return num2 * num1;
            default:
                throw new IllegalArgumentException("Invalid Expression !");
        }
    }

}
