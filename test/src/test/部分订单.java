//用户可见的订单界面
package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
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

public class 部分订单 extends JFrame {
	private final JButton btnNewButton = new JButton("评论");
	private JPanel contentPane;
	private JTable table;
	ResultSet rs;
	String 订单细则号;
	private JTextField textField;
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
	public 部分订单(Statement stmt,Connection con) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\02022030760.jpg"));
		setTitle("\u8BA2\u5355");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("指定商品");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(370, 527, 150, 47);
		contentPane.add(label);
		
		//评论按钮
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				订单细则号=textField.getText();	    
				if(订单细则号==null) {
					JOptionPane.showMessageDialog(null, "请重新输入！", "", JOptionPane.WARNING_MESSAGE);
				}
				else {	
					try
					{
					rs = stmt.executeQuery("SELECT 手机名 from 订单细则 where 购买者=\""+login.username+"\"");
					rs.next();
					String 手机名 = rs.getString("手机名");
					评论 number = new 评论(con,stmt,订单细则号,手机名);
					number.setVisible(true);	   
					}
					catch(Exception exx)
					{	
						System.out.println("不存在该订单号");
					}
					} 				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 30));
		btnNewButton.setBounds(691, 530, 113, 40);
		contentPane.add(btnNewButton);
		
		//评论选择输入框
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 30));
		textField.setBounds(527, 528, 139, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
				rs = stmt.executeQuery("SELECT 订单细则号,手机名,购买数量,购买者,订单状态 from 订单细则 where 购买者=\""+login.username+"\"");
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
