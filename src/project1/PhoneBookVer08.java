package project1;

import java.io.IOException;
import java.util.Scanner;

import project1.ver08.MenuItem;
import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;


public class PhoneBookVer08 implements MenuItem {
	

	public static void main(String[] args) {

		PhoneBookManager pb1 = new PhoneBookManager();
		
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
				pb1.output();
				return;
			}
			System.out.println();
			
		}
		

	}

}
