package test;
import java.sql.*;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class 评论 extends JFrame {
	JRadioButton radioButton,radioButton_1,radioButton_2;
	private JPanel contentPane;
    String 评论内容;
    String 用户号 = login.username;
    String 评论号;
    JTextArea textArea = new JTextArea();	
	/**
	 * Launch the application.
	 */
    PreparedStatement pstmt ;
	ResultSet rs ;
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					//评论 frame = new 评论();
//					//frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public 评论(Connection dbConn , Statement stmt,String 订单细则号,String 手机名 ) {
		评论号 = 订单细则号+用户号;
//		System.out.println(评论号);
		setTitle("评论");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("发表评论");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(545, 52, 160, 57);
		contentPane.add(label);
		
		JButton button = new JButton("发布");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				评论内容 = textArea.getText();
				System.out.println(评论内容);	
				try {
					String 评论类型;
					if(radioButton.isSelected())
					{
						评论类型="差评";
					}
					else if(radioButton_1.isSelected())
					{
						评论类型="中评";
					}
					else
					{
						评论类型="好评";
					}
					
					pstmt=dbConn.prepareStatement("insert into 评论 values(?,?,?,?,?);"); 
					pstmt.setString(1, 评论号);
					pstmt.setString(2, 手机名);
//					pstmt.setString(3, 订单细则号);
					pstmt.setString(3, 用户号);
					pstmt.setString(4, 评论内容);
					pstmt.setString(5, 评论类型);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "发布成功");
					}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		button.setFont(new Font("宋体", Font.PLAIN, 30));
		button.setBounds(545, 528, 136, 43);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\uFF08\u5B57\u6570\u8BF7\u5C0F\u4E8E50\uFF09");
		label_1.setBounds(885, 393, 148, 18);
		contentPane.add(label_1);
		
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 30));
		
		textArea.setBounds(360, 147, 523, 265);
		contentPane.add(textArea);
		
		radioButton = new JRadioButton("差评");
		radioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton.setBounds(763, 454, 157, 27);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("中评");
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton_1.setBounds(404, 454, 157, 27);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("好评");
		radioButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		radioButton_2.setBounds(587, 454, 157, 27);
		contentPane.add(radioButton_2);
	}
}
