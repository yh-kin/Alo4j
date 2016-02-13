package org.alo4j.helper.formatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.alo4j.helper.formatter.ObjectDetailFormatter;
import org.junit.Test;

import resources.variable.IterableVariable;
import resources.variable.MapVariable;
import resources.variable.OneListVariable;
import resources.variable.OnePrivateStringVariable;
import resources.variable.VariablePrivateVariable;

public class ObjectDetailFormatterTest {

	ObjectDetailFormatter formatter = new ObjectDetailFormatter();
	
	@Test
	public void integer_primitive_type() throws Exception {
		String result = formatter.format("age", 31).toString();
		
		String expected = "age<java.lang.Integer>: 31";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void integer_primitive_wrapper_type() throws Exception {
		String result = formatter.format("age", new Integer("31")).toString();
		
		String expected = "age<java.lang.Integer>: 31";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void String_primitive_type() throws Exception {
		String result = formatter.format("name", "Yonghyun").toString();
		
		String expected = "name<java.lang.String>: Yonghyun";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void printVariable_one_primitive_variable() throws Exception {
		OnePrivateStringVariable target = new OnePrivateStringVariable();
		
		String result = formatter.format("target", target).toString();
		
		String expected = 
				"target<resources.variable.OnePrivateStringVariable>"+"\n"+
				"> target.string<String>: string";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void printVariable_various_type_object() throws Exception {
		VariablePrivateVariable target = new VariablePrivateVariable();
		
		String result = formatter.format("target", target).toString();
		
		String expected = 
				"target<resources.variable.VariablePrivateVariable>\n" + 
				"> target.name<String>: yonghyun\n" + 
				"> target.age<int>: 31\n" + 
				"> target.height<double>: 198.6\n" + 
				"> target.salary<Long>: 123\n" + 
				"> target.isMale<boolean>: true\n" + 
				"> target.isSingle<Boolean>: false";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void printVariable_one_collection_type() throws Exception {
		OneListVariable target = new OneListVariable();
		
		String result = formatter.format("target", target).toString();
		
		String expected = 
				"target<resources.variable.OneListVariable>\n" + 
				"> target.stringList[0]: abc\n" + 
				"> target.stringList[1]: def\n" + 
				"> target.stringList[2]: ghi";
		
		assertThat(result, is(expected));
	}
	
	@Test
	public void printVariable_multiple_Iterable_type() throws Exception {
		IterableVariable target = new IterableVariable();
		
		String result = formatter.format("target", target).toString();
		
		String expected = 
				"target<resources.variable.IterableVariable>\n" + 
				"> target.stringList[0]: abc\n" + 
				"> target.stringList[1]: def\n" + 
				"> target.stringList[2]: ghi\n" + 
				"> target.intCollection[0]: 1\n" + 
				"> target.intCollection[1]: 2\n" + 
				"> target.intCollection[2]: 3\n" + 
				"> target.doubleIterable[0]: 1.2\n" + 
				"> target.doubleIterable[1]: 3.4\n" + 
				"> target.doubleIterable[2]: 5.6";
		System.out.println(result);
		assertThat(result, is(expected));
	}
	
	@Test
	public void printVariable_map_type() throws Exception {
		MapVariable target = new MapVariable();
		
		String result = formatter.format("target", target).toString();
		
		String expected = 
				"target<resources.variable.MapVariable>\n" + 
				"> target.map[0]-key: abc\n" + 
				"> target.map[0]-value: 1\n" + 
				"> target.map[1]-key: def\n" + 
				"> target.map[1]-value: 2\n" + 
				"> target.map[2]-key: ghi\n" + 
				"> target.map[2]-value: 3";
		
		assertThat(result, is(expected));
	}

}
