//用户信息界面用于连接数据库
package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class User {
	    private String userNum;//用户号
	    private String userName;//姓名
	    private String userSex;//性别
	    private String userTel;//电话号码
	    private String userAddress;//地址
	 
	    public User() {
	    }
	 
	    public User(String userNum, String userName, String userSex,
	                   String userTel,String userAddress) {
	        super();
	        this.userNum = userNum;
	        this.userName = userName;
	        this.userSex = userSex;
	        this.userTel = userTel;
	        this.userAddress=userAddress;
	    }
	 
	    public String getStuNum() {
	        return userNum;
	    }
	 
	    public void setStuNum(String userNum) {
	        this.userNum = userNum;
	    }
	 
	    public String getStuName() {
	        return userName;
	    }
	 
	    public void setStuName(String userName) {
	        this.userName = userName;
	    }
	 
	    public String getStuClass() {
	        return userSex;
	    }
	 
	    public void setStuClass(String userSex) {
	        this.userSex = userSex;
	    }
	 
	    public String getStuProfessional() {
	        return userTel;
	    }
	 
	    public void setStuProfessional(String userTel) {
	        this.userTel = userTel;
	    }
	    
	    public String getStuAddress() {
	        return userAddress;
	    }
	 
	    public void setStuAddress(String userAddress) {
	        this.userAddress = userAddress;
	    }
	    //连接数据库
	    public Connection connectToMySql() {
	        try {
	        	// 驱动程序名
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            // URL指向要访问的数据库名"学生-课程数据库"
	         	String url = "jdbc:mysql://localhost:3306/华为手机";
                // MySQL配置时的用户名
	         	String user = "zxp"; 
	         	// MySQL配置时的密码
	         	String password = "123456";
	            Connection connection = DriverManager.getConnection(url, user, password);
	            return connection;
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("数据库连接出错");
	        }
	        return null;
	    }
	 
        //显示用户信息
	    public User queryStuInfo1(String sNum) {
	        User stu = new User();
	        String querySql = "select * from 用户  where 用户号="+"'"+sNum+"'";/**sNum为当前登陆的用户id号 
	                                                              *
	                                                              *
	                                                              *
	                                                              **/
	        Connection conn  = connectToMySql();
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(querySql);
	            while(rs.next()) {
	                stu.userNum = rs.getString("用户号");
	                System.out.print(rs.getString("用户号"));
	                stu.userName = rs.getString("姓名");
	                stu.userSex = rs.getString("性别");
	                stu.userTel = rs.getString("电话号码");
	                stu.userAddress=rs.getString("地址");
	            }
	            return stu;
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	            return null;	 
	        }
	    }	
	    
	    
	 
}
	 
