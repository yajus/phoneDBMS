//收藏夹用于连接数据库
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
 
import javax.swing.JOptionPane;
 
public class Collections {
	public static String sql_url = "jdbc:mysql://localhost:3306/华为手机";	//数据库路径（一般都是这样写），test是数据库名称
	public static String name = "zxp";		//用户名
	public static String password = "123456";	//密码
	public static Connection conn;
	public static PreparedStatement preparedStatement = null;
	
	// 得到数据库表数据
	public static Vector getRows(){
		Vector rows = null;
		Vector columnHeads = null;		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库 
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			Statement statement = null;
			statement = conn.createStatement();//prepareStatement("select * from 收藏 where 用户号="+login.username+"");
			ResultSet result1 = statement.executeQuery( "select * from 收藏 where 用户号=\""+login.username+"\"");
			System.out.println("成功选择");
//			if(result1.wasNull())
//				JOptionPane.showMessageDialog(null, "结果集中无记录");		
			
			rows = new Vector();			
			ResultSetMetaData rsmd = result1.getMetaData();					
			while(result1.next()){
				rows.addElement(getNextRow(result1,rsmd));
			}		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功加载驱动。");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			System.out.println(e);
			e.printStackTrace();
		}
		return rows;
	}

	
	
	

	// 得到数据库表头
	public static Vector getHead(){
		Vector columnHeads = null;		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");
			preparedStatement = conn.prepareStatement("select * from 收藏");
			ResultSet result1 = preparedStatement.executeQuery();			
			boolean moreRecords = result1.next();
			if(!moreRecords)
				JOptionPane.showMessageDialog(null, "收藏夹为空，可到商城主页将商品添加到收藏夹");			
			columnHeads = new Vector();
			ResultSetMetaData rsmd = result1.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++)
				columnHeads.addElement(rsmd.getColumnName(i));			
		} catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      System.out.println("未成功加载驱动。");
			  e.printStackTrace();
		} catch (SQLException e) {
			  // TODO Auto-generated catch block
			  System.out.println("未成功打开数据库。");
			  e.printStackTrace();
		}
		return columnHeads;
	}
	
	
	
	// 得到数据库中下一行数据
	private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{
		Vector currentRow = new Vector();
		for(int i = 1; i <= rsmd.getColumnCount(); i++){
			currentRow.addElement(rs.getString(i));
		}
		return currentRow;
	}
	
	
	
	
	//删除记录
    public boolean deleteStuInfo(String sNum){    	 
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//连接驱动
			conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
//			if(!conn.isClosed())
//				System.out.println("成功连接数据库");			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功加载驱动。");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功打开数据库。");
			e.printStackTrace();
		}
		 String deleteSQL = "delete from 收藏  where 手机名=" + sNum;
	        PreparedStatement ps = null;
	        try {
	            ps = conn.prepareStatement(deleteSQL);
	            ps.executeUpdate();
	            return true;	            
	        } catch (Exception e3) {
	            e3.printStackTrace();
	            System.out.println("数据库语句检查或执行出错");
	            return false;	            
	        } finally {
	            try {
	                ps.close();
	                conn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }   
    }
}

