package resources.variable;

@SuppressWarnings("unused")
public class VariablePrivateVariable {
	private String name = "yonghyun";
	private int age = 31;
	private double height = 198.6;
	private Long salary = new Long(123L);
	private boolean isMale = true;
	private Boolean isSingle = new Boolean(false);

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Boolean getIsSingle() {
		return isSingle;
	}
	public void setIsSingle(Boolean isSingle) {
		this.isSingle = isSingle;
	}
}
