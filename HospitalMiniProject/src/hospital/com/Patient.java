package hospital.com;

public class Patient {
	// Patient class

	private String name;
	private int age;
	private String gender;
	private String contact;

	public Patient(String name, int age, String gender, String contact) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
