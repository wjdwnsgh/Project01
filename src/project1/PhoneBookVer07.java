package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.MenuItem;
import project1.ver07.PhoneBookManager;
import project1.ver07.PhoneInfo;
import project1.ver07.MenuSelectException;


public class PhoneBookVer07 implements MenuItem {

	public static void main(String[] args) {

		PhoneBookManager pb1 = new PhoneBookManager(100);
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			try {
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
					
				if(choice<1 || choice>5) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
				System.out.println("1~5사이 번호만 입력해주세요");
				System.out.println();
			}
			catch(InputMismatchException e) {
				System.out.println("1~5사이 숫자만 입력해주세요");
				System.out.println();
				scan.nextLine();
			}
			catch(NullPointerException e) {
				
			}
		}
		

	}

}
