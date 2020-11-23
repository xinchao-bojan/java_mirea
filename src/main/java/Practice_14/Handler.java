package Practice_14;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handler {

	private String[] simpleArray;
	private String line;

	public Handler(String[] simpleArray, String line) {
		this.simpleArray = simpleArray;
		this.line = line;
	}

	public void firstMethod() {
		String tmp = "";
		String line1 = line;
		String[] what = new String[simpleArray.length];
		String[] forWhat = new String[simpleArray.length];

		for (int i = 0; i < simpleArray.length; i++) {
			what[i] = simpleArray[i].split(" ")[0];
			forWhat[i] = simpleArray[i].split(" ")[1];
		}
		for (int j = 0; j < line.length(); j++) {
			tmp += line.charAt(j);
			for (int i = 0; i < what.length; i++) {
				if (what[i].indexOf(tmp) != -1
						&& line1.indexOf(what[i]) != -1) {
					line1 = line1.replaceAll(what[i], " "+forWhat[i]+" ");
				} else if (tmp.indexOf(what[i]) != -1) {
					line1 = line1.replaceAll(what[i], " "+ forWhat[i]+" ");
					tmp = "";
					break;
				}
			}
		}
		System.out.println("First method result | " + line1.replace(" ", ""));
	}

	public void secondMethod() {

		String str ="";
		for (int i = 0; i < simpleArray.length; i++) {
			str+=simpleArray[i].split(" ")[0];
			if (i != simpleArray.length - 1)
				str+="|";
		}
		HashMap<String, String> replaceMap = new HashMap<>();
		for (String t : simpleArray) {
			replaceMap.put(t.split(" ")[0], t.split(" ")[1]);
		}

		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(line);
		System.out.println("Second method result | " + matcher.replaceAll(mchr -> replaceMap.get(mchr.group())));

	}
}