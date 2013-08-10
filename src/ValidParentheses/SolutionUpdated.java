import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

  public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Map<Character, Integer> validMap = new HashMap<Character, Integer>();
		validMap.put('(', 1);
		validMap.put('[', 2);
		validMap.put('{', 3);
		validMap.put(')', 4);
		validMap.put(']', 5);
		validMap.put('}', 6);

		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty() || validMap.get(s.charAt(i)) <= 3) {
				stack.push(s.charAt(i));
			} else if (!stack.isEmpty()) {
				char top = stack.peek();
				if (validMap.get(top) % 3 != validMap.get(s.charAt(i)) % 3
						|| validMap.get(top) == validMap.get(s.charAt(i)))
					return false;
				else
					stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
