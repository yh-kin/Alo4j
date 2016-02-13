package org.alo4j.helper.formatter;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectDetailFormatter {
	private static final String TYPE_FORMAT = "<%s>";
	private static final String INDEX_FORMAT = "[%d]";
	private static final String CHILD_DIRECTOR = "> ";
	
	public String format(String variableName, Object obj){
		StringBuilder sb = new StringBuilder(variableName);
		sb.append(formattedType(obj.getClass().getName()));
		
		if(this.isPrimitive(obj)){
			this.printPrimitive(obj, "", sb);
			return sb.toString();
		}
		
		this.format(obj, variableName, sb);
		return sb.toString();
	}
	
	private String formattedType(String type){
		return String.format(TYPE_FORMAT, type);
	}
	
	private void format(Object obj, String path, StringBuilder sb){
		if(this.isPrimitive(obj)){
			sb.append("\n")
				.append(CHILD_DIRECTOR);
			
			this.printPrimitive(obj, path, sb);
			return;
		}
		
		if(obj instanceof Iterable){
			printIterable((Iterable<?>)obj, path, sb);
			return;
		}
		
		if(obj instanceof Map){
			printMap((Map<?,?>)obj, path, sb);
			return;
		}
		
		printObject(obj, path, sb);
	}

	private void printPrimitive(Object obj, String path, StringBuilder sb) {
		sb.append(path).append(": ").append(obj.toString());
	}
	
	private void printIterable(Iterable<?> iterable, String path, StringBuilder sb) {
		int index = 0;
		for(Object item: iterable){
			this.format(item, path+formattedIndex(index), sb);
			index++;
		}
	}
	
	private String formattedIndex(int index){
		return String.format(INDEX_FORMAT, index);
	}
	
	private void printMap(Map<?,?> map, String path, StringBuilder sb) {
		int index = 0;
		for(Object key: map.keySet()){
			this.format(key, path+formattedIndex(index)+"-key", sb);
			this.format(map.get(key), path+formattedIndex(index)+"-value", sb);
			index++;
		}
	}
	
	private void printObject(Object obj, String path, StringBuilder sb) {
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field: fields){
			Object value = this.getValue(obj, field);
			
			if(isPrimitive(value)){
				sb.append("\n")
					.append(CHILD_DIRECTOR).append(path).append(".").append(field.getName())
					.append(formattedType(field.getType().getSimpleName())).append(": ")
					.append(value.toString());
				
			}else{
				this.format(value, path+"."+field.getName(), sb);
			}
		}
	}
	
	private Object getValue(Object obj, Field field){
		field.setAccessible(true);
		
		Object value = null;
		try {
			value = field.get(obj);
		} catch (Exception e) {
			value = "NOT ACCESSIBLE VARIABLE : " + field.getName();
			e.printStackTrace();
		}
		
		return value;
	}
	
	private boolean isPrimitive(Object target){
		return (target instanceof Byte) ||
				(target instanceof Short) ||
				(target instanceof Integer) ||
				(target instanceof Long) ||
				(target instanceof Float) ||
				(target instanceof Double) ||
				(target instanceof Character) ||
				(target instanceof Boolean) ||
				(target instanceof String);
	}
}