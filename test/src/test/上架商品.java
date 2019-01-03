//上架商品
package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 上架商品 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	ResultSet rs;
	PreparedStatement pstmt;
	String CPU型号,手机名;
	int 售价,库存;
	boolean flag=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//上架商品 frame = new 上架商品();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. 
	 */
	public 上架商品(Statement stmt,Connection con) {
		setTitle("\u4E0A\u67B6\u5546\u54C1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u540D\u79F0");
		label.setBounds(296, 119, 72, 18);
		contentPane.add(label);
		
		JLabel lblCpu = new JLabel("CPU\u578B\u53F7");
		lblCpu.setBounds(296, 174, 72, 18);
		contentPane.add(lblCpu);
		
		JLabel label_2 = new JLabel("\u552E\u4EF7");
		label_2.setBounds(296, 249, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E93\u5B58");
		label_3.setBounds(296, 315, 72, 18);
		contentPane.add(label_3);
		
		textField = new JTextField();//名称
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    手机名=textField.getText();
			    System.out.println(手机名);

			}
		});
		textField.setBounds(411, 116, 160, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//CPU型号
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        CPU型号=textField_1.getText();
		        //System.out.println(CPU型号);
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(411, 183, 160, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();//价格
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str_2=textField_2.getText();
				 售价=Integer.parseInt(str_2);
				 // System.out.println(售价);
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(411, 246, 160, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();//库存
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str_3=textField_3.getText();
				 库存=Integer.parseInt(str_3);
				 //System.out.println(库存);
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(411, 312, 160, 25);
		contentPane.add(textField_3);
		
		//
		   
	       
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					pstmt = con.prepareStatement("SELECT * from 手机 where 手机名=?");
					pstmt.setString(1,手机名);
					rs=pstmt.executeQuery();
					if(rs.next()){
						  flag=false;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			//
				if((手机名!=null)&&flag){
					try {
						//String insert="insert into 手机(手机名,CPU型号,售价,库存) values(?,?,?,);";
						pstmt = con.prepareStatement("insert into 手机(手机名,CPU型号,售价,库存) values(?,?,?,?);");
						pstmt.setString(1,手机名);
						pstmt.setString(2,CPU型号);
						pstmt.setInt(3, 售价);
						pstmt.setInt(4, 库存);
						pstmt.executeUpdate();


					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null ,"上架成功");
				    dispose();}
				else{
					JOptionPane.showMessageDialog(null ,"手机名不能为空或重复", "", JOptionPane.WARNING_MESSAGE);
					flag=true;
				}
				
			}
		});
		button.setBounds(380, 420, 113, 27);
		contentPane.add(button);
	}
}
