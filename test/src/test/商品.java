//商品页面
package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.sql.*;
import java.util.Vector;
public class 商品 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					商品 framesp = new 商品();
					framesp.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 商品() {
		setTitle("\u5546\u54C1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("上架");//上架按钮
		btnNewButton.setBounds(291, 564, 113, 27);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//上架商品 sj =new 上架商品();
				//sj.setVisible(true);

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(540, 564, 113, 27);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//修改商品 xg =new 修改商品();
				//xg.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("下架");
		btnNewButton_2.setBounds(779, 564, 113, 27);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//下架商品 xj =new 下架商品();
				//xj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 96, 986, 367);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u5546\u54C1\u53F7", "\u540D\u79F0", "\u4EF7\u683C", "\u5E93\u5B58"
			}
		));
	
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
//从这里开始有效 logbyzxp
	public 商品(Statement stmt,Connection con) {
		setTitle("\u5546\u54C1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u4E0A\u67B6");
		btnNewButton.setBounds(291, 564, 113, 27);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				上架商品 sj =new 上架商品(stmt,con);
				sj.setVisible(true);

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setBounds(540, 564, 113, 27);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				修改商品 xg =new 修改商品(stmt, con);
				xg.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4E0B\u67B6");
		btnNewButton_2.setBounds(779, 564, 113, 27);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				下架商品 xj =new 下架商品(stmt,con);
				xj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 96, 986, 367);
		contentPane.add(scrollPane);
		
		 Vector data = new Vector();
		 Vector name = new Vector();
		 name.add("名称");
		 name.add("CPU型号");
		 name.add("售价");
		 name.add("库存");
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		


		   
       try {
			rs = stmt.executeQuery("SELECT CPU型号,手机名,售价,库存 from 手机");
			while(rs.next()){
				  Vector row = new Vector(); 
				  String CPU型号 = rs.getString("CPU型号");
			      String 名称 = rs.getString("手机名");
			      //int 售价 = rs.getInt("售价");
			      //int 库存 = rs.getInt("库存");
			      String 售价 = String.valueOf(rs.getInt("售价"));
			      String 库存 = String.valueOf(rs.getInt("库存"));
			      row.add(名称);
			      row.add(CPU型号);
			      row.add(售价);
			      row.add(库存);
			      data.add(row);
			     
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
       table.setModel(new DefaultTableModel(
			data,name		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	
}

