package das.bodmas;

import java.util.Stack;

public class EvaluateString {
    public static void main(String[] args) {
        EvaluateString evaluateString = new EvaluateString();
        System.out.println(evaluateString.evaluate("10 + 2 * 6"));
        System.out.println(evaluateString.evaluate("100 * 2 + 12"));
        System.out.println(evaluateString.evaluate("100 * ( 2 + 12 )"));
        System.out.println(evaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
    }

    public int evaluate(String expression){
        char[] tokens = expression.toCharArray();

        Stack<Integer> values = new Stack<Integer>();

        Stack<Character> ops = new Stack<Character>();

        for(int i = 0; i < tokens.length; i++){
            if(tokens[i] == ' '){
                continue;
            }

            if(tokens[i] >= '0' && tokens[i] <= '9'){
                StringBuffer stringBuffer = new StringBuffer();
                while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9'){
                    stringBuffer.append(tokens[i++]);
                }
                values.push(Integer.parseInt(stringBuffer.toString()));
            }
            else if(tokens[i] == '('){
                ops.push(tokens[i]);
            }
            else if(tokens[i] == ')'){
                while(ops.peek() != '('){
                    values.push(applyOps(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }
            else if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '/' || tokens[i] == '*'){
                while(!ops.empty() && hasPrecedence(tokens[i], ops.peek())){
                    values.push(applyOps(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }

        while(!ops.empty()){
            values.push(applyOps(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    public int applyOps(char op, int b, int a){
        switch(op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if(b == 0)
                    throw new UnsupportedOperationException("can not divide by zero");
                return a/b;
        }
        return 0;
    }

    public boolean hasPrecedence(char op1, char op2){
        if(op2 == '(' || op2 == ')')
            return false;
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
}
