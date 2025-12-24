public class floor {
    public static void main(String arg[]){
        int[] arr={23,45,66,777,888,7678};
        int target=880;
        System.out.println("Floor of the target from the array is:"+findFloor(arr,target));
    }
    // Floor has same logic as celing ,but here we return the END position value ( arr[end] )
    public static int findFloor(int[] arr,int target){

        
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return arr[mid];
            }
            if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return arr[end];
    }
}
