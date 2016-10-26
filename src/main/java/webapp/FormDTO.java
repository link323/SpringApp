package webapp;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class FormDTO {
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Min(18)
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
