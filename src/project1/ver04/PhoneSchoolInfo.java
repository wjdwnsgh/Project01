package project1.ver04;

public class PhoneSchoolInfo extends PhoneInfo {

	String jun;
	int hak;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String jun, int hak) {
		super(name, phoneNumber);
		this.jun = jun;
		this.hak = hak;
	}
	
	@Override
	public void showPhoneInfio() {
		super.showPhoneInfio();
		System.out.println("전공: " + jun);
		System.out.println("학년: " + hak);
	}
	
	
}
