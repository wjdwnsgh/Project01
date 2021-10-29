package project1.ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;





public class PhoneBookManager implements SubMenuItem {

	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	
	
	public PhoneBookManager() {
		set = new HashSet<PhoneInfo>();
		
		input();
		/*
		input 부분은 반드시 생성자에서 호출하기 그래야
		재생버튼 누르자마자 복원을 함
		 */
	}
	
	public void dataInput(int choice) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반,2.동창,3.회사");
		System.out.println("선택>>");
		int run = scan.nextInt();
		scan.nextLine();
		
		String pName, pPhoneNumber, pjun, pcom;
		int phak;
		
		switch(run) {
		case BAN:
			System.out.println("이름: "); 
			pName = scan.nextLine();
			System.out.println("전화번호: "); 
			pPhoneNumber = scan.nextLine();

			PhoneInfo pi = new PhoneInfo(pName, pPhoneNumber);
			boolean isAdd = set.add(pi);
			if(isAdd==true) {
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				String Yn = scan.next();
				scan.nextLine();
				if(Yn.equalsIgnoreCase("Y") || Yn.equalsIgnoreCase("y")) {
					set.remove(pi);
					set.add(new PhoneInfo(pName, pPhoneNumber));
					System.out.println("입력이 완료되었습니다.");
				}
				else if(Yn.equalsIgnoreCase("N") || Yn.equalsIgnoreCase("n")) {
					System.out.println("입력이 완료되었습니다.");
				}
			}
			
			break;
		case Hak:
			System.out.println("이름: "); 
			pName = scan.nextLine();
			System.out.println("전화번호: "); 
			pPhoneNumber = scan.nextLine();
			System.out.println("전공: ");
			pjun = scan.nextLine();
			System.out.println("학년: ");
			phak = scan.nextInt();
			
			PhoneInfo pi2 = new PhoneSchoolInfo(pName, pPhoneNumber, pjun, phak);
			boolean isAdd2 = set.add(pi2);
			if(isAdd2==true) {
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				String Yn = scan.next();
				scan.nextLine();
				if(Yn.equalsIgnoreCase("Y") || Yn.equalsIgnoreCase("y")) {
					set.remove(pi2);
					set.add(new PhoneSchoolInfo(pName, pPhoneNumber, pjun, phak));
					System.out.println("입력이 완료되었습니다.");
				}
				else if(Yn.equalsIgnoreCase("N") || Yn.equalsIgnoreCase("n")) {
					System.out.println("입력이 완료되었습니다.");
				}
			}
			
			break;
		case SA:
			System.out.println("이름: "); 
			pName = scan.nextLine();
			System.out.println("전화번호: "); 
			pPhoneNumber = scan.nextLine();
			System.out.println("회사: ");
			pcom = scan.nextLine();
			
			PhoneInfo pi3 = new PhoneCompanyInfo(pName, pPhoneNumber, pcom);
			boolean isAdd3 = set.add(pi3);
			if(isAdd3==true) {
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				String Yn = scan.next();
				scan.nextLine();
				if(Yn.equalsIgnoreCase("Y") || Yn.equalsIgnoreCase("y")) {
					set.remove(pi3);
					set.add(new PhoneCompanyInfo(pName, pPhoneNumber, pcom));
					System.out.println("입력이 완료되었습니다.");
				}
				else if(Yn.equalsIgnoreCase("N") || Yn.equalsIgnoreCase("n")) {
					System.out.println("입력이 완료되었습니다.");
				}
			}
			
			break;
		}
		
	}
	
	public void dataSearch() {
		
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("이름: ");
		Scanner scan = new Scanner(System.in);
		String Search = scan.nextLine();
		
		boolean a = false;
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			
			if(Search.equals(pi.name)) {
				pi.showPhoneInfio();
				System.out.println("데이터를 찾았습니다.");
				
				a = true;
			}
		}
		if(a == false) {
			System.out.println("데이터를 찾을 수가 없습니다.");
		}
		
	}
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		Scanner scan = new Scanner(System.in);
		System.out.println("이름: ");
		String Delete = scan.nextLine();
		
		int index = -1;
		
		Iterator<PhoneInfo> itr = set.iterator();
		while(itr.hasNext()) {
			
			PhoneInfo pi = itr.next();
			if(Delete.equals(pi.name)) {
				set.remove(pi);
				index = 1;
				break;
			}
		}
		if(index==-1) {
			System.out.println("데이터가 없어 삭제할 수 가 없습니다.");
		}
		else {
			System.out.println("데이터를 삭제했습니다.");
		}
	}
	
	public void dataAllShow() {
		for(PhoneInfo pi : set) {
			pi.showPhoneInfio();
		}
	}
	
	public void output() {
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(
							new FileOutputStream("src/project1/ver08/PhoneBook.obj"));
			
			for(PhoneInfo pi : set) {
				out.writeObject(pi);
			}
			out.close();
		}
		catch(Exception e) {
			
		}
		
	}
	
	public void input() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
							new FileInputStream("src/project1/ver08/PhoneBook.obj"));
			
			while(true) {
				PhoneInfo pi = (PhoneInfo)in.readObject();
				set.add(pi);
				if(pi==null) break;
			}
			in.close();
		}
		catch(Exception e) {
			System.out.println("복원완료");
		}
		
	}
	
	
	
	public void thread(AutoSaverT save) {
		System.out.println("저장옵션 선택!");
		System.out.println("자동저장on(1) 자동저장off(2)");
		System.out.println("선택");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if(num==1) {
			if(save.isAlive()) {
				System.out.println("이미 자동저장 중입니다..");
			}
			else {
				save.setDaemon(true);
				save.start();
				System.out.println("자동저장 시작....");
			}
		}
		else if(num==2) {
			if(save.isAlive()) {
				System.out.println("자동저장이 종료되었습니다.");
				save.interrupt();
				
			}
		}
	}
	
	public void FileTxt() {
		try {
			PrintWriter pw = 
					new PrintWriter(
							new FileWriter("src/project1/Ver08/AutoSaveBook.txt"));
			
			for(PhoneInfo pi : set) {
				pw.println(pi);
			}
			pw.close();
			System.out.println("저장중");
		}
		catch(IOException e) {
			System.out.println("에러");
		}
	}
	
	public void printMenu() {
		System.out.println("=====숫자를 입력해주세요.=====");
		System.out.print("1.데이터 입력 ");
		System.out.println("2.데이터 검색");
		System.out.print("3.데이터 삭제 ");
		System.out.println("4.주소록 출력");
		System.out.print("5.저장옵션 ");
		System.out.println("6.프로그램 종료");
		System.out.println("==============================");
		System.out.println("입력 : ");
	}
}
