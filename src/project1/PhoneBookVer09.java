package project1;

import java.util.Scanner;

import project1.ver09.PhoneBookManager;
import project1.ver09.PhoneInfo;


public class PhoneBookVer09 {

	public static void main(String[] args) {

		PhoneBookManager pb1 = new PhoneBookManager(100);
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			pb1.printMenu();
			
			int choice = scan.nextInt();			
			switch(choice) {
			case 1:
				pb1.dataInput(choice);
				break;
			case 2:
				pb1.dataSearch();
				break;
			case 3:
				pb1.dataDelete();
				break;
			case 4:
				pb1.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			System.out.println();
		}

	}

}
