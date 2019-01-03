//用户信息界面
package test;

import java.sql.*;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.EmptyBorder;

public class Mydemo extends JFrame {

	private JPanel contentPane;
	private JLabel textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5; 

	public String userNum="'晃晃'";//userNum为当前登陆名
		         

	Collections collections=new Collections(); 
	User user = new User();

	
	//构造函数
	public Mydemo(String username) {
		userNum=username;
//		System.out.println(userNum);
		this.setVisible(true);
		this.setSize(722, 1213);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(new Color(255, 250, 240));		
		this.setBounds(100, 100,1280,720);
		//主面板
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//用户信息中心标签
		textField = new JLabel();
		textField.setBounds(533, 15, 181, 45);
		textField.setForeground(UIManager.getColor("CheckBox.foreground"));
		textField.setBackground(new Color(233, 150, 122));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("华文新魏", Font.PLAIN, 25));
		textField.setText("\u7528\u6237\u4FE1\u606F\u4E2D\u5FC3");
		contentPane.add(textField);
        //修改密码按钮
		JButton btnNewButton_1 = new JButton("修改用户信息");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 19));
		btnNewButton_1.setBounds(332, 379, 581, 58);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	        	System.out.println("进入修改信息界面");
//	        	setVisible(false);    
	        	login del=new login();
	        	del.updatedate();
	        }
	    });
		
		//进入收藏夹按钮
		JButton btnNewButton = new JButton("收藏夹");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 19));
		btnNewButton.setBounds(332, 432, 581, 58);
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setForeground(new Color(0, 0, 0));
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	        	System.out.println("进入收藏夹");
	        	setVisible(false);
	        	
	        	//contentPane.setVisible(false);
	        	new Collection(userNum);
	        }
	    });
		
		//查看个人订单按钮
		JButton button_1 = new JButton("订单");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 19));
		button_1.setBounds(332, 488, 581, 58);
		button_1.setHorizontalAlignment(SwingConstants.CENTER);
		button_1.setForeground(new Color(0, 0, 0));
		button_1.setBackground(new Color(230, 230, 250));
		contentPane.add(button_1);
		button_1.addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	        	System.out.println("进入订单页");
//	        	setVisible(false);  
	        	try {
	        	Statement stmt;
			    PreparedStatement pstmt;
			    ResultSet rs;
				Class.forName("com.mysql.cj.jdbc.Driver");
				String urlName = "jdbc:mysql://localhost:3306/华为手机";
				Connection con = DriverManager.getConnection(urlName,"zxp","123456");
				stmt = con.createStatement();
				部分订单 dd =new 部分订单(stmt,con);
				dd.setVisible(true);
	        	}
	        	catch(Exception epp)
	        	{
	        		System.out.println("进入页面失败");
	        	}
	        }
	    });
		
		//退出登陆按钮
		JButton button = new JButton("返回主页面");
		button.setBounds(543, 583, 165, 45);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setFont(new Font("宋体", Font.BOLD, 19));
		button.setBackground(new Color(230, 230, 250));
		contentPane.add(button);
		button.addMouseListener(new MouseAdapter(){
	        public void mouseClicked(MouseEvent e){
	        	System.out.println("已退出登陆");
	        	//contentPane.setVisible(false);
	        	//System.exit(0);//结束程序
	        	setVisible(false); ///结束程序？退出登录？
	        	main frame = new main();
				frame.setVisible(true);                   
	        }
	    });
		
		//用户详细信息
		JLabel label = new JLabel("用户名:");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(375, 95, 80, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(375, 148, 72, 21);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("性别:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(375, 200, 64, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("手机号码:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(375, 258, 100, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("地址:");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(375, 308, 72, 21);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("仿宋", Font.PLAIN, 19));
		textField_1.setText("");
		textField_1.setBounds(490, 89, 399, 32);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("仿宋", Font.PLAIN, 19));
		textField_2.setText("\u6C6A\u9896");
		textField_2.setBounds(490, 142, 399, 32);
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("仿宋", Font.PLAIN, 19));
		textField_3.setText("");
		textField_3.setBounds(490, 189, 399, 42);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("仿宋", Font.PLAIN, 19));
		textField_4.setText("");
		textField_4.setBounds(490, 246, 399, 38);
		textField_4.setEditable(false);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("仿宋", Font.PLAIN, 19));
		textField_5.setText("");
		textField_5.setBounds(490, 302, 399, 38);
		textField_5.setEditable(false);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		//显示用户信息		
		showID();		
	}


	
	
	
	//显示用户信息
	public void showID(){		
		final User userRet = user.queryStuInfo1(userNum);		
		textField_1.setText(userRet.getStuNum());
        textField_2.setText(userRet.getStuName());
        textField_3.setText(userRet.getStuClass());
        textField_4.setText(userRet.getStuProfessional());
        textField_5.setText(userRet.getStuAddress());
	}
}
	

	
//	//主函数
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					final Mydemo frame = new Mydemo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//}
