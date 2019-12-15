package das.bodmas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OperationOnOperator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        OperationOnOperator operationOnOperator = new OperationOnOperator();
        System.out.println("Enter any String e.g. a+(b-c)-(d-e)-(f+g)+(h-i)");
        String inputStr = scan.nextLine();
        String outputStr = operationOnOperator.removalOfParenthesis(inputStr);
        System.out.println(outputStr);
        scan.close();
    }

    public String removalOfParenthesis(String input){
        Queue<Character> queue = new LinkedList<Character>();
        String result = "";
        char[] ch = input.toCharArray();
        boolean exist = false;
        char operator = Character.MIN_VALUE;
        int open = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != '(' && ch[i] != ')'){
                char toadd = ch[i];
                if(exist){
                    if(operator == '-' && toadd == '+') {
                        toadd = '-';
                        operator = Character.MIN_VALUE;
                    }
                    else if(operator == '-' && toadd == '-') {
                        toadd = '+';
                        operator = Character.MIN_VALUE;
                    }
                }
                queue.add(toadd);
            }
            if(ch[i] == '('){
                open++;
            }else if(ch[i] == ')'){
                open--;
            }
            if(open == 0 && ch[i] == '-'){
                exist = true;
                operator = ch[i];
            }
        }

        for(Character val : queue){
            result = result + String.valueOf(val);
        }

        return result;
    }
}
