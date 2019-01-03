//这是绑定登陆界面的数据库连接类
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.swing.JOptionPane;
 
public class Jdbcs {
Connection con = null;
Statement statement = null;
ResultSet res = null;
String driver = "com.mysql.cj.jdbc.Driver";
String url  = "jdbc:mysql://localhost:3306/华为手机";
String name = "zxp";
String passwd = "123456";
 
public Jdbcs(){
	try{
	Class.forName(driver).newInstance();
	con = DriverManager.getConnection(url,name,passwd);
	statement = con.createStatement();
	
	}catch(ClassNotFoundException e){
		System.out.println("对不起，找不到这个Driver");
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
		}
}
//对用户信息的修改实际上就是对密码的修改
public boolean update(String username1,String password1,String newpassword){
	boolean judge = false;
	boolean s =compare(username1,password1);
	if(s){
	String sql = "update 用户 set 密码=\""+newpassword+"\"where 用户号=\""+username1+"\"";
	try {
		int a = statement.executeUpdate(sql);
		if(a==1){
			JOptionPane.showMessageDialog(null,"密码修改成功！");
			judge = true;
		}
//		con.close();
//		statement.close();
	} catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "用户不存在！");
		e.printStackTrace();
	}
	}
	else{
		 JOptionPane.showMessageDialog(null, "修改失败");
	}
	return judge;
}

//修改用户信息
public boolean updatemessage(String username1,String name,String sex,String phone,String local){
	boolean judge = false;
//	System.out.println("测试位置"+username1);
	String sql1 = "update 用户 set 姓名=\""+name+"\"where 用户号=\""+username1+"\"";
	String sql2 = "update 用户 set 性别=\""+sex+"\"where 用户号=\""+username1+"\"";
	String sql3 = "update 用户 set 电话号码=\""+phone+"\"where 用户号=\""+username1+"\"";
	String sql4 = "update 用户 set 地址=\""+local+"\"where 用户号=\""+username1+"\"";
	try {
		int a = statement.executeUpdate(sql1);
		int b=statement.executeUpdate(sql2);
		int c=statement.executeUpdate(sql3);
		int d=statement.executeUpdate(sql4);
		if(a==1&&b==1&&c==1&&d==1){
			JOptionPane.showMessageDialog(null,"信息修改成功！");
			judge = true;
		}
//		con.close();
//		statement.close();
	} catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "用户不存在！");
		e.printStackTrace();
	}
	return judge;
}

//删除用户信息
public void delete(String username,String password){
	if(compare(username,password)){
		JOptionPane.showMessageDialog(null,"正在删除");
	}else{
		return;
	}
	String sql1="delete from 评论 where 用户号=\""+username+"\"";
	String sql2 = "delete from 用户 where 用户号=\""+username+"\"";
	try{
		statement.executeUpdate(sql1);
		statement.executeUpdate(sql2);
//		con.close();
//		statement.close();
		JOptionPane.showMessageDialog(null,"删除完成");
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null,"不存在该用户！");
		e.printStackTrace();
	}
	
}
//用户注册功能的实现，添加数据
public void insert(String username,String password){
	String sql = "insert into 用户(用户号,密码) values(\""+username+"\",\""+password+"\")";
	try{
		int a = statement.executeUpdate(sql);
//		con.close();
//		statement.close();
		if(a==1){
			JOptionPane.showMessageDialog(null,"注册成功！");
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "对不起该用户名已经有了！");
		e.printStackTrace();
	}
}

//对比用户名和密码是不匹配
public boolean compare(String username,String password){
	boolean m = false;
	String sql = "select 密码 from 用户 where 用户号=\""+username+"\"";
    try{
    	res = statement.executeQuery(sql);
    	if(res.next()){
    		String pa = res.getString(1);
    		System.out.println(pa+" " +password);
    		if(pa.equals(password)){
    			m = true;
    		}else {
    			JOptionPane.showMessageDialog(null, "密码错误！");
        	}
    	}else {
    		JOptionPane.showMessageDialog(null, "用户名不存在！");
    	}
//    	res.close();
//    	con.close();
//		statement.close();
    	
    }catch(SQLException e){
    	e.printStackTrace();
    }
    return m;
}
 
}
