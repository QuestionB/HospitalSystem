package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class admin_login {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_login window = new admin_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public admin_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(600, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u7AEF");
		lblNewLabel_1.setBounds(32, 13, 221, 50);
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u8D26\u53F7\uFF1A");
		lblNewLabel_2.setBounds(227, 190, 90, 24);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(317, 188, 132, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(232, 228, 66, 24);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(318, 228, 132, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(313, 146, 132, 24);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u533B\u751F", "\u6302\u53F7", "\u836F\u623F", "\u9662\u957F"}));
		comboBox.setForeground(new Color(255, 0, 0));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("\u4FE1\u606F");
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x=0,y=0,j=0;
				String s = comboBox.getSelectedItem().toString() ;
				      if(s.compareTo("管理员")==0) j=1;
				   else if(s.compareTo("医生")==0)j=3;
				   else if(s.compareTo("药房")==0)j=5;
				   else if(s.compareTo("挂号")==0)j=4;
				   else if(s.compareTo("院长")==0)j=6;
				
				
                try {//addUser(String name,String passWord,int i,int tN)
					y=hospital.addUser(textField.getText(),textField_1.getText(), j,11,1 );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //病人类型为2，注册类型号为1
				
                
               
			     
			 
                  
                  if(y==1){//
                	  lblNewLabel_6.setVisible(true);
                	  lblNewLabel_6.setText("添加成功");
                  }
                  else if(y==4){
                	  lblNewLabel_6.setVisible(true);
                	  lblNewLabel_6.setText("用户名已存在");
                	  
                  }
				
				
			}
		});
		btnNewButton.setBounds(369, 266, 83, 27);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int y=0;
				try {
					y=hospital.addUser(textField.getText(),"notuse", 0,11,2 );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				  
                if(y==1){//
              	  lblNewLabel_6.setVisible(true);
              	  lblNewLabel_6.setText("删除成功");
                }
                else if(y==-1){
              	  lblNewLabel_6.setVisible(true);
              	  lblNewLabel_6.setText("账号不存在");
              	  
                }
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(474, 189, 83, 27);
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u7BA1\u7406\u8D26\u53F7");
		lblNewLabel_4.setBounds(38, 139, 132, 31);
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u7BA1\u7406\u836F\u54C1");
		lblNewLabel_5.setBounds(45, 335, 132, 31);
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel label = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		label.setBounds(236, 363, 90, 24);
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(317, 363, 132, 24);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 17));
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		JLabel label_1 = new JLabel("\u62FC\u97F3\uFF1A");
		label_1.setBounds(238, 405, 90, 24);
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(317, 408, 132, 24);
		textField_3.setFont(new Font("宋体", Font.PLAIN, 17));
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		JLabel label_2 = new JLabel("\u6570\u91CF\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		label_2.setBounds(238, 445, 90, 24);
		frame.getContentPane().add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBounds(317, 445, 132, 24);
		frame.getContentPane().add(textField_4);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=0;
				
				try {
					x=hospital.Medicine(textField_2.getText(),textField_3.getText(),Integer.parseInt(textField_4.getText()),12,1,Integer.parseInt(textField_5.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//第五位为1添加
				
				 if(x==1){//
	              	  lblNewLabel_6.setVisible(true);
	              	  lblNewLabel_6.setText("药品添加成功");
	                }
	                else if(x==-1){
	              	  lblNewLabel_6.setVisible(true);
	              	  lblNewLabel_6.setText("添加失败");
	              	  
	                }
				
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("宋体", Font.PLAIN, 17));
		button.setBounds(369, 523, 83, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x=0;
				try {
					x=hospital.Medicine(textField_2.getText(),"",0,12,2,0);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 if(x==1){//
	              	  lblNewLabel_6.setVisible(true);
	              	  lblNewLabel_6.setText("删除成功");
	                }
	                else if(x==-1){
	              	  lblNewLabel_6.setVisible(true);
	              	  lblNewLabel_6.setText("药品不存在失败");
	              	  
	                }
				
				
				
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("宋体", Font.PLAIN, 17));
		button_1.setBounds(474, 362, 83, 27);
		frame.getContentPane().add(button_1);
		
		
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_6.setBounds(313, 58, 401, 55);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel label_3 = new JLabel("\u5355\u4EF7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 17));
		label_3.setBounds(236, 490, 90, 24);
		frame.getContentPane().add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBounds(317, 486, 132, 24);
		frame.getContentPane().add(textField_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 794, 565);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\liujianlong\\Desktop\\\u533B\u751F\u5BA2\u6237\u7AEF\\image\\13.jpg"));
		frame.getContentPane().add(lblNewLabel);
	}
}
