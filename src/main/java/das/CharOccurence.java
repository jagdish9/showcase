package das;

import java.util.Scanner;

public class CharOccurence {

    public void showNoOfOccurence(String inputStr){

        for(int i = 0; i < inputStr.length(); i++){
            int count = 0;
            boolean charExist = false;
            for(int j = i - 1; j >= 0; j--){
                if(inputStr.charAt(i) == inputStr.charAt(j)){
                    charExist = true;
                }
            }
            if(!charExist && inputStr.charAt(i) != ' '){
                for(int k = i+1; k < inputStr.length() - 1; k++){
                    if(inputStr.charAt(i) == inputStr.charAt(k)){
                        count++;
                    }
                }
                count++;
            }

            if(count > 0){
                System.out.println(inputStr.charAt(i)+" occured "+count+" times");
            }
        }
    }

    public static void main(String[] args) {
        CharOccurence charOccurence = new CharOccurence();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any String");
        String str = scan.nextLine();
        charOccurence.showNoOfOccurence(str);
        scan.close();
    }
}
