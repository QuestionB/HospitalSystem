package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Medicine_login {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine_login window = new Medicine_login();
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
	public Medicine_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\liujianlong\\Desktop\\\u533B\u751F\u5BA2\u6237\u7AEF\\image\\11.jpg"));
		frame.setResizable(false);
		frame.setBounds(600, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u623F");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(32, 13, 221, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u836F\u5355:");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(435, 172, 221, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u60A3\u8005\u8D26\u53F7:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(32, 184, 90, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(113, 185, 132, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textArea.setBounds(32, 227, 310, 259);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 21));
		textArea_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		textArea_1.setBounds(435, 227, 277, 259);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");//
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String information=null;
				String patientid=textField.getText();
					try {
						 information=hospital.shouFei(patientid)	;
						 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					String  strs[]=information.split(",");      //strs[0]=药名  ，strs[1]=数量，strs[2]=单价，strs[3]=总价 strs[4]=药名…………	 
					
					if(strs.length==0){lblNewLabel_4.setVisible(true);lblNewLabel_4.setText("暂无药单");textArea.setText("");} 
					if(patientid!="11111111111111"){textArea.setText("");} 	
					
					for(int k=0;k<strs.length-1;k++){ 
						strs[k]=strs[k+1];
					}
   				     String x=strs[0];
					 for(int j=0;j<strs.length-1;j=j+4){

						
                     textArea.append(strs[j].toString()+"*"+strs[j+1].toString()+"*"+strs[j+2].toString()+"="+strs[j+3].toString()+"\r\n");
                    // allprice=allprice+Integer.parseInt(strs[j+3]); 
                    		 
					}
					
					 //textArea.append("\r\n"+"\r\n"+"总价:"+allprice);
					 lblNewLabel_4.setVisible(false);
		
				
				
		
				
				
				
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(259, 183, 83, 27);
		frame.getContentPane().add(btnNewButton);
		
		
		lblNewLabel_4.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("\u5F00\u542F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

					//System.out.println("我想停下来");
					//doClickButton.doClick(10000);
					new Thread(new Runnable() {
					@Override
					public void run() {
					// TODO Auto-generated method stub
				//	System.out.println("刷新订单");
					try{
						
						while(true){
							String info=null;
							try {
								info = hospital.yaodan2();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								String  strs[]=info.split(",");
								int y=Integer.parseInt(strs[2]);
								System.out.println(y);
								if(y!=0){
									textArea_1.setText("");
									 textArea_1.append("病人ID："+strs[0].toString()+"\r\n");
									
									String patientid=textField.getText();
									
										
										String  strs1[]=info.split(",");      //strs[0]=药名  ，strs[1]=数量，strs[2]=单价，strs[3]=总价 strs[4]=药名…………	 
										for(int k=0;k<strs1.length-1;k++){ 
											strs1[k]=strs1[k+1];
										}
										
										//if(strs1.length==0){lblNewLabel_9.setVisible(true);lblNewLabel_9.setText("暂无药单");} 
											
										
										
					   				   
										 for(int j=0;j<strs1.length-1;j=j+4){

											
					                     textArea_1.append(strs1[j].toString()+"*"+strs1[j+1].toString()+"\r\n");
					                   
					                    		 
										}
										
										
									
							
									
									
								
							
									
									
								}
								
								break;}	
						
					Thread.currentThread().sleep(5000L);textArea_1.setText("");
					} catch (InterruptedException e) {
					System.out.println("doClick interrupted");
					}finally{
					run();
					}
					}	

					}).start();
				
				
				
				
				
				
				
				
				
				
				
				
				
			//	public void doClick(1000);
				
				
				
				
				
				
				

			}
		});
		
		
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton_1.setBounds(539, 183, 83, 27);
		frame.getContentPane().add(btnNewButton_1);
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(32, 511, 310, 41);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\liujianlong\\Desktop\\\u533B\u751F\u5BA2\u6237\u7AEF\\image\\9.jpg"));
		lblNewLabel.setBounds(0, 0, 794, 565);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
