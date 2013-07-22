package IntegertoRoman;

import java.util.HashMap;
import java.util.Map;

/**
 * 羅馬數字共有7個，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。
 * 按照下述的規則可以表示任意正整數。需要注意的是罗马数字中没有“0”，與進位制無關。一般認為羅馬數字只用來記數，而不作演算。
 * 重複數次：一個羅馬數字重複幾次，就表示這個數的幾倍。 右加左減： 在較大的羅馬數字的右邊記上較小的羅馬數字，表示大數字加小數字。
 * 在較大的羅馬數字的左邊記上較小的羅馬數字，表示大數字减小數字。 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 * 但是，左減時不可跨越一個位數。比如，99不可以用IC（）表示，而是用XCIX（）表示。（等同於阿拉伯數字每位數字分別表示。）
 * 左減數字必須為一位，比如8寫成VIII，而非IIX。 右加數字不可連續超過三位，比如14寫成XIV，而非XIIII。（見下方“數碼限制”一項。）
 * 
 * @author dongywan
 * 
 */
/**
 * 1<=digit <=3 digit =4 digit = 5 5<digit<=8 digit =9
 * 
 * @author dongywan
 * 
 */
public class Solution {

	public String intToRoman(int num) {
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
		StringBuffer buffer = new StringBuffer(10);
		for (int i = 0; i < digital.length; i++) {
			while (num >= digital[i]) {
				num -= digital[i];
				buffer.append(romanMap.get(digital[i]));
			}
		}
		return buffer.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		System.out.println(su.intToRoman(1));
	}

}
