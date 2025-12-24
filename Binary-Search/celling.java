public class celling {
    public static void main(String arg[]){
        int[] arr={2,4,6,33,56};
        int target=100;
        System.out.println("Celling of this target is :"+findCelling(arr,target));
    }
    
    public static int findCelling(int[] arr,int target){

        // What if the target number is greater than the greatest number in the array
        if(target>arr[arr.length-1]){
            return -1;
        }

        int start=0;
        // int mid=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
            {
                return arr[mid];
            }
            if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        // We return start as start id the smallest >=target , which describes the celling of a number
        return arr[start];
    }
}
