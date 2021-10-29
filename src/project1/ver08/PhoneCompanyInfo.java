package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo	{

	String com;

	public PhoneCompanyInfo(String name, String phoneNumber, String com) {
		super(name, phoneNumber);
		this.com = com;
	}
	
	@Override
	public void showPhoneInfio() {
		super.showPhoneInfio();
		System.out.println("회사: " + com);
		System.out.println();
	}

	@Override
	public String toString() {
		return "이름: "+name+" 전화번호: "+phoneNumber+" 회사: "+com;
	}
	
	
	
}
