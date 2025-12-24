public class peakIndex {
    public static void main(String arg[]){
        int[] arr={1,2,3,4,5,6,3,2,1};
        System.out.println("Peak value of array is :"+findPeakIndex(arr));
    }
    public static int findPeakIndex(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
    return arr[start];
    }
}
