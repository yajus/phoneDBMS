//这是主界面
package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					main frame = new main();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//按钮用户信息中心
		JButton button = new JButton("用户信息中心");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("进入用户信息中心");
				try {
					System.out.println(login.username);
					final Mydemo frame = new Mydemo(login.username);
					setVisible(false);
					frame.setVisible(true);
				} catch (Exception epp) {
					epp.printStackTrace();
				}
//				shangpingxiangqing test=new shangpingxiangqing("");
//				setVisible(false);
//				test.setVisible(true);
			}
		});
		button.setBounds(943, 49, 117, 29);
		contentPane.setLayout(null);
		contentPane.add(button);
		
		
		//按钮订单管理
		JButton button_1 = new JButton("商家界面");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(login.username.equals("root"))
				{
					try{
					Statement stmt;
				    PreparedStatement pstmt;
				    ResultSet rs;
					Class.forName("com.mysql.cj.jdbc.Driver");
					String urlName = "jdbc:mysql://localhost:3306/华为手机";
					Connection con = DriverManager.getConnection(urlName,"zxp","123456");
					stmt = con.createStatement();
					商家主界面 homepage = new 商家主界面(stmt,con);
					homepage.setVisible(true);
					}
					catch(Exception epp)
					{
						System.out.println("无法进入商家页面");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null ,"非商家无法进入管理页面");
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(943, 90, 117, 29);
		contentPane.add(button_1);
		
		//查询文本框
		textField = new JTextField();
		textField.setBounds(300, 48, 371, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//查询按钮
		JButton button_2 = new JButton("search");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String phonename=textField.getText();
				if(phonename!=null)
				{
				shangpingxiangqing test=new shangpingxiangqing(phonename);
				setVisible(false);
				test.setVisible(true);
				}
				else
				{
					
				}
			}
		});
		button_2.setBounds(421, 90, 117, 29);
		contentPane.add(button_2);
		
		
		//list布局
		JList list = new JList();
		list.setFont(new java.awt.Font("宋体",java.awt.Font.PLAIN,25));
		list.setBounds(124, 128, 1030, 482);
		contentPane.add(list);
		DefaultListModel dlm=new DefaultListModel();
		jdbccon jdbc1=new jdbccon();
		 String[][] attribute=new String[30][2];
		 int j=jdbc1.selectpartobject(attribute);
		 for(int i=1;i<j;i++)
		 {
			 dlm.addElement("手机款式:"+attribute[i][0]);
		 }
	     list.setModel(dlm);
		
	     
	     //list事件
	     list.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent evt) {
	             JList list = (JList)evt.getSource();
	             if (evt.getClickCount() == 2) {          // Double-click
	                 // Get item index
	                 int index = list.locationToIndex(evt.getPoint());
	                 
	                 String phonename= (String)list.getSelectedValue();
	                 phonename=phonename.substring(5, phonename.length());
//	                 System.out.println( phonename);
	                shangpingxiangqing test=new shangpingxiangqing(phonename);
	 				setVisible(false);
	 				test.setVisible(true);
	             } 
	         }
	     });
   
	}
	
}
