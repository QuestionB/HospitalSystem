package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class doctor_login {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private String patientID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctor_login window = new doctor_login();
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
	public doctor_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(new Rectangle(600, 200, 800, 600));
		frame.setBounds(600, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKeshi = new JLabel(hospital_windows.keshi);
		lblKeshi.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeshi.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblKeshi.setForeground(new Color(255, 0, 0));
		lblKeshi.setBounds(32, 13, 221, 50);
		lblKeshi.setFont(new Font("宋体", Font.PLAIN, 26));
		
		JLabel lblid = new JLabel("\u60A3\u8005\u8D26\u53F7\uFF1A");
		lblid.setBounds(32, 130, 90, 24);
		lblid.setBackground(new Color(255, 255, 255));
		lblid.setForeground(new Color(0, 0, 0));
		lblid.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_5 = new JLabel("\u67E5\u8BE2\u4FE1\u606F");//预先定义
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		JButton btnNewButton_2 = new JButton("\u5F00\u836F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String x=hospital.yaodan(textField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x=0;
				String s=null;
				
				try {
					s=hospital.login(textField.getText(),"x",3);
					patientID=textField.getText();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//登陆
				
				   String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
				      x=Integer.parseInt(strs[0]);	//接收服务器传来的成功或失败信号	      
				      int type=Integer.parseInt(strs[2]);
					if(x==1||x==3){//用户存在
						if(type==2){System.out.println("chaxunchengg");
							lblNewLabel_5.setVisible(true);
							lblNewLabel_5.setText(patientID+"患者验证成功！");
							btnNewButton_1.setVisible(true);
							btnNewButton_2.setVisible(true);
						}
					
					}
				
					else if(x==2){//登陆失败
						lblNewLabel_5.setVisible(true);
						lblNewLabel_5.setText("系统无该患者信息！");
						}
					
					System.out.println(x);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBounds(280, 130, 83, 27);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(121, 245, 132, 24);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setForeground(new Color(255, 0, 0));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u836F\u54C1\u5168\u79F0", "\u836F\u54C1\u9996\u5B57\u6BCD"}));
		
		JLabel label = new JLabel("\u8F93\u5165\u6CD5\uFF1A");
		label.setBounds(32, 248, 82, 18);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u6DFB\u52A0\u836F\u54C1\uFF1A");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(32, 190, 132, 31);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));
		
		textField = new JTextField();
		textField.setBounds(121, 132, 132, 24);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 281, 140, 24);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 330, 86, 24);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel_2.setBounds(32, 286, 90, 18);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("\u6570\u91CF\uFF1A");
		lblNewLabel_3.setBounds(32, 330, 72, 18);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 26));
		
		JLabel lblNewLabel_6 = new JLabel("New label");//先定义声明
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int x=0;
				int j=2;
				String s=null;
				String shurufa = comboBox.getSelectedItem().toString() ;
				   if(shurufa.compareTo("药品全称")==0) j=1;
				   else if(shurufa.compareTo("药品首字母")==0)j=2;
					try {
						s=hospital.kaiyao(patientID,j,textField_1.getText(),4,Integer.parseInt(textField_2.getText()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					 int Mnumble=Integer.parseInt(textField_2.getText());
				     
				      String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
				     String Mname=strs[0];
				    int x1=Integer.parseInt(strs[2]);
				    if(x1==7){    textArea.append(Mname+"*"+Mnumble+"\r\n");           }
				    else if(x1==6){
				    	lblNewLabel_6.setVisible(true); 
				    	lblNewLabel_6.setText("查无此药！"); 
				    }
				    
				    
				    //  Mname=Integer.parseInt(strs[0]);	//接收服务器传来的成功或失败信号	      
				
				
				
				
			}
		});
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setBounds(280, 327, 83, 27);
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_4 = new JLabel("\u836F\u5355\uFF1A");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(447, 190, 83, 31);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblKeshi);
		frame.getContentPane().add(lblid);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(comboBox);
		frame.getContentPane().add(label);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(textField_2);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(lblNewLabel_3);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textArea.setBounds(447, 227, 277, 259);
		frame.getContentPane().add(textArea);
		
		
		btnNewButton_2.setVisible(false);
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(607, 491, 113, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		//JLabel lblNewLabel_5 = new JLabel("\u67E5\u8BE2\u4FE1\u606F");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(435, 100, 321, 50);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		
		
		
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_6.setBounds(32, 381, 321, 50);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\liujianlong\\Desktop\\\u533B\u751F\u5BA2\u6237\u7AEF\\image\\6.jpg"));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(0, 0, 794, 565);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
	}
}
