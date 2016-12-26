package hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class hospital {

	
		 static String host = "169.254.98.25";  //要连接的服务端IP地址  
	     static int port = 8877;   //要连接的服务端对应的监听端口  
	     //与服务端建立连接  
		public static void main(String[] args) throws  IOException {
			// TODO Auto-generated method stub
			
			//patient_window s=null;
		//s.main(args);
		
		
			//	System.out.println(patient_window.information)	;
			
					
			//login("liujianlong20","12354",3);
			//addUser("liujianlong20","1234",2,1);
	       // order("fucker",1,2);
	     
			   }  
		
		
		 public static int time(){	       
			 Date now = new Date(); 
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
			 String hehe = dateFormat.format( now ); 
			 System.out.println(hehe); 
			 Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
			 int year = c.get(Calendar.YEAR); 
			 int month = c.get(Calendar.MONTH); 
			 int date = c.get(Calendar.DATE); 
			 int hour = c.get(Calendar.HOUR_OF_DAY); 
			 int minute = c.get(Calendar.MINUTE); 
			 int second = c.get(Calendar.SECOND); 
			 return   date*24*60+hour*60+minute ;
			 }
		

		 public static String order(String name,String password ,int order,int order_time,int tN,String keshi) throws IOException {  //病人注册 类型号1
			
			    
			     Socket client = new Socket(host, port);  
			      //建立连接后就可以往服务端写数据了  
			     Writer writer = new OutputStreamWriter(client.getOutputStream());  
			      writer.write(name+","+password+","+2+","+tN+","+0+","+order_time+","+keshi);  writer.flush();  
			      writer.write("eof\n");  
			      writer.flush();  
			      //写完以后进行读操作  
			     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  
			      StringBuffer sb = new StringBuffer();  
			      String temp;  
			      int index;  
			     // System.out.println("from server: " + sb);  
			      while ((temp=br.readLine()) != null) {  
			         if ((index = temp.indexOf("eof")) != -1) {  
			            sb.append(temp.substring(0, index));  
			            break;  
			         }  
			         sb.append(temp);  
			      }  
			      System.out.println("服务端: " + sb);  
			      writer.close();  
			      br.close();  
			      client.close(); 
			      int x;
			      String s=sb.toString();
			      String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
			      x=Integer.parseInt(strs[0]);	//接收服务器传来的成功或失败信号	      
			      return  s;
			     
		 }
		
		 public static String kaiyao(String patientID,int shurufa,String Mname,int tN,int numble) throws IOException {//病人预约   类型号tN=2  
			 
			 
		      //为了简单起见，所有的异常都直接往外抛  
			    
			     Socket client = new Socket(host, port);  
			      //建立连接后就可以往服务端写数据了  
			     Writer writer = new OutputStreamWriter(client.getOutputStream());  
			      writer.write(patientID+","+shurufa+","+Mname+","+tN+","+numble);  writer.flush();  //把预约信息传给服务器端           information=账号+预约标志+预约时间+tN
			      writer.write("eof\n");  
			      writer.flush();  
			      //写完以后进行读操作  
			     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  
			      StringBuffer sb = new StringBuffer();  
			      String temp;  
			      int index;  
			     // System.out.println("from server: " + sb);  
			      while ((temp=br.readLine()) != null) {  
			         if ((index = temp.indexOf("eof")) != -1) {  
			            sb.append(temp.substring(0, index));  
			            break;  
			         }  
			         sb.append(temp);  
			      }  
			      System.out.println("服务端: " + sb);  
			      writer.close();  
			      br.close();  
			      client.close();  
			      String s=sb.toString();       
			      return  s;
			      
			     
		 }
		

	public static String login(String name,String passWord,int tN) throws IOException {//医院客户端登陆 类型号3
			
			    
			     Socket client = new Socket(host, port);  
			      //建立连接后就可以往服务端写数据了  
			     Writer writer = new OutputStreamWriter(client.getOutputStream());  
			      writer.write(name+","+passWord+","+","+tN);  writer.flush();  
			      writer.write("eof\n");  
			      writer.flush();  
			      //写完以后进行读操作  
			     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  
			      StringBuffer sb = new StringBuffer();  
			      String temp;  
			      int index;  
			     // System.out.println("from server: " + sb);  
			      while ((temp=br.readLine()) != null) {  
			         if ((index = temp.indexOf("eof")) != -1) {  
			            sb.append(temp.substring(0, index));  
			            break;  
			         }  
			         sb.append(temp);  
			      }  
			      System.out.println("服务端: " + sb);  
			      writer.close();  
			      br.close();  
			      client.close();  
			      
			      String s=sb.toString();
			      
			     
			      return  s;
		 }
		
		
		
	 public static String shouFei(String Pname) throws IOException {  //挂号端收费查询
			
        Socket client = new Socket(host, port);  
	      //建立连接后就可以往服务端写数据了  
	     Writer writer = new OutputStreamWriter(client.getOutputStream());  
	      writer.write(Pname+","+","+","+7);  writer.flush();  
	      writer.write("eof\n");  
	      writer.flush();  
	      //写完以后进行读操作  
	     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  
	      StringBuffer sb = new StringBuffer();  
	      String temp;  
	      int index;  
	     // System.out.println("from server: " + sb);  
	      while ((temp=br.readLine()) != null) {  
	         if ((index = temp.indexOf("eof")) != -1) {  
	            sb.append(temp.substring(0, index));  
	            break;  
	         }  
	         sb.append(temp);  
	      }  
	      System.out.println("服务端: " + sb);  
	      writer.close();  
	      br.close();  
	      client.close();  
	      
	      String s=sb.toString();
	      
	     
	      return  s;
	     
 }
		
	 public static String shouFei2(String Pname) throws IOException {  //挂号端收费
			
	        Socket client = new Socket(host, port);  
		      //建立连接后就可以往服务端写数据了  
		     Writer writer = new OutputStreamWriter(client.getOutputStream());  
		      writer.write(Pname+","+","+","+8);  writer.flush();  
		      writer.write("eof\n");  
		      writer.flush();  
		      //写完以后进行读操作  
		     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  
		      StringBuffer sb = new StringBuffer();  
		      String temp;  
		      int index;  
		     // System.out.println("from server: " + sb);  
		      while ((temp=br.readLine()) != null) {  
		         if ((index = temp.indexOf("eof")) != -1) {  
		            sb.append(temp.substring(0, index));  
		            break;  
		         }  
		         sb.append(temp);  
		      }  
		      System.out.println("服务端: " + sb);  
		      writer.close();  
		      br.close();  
		      client.close();  
		      
		      String s=sb.toString();
		      
		     
		      return  s;
		     
	 }
		
	 public static String  yaodan(String Pname) throws IOException {  //医生开药传去病人ID，让服务器传给药房
			
	        Socket client = new Socket(host, port);  
		      //建立连接后就可以往服务端写数据了  
		     Writer writer = new OutputStreamWriter(client.getOutputStream());  
		      writer.write(Pname+","+","+","+9);  writer.flush();  
		      writer.write("eof\n");  
		      writer.flush();  
		      //写完以后进行读操作  
		     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  
		      StringBuffer sb = new StringBuffer();  
		      String temp;  
		      int index;  
		     // System.out.println("from server: " + sb);  
		      while ((temp=br.readLine()) != null) {  
		         if ((index = temp.indexOf("eof")) != -1) {  
		            sb.append(temp.substring(0, index));  
		            break;  
		         }  
		         sb.append(temp);  
		      }  
		      System.out.println("服务端: " + sb);  
		      writer.close();  
		      br.close();  
		      client.close();  
		      
		      String s=sb.toString();
		      
		     
		      return  s;
		     
	 }
		
		
	 public static String  yaodan2() throws IOException {  //医生开药传去病人ID，让服务器传给药房
			
	        Socket client = new Socket(host, port);  
		      //建立连接后就可以往服务端写数据了  
		     Writer writer = new OutputStreamWriter(client.getOutputStream());  
		      writer.write(0+","+","+","+10);  writer.flush();  
		      writer.write("eof\n");  
		      writer.flush();  
		      //写完以后进行读操作  
		     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  
		      StringBuffer sb = new StringBuffer();  
		      String temp;  
		      int index;  
		     // System.out.println("from server: " + sb);  
		      while ((temp=br.readLine()) != null) {  
		         if ((index = temp.indexOf("eof")) != -1) {  
		            sb.append(temp.substring(0, index));  
		            break;  
		         }  
		         sb.append(temp);  
		      }  
		      System.out.println("服务端: " + sb);  
		      writer.close();  
		      br.close();  
		      client.close();  
		      
		      String s=sb.toString();
		      
		     
		      return  s;
		     
	 }
		
		
		
		
		
		
			}  