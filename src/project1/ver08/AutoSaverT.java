package project1.ver08;

public class AutoSaverT extends Thread {
	
	PhoneBookManager pb1;
	
	public AutoSaverT(PhoneBookManager pb1) {
		this.pb1 = pb1;
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				pb1.FileTxt();		
				sleep(5000);
			}
		}
		catch(Exception e) {
			System.out.println("자동 저장을 종료합니다");
		}
	}
	
}
