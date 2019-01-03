//修改商品
package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 修改商品 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String CPU型号,手机名;
	int 售价,库存;
	ResultSet rs;
	PreparedStatement pstmt, pstmt1;
	boolean flag=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//修改商品 frame = new 修改商品();
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
	public 修改商品(Statement stmt,Connection con) {
		setTitle("\u4FEE\u6539\u5546\u54C1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u624B\u673A\u540D");
		label.setBounds(296, 119, 72, 18);
		contentPane.add(label);
		
		JLabel lblCpu = new JLabel("CPU\u578B\u53F7");
		lblCpu.setBounds(296, 174, 72, 18);
		contentPane.add(lblCpu);
		
		JLabel label_2 = new JLabel("\u4EF7\u683C");
		label_2.setBounds(296, 249, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E93\u5B58");
		label_3.setBounds(296, 315, 72, 18);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				手机名=textField.getText();
			}
		});
		textField.setBounds(411, 116, 160, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 CPU型号=textField_1.getText();
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(411, 183, 160, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str_2=textField_2.getText();
				 售价=Integer.parseInt(str_2);
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(411, 246, 160, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str_3=textField_3.getText();
				 库存=Integer.parseInt(str_3);
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(411, 312, 160, 25);
		contentPane.add(textField_3);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					pstmt = con.prepareStatement("SELECT * from 手机 where 手机名=?;");
					pstmt.setString(1,手机名);
					rs=pstmt.executeQuery();
					if(rs.next()){
						  flag=true;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if((手机名!=null)&&flag){
					try {
						pstmt1 = con.prepareStatement("update 手机 set CPU型号=?,售价=?,库存=? where 手机名=?;");
						
						pstmt1.setString(1,CPU型号);
						pstmt1.setInt(2, 售价);
						pstmt1.setInt(3, 库存);
						pstmt1.setString(4,手机名);						
						pstmt1.executeUpdate();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null ,"修改成功");	
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null ,"手机名不存在", "", JOptionPane.WARNING_MESSAGE);
					flag=false;
				}
					
			}
		});
		button.setBounds(380, 420, 113, 27);
		contentPane.add(button);
	}
		
	}


