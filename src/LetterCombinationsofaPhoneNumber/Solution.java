package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;

public class Solution {

	private final String[] digitalToChar = { " ", "", "abc", "def", "ghi",
			"jkl", "mno", "pqrs", "tuv", "wxyz", "*", "#" };

	public ArrayList<String> letterCombinations(String digits) {

		ArrayList<String> ans = new ArrayList<String>();
		// Start typing your Java solution below
		// DO NOT write main() function
		if (digits == null) {
			ans.add("");
			return ans;
		}

		int len = digits.length();
		if (len == 0) {
			ans.add("");
			return ans;
		}
		String[] alph = new String[len];
		for (int i = 0; i < len; i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			alph[i] = digitalToChar[index];
		}
		StringBuilder item = new StringBuilder("");
		letterCombinationsHelper(ans, alph, item, 0);
		return ans;
	}

	public void letterCombinationsHelper(ArrayList<String> ans, String[] alph,
			StringBuilder item, int index) {

		if (index == alph.length) {
			ans.add(new StringBuilder(item).toString());
			return;
		}

		for (int j = 0; j < alph[index].length(); j++) {
			item.append(alph[index].charAt(j));
			letterCombinationsHelper(ans, alph, item, index + 1);
			item.deleteCharAt(item.length() - 1);

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		String digits = "23";
		System.out.println(su.letterCombinations(digits));
	}

}
/**
 * 
 Output:
 * 
 * "9387"
 * ["xdtp","xdtq","xdtr","xdts","xdup","xduq","xdur","xdus","xdvp","xdvq",
 * "xdvr",
 * "xdvs","xetp","xetq","xetr","xets","xeup","xeuq","xeur","xeus","xevp","xevq"
 * ,"xevr"
 * ,"xevs","xftp","xftq","xftr","xfts","xfup","xfuq","xfur","xfus","xfvp",
 * "xfvq",
 * "xfvr","xfvs","ydtp","ydtq","ydtr","ydts","ydup","yduq","ydur","ydus","ydvp"
 * ,"ydvq"
 * ,"ydvr","ydvs","yetp","yetq","yetr","yets","yeup","yeuq","yeur","yeus",
 * "yevp",
 * "yevq","yevr","yevs","yftp","yftq","yftr","yfts","yfup","yfuq","yfur","yfus"
 * ,"yfvp"
 * ,"yfvq","yfvr","yfvs","zdtp","zdtq","zdtr","zdts","zdup","zduq","zdur",
 * "zdus",
 * "zdvp","zdvq","zdvr","zdvs","zetp","zetq","zetr","zets","zeup","zeuq","zeur"
 * ,"zeus"
 * ,"zevp","zevq","zevr","zevs","zftp","zftq","zftr","zfts","zfup","zfuq",
 * "zfur","zfus","zfvp","zfvq","zfvr","zfvs"]
 * ["wdtp","wdtq","wdtr","wdts","wdup"
 * ,"wduq","wdur","wdus","wdvp","wdvq","wdvr",
 * "wdvs","wetp","wetq","wetr","wets",
 * "weup","weuq","weur","weus","wevp","wevq","wevr"
 * ,"wevs","wftp","wftq","wftr","wfts"
 * ,"wfup","wfuq","wfur","wfus","wfvp","wfvq",
 * "wfvr","wfvs","xdtp","xdtq","xdtr",
 * "xdts","xdup","xduq","xdur","xdus","xdvp","xdvq"
 * ,"xdvr","xdvs","xetp","xetq","xetr"
 * ,"xets","xeup","xeuq","xeur","xeus","xevp",
 * "xevq","xevr","xevs","xftp","xftq",
 * "xftr","xfts","xfup","xfuq","xfur","xfus","xfvp"
 * ,"xfvq","xfvr","xfvs","ydtp","ydtq"
 * ,"ydtr","ydts","ydup","yduq","ydur","ydus",
 * "ydvp","ydvq","ydvr","ydvs","yetp",
 * "yetq","yetr","yets","yeup","yeuq","yeur","yeus"
 * ,"yevp","yevq","yevr","yevs","yftp"
 * ,"yftq","yftr","yfts","yfup","yfuq","yfur",
 * "yfus","yfvp","yfvq","yfvr","yfvs",
 * "zdtp","zdtq","zdtr","zdts","zdup","zduq","zdur"
 * ,"zdus","zdvp","zdvq","zdvr","zdvs"
 * ,"zetp","zetq","zetr","zets","zeup","zeuq",
 * "zeur","zeus","zevp","zevq","zevr",
 * "zevs","zftp","zftq","zftr","zfts","zfup","zfuq"
 * ,"zfur","zfus","zfvp","zfvq","zfvr","zfvs"]
 * 
 * "2859"
 * ["atjx","atjy","atjz","atkx","atky","atkz","atlx","atly","atlz","aujx",
 * "aujy",
 * "aujz","aukx","auky","aukz","aulx","auly","aulz","avjx","avjy","avjz","avkx"
 * ,"avky"
 * ,"avkz","avlx","avly","avlz","btjx","btjy","btjz","btkx","btky","btkz",
 * "btlx",
 * "btly","btlz","bujx","bujy","bujz","bukx","buky","bukz","bulx","buly","bulz"
 * ,"bvjx"
 * ,"bvjy","bvjz","bvkx","bvky","bvkz","bvlx","bvly","bvlz","ctjx","ctjy",
 * "ctjz",
 * "ctkx","ctky","ctkz","ctlx","ctly","ctlz","cujx","cujy","cujz","cukx","cuky"
 * ,"cukz"
 * ,"culx","culy","culz","cvjx","cvjy","cvjz","cvkx","cvky","cvkz","cvlx",
 * "cvly","cvlz"]
 * ["atjw","atjx","atjy","atjz","atkw","atkx","atky","atkz","atlw"
 * ,"atlx","atly",
 * "atlz","aujw","aujx","aujy","aujz","aukw","aukx","auky","aukz",
 * "aulw","aulx","auly"
 * ,"aulz","avjw","avjx","avjy","avjz","avkw","avkx","avky","avkz"
 * ,"avlw","avlx",
 * "avly","avlz","btjw","btjx","btjy","btjz","btkw","btkx","btky",
 * "btkz","btlw","btlx"
 * ,"btly","btlz","bujw","bujx","bujy","bujz","bukw","bukx","buky"
 * ,"bukz","bulw",
 * "bulx","buly","bulz","bvjw","bvjx","bvjy","bvjz","bvkw","bvkx",
 * "bvky","bvkz","bvlw"
 * ,"bvlx","bvly","bvlz","ctjw","ctjx","ctjy","ctjz","ctkw","ctkx"
 * ,"ctky","ctkz",
 * "ctlw","ctlx","ctly","ctlz","cujw","cujx","cujy","cujz","cukw",
 * "cukx","cuky","cukz"
 * ,"culw","culx","culy","culz","cvjw","cvjx","cvjy","cvjz","cvkw"
 * ,"cvkx","cvky","cvkz","cvlw","cvlx","cvly","cvlz"]
 * 
 * "8888"
 * ["tttt","tttu","tttv","ttut","ttuu","ttuv","ttvt","ttvu","ttvv","tutt",
 * "tutu",
 * "tutv","tuut","tuuu","tuuv","tuvt","tuvu","tuvv","tvtt","tvtu","tvtv","tvut"
 * ,"tvuu"
 * ,"tvuv","tvvt","tvvu","tvvv","uttt","uttu","uttv","utut","utuu","utuv",
 * "utvt",
 * "utvu","utvv","uutt","uutu","uutv","uuut","uuuu","uuuv","uuvt","uuvu","uuvv"
 * ,"uvtt"
 * ,"uvtu","uvtv","uvut","uvuu","uvuv","uvvt","uvvu","uvvv","vttt","vttu",
 * "vttv",
 * "vtut","vtuu","vtuv","vtvt","vtvu","vtvv","vutt","vutu","vutv","vuut","vuuu"
 * ,"vuuv"
 * ,"vuvt","vuvu","vuvv","vvtt","vvtu","vvtv","vvut","vvuu","vvuv","vvvt",
 * "vvvu","vvvv"]
 * ["tttt","tttu","tttv","ttut","ttuu","ttuv","ttvt","ttvu","ttvv"
 * ,"tutt","tutu",
 * "tutv","tuut","tuuu","tuuv","tuvt","tuvu","tuvv","tvtt","tvtu",
 * "tvtv","tvut","tvuu"
 * ,"tvuv","tvvt","tvvu","tvvv","uttt","uttu","uttv","utut","utuu"
 * ,"utuv","utvt",
 * "utvu","utvv","uutt","uutu","uutv","uuut","uuuu","uuuv","uuvt",
 * "uuvu","uuvv","uvtt"
 * ,"uvtu","uvtv","uvut","uvuu","uvuv","uvvt","uvvu","uvvv","vttt"
 * ,"vttu","vttv",
 * "vtut","vtuu","vtuv","vtvt","vtvu","vtvv","vutt","vutu","vutv",
 * "vuut","vuuu","vuuv"
 * ,"vuvt","vuvu","vuvv","vvtt","vvtu","vvtv","vvut","vvuu","vvuv"
 * ,"vvvt","vvvu","vvvv"]
 */
