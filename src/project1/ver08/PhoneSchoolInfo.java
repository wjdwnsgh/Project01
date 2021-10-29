package project1.ver08;

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
		System.out.println();
	}

	@Override
	public String toString() {
		
		return "이름:"+ name + " 전화번호:" + phoneNumber + " 전공:" + jun + " 학년:"+ hak;
	}
	
	
	
	
}
