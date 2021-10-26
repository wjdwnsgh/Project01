package project1;

import java.util.Scanner;

import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;
import project1.ver05.PhoneInfo;


public class PhoneBookVer05 implements MenuItem {

	public static void main(String[] args) {

		PhoneBookManager pb1 = new PhoneBookManager(100);
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			pb1.printMenu();
			
			int choice = scan.nextInt();			
			switch(choice) {
			case INSERT:
				pb1.dataInput(choice);
				break;
			case SELECT:
				pb1.dataSearch();
				break;
			case DELETE:
				pb1.dataDelete();
				break;
			case SHOW:
				pb1.dataAllShow();
				break;
			case EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			System.out.println();
		}

	}

}
