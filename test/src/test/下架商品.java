//下架商品
package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 下架商品 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String 手机名;
	boolean flag=false;
	ResultSet rs;
	PreparedStatement pstmt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//下架商品 frame = new 下架商品();
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
	public 下架商品(Statement stmt,Connection con) {
		setTitle("\u4E0B\u67B6\u5546\u54C1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u624B\u673A\u540D");
		label.setBounds(361, 267, 72, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				手机名=textField.getText();
			}
		});
		textField.setBounds(503, 264, 160, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u4E0B\u67B6");
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
						pstmt = con.prepareStatement("delete from 手机  where 手机名=?;");
						pstmt.setString(1,手机名);				
						pstmt.executeUpdate();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				JOptionPane.showMessageDialog(null ,"下架成功");	
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null ,"手机名不存在", "", JOptionPane.WARNING_MESSAGE);
					flag=false;
				}	
			}
		});
		button.setBounds(461, 369, 113, 27);
		contentPane.add(button);
	}

}
