package pingce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GetConn {
	Connection conn;
	static PreparedStatement sql;/////////Ҫ���
	public Connection getConnectin() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("���ݿ��������سɹ�");
			conn = DriverManager.getConnection("jdbc:sqlserver://6404st0139:1433;DatabaseName = hcl","sa","123456");
			//conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName = hcl","sa","123456");
			//conn = DriverManager.getConnection("jdbc:sqlserver://mysql:1433;DatabaseName = hcl","sa","123456");
			if (conn != null) {
				System.out.println("���ݿ����ӳɹ�");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		GetConn ge = new GetConn();
		ge.getConnectin();
	}
	
}
