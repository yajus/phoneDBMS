//收藏夹
package test;

import java.sql.*;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.EmptyBorder;

public class Collection extends JFrame {
		private DefaultTableModel tableModel;		// 默认显示的表格
		private JPanel contentPane;
		private JLabel textField;
        final JFrame collection=new JFrame();  
    	public Vector rowData;
    	public Vector columnNames;
    	JButton btnNewButton1 = new JButton("从收藏夹中移除");
    	JButton btnNewButton = new JButton("刷新收藏夹");
    	JTable table;

    	
    	//构造函数
		public Collection(String name) {
//			System.out.println("sssss");
			this.setVisible(true);
			setBackground(new Color(255, 250, 240));
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100,  1280,720);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.window);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			//标题
			textField = new JLabel();
			textField.setBounds(0, 15, 1258, 39);
			textField.setFont(new Font("华文新魏", Font.PLAIN, 25));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("\u6536\u85CF\u5939");
			contentPane.add(textField);

			//显示表格内容
			showCollection();
			
			//删除按钮
			btnNewButton1.setFont(new Font("宋体", Font.PLAIN, 19));
			btnNewButton1.setBackground(new Color(230, 230, 250));
			btnNewButton1.setBounds(346, 541, 207, 29);
			contentPane.add(btnNewButton1);

			//刷新按钮
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 19));
			btnNewButton.setBackground(new Color(230, 230, 250));
			btnNewButton.setBounds(713, 541, 207, 29);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("返回用户信息中心");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new Mydemo(name);
				}
			});
			btnNewButton_1.setBounds(513, 610, 223, 39);
			btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
			btnNewButton_1.setBackground(new Color(230, 230, 250));
			contentPane.add(btnNewButton_1);
			
			//事件处理			
			MyEvent();
			
		}
	
    	
      //显示所有收藏商品
    	public void showCollection(){
    		//表格
//    		System.out.println("ssssss");
    		rowData = Collections.getRows();//rowData用来存放行数据,columnNames存放列名
    		columnNames = Collections.getHead();

    	    // 新建表格
    		tableModel = new DefaultTableModel(rowData,columnNames);	
    		table = new JTable(tableModel){
    		    public boolean isCellEditable(int row, int column){
    	            return false;//设置单元格不可编辑
    	        }
    	    };
    	    
            //鼠标点击事件
    	    table.addMouseListener(new MouseAdapter(){
    	        public void mouseClicked(MouseEvent e){
    	        	int row1=table.getSelectedRow();
    	        	int col1=table.getSelectedColumn();
    	        	if(col1==1){                              
    	        	   System.out.println("进入手机详情界面");   
    	        	   setVisible(false);
    	        	   String phonename=(String)table.getValueAt(row1,col1);
    	        	   shangpingxiangqing test=new shangpingxiangqing(phonename);
    	        	   test.setVisible(true);
    	        	}
    	        }
    	    });
    	    table.setFillsViewportHeight(false);
    	    table.setShowGrid(false);;
    	    table.setRowSelectionAllowed(true);
    	    table.setBackground(new Color(255, 255, 255));//表格背景色
    	    table.setFont(new Font("仿宋", Font.PLAIN, 18));//设置表格字体
    	    table.setRowHeight(30);//设置表格行高
    	    table.setShowHorizontalLines(true);//横线
    	    table.setShowVerticalLines(true);//竖线
    	    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
    	    cr.setHorizontalAlignment(JLabel.CENTER);
    	    table.setDefaultRenderer(Object.class, cr);//设置单元格内容居中	    
    	    
    	    //设置表头
    	    table.getTableHeader().setBackground(new Color(230, 230, 250));// 设置表头背景颜色
    		table.getTableHeader().setForeground(new Color(250, 0, 150));// 设置表头字体颜色
    		table.getTableHeader().setFont(new Font("楷体", Font.PLAIN, 20));// 设置表头字体
    	    Dimension size = table.getTableHeader().getPreferredSize();
            size.height =40;//设置新的表头高度60
            table.getTableHeader().setPreferredSize(size);
            table.getTableHeader().setReorderingAllowed(false);

    	    // 将表格加入到滚动条组件中
    	    JScrollPane scrollPane = new JScrollPane();
    		scrollPane.setBounds(270, 86, 755, 396);
    		contentPane.add(scrollPane);
    	    // 再将滚动条组件添加到中间容器中		
    		scrollPane.setViewportView(table);    		
    	}

    	
    	
    	//删除收藏
    	public void deleteCollection(){
    		// 删除指定行
			int rowcount = table.getSelectedRow();
			if(rowcount >= 0){
				tableModel.removeRow(rowcount);		
			    // TODO Auto-generated method stub
				int column = table.getColumnCount();		// 表格列数
				int row = table.getRowCount();		// 表格行数			
				// value数组存放表格中的所有数据
				String[][] value = new String[row][column];				
				for(int i = 0; i < row; i++){
					for(int j = 0; j < column; j++){
						value[i][j] = table.getValueAt(i, j).toString();
					}
				}				
				// 更新删除后的数据库收藏表
				String sql_url = "jdbc:mysql://localhost:3306/华为手机";	
				String name = "zxp";		//用户名
				String password = "123456";	//密码
				Connection conn;
				PreparedStatement preparedStatement = null;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");		//连接驱动
					conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
					if(!conn.isClosed())
						System.out.println("成功连接数据库save2");					
					// 删除收藏表中所有数据
					preparedStatement = conn.prepareStatement("delete from 收藏  ");
					preparedStatement.executeUpdate();					
					// 将value数组中的数据依次存放到收藏表中
					for(int i = 0; i < row; i++){
						preparedStatement = conn.prepareStatement("insert into 收藏  values('" + value[i][0]+ "','" + value[i][1] + "')");
						preparedStatement.executeUpdate();
					}					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("未成功加载驱动。");
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("未成功打开数据库。");
					e1.printStackTrace();
				}
			}
    	}
    	
	
		
		//处理事件函数
		public void MyEvent(){
			btnNewButton1.addActionListener(new ActionListener(){
				 
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					deleteCollection();
				}
			});
			
			btnNewButton.addActionListener(new ActionListener(){
				 
				@Override
				public void actionPerformed(ActionEvent e) {	
					showCollection();
					
					
				}
			});
				 
		}
	}
