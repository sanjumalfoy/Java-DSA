import java.util.Arrays;

public class matrixSearchElement {
public static void main(String arg[]){
        int[][] arr={
            {12,25,35,67},
            {13,26,37,70},
            {16,30,40,80}
        };
        int target= 90;
        System.out.println("Peak value of array is :"+Arrays.toString(findElementfromMatrix(arr,target)));
    }
    public static int[] findElementfromMatrix(int[][] arr, int target) {
       int row=0;
       int col=arr[0].length-1;
       while(row<arr.length && col>=0){
        if(arr[row][col]==target){
            return new int[]{row,col};
        }
        if(arr[row][col]<target){
            row++;
        }
        else{
            col--;
        }
       }

       return new int[] {-1,-1};
    }
}
