public class celling {
    public static void main(String arg[]){
        int[] arr={2,4,6,33,56};
        int target=30;
        System.out.println("Celling of this target is :"+findCelling(arr,target));
    }
    public static int findCelling(int[] arr,int target){
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
            if(arr[mid]>target){
                end=mid-1;
            }
        }

        return arr[start];
    }
}
