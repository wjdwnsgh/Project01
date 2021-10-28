package project1.ver09;

import java.util.Scanner;

public class PhoneBookManager {

	//멤버변수
	private PhoneInfo[] myPi; //객체배열
	private int numOfPi; // 저장할 변수
	
	//생성자
	public PhoneBookManager(int num) {
		myPi = new PhoneInfo[num];
		numOfPi = 0;
	}
	
	public void dataInput(int choice) {
		Scanner scan = new Scanner(System.in);
		
		String pName, pPhoneNumber, pBirthday;
		
		System.out.println("이름: "); 
		pName = scan.nextLine();
		System.out.println("전화번호: "); 
		pPhoneNumber = scan.nextLine();
		System.out.println("생년월일: "); 
		pBirthday = scan.nextLine();
		
		myPi[numOfPi++] = new PhoneInfo(pName, pPhoneNumber, pBirthday);
		
		System.out.println("데이터 입력이 완료되었습니다.");
		
	}
	
	public void dataSearch() {
		
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("이름: ");
		Scanner scan = new Scanner(System.in);
		String Search = scan.nextLine();
		
		boolean a = false;
		for(int i =0; i<numOfPi; i++) {
			
			if(Search.compareTo(myPi[i].name)==0) {
				myPi[i].showPhoneInfio();
				System.out.println("데이터 검색이 완료되었습니다.");
				
				a = true;
			}
			
		}
		if(a==false) {
			System.out.println("찾는 정보가 없습니다.");
		}
		
	}
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		Scanner scan = new Scanner(System.in);
		System.out.println("이름: ");
		String Delete = scan.nextLine();
		
		int index = -1;
		
		for(int i = 0; i<numOfPi; i++) {
			
			if(Delete.compareTo(myPi[i].name)==0) {
				myPi[i] = null;
				
				index = i;
				
				numOfPi--;
				break;
			}
		}
		
		if(index==-1) {
			System.out.println("정보가 없어 삭제할 수 없습니다.");
		}
		else {
			for(int i = index; i<numOfPi; i++) {
				myPi[i] = myPi[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}
	
	public void dataAllShow() {
		for(int i =0; i<numOfPi; i++) {
			myPi[i].showPhoneInfio();
		}
	}
	
	public void printMenu() {
		System.out.println("=====숫자를 입력해주세요.=====");
		System.out.print("1.데이터 입력 ");
		System.out.println("2.데이터 검색");
		System.out.print("3.데이터 삭제 ");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택 : ");
	}
}
