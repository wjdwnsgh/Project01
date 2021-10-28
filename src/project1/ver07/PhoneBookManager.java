package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager implements SubMenuItem{

	HashSet<PhoneInfo> set;
	
	
	public PhoneBookManager() {
		set = new HashSet<PhoneInfo>();
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
			
//			boolean isFind = false;
//			for(PhoneInfo pi : set) {
//				if(pi.name.equals(pName)) {
//					isFind = true;
//				}
//			
//				if(isFind = true) {
//					System.out.println("이미 저장된 데이터입니다.");
//					System.out.println("덮어쓸까요? Y(y)/N(n)");
//					String Yn = scan.next();
//					scan.nextLine();
//					if(Yn.equals("y") || Yn.equals("Y")) {
//						set.remove(pi);
//					}
//					else if(Yn.equals("n") || Yn.equals("N")) {
//						set.add(new PhoneInfo(pName, pPhoneNumber));
//					}
//				}
//			}
			
			
			/*
			boolean 타입으로 set.add(){추가하려는 객체}를 만들어서 추가하고, equals()에서 나온 false, true를 이용해
			if문으로 만들어 true,false에 따른 결과를 출력한다.
			(삭제할 때 기존에 있던 객체를 변수로 선언해서 처리해야한다..)
			 */
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
			
			
//			for(PhoneInfo pi : set) {
//				if(pi.name.equals(pName)) {
//					isFind = true;
//				}
//			
//				if(isFind = true) {
//					System.out.println("이미 저장된 데이터입니다.");
//					System.out.println("덮어쓸까요? Y(y)/N(n)");
//					String Yn = scan.next();
//					scan.nextLine();
//					if(Yn.equals("y") || Yn.equals("Y")) {
//						set.remove(pi);
//					}
//					else if(Yn.equals("n") || Yn.equals("N")) {
//						set.add(new PhoneInfo(pName, pPhoneNumber));
//					}
//				}
//			}
			
			PhoneInfo pi2 = new PhoneInfo(pName, pPhoneNumber);
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
			
			
//			for(PhoneInfo pi : set) {
//				if(pi.name.equals(pName)) {
//					isFind = true;
//				}
//			
//				if(isFind = true) {
//					System.out.println("이미 저장된 데이터입니다.");
//					System.out.println("덮어쓸까요? Y(y)/N(n)");
//					String Yn = scan.next();
//					scan.nextLine();
//					if(Yn.equals("y") || Yn.equals("Y")) {
//						set.remove(pi);
//					}
//					else if(Yn.equals("n") || Yn.equals("N")) {
//						set.add(new PhoneInfo(pName, pPhoneNumber));
//					}
//				}
//			}
			
			PhoneInfo pi3 = new PhoneInfo(pName, pPhoneNumber);
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
		
		
		System.out.println("데이터 입력이 완료되었습니다.");
		
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
	
	public void printMenu() {
		System.out.println("=====숫자를 입력해주세요.=====");
		System.out.print("1.데이터 입력 ");
		System.out.println("2.데이터 검색");
		System.out.print("3.데이터 삭제 ");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.println("선택 : ");
		System.out.println("===============================");
		System.out.println();
	}
}
