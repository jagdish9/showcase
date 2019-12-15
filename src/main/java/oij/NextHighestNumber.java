package oij;

public class NextHighestNumber {

    public int[] nextHighestNumber(int arr[]){
        int[] resultArr = new int[arr.length];
        int j = 0;
        for(int y = 0; y < arr.length; y++){
            boolean foundNext = false;
            for(int z = y+1; z < arr.length; z++){
                if(arr[y] < arr[z]){
                    resultArr[j] = arr[z];
                    foundNext = true;
                    break;
                }
            }
            if(!foundNext){
                resultArr[j] = -1;
            }
            j++;
        }

        return resultArr;
    }

    public static void main(String[] args) {
        NextHighestNumber nextHighestNumber = new NextHighestNumber();
        int[] arr = {11, 2, 4, 6, 8, 7, 10};
        System.out.println("*****Original Array*****");
        for(int x = 0; x < arr.length; x++){
            System.out.print(arr[x]+" ");
        }
        System.out.println();
        int[] duplicateArr = nextHighestNumber.nextHighestNumber(arr);
        System.out.println("*****Duplicate Array*****");
        for(int x = 0; x < duplicateArr.length; x++){
            System.out.print(duplicateArr[x]+" ");
        }
    }
}
