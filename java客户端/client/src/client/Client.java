package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	 static String host = "192.168.226.1";  //要连接的服务端IP地址  
     static int port = 8877;   //要连接的服务端对应的监听端口  
     //与服务端建立连接  
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		addUser("fucker","fuckes",2);
	
		   }  
	
	
	
	 public static void addUser(String name,String passWord,int i) throws IOException {
		 
		 
	      //为了简单起见，所有的异常都直接往外抛  
		    
		     Socket client = new Socket(host, port);  
		      //建立连接后就可以往服务端写数据了  
		     Writer writer = new OutputStreamWriter(client.getOutputStream());  
		      writer.write(name+","+passWord+","+i);  writer.flush();  
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
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		}  