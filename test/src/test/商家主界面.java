//商家管理页面
package test;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class 商家主界面 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.

	 */
//	public static void main(String[] args)  {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					商家主界面 framehome = new 商家主界面();
//					framehome.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public 商家主界面() {
		setTitle("\u5546\u5BB6\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("商品");//商品
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			         商品 sp =new 商品();
			     sp.setVisible(true);
			}
		});
		
		button.setBounds(228, 261, 272, 260);
		contentPane.add(button);
		
		JButton button_1 = new JButton("订单"); //订单
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//订单 dd =new 订单();
				//dd.setVisible(true);
			}
		});
		button_1.setBounds(704, 261, 295, 260);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\\u5FAE\u4FE1\u56FE\u7247_20181218001645.jpg"));
		label.setBounds(476, 164, 295, 260);
		contentPane.add(label);
	}
	
	public 商家主界面(Statement stmt,Connection con) {
		setTitle("\u5546\u5BB6\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("商品");//商品
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			         商品 sp =new 商品(stmt,con);
			     sp.setVisible(true);
			}
		});
		
		button.setBounds(387, 494, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("订单"); //订单
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				订单 dd =new 订单(stmt,con);
				dd.setVisible(true);
			}
		});
		button_1.setBounds(704, 494, 113, 27);
		contentPane.add(button_1);
		
		/*JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\\u5FAE\u4FE1\u56FE\u7247_20181218001645.jpg"));
		label.setBounds(476, 164, 295, 260);
		contentPane.add(label);*/
	}	
}

