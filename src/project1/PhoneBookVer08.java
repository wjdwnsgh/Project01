package project1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;
import project1.ver08.AutoSaverT;

public class PhoneBookVer08 implements MenuItem{
	

	public static void main(String[] args) {

		PhoneBookManager pb1 = new PhoneBookManager();
		AutoSaverT as = new AutoSaverT(pb1);
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			pb1.printMenu();
					
			try {
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
				case IO:
					try {
						if(!as.isAlive()) {
							as = new AutoSaverT(pb1);
						}
					}
					catch(Exception e) {
						as = new AutoSaverT(pb1);
					}
					pb1.thread(as);
					break;
				case EXIT:
					System.out.println("프로그램을 종료합니다.");
					pb1.output();
					return;
				}
				System.out.println();
				
				pb1.choiceNum(choice);
			}
			catch(InputMismatchException e) {
				System.out.println("숫자를 입력하십시오.");
				scan.nextLine();
				System.out.println();
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
			
		}
		

	}

}
