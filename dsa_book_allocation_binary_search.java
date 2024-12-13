/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    boolean isValid(int arr[], int n, int student, int mid){
        int studCount=1;
        int pages=0;
        for(int i=0; i<n; i++){
            if(arr[i]>mid){
                return false;
            }
            if(pages+arr[i]<=mid){
                pages+=arr[i];
            }else{
                studCount++;
                pages=arr[i];
            }
        }
        return studCount>student?false:true;
    }
    int bookAllocate(int arr[], int n, int student){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        if(student>n){
            return -1;
        }
        int start=0, end=sum;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isValid(arr,n,student,mid)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		int arr[]={2,1,3,4};
		int n=arr.length;
		int student=2;
		Main main=new Main();
		int ans = main.bookAllocate(arr,n,student);
		System.out.println(ans);
	}
}