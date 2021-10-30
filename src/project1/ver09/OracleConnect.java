package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleConnect implements Connect{

	public Connection con;
	public PreparedStatement psmt; 
	public ResultSet rs;
	public Statement stmt;
	
	public OracleConnect() {
		
	}
	
	public OracleConnect(String user, String pass) {
		
		try {
			Class.forName(DRIVER);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public OracleConnect(String driver, String user, String pass) {
		
		try {
			Class.forName(driver);
			connect(user, pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(URI, user, pass);
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	
	public void execute() {
		
	}
	
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String scanValue(String title) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println(title+"을(를) 입력(exit->종료):");
		String inputStr = scan.nextLine();
		
		/*
		equalsIgnoreCase()
			: equals()와 동일하게 문자열이 같은지 비교하는 메소드로
			대소문자를 구분없이 비교할 수 있다.
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0);//프로그램 자제를 즉시 종료시킴.
		}
		return inputStr;
	}
	
	
}
