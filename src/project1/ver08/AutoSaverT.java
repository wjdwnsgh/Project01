package project1.ver08;

public class AutoSaverT extends Thread {
	
	PhoneBookManager pbm;
	
	public AutoSaverT(PhoneBookManager pbm) {
		this.pbm = pbm;
	}
	
	@Override
	public void run() {
		try {
			pbm.FileTxt();
			sleep(5000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
