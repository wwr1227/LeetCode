public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
      if(s==null||s.length()==0)
    		return 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int ans = 0;
		for (int i = 0; i < s.length(); i++){
           if (s.charAt(i) == '(')
               stack.push(i);
           else{
               if (stack.size() == 1){
                   stack.pop();
                   stack.push(i);                    
                   continue;
               }
               stack.pop();
               ans = Math.max(ans, i - stack.peek());            
           }
       }
       return ans;
   }
}
