package IntegertoRoman;

import java.util.HashMap;
import java.util.Map;

/**
 * �_�R���ֹ���7������I��1����V��5����X��10����L��50����C��100����D��500����M��1000����
 * ����������Ҏ�t���Ա�ʾ��������������Ҫע���������������û�С�0�����c�Mλ�Ɵo�P��һ���J���_�R����ֻ�Á�ӛ�������������㡣
 * ���}���Σ�һ���_�R�������}�״Σ��ͱ�ʾ�@�����Ďױ��� �Ҽ���p�� ���^����_�R���ֵ���߅ӛ���^С���_�R���֣���ʾ���ּ�С���֡�
 * ���^����_�R���ֵ���߅ӛ���^С���_�R���֣���ʾ���ּ�С���֡� ��������������ƣ�������I��X��C������45������д��VL��ֻ����XLV
 * ���ǣ���p�r���ɿ�Խһ��λ�������磬99��������IC������ʾ��������XCIX������ʾ������ͬ춰���������ÿλ���ַքe��ʾ����
 * ��p���ֱ�횞�һλ������8����VIII������IIX�� �ҼӔ��ֲ����B�m���^��λ������14����XIV������XIIII����Ҋ�·������a���ơ�һ헡���
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
