package project1.ver09;

import java.util.Scanner;

import project1.ver09.OracleConnect;

public class PhoneBookManager extends OracleConnect{

	//멤버변수
	private PhoneInfo[] myPi; //객체배열
	private int numOfPi; // 저장할 변수
	
	
	//생성자
	public PhoneBookManager(int num) {
		super("kosmo", "1234");
		myPi = new PhoneInfo[num];
		numOfPi = 0;
	}
	
	public void dataInput() {
		
		try {
			String query = "INSERT INTO phonebook_tb VALUES (seq_phonebook.nextval, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			
			Scanner scan = new Scanner(System.in);
			
			String pName, pPhoneNumber, pBirthday;
				
			System.out.println("이름: "); 
			pName = scan.nextLine();
			System.out.println("전화번호: "); 
			pPhoneNumber = scan.nextLine();
			System.out.println("생년월일: "); 
			pBirthday = scan.nextLine();
			
			psmt.setString(1, pName);
			psmt.setString(2, pPhoneNumber);
			psmt.setString(3, pBirthday);
			
			int num = psmt.executeUpdate();
			
			System.out.println(num+"행 입력");
		}
		catch(Exception e) {
			System.out.println("에러발생");
		}
		
	}
	
	public void dataSearch() {
		
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("이름: ");
		try {
			
			String query = "SELECT * FROM phonebook_tb "
					+ " WHERE phon_name LIKE '%'||?||'%' ";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, scanValue("찾는이름"));
			rs = psmt.executeQuery();
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("phon_name");
				String phoneNumber = rs.getString("phon_number");
				String birthday = rs.getString("phon_birth").substring(0, 10);
				
				System.out.printf("%s %s %s\n", name, phoneNumber, birthday);
			}
			System.out.println("검색 완료!");
			
		}
		catch(Exception e) {
			System.out.println("에러발생");
		}
		
	}
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		
		try {
			
			String query = "DELETE FROM phonebook_tb WHERE phon_name=?";
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, scanValue("삭제할이름"));
			int delete = psmt.executeUpdate();
			System.out.println(delete+"행 삭제 완료");
			
		}
		catch(Exception e) {
			System.out.println("에러발생");
		}
	}
	
	public void dataAllShow() {
		try {
			String query = "SELECT * FROM phonebook_tb";
			psmt = con.prepareStatement(query);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("phon_name");
				String phoneNumber = rs.getString("phon_number");
				String birthday = rs.getString("phon_birth").substring(0, 10);
				
				System.out.printf("%s %s %s\n", name, phoneNumber, birthday);
			}
			System.out.println("출력 완료!");
			
		}
		catch(Exception e) {
			System.out.println("에러발생");
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
