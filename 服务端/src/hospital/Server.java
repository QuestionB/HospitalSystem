package hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Administrators admin = null;
		//Swing s=null;
		//s.main(args);;
     // int i=  admin.yanzheng();
   //  i=  admin.addUser();
   //  int i=admin.delUser();
    //   admin.printUser();
		
//doctor doc4=null;
//doc4.kaiYao(123);


		   int port = 8877;  
            //����һ��ServerSocket�����ڶ˿�8899��  
		     ServerSocket server = new ServerSocket(port);  
		      while (true) {  
		         //server���Խ�������Socket����������server��accept����������ʽ��  
		         Socket socket = server.accept();  
		         //ÿ���յ�һ��Socket�ͽ���һ���µ��߳���������  
		         new Thread(new Task(socket)).start();  
		      }  
		   }  
		     
		   /** 
		    * ��������Socket����� 
		   */  
  static class Task implements Runnable {  
		   
		      private Socket socket;  
		        
		      public Task(Socket socket) {  
		         this.socket = socket;  
		      }  
		        
		      public void run() {  
		         try {  
		            handleSocket();  
		         } catch (Exception e) {  
		            e.printStackTrace();  
		         }  
		      }  
		    
 private void handleSocket() throws Exception {  
		         BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
		         StringBuilder sb = new StringBuilder();  
		         String temp;  
		         int index;  
		         while ((temp=br.readLine()) != null) {  
		        
		            if ((index = temp.indexOf("eof")) != -1) {//����eofʱ�ͽ�������  
		             sb.append(temp.substring(0, index));  
		                break;  
		            }  
		            sb.append(temp);  
		         }  
		         String s=sb.toString();
		       System.out.println(sb);   
		     /*    //�����дһ��  
		       Writer writer = new OutputStreamWriter(socket.getOutputStream());  
		       
		       Scanner input=new Scanner(System.in);
		       String x=input.nextLine();
		       
		       
		         writer.write(x);  
		         writer.write("eof\n");  
		         writer.flush();  
		         writer.close();  */
		       
		       patient p=null;
		       p.addUser(s);
		         br.close();  
		         socket.close();  
		      }  
		   }  
		
	      
	   }  
	  
	      
	      
	      
	    



