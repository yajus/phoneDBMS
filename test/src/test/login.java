//登陆界面
package test;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class login extends JFrame implements ActionListener {
private JPanel pan = new JPanel();
private JLabel namelab = new JLabel("用户名");
private JLabel passlab = new JLabel("密    码");
private JTextField nametext = new JTextField();
private JPasswordField passtext = new JPasswordField();
 
public JButton denglu = new JButton("登录");
public JButton zhuce = new JButton("注册");
public JButton updatepass = new JButton("修改密码");
public JButton deleteuser = new JButton("删除用户");
 
public static String username;
public login(){
	Font font = new Font("宋体",Font.BOLD,12);
	super.setTitle("欢迎登录本系统");
	pan.setLayout(null);
	namelab.setBounds(20,20,60,30);
	nametext.setBounds(90,20,140,30);
	passlab.setBounds(20,60,60,30);
	passtext.setBounds(90,60,140,30);
	denglu.setBounds(30,120,90,20);
	zhuce.setBounds(140,120,90,20);
	updatepass.setBounds(30,150,90,20);
	deleteuser.setBounds(140,150,90,20);
	
	pan.add(namelab);
	pan.add(nametext);
	pan.add(passlab);
	pan.add(passtext);
	pan.add(denglu);
	pan.add(zhuce);
	pan.add(updatepass);
	pan.add(deleteuser);
	
	passtext.setFont(font);
	zhuce.setFont(font);
	updatepass.setFont(font);
	deleteuser.setFont(font);
	
	denglu.addActionListener(this);
	zhuce.addActionListener(this);
	updatepass.addActionListener(this);
	deleteuser.addActionListener(this);
	
	super.add(pan);
	super.setSize(300,250);
	//super.setVisible(true);
}
 
public static void main(String []args){
	
	login Login=new login();
	Login.setVisible(true);
}
 
	@Override
	public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource()==denglu){
		denglu();
	}else if (arg0.getSource()==zhuce){
		zhuce();
	}else if (arg0.getSource()==updatepass){
		updatepass();
	}else if (arg0.getSource()==deleteuser){
		deleteuser();
	}
 
	}
	//登录按钮的事件处理函数
	public void denglu(){
	 Jdbcs d  =	new Jdbcs();
     username = nametext.getText();
	 String password = passtext.getText();
      if(d.compare(username, password)){
    	JOptionPane.showMessageDialog(null,"登录成功！");
    	  super.setVisible(false);
    	  try {
				main frame = new main();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
      }
	}
	//注册按钮触发后的事件处理函数
	public void zhuce(){
		Jdbcs d  =	new Jdbcs();
		String username = nametext.getText();
		 String password = passtext.getText();
		 d.insert(username,password);
	}
	//修改密码按钮触发后的事件处理函数
	public void updatepass(){

		pan.setEnabled(false);
		JFrame frame1 = new JFrame("密码修改");
		frame1.setSize(250, 200);
		JPanel updatepass = new JPanel();
		JLabel namelab1 = new JLabel("用户号");
		JLabel passlab1 = new JLabel("旧密码");
		JLabel newpasslab = new JLabel("新密码");
		JTextField nametext1  = new JTextField(""+nametext.getText());
		JPasswordField passtext1 = new JPasswordField();
		JPasswordField newpasstext  = new JPasswordField();
		JButton ok = new JButton("修改");
		JButton resert = new JButton("重置");
		
		updatepass.setLayout(null);
		
		namelab1.setBounds(5,5,70,20);
		nametext1.setBounds(80,5,120,20);
		passlab1.setBounds(5,30,70,20);
		passtext1.setBounds(80,30,120,20);
		newpasslab.setBounds(5,60,70,20);
		newpasstext.setBounds(80,60,120,20);
		ok.setBounds(10,110,60,20);
		resert.setBounds(90,110,60,20);
		
		updatepass.add(namelab1);
		updatepass.add(nametext1);
		updatepass.add(passlab1);
		updatepass.add(passtext1);
		updatepass.add(newpasslab);
		updatepass.add(newpasstext);
		updatepass.add(ok);
		updatepass.add(resert);
		
		frame1.add(updatepass);
		frame1.setVisible(true);
		
		ok.addActionListener(new ActionListener(){
 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Jdbcs d  =	new Jdbcs();
				String username = nametext1.getText();
				 String password1 = passtext1.getText();
				 String newpassword = newpasstext.getText();
				if(d.update(username,password1,newpassword)){
					frame1.setVisible(false);
				}
			}
		});
		//重置文本框 里的内容
		resert.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				nametext1.setText("");
				passtext1.setText("");
				newpasstext.setText("");
			}
		});
	}
	
	//修改用户信息
	public void updatedate(){

		pan.setEnabled(false);
		JFrame frame1 = new JFrame("信息修改");
		frame1.setSize(250, 200);
		JPanel updatepass = new JPanel();
//		JLabel namelab1 = new JLabel("用户号");
//		JLabel passlab1 = new JLabel("旧密码");
//		JLabel newpasslab = new JLabel("新密码");
		JLabel namelab3 = new JLabel("姓名");
		JLabel sexlab1 = new JLabel("性别");
		JLabel phonelab1 = new JLabel("电话号码");
		JLabel locallab1 = new JLabel("地址");
//		JTextField nametext1  = new JTextField(""+nametext.getText());
		JTextField nametext3  = new JTextField();
		JTextField sextext1  = new JTextField();
		JTextField phonetext1  = new JTextField();
		JTextField localtext1  = new JTextField();
//		JPasswordField passtext1 = new JPasswordField();
//		JPasswordField newpasstext  = new JPasswordField();
		JButton ok = new JButton("修改");
		JButton resert = new JButton("重置");
		
		updatepass.setLayout(null);
		
		namelab3.setBounds(5,5,70,20);
		nametext3.setBounds(80,5,120,20);
		sexlab1.setBounds(5,30,70,20);
		sextext1.setBounds(80,30,120,20);
		phonelab1.setBounds(5,60,70,20);
		phonetext1.setBounds(80,60,120,20);
		locallab1.setBounds(5,90,70,20);
		localtext1.setBounds(80,90,120,20);
		ok.setBounds(10,130,60,20);
		resert.setBounds(90,130,60,20);
		
		updatepass.add(namelab3);
		updatepass.add(nametext3);
		updatepass.add(sexlab1);
		updatepass.add(sextext1);
		updatepass.add(phonelab1);
		updatepass.add(phonetext1);
		updatepass.add(locallab1);
		updatepass.add(localtext1);
		updatepass.add(ok);
		updatepass.add(resert);
		
		frame1.add(updatepass);
		frame1.setVisible(true);
		
		ok.addActionListener(new ActionListener(){
 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Jdbcs d  =	new Jdbcs();
//				String username = nametext1.getText();
//				 String password1 = passtext1.getText();
//				 String newpassword = newpasstext.getText();
				String name = nametext3.getText();
				String  sex= sextext1.getText();
				String phone = phonetext1.getText();
				String local = localtext1.getText();
				if(d.updatemessage(login.username,name,sex,phone,local)){
					frame1.setVisible(false);
				}
			}
		});
		//重置文本框 里的内容
		resert.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				nametext3.setText("");
				sextext1.setText("");
				phonetext1.setText("");
				localtext1.setText("");
			}
		});
	}
	
	//删除用户按钮触发后的事件处理函数
	public void deleteuser(){
	String username = nametext.getText();
	String password = passtext.getText();
	Jdbcs s = new Jdbcs();
		s.delete(username,password);
	}
 
}
