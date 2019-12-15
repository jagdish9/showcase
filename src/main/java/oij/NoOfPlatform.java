package oij;

import java.util.Arrays;

public class NoOfPlatform{

    public int findPlatform(int[] arr, int[] dep, int n){

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platformNeeded = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                platformNeeded++;
                i++;

                if(platformNeeded > result){
                    result = platformNeeded;
                }
            }else{
                platformNeeded--;
                j++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        NoOfPlatform noOfPlatform = new NoOfPlatform();

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + noOfPlatform.findPlatform(arr, dep, n));
    }
}