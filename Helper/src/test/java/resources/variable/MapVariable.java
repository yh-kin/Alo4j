package resources.variable;

import java.util.HashMap;
import java.util.Map;

public class MapVariable {
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public MapVariable() {
		map.put("abc", 1);
		map.put("def", 2);
		map.put("ghi", 3);
	}
}
