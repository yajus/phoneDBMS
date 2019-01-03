//这是商品详情界面
package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.*;

public class shangpingxiangqing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					shangpingxiangqing frame = new shangpingxiangqing("");
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
	public shangpingxiangqing(String phonename) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//返回原来的窗口
		JButton button = new JButton("返回");
		button.setBounds(670, 54, 117, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main test2=new main();
				setVisible(false); 
				test2.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);
		
		//显示的内容
		JList list = new JList();
		list.setFont(new java.awt.Font("宋体",java.awt.Font.PLAIN,25));
		list.setBounds(94, 116, 1111, 515);
		contentPane.add(list);
		DefaultListModel dlm=new DefaultListModel();
		jdbccon jdbc1=new jdbccon();
		 String[][] attribute=new String[3][10];
		 jdbc1.selectobject(phonename,attribute);
		 for(int i=1;i<=9;i++)
		 {
			 dlm.addElement(attribute[0][i]+":"+(String)attribute[1][i]);
		 }
	     list.setModel(dlm);
	     
	     JButton button_1 = new JButton("收藏");
	     button_1.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		jdbccon a=new jdbccon();
	     		a.insertcollection(login.username, (String)attribute[1][1]);
	     	}
	     });
	     button_1.setBounds(446, 54, 117, 29);
	     contentPane.add(button_1);
	     
	     JButton button_2 = new JButton("购买");
	     button_2.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		jdbccon a=new jdbccon();
	     		a.insertbuy(login.username, (String)attribute[1][1]);
	     	}
	     });
	     button_2.setBounds(910, 54, 117, 29);
	     contentPane.add(button_2);
	     
	     JButton button_3 = new JButton("商品评价");
	     button_3.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		comment com = new comment(phonename);
	     		com.setVisible(true);
	     	}
	     });
	     button_3.setBounds(230, 54, 117, 29);
	     contentPane.add(button_3);
		
	}
}
