public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<ArrayList<Integer>>();
		if(numRows<=0)
			return ans;
		int[][] triangle = new int[numRows][numRows];
		triangle[0][0]=1;
		for(int i=0;i<numRows;i++){
			triangle[0][i]=1;
		}
		for(int i=1;i<numRows;i++){
			for(int j=1;j<=i;j++){
				triangle[i][j]=triangle[i-1][j-1]+triangle[i][j-1];
			}
		}
		for(int i=0;i<numRows;i++){
			for(int j=0;j<=i;j++){
				item.add(triangle[i][j])
			}
			ans.add(new ArrayList<Integer>(item));
			item.clear();
		}
		return ans;
    }
}
