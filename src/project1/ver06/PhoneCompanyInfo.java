package project1.ver06;

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
	}
	
	
}
