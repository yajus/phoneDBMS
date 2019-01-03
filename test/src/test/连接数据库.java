//连接数据库对商家界面进行测试
package test;

import java.sql.*;

public class 连接数据库 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			
			Statement stmt;
		    PreparedStatement pstmt;
		    ResultSet rs;
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				String urlName = "jdbc:mysql://localhost:3306/华为手机";
			Connection con = DriverManager.getConnection(urlName,"zxp","123456");
			//System.out.println("连接成功");
			
			
			stmt = con.createStatement();
			
			商家主界面 homepage = new 商家主界面(stmt,con);
			homepage.setVisible(true);
	

            //关闭连接

           // con.close();
	     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}

}
