package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class hospital_windows {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String keshi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hospital_windows window = new hospital_windows();
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
	public hospital_windows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(600, 200, 800, 600));
		frame.setBounds(600, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(289, 349, 64, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(289, 386, 52, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(358, 349, 164, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setVisible(false);
		
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int x=0;
				String s=null;
					try {
						
						s=hospital.login(textField.getText(),String.valueOf(passwordField.getPassword()),3);//登陆
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				
				      String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
				      x=Integer.parseInt(strs[0]);	//接收服务器传来的成功或失败信号	      
				      int type=Integer.parseInt(strs[2]);    
						    
					
					
					if(x==1){//登陆成功
						System.out.println(type+"text");
						if(type==3){
						keshi=strs[1].trim();	
						frame.dispose();
						doctor_login window = new doctor_login();
						window.frame.setVisible(true);
						//keshi=strs[1];				
						}
						else if(type==4){
							frame.dispose();
						Register_login window = new Register_login();
						window.frame.setVisible(true);}
						
						
					
					}
					
					if(x==3){//登陆失败
						lblNewLabel_3.setVisible(true);
						lblNewLabel_3.setText("密码错误");
						}
					
					else if(x==2){//登陆失败
						lblNewLabel_3.setVisible(true);
						lblNewLabel_3.setText("用户名不存在");
						}
					
					System.out.println(x);
						
				
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(454, 423, 68, 27);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(358, 387, 164, 24);
		frame.getContentPane().add(passwordField);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_3.setBounds(256, 294, 343, 42);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\liujianlong\\Desktop\\\u533B\u751F\u5BA2\u6237\u7AEF\\image\\3.jpg"));
		lblNewLabel.setBounds(new Rectangle(0, 0, 782, 553));
		lblNewLabel.setBounds(0, 0, 782, 553);
		frame.getContentPane().add(lblNewLabel);
	}
}
