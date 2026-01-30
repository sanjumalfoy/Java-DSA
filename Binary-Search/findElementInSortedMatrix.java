import java.util.Arrays;

public class findElementInSortedMatrix {
    public static void main(String arg[]) {
        int[][] arr = {
                { 12, 14, 19, 22 },
                { 24, 36, 49, 50 },
                { 69, 81, 95, 99 }
        };
        int target = 14;
        System.out.println( Arrays.toString(findElement(arr, target)));
    }

    // to do normal Binary Search in each part of a particular row. The column range may differ but row is same
    public static int[] binarySearch(int[][] arr,int row, int cStart, int cEnd, int target ){
        while (cStart<=cEnd) {
            int mid=cStart+(cEnd-cStart)/2;
            if(arr[row][mid]==target){
                return new int[] {row,mid};
            }
            if(arr[row][mid]<target){
                cStart=mid+1;
            }
            else{
                cEnd=mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] findElement(int[][] arr, int target) {
        int row=arr.length;
        int col=arr[0].length;
        
        if(col==0){
            return new int[]{-1,-1};
        }
        if(row==1){
            return binarySearch(arr, 0, 0, col-1, target);
        }

        int rStart=0;
        int rEnd=row-1;
        int cMid=col/2;
        // Run the following loop until we get 2 rows
        while (rStart<(rEnd-1)) { 
            int mid=rStart+(rEnd-rStart)/2;
            if(arr[mid][cMid]==target){
                return new int[] {mid,cMid};
            }
            if(arr[mid][cMid]<target){
                rStart=mid;
            }
            else{
                rEnd=mid;
            }
        }

        //Now we get 2 rows, check if the target lies in these middle
        if(arr[rStart][cMid]==target){  //Mid of first row
            return new int[]{rStart,cMid};
        }
        if(arr[rStart+1][cMid]==target){ //Mid of Second row
            return new int[]{rStart+1,cMid};
        }

        //Binary Search among the elements before the mid of FIRST row
        if(target<=arr[rStart][cMid-1]){
            return binarySearch(arr, rStart, 0, cMid-1, target);
        }

        //Binary search among the elemnts after the mid of FIRST row
        if(target>=arr[rStart][cMid+1] && target<=arr[rStart][col-1]){
            return binarySearch(arr, rStart, cMid+1, col-1, target);
        }

        //Binary search among the elements before the mid of SECOND row
        if(target<=arr[rStart+1][cMid-1]){
            return binarySearch(arr, rStart+1, 0, cMid-1, target);
        }
        else{//Binary search among the elements after the mid of SECOND row
            return binarySearch(arr, rStart+1, cMid+1, col-1, target);
        }
    }
}
