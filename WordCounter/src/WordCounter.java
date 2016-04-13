import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCounter {

	private HashMap<String, Integer> map = new HashMap<>();

	public HashMap<String, Integer> getMap() {
		return map;
	}

	public void countDistinctWords(String str) {
		
		StringTokenizer tokenizer;
		tokenizer = new StringTokenizer(str, " ");
		String word;

		while (tokenizer.hasMoreTokens()) {
			word = (tokenizer.nextToken()).toLowerCase();
			if (!map.containsKey(word)) {
				map.put(word, 1);
			} else {
				map.put(word, map.get(word) + 1);
			}
		}
	}

	public void printDistinctWords() {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = map.get(key);
			System.out.println(key + " : " + value);
		}
	}
}
