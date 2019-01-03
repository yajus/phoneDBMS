//将订单删除
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

public class 删除订单 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ResultSet rs;
	PreparedStatement pstmt;
	String 订单号,用户号,订单创建日期,订单状态 ;
	int 订单细则数;
	boolean flag=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//删除订单 frame = new 删除订单();
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
	public 删除订单(Statement stmt,Connection con) {
		setTitle("\u5220\u9664\u8BA2\u5355");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BA2\u5355\u53F7");
		label.setBounds(361, 267, 72, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				订单号=textField.getText();
			}
		});
		textField.setBounds(503, 264, 160, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u5220\u9664");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					pstmt = con.prepareStatement("SELECT * from 订单细则 where 订单细则号=?;");
					pstmt.setString(1,订单号);
					rs=pstmt.executeQuery();
					if(rs.next()){
						  flag=true;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if((订单号!=null)&&flag){
					try {
						pstmt = con.prepareStatement("delete from 订单细则  where 订单细则号=?;");						
						
						pstmt.setString(1,订单号);
						pstmt.executeUpdate();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null ,"删除成功");	
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null ,"订单号不存在", "", JOptionPane.WARNING_MESSAGE);
					flag=false;
				}
			}
		});
		button.setBounds(461, 369, 113, 27);
		contentPane.add(button);
	}
	}


