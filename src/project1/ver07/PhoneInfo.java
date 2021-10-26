package project1.ver07;

public class PhoneInfo {

	String name; // 이름
	String phoneNumber; // 전화번호
	
	
	//2개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		
	}
	
	public void showPhoneInfio() {
		System.out.println("=========================");
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		
		System.out.println();
	}
	
	@Override
	public int hashCode() {
		int namehashCode = name.hashCode();
		return namehashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo phoneinfo = (PhoneInfo)obj;
		if(phoneinfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
