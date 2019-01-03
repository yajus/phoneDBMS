package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 订单 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					//订单 frame = new 订单();
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
	public 订单(Statement stmt,Connection con) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\02022030760.jpg"));
		setTitle("\u8BA2\u5355");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				修改订单 xg = new 修改订单(stmt,con);
				xg.setVisible(true);
			}
		});
		btnNewButton.setBounds(246, 531, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			删除订单 sc = new 删除订单(stmt,con);
			sc.setVisible(true);}
		});
		btnNewButton_2.setBounds(758, 531, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 96, 986, 367);
		contentPane.add(scrollPane);
		
		 Vector data = new Vector();
		 Vector name = new Vector();
		 name.add("订单细则号");
		 name.add("手机名");
		 name.add("购买数量");
		 name.add("购买者");
		 name.add("订单状态");
		 
		 try {
				rs = stmt.executeQuery("SELECT 订单细则号,手机名,购买数量,购买者,订单状态 from 订单细则");
				while(rs.next()){
					  Vector row = new Vector(); 
					  String 订单细则号 = rs.getString("订单细则号");
				      String 手机名 = rs.getString("手机名");
				      //int 售价 = rs.getInt("售价");
				      //int 库存 = rs.getInt("库存");
				      String 购买数量 = String.valueOf(rs.getInt("购买数量"));
				      String 购买者 = rs.getString("购买者");
				      String 订单状态 = rs.getString("订单状态");
				      
				      row.add(订单细则号);
				      row.add(手机名);
				      row.add(购买数量);
				      row.add(购买者);
				      row.add(订单状态);
				      data.add(row);
				     
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			data,name
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}

}
