package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Register_login {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
    private int allprice=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_login window = new Register_login();
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
	public Register_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\liujianlong\\Desktop\\\u533B\u751F\u5BA2\u6237\u7AEF\\image\\11.jpg"));
		frame.setBounds(new Rectangle(600, 200, 800, 600));
		frame.setBounds(600,200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u6302\u53F7\u6536\u8D39\u7A97\u53E3");
		lblNewLabel_1.setBounds(32, 13, 221, 50);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(447, 227, 277, 259);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("\u6536\u8D39\uFF1A");
		lblNewLabel_3.setBounds(440, 109, 132, 31);
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u6302\u53F7\uFF1A");
		lblNewLabel_2.setBounds(32, 109, 132, 31);
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u60A3\u8005\u8D26\u53F7\uFF1A");
		lblNewLabel_4.setBounds(32, 194, 90, 24);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(136, 194, 132, 24);
		textField.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("    \u5BC6\u7801\uFF1A");
		lblNewLabel_5.setBounds(32, 249, 90, 24);
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 250, 132, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("    \u79D1\u5BA4\uFF1A");
		lblNewLabel_6.setBounds(32, 304, 90, 24);
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u4FE1\u606F");
		lblNewLabel_7.setBounds(32, 431, 401, 55);
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_7.setVisible(false);
		frame.getContentPane().add(lblNewLabel_7);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(136, 305, 132, 24);
		
		JButton btnNewButton = new JButton("\u6302\u53F7");
		btnNewButton.setBounds(185, 351, 83, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x=0,y;
				String s=null;
				//order(String name,String password ,int order,int order_time,int tN,String keshi)
                try {
					s=hospital.order(textField.getText(),textField_1.getText(), 0, hospital.time(),6,comboBox.getSelectedItem().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //病人类型为2，注册类型号为1
				
                
               
			     
			      String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
			      x=Integer.parseInt(strs[0]);	//接收服务器传来的成功或失败信号	      
                  y=Integer.parseInt(strs[1]);	
                  
                  if(x==1){//
                	  lblNewLabel_7.setVisible(true);
                	  lblNewLabel_7.setText("挂号成功，排在"+comboBox.getSelectedItem().toString()+"第"+y+"位");
                  }
                  else if(x==2){
                	  lblNewLabel_7.setVisible(true);
                	  lblNewLabel_7.setText("已预约，排在"+comboBox.getSelectedItem().toString()+"第"+y+"位");
                	  
                  }
                
                
                
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setForeground(new Color(255, 0, 0));
		frame.getContentPane().add(btnNewButton);
		
		
		JLabel lblNewLabel_9 = new JLabel("\u4FE1\u606F");//声明
		lblNewLabel_9.setBounds(447, 518, 180, 34);
		
		JButton btnNewButton_1 = new JButton("\u6536\u8D39");
		btnNewButton_1.setBounds(641, 509, 83, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x=null;
				try {
					 x=hospital.shouFei2(textField_3.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblNewLabel_9.setVisible(true);
				lblNewLabel_9.setText("收费成功"); 
				allprice=0;
				textArea.setText("");
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("\u60A3\u8005\u8D26\u53F7\uFF1A");
		lblNewLabel_8.setBounds(410, 193, 90, 27);
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(497, 194, 132, 24);
		textField_3.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.setBounds(641, 193, 83, 27);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String information=null;
				String patientid=textField_3.getText();
					try {
						 information=hospital.shouFei(patientid)	;
						 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					String  strs[]=information.split(",");      //strs[0]=药名  ，strs[1]=数量，strs[2]=单价，strs[3]=总价 strs[4]=药名…………	 
					
					if(strs.length==0){lblNewLabel_9.setVisible(true);lblNewLabel_9.setText("暂无药单");} 
						
					
					for(int k=0;k<strs.length-1;k++){ 
						strs[k]=strs[k+1];
					}
   				     String x=strs[0];
					 for(int j=0;j<strs.length-1;j=j+4){

						
                     textArea.append(strs[j].toString()+"*"+strs[j+1].toString()+"*"+strs[j+2].toString()+"="+strs[j+3].toString()+"\r\n");
                     allprice=allprice+Integer.parseInt(strs[j+3]); 
                    		 
					}
					
					 textArea.append("\r\n"+"\r\n"+"总价:"+allprice);
					 lblNewLabel_9.setVisible(false);
		
				
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 17));
		frame.getContentPane().add(btnNewButton_2);
		
		
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setVisible(false);
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 26));
		frame.getContentPane().add(lblNewLabel_9);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5185\u79D1", "\u5916\u79D1", "\u513F\u79D1", "\u5987\u4EA7\u79D1", "\u4E94\u5B98\u79D1", "\u76AE\u80A4\u79D1", "\u4F20\u67D3\u75C5\u79D1", "\u809B\u80A0\u79D1"}));
		comboBox.setForeground(new Color(255, 0, 0));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 794, 565);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\liujianlong\\Desktop\\\u533B\u751F\u5BA2\u6237\u7AEF\\image\\7.jpg"));
		frame.getContentPane().add(lblNewLabel);
	}
}
