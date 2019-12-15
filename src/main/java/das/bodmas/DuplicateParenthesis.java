package das.bodmas;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateParenthesis {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DuplicateParenthesis duplicateParenthesis = new DuplicateParenthesis();
        System.out.println("Enter any string with parenthesis e.g. (a+b).");
        String inputStr = scan.nextLine();
        boolean result = duplicateParenthesis.duplicateParenthesis(inputStr);
        if(result)
            System.out.println("Duplicate parenthesis found");
        else
            System.out.println("Duplicate parenthesis not found");
        scan.close();
    }

    public boolean duplicateParenthesis(String input){
        Stack<Character> stack = new Stack<Character>();
        char ch[] = input.toCharArray();
        int counter = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != ')'){
                stack.push(ch[i]);
                counter = 0;
            }
            else if(ch[i] == ')'){
                char tempChar = stack.pop();
                while(tempChar != '('){
                    tempChar = stack.pop();
                }
                if(tempChar == '(' && ch[i] == ')'){
                    counter++;
                }
            }
        }
        if(counter > 1){
            return true;
        }else{
            return false;
        }
    }
}

//    Below expressions have duplicate parenthesis -
//        ((a+b)+((c+d)))
//        The subexpression "c+d" is surrounded by two
//        pairs of brackets.
//
//        (((a+(b)))+(c+d))
//        The subexpression "a+(b)" is surrounded by two
//        pairs of brackets.
//
//        (((a+(b))+c+d))
//        The whole expression is surrounded by two
//        pairs of brackets.
//
//        Below expressions don't have any duplicate parenthesis -
//        ((a+b)+(c+d))
//        No subsexpression is surrounded by duplicate
//        brackets.
//
//        ((a+(b))+(c+d))
//        No subsexpression is surrounded by duplicate
//        brackets.