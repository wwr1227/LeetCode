public class Solution {
    public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (path == null || path.length() == 0)
			return "";

		ArrayList<String> folders = new ArrayList<String>();
		int i = 0;
		while (i < path.length()) {
			while (i < path.length() && path.charAt(i) == '/')
				i++;
			if (i == path.length())
				break;

			String folder = "";
			while (i < path.length() && path.charAt(i) != '/') {
				folder += path.charAt(i);
				i++;
			}

			if (folder.equals("..")) {
				if (!folders.isEmpty())
					folders.remove(folders.size() - 1);
			} else if (!folder.equals(".")) {
				folders.add(folder);
			}
		}
		if (folders.isEmpty())
			return "/";
		else {
			path = "";
			for (int index = 0; index < folders.size(); index++)
				path += "/" + folders.get(index);
		}
		return path;
	}
}
