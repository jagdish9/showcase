package recursion;

public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        String inputStr = "I am an original String";
        ReverseStringUsingRecursion rString = new ReverseStringUsingRecursion();
        rString.reverse(inputStr);
    }

    public void reverse(String inputStr){
        if(inputStr == null || inputStr.length() <= 1) {
            System.out.print(inputStr.charAt(inputStr.length() - 1));
        }
        else {
            System.out.print(inputStr.charAt(inputStr.length() - 1));
            reverse(inputStr.substring(0, inputStr.length() - 1));
        }
    }
}
