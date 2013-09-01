//Time complexity:O(n^2)
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        if(rowIndex<0)
            return arraylist;
        
        int[] triangle = new int [rowIndex+1];
        triangle[0]=1;
     
        for(int i=0;i<=rowIndex;i++){
            for(int j=i;j>0;j--){
                triangle[j]=triangle[j]+triangle[j-1];
            }
        }
        for(int i=0;i<=rowIndex;i++)
            arraylist.add(triangle[i]);
        
        return arraylist;
        
    }
}
