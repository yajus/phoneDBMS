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
import javax.swing.JLabel;

public class 全部订单 extends JFrame {
	private JPanel contentPane;
	private JTable table = new JTable();;
	ResultSet rs ;
	Vector data=new Vector();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//全部订单 frame = new 全部订单();
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
	public 全部订单(Connection dbConn , Statement stmt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Vector name=new Vector();
		name.add("订单号");
		name.add("用户号");
		name.add("订单细则数");
		name.add("订单创建日期");
		name.add("订单状态");
		name.add("支付方式");
		name.add("支付时间");
		name.add("发货日期");
		name.add("成交日期");
		
		 try {
		    rs=stmt.executeQuery("select * from 订单;");

		    while(rs.next()) {
		    		    	
			    String 订单号=rs.getString("订单号");
				String 用户号=rs.getString("用户号");
				int 订单细则数=rs.getInt("订单细则数");
				String str1=String.valueOf(订单细则数);
				String 订单创建日期=rs.getString("订单创建日期");				
				String 订单状态=rs.getString("订单状态");	
				String 支付方式=rs.getString("支付方式");	
				String 支付时间=rs.getString("支付时间");	
				String 发货日期=rs.getString("发货日期");	
				String 成交日期=rs.getString("成交日期");	
				
				Vector row=new Vector();
				row.add(订单号);
				row.add(用户号);
				row.add(str1);
				row.add(订单创建日期);
				row.add(订单状态);
				row.add(支付方式);
				row.add(支付时间);
				row.add(成交日期);
				data.add(row);
			
				}}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		table.setModel(new DefaultTableModel(data,name));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 196, 672, 320);
		contentPane.add(scrollPane);	
		
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u5168\u90E8\u8BA2\u5355");
		label.setFont(new Font("宋体", Font.PLAIN, 40));
		label.setBounds(519, 90, 178, 47);
		contentPane.add(label);
	}

}
