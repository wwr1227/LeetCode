public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null||s.length()<=1)
            return s;
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for(int i=0;i<s.length();i++)
            sb.append(s.charAt(i)+"#");
        String ss=sb.toString();  
        int center=0; 
        int right=0;
        int []plen=new int[ss.length()];
        for(int i=1;i<ss.length()-1;i++){
            int mirror_i=2*center-i;
            if(right>i)
                plen[i]=Math.min(right-i,plen[mirror_i]);
            while(i+plen[i]+1<ss.length()-1&&i-plen[i]-1>0&& 
                    ss.charAt(i+plen[i]+1)==ss.charAt(i-plen[i]-1))
                plen[i]++;
            if(plen[i]+i>right){
                center=i;
                right=plen[i]+i;                
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < ss.length()-1; i++) {
            if (plen[i] > maxLen) {
              maxLen = plen[i];
              centerIndex = i;
            }
        }
        int start=(centerIndex - 1 - maxLen)/2;
        int end =centerIndex;
        return s.substring(start, end);
    }
}
