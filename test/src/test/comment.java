package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class comment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					comment frame = new comment();
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
	public comment(String phonename) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JList list = new JList();
		list.setBounds(94, 116, 1111, 515);
		contentPane.add(list);
		DefaultListModel dlm=new DefaultListModel();
		jdbccon jdbc1=new jdbccon();
		 String[][] attribute=new String[4][20];
		 int i =jdbc1.selectcommit(phonename,attribute);
		 for(int j=1;j<i;j++)
		 {
			 dlm.addElement("手机名:"+(String)attribute[0][j]+"评论内容:"+(String)attribute[1][j]+"评论类型:"+(String)attribute[2][j]);
		 }
	     list.setModel(dlm);
	}
	
	

}
