//商品详情界面的数据库连接
package test;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
 
public class jdbccon {
private static final String[][] attribute = null;
Connection con = null;
Statement statement = null;
ResultSet res = null;
String driver = "com.mysql.cj.jdbc.Driver"; //加载JDBC驱动
String url = "jdbc:mysql://localhost:3306/华为手机"; 
String name = "zxp"; //数据库用户名
String passwd = "123456"; //安装sql server 2005时的密码


public jdbccon(){
	try{
	Class.forName(driver);
	con = DriverManager.getConnection(url,name,passwd);
	statement = con.createStatement();
	
	}catch(ClassNotFoundException e){
		System.out.println(e);
		System.out.println("对不起，找不到这个Driver");
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
		}
}

//select*
public void selectobject(String objectname,String[][] attribute)
{
	boolean judge=false;
	try {
	String sql="select * from 手机 where 手机名=\""+objectname+"\"";
	ResultSet rs=statement.executeQuery(sql);
	int count = rs.getMetaData().getColumnCount();
	ResultSetMetaData rsmd = rs.getMetaData();

	while (rs.next()) { 
		for(int i=1;i<=count;i++)
		{ 
			attribute[0][i]=rsmd.getColumnName(i);
//			System.out.print(rsmd.getColumnName(i)+":");
			attribute[1][i]=rs.getString(i);
//			System.out.println(rs.getString(i) + " " ); 
		}
	} 

	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	//return attribute;
}

public int  selectcommit(String objectname,String[][] attribute)
{
	int i=1;
	boolean judge=false;
	try {
	String sql="select * from 评论 where 手机名=\""+objectname+"\"";
	ResultSet rs=statement.executeQuery(sql);
	int count = rs.getMetaData().getColumnCount();
	ResultSetMetaData rsmd = rs.getMetaData();
	while (rs.next()) { 
//		for(int i=1;i<=count;i++)
//		{ 
			attribute[0][i]=rs.getString(2);
//			System.out.print(rsmd.getColumnName(i)+":");
			attribute[1][i]=rs.getString(4);
			System.out.println(rs.getString(3) + "this is 3 " ); 
			attribute[2][i]=rs.getString(5);
			i++;
//		}
	} 

	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	//return attribute;
	return i;
}

public void insertcollection(String username,String phonename){
	String sql = "insert into 收藏(用户号,手机名) values(\""+username+"\",\""+phonename+"\")";
	try{
		int a = statement.executeUpdate(sql);
//		con.close();
//		statement.close();
		if(a==1){
			JOptionPane.showMessageDialog(null,"收藏成功");
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "收藏失败");
		e.printStackTrace();
	}
}

public void insertbuy(String username,String phonename){
	int one=1;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	String xizenumber=df.format(new Date());
//	System.out.println(xizenumber);
	String sql = "insert into 订单细则(订单细则号,购买者,手机名,"
			+ "购买数量) values(\""+xizenumber+"\",\""+username+"\",\""+phonename+"\",\""+one+"\")";
//	String sql2="insert into 订单(订单号,用户号,订单细则数,订单创建日期,订单状态,支付方式,支付时间,成交日期)";
//			row.add(订单号);
//	row.add(用户号);
//	row.add(str1);
//	row.add(订单创建日期);
//	row.add(订单状态);
//	row.add(支付方式);
//	row.add(支付时间);
//	row.add(成交日期);
	try{
		int a = statement.executeUpdate(sql);
//		con.close();
//		statement.close();
		if(a==1){
			JOptionPane.showMessageDialog(null,"购买成功");
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "购买失败");
		e.printStackTrace();
	}
}



//select 手机名
public int selectpartobject(String[][] attribute)
{   int j=1;
	boolean judge=false;
	try {
	String sql="select 手机名 from 手机";
	ResultSet rs=statement.executeQuery(sql);
	ResultSetMetaData rsmd = rs.getMetaData();
	
	while (rs.next()) { 

			attribute[j][0]=rs.getString(1);
			j++;
	} 

	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return j;
}
}