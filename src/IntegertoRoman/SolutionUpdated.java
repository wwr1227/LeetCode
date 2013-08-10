public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
      Map<Integer, String> romanMap = new HashMap<Integer, String>();
		romanMap.put(1, "I");
		romanMap.put(4, "IV");
		romanMap.put(5, "V");
		romanMap.put(9, "IX");
		romanMap.put(10, "X");
		romanMap.put(40, "XL");
		romanMap.put(50, "L");
		romanMap.put(90, "XC");
		romanMap.put(100, "C");
		romanMap.put(400, "CD");
		romanMap.put(500, "D");
		romanMap.put(900, "CM");
		romanMap.put(1000, "M");

		int[] digital = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuffer buffer = new StringBuffer();
		for(int i = 0;i<digital.length;i++){
			while(num>=digital[i]){
				num-=digital[i];
				buffer.append(romanMap.get(digital[i]));
			}
		}
		return buffer.toString();
    }
}
