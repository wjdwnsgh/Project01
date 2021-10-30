package project1.ver09;

public interface Connect {

	String DRIVER = "oracle.jdbc.OracleDriver";
	String URI = "jdbc:oracle:thin:@localhost:1521:xe";
	
	void connect(String user, String pass);
	void execute(); 
	void close(); 
	
	
	String scanValue(String title);
}
