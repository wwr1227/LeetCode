//Time complexity:O(n)
public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null || A.length==0)
            return 1;
        int i=0;
        while(i<A.length){
            if(A[i]<=0||A[i]>A.length||A[i]==i+1||A[i]==A[A[i]-1])
                i++;
            else
                swap(A,i,A[i]-1);
        }
        int ans=0;
        for( i=0;i<A.length;i++){
            if(A[i]!=i+1){
                ans=i+1;
                break;
            }
        }
        if(ans==0)
            ans=A.length+1;
        return ans;
    }
    public void swap(int[] A, int i,int j){
        int temp =A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
