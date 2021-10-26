package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;


public class PhoneBookVer02 {
	
	public static void menu() {
		System.out.println("=====숫자를 입력해주세요.=====");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.println("선택 : ");
	}

	public static void main(String[] args) {

		PhoneInfo pi1 = new PhoneInfo("유비", "010-1111-1111", "1980-10-10");
		
		PhoneInfo pi2 = new PhoneInfo("손오공", "010-2222-2222");
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			menu();
			
			int choice = scan.nextInt();			
			switch(choice) {
			case 1:
				pi1.showPhoneInfio();
				break;
			case 2:
				System.out.print("프로그램을 종료합니다.");
				return;
			}
			System.out.println();
		}

	}

}
