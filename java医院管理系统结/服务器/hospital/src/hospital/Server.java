package hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Server {
	public static  String patientName=null;
	public static  int symbol=0;//1为医生开新单
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Administrators admin = null;
		//Swing s=null;
		//s.main(args);;
     // int i=  admin.yanzheng();
   //  i=  admin.addUser();
   //  int i=admin.delUser();
     // admin.printUser();
		
//doctor doc4=null;
//doc4.kaiYao(123);
		
		
	   /*InetAddress ia=null;
	        try {
	            ia=ia.getLocalHost();
	             
	            String localname=ia.getHostName();
	            String localip=ia.getHostAddress();
	            System.out.println("本机名称是："+ localname);
	            System.out.println("本机的ip是 ："+localip);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }*/
		
		
		   int port = 8877;  
            //定义一个ServerSocket监听在端口8899上  
		     ServerSocket server = new ServerSocket(port);  
		      while (true) {  
		         //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的  
		         Socket socket = server.accept();  
		         //每接收到一个Socket就建立一个新的线程来处理它  
		         new Thread(new Task(socket)).start();  
		      }  
		   }  
	 public static int find_line(String keshi,String patientname){	       
		
		 
			for(int i=0;doctor.line[i]!=null;i++){doctor.line[i]=null;
		    }
			 switch(keshi){
			case "内科":System.arraycopy(doctor.neike, 0, doctor.line, 0, doctor.neike.length); break;
			case "外科":System.arraycopy(doctor.waike, 0, doctor.line, 0, doctor.waike.length); break;
			case "儿科":System.arraycopy(doctor.erke, 0, doctor.line, 0, doctor.erke.length); break;
			case "妇产科":System.arraycopy(doctor.fuchanke, 0, doctor.line, 0, doctor.fuchanke.length); break;
			case "五官科":System.arraycopy(doctor.wuguanke, 0, doctor.line, 0, doctor.wuguanke.length); break;
			case "皮肤科":System.arraycopy(doctor.pifuke, 0, doctor.line, 0, doctor.pifuke.length); break;
			case "传染病科":System.arraycopy(doctor.chuanranbingke, 0, doctor.line, 0, doctor.chuanranbingke.length); break;
			case "肛肠科":System.arraycopy(doctor.gangchangke, 0, doctor.line, 0, doctor.gangchangke.length); break;
			
			
			}
		 
			for(int i=0;doctor.line[i]!=null&&i<20;i++){
                if(doctor.line[i].compareTo(patientname)==0)return (i+1);
			
		    }
	 
		 return   0;
		 }
		     
		   /** 
		    * 用来处理Socket请求的 
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
		        
		            if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收  
		             sb.append(temp.substring(0, index));  
		                break;  
		            }  
		            sb.append(temp);  
		         }  
		         String s=sb.toString();
		       System.out.println(sb);    
		        //读完后写一句  
		       Writer writer = new OutputStreamWriter(socket.getOutputStream());  
		      
	
		       
		       String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
		      
		      
				
				int tN=Integer.parseInt(strs[3]); 
              String name=strs[0];
             
            
                          String isSuccess=null;
                          String x=null;
	                      switch(tN){
	                        
			               case 1: x=patient.addUser(s);break; //病人客户端的注册
			               case 2: x=patient.orders(s);break;//病人预约
	                       case 3: System.out.println("text2");x=Administrators.yanzheng(s);
	                       
	                       System.out.println(x);break;//病人登陆
	                       case 4: x=doctor.kaiYao(s); break;  //医生开药
	                       case 5:x=doctor.kaiYao(s); break;  //医院客户端登录
	                       case 6:x=patient.addUser(s);int y,y1,y2;
	                              String keshi=strs[6];
	                             // String strsx[]=x.split(","); 
	                              y=Integer.parseInt(x.trim());
	                             // System.out.println(y);
	                              if(y==1){String info=strs[0]+","+0+","+strs[5]+","+","+keshi;System.out.println(info);
	                            	  String q=patient.orders(info);
	                                         //String strsx2[]=q.split(","); 
	                                         y1=Integer.parseInt(q.trim());
	                                         x="1,"+y1;
	                                      }
	                              else if(y==4){
	                            	y2= find_line( keshi,name);
	                            	  x="2,"+y2;
	                              }
	                               break;
	                       
	                       
	                       case 7:x=hostpitalDataBase.DBPMedicine(strs[0],1);break;
	                       case 8:hostpitalDataBase.DBChange(strs[0],3,0,"text");x="success" ; break;
	                       case 9:patientName=strs[0];symbol=1;x="success";break;
	                       case 10:if(symbol==1){x=hostpitalDataBase.DBPMedicine(patientName,2);symbol=0;}else {x=""+","+""+","+0;} break;
	                       case 11:int nq=Integer.parseInt(strs[4]) ;if(nq==1)x=patient.addUser(s);//添加
	                                if(nq==2){ int ss=hostpitalDataBase.DBDeleteUsers(strs[0].toString());x=ss+"";}break;
	                       case 12: int ss=hostpitalDataBase.DBMedicine(s);x=ss+""; x=ss+"";break;
                                  
	                    	   
	                    	   
	                    	   
	                    	   
	                          }

                          
	                    
	                      isSuccess=x;
	       		       
	       		         writer.write(isSuccess);  
	       		         writer.write("eof\n");  
	       		         writer.flush();  
	       		         writer.close();      
	               
	       		         
	       		  /*    for(int i = 0;i<doctor.neike.length;i++){
	       		       System.out.println(doctor.neike[i]+"1");

	       		   }
	       		       */  
	       		         
	       		         
	       		         
	                      

			         br.close();  
			         socket.close();  
			      }  
			   }  
			
		      
		   }  
		  
		      
		      
		      
	      
	      
	      
	    



