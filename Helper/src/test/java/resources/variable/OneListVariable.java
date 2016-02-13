package resources.variable;

import java.util.ArrayList;
import java.util.List;

public class OneListVariable {
	private List<String> stringList = new ArrayList<String>();
	
	public OneListVariable(){
		stringList.add("abc");
		stringList.add("def");
		stringList.add("ghi");
	}
}
