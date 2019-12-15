package das.bodmas;

import java.util.Stack;

public class CheckParenthesis {
    public static void main(String[] args) {
//        char exp[] = {'{', '(', ')', '}', '[', ']'};
        char exp[] = {'{', '(', ')', '}', '[', ']', '['};
        CheckParenthesis checkParenthesis = new CheckParenthesis();
        if(checkParenthesis.areParenthesisBalanced(exp))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }

    public boolean areParenthesisBalanced(char[] exp){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < exp.length; i++){
            if(exp[i] == '{' || exp[i] == '(' || exp[i] == '['){
                stack.push(exp[i]);
            }
            if(exp[i] == '}' || exp[i] == ')' || exp[i] == ']'){

                if(stack.isEmpty()){
                    return false;
                }
                else if(!isMatchingPair(stack.pop(), exp[i])){
                    return false;
                }
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public boolean isMatchingPair(char ch1, char ch2){
        if(ch1 == '(' && ch2 == ')')
            return true;
        else if(ch1 == '{' && ch2 == '}')
            return true;
        else if(ch1 == '[' && ch2 == ']')
            return true;
        else
            return false;
    }
}
