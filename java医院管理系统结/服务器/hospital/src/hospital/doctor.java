package hospital;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Date;

public class doctor {
	
	public int room;//科室
	 public static  	String line[]=new String[20];//病人队列
	 public static  	String neike[]=new String[20];
	 public static  	String waike[]=new String[20];
	 public static  	String erke[]=new String[20];
	 public static  	String fuchanke[]=new String[20];
	 public static  	String wuguanke[]=new String[20];
	 public static  	String pifuke[]=new String[20];
	 public static  	String chuanranbingke[]=new String[20];
	 public static  	String gangchangke[]=new String[20];
	 
	 
	 
	 public static int times(){	       
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

public static  int line(String patientId,int order,int order_time,String keshi){//病人排队    病人                                                        //号，0不预约，1预约，  order_time 预约时间 day*24*60+hour*60+minute
	
	for(int i=0;line[i]!=null;i++){line[i]=null;
    }
	 switch(keshi){
	case "内科":System.arraycopy(neike, 0, line, 0, neike.length); break;
	case "外科":System.arraycopy(waike, 0, line, 0, waike.length); break;
	case "儿科":System.arraycopy(erke, 0, line, 0, erke.length); break;
	case "妇产科":System.arraycopy(fuchanke, 0, line, 0, fuchanke.length); break;
	case "五官科":System.arraycopy(wuguanke, 0, line, 0, wuguanke.length); break;
	case "皮肤科":System.arraycopy(pifuke, 0, line, 0, pifuke.length); break;
	case "传染病科":System.arraycopy(chuanranbingke, 0, line, 0, chuanranbingke.length); break;
	case "肛肠科":System.arraycopy(gangchangke, 0, line, 0, gangchangke.length); break;
	
	
	}
		
	int x=0;
		 int i=0;
         if(order==1){
                       int nows=times();
                       System.out.println(order_time-nows);
                       if(order_time-nows<=60){//预约时间在一小时内
                        for (i = 20 - 1; i > 0; i--)  //排队最多20人
                      {line[i] = line[i - 1];}          
                       line[0]=patientId;//排在首位}
                       System.out.println("排队成功,排在第1位");
                       
                       switch(keshi){
                   	case "内科":for(int i1=0;neike[i1]!=null;i1++){neike[i1]=null;} System.arraycopy(line, 0, neike, 0, line.length);break;
                   	case "外科":for(int i1=0;waike[i1]!=null;i1++){waike[i1]=null;} System.arraycopy(line, 0, waike, 0, line.length);break;
                	case "儿科":for(int i1=0;erke[i1]!=null;i1++){erke[i1]=null;} System.arraycopy(line, 0, erke, 0, line.length);break;
                	case "妇产科":for(int i1=0;fuchanke[i1]!=null;i1++){fuchanke[i1]=null;} System.arraycopy(line, 0, fuchanke, 0, line.length);break;
                	case "五官科":for(int i1=0;wuguanke[i1]!=null;i1++){wuguanke[i1]=null;} System.arraycopy(line, 0, wuguanke, 0, line.length);break;
                	case "皮肤科":for(int i1=0;pifuke[i1]!=null;i1++){pifuke[i1]=null;} System.arraycopy(line, 0, pifuke, 0, line.length);break;
                	case "传染病科":for(int i1=0;chuanranbingke[i1]!=null;i1++){chuanranbingke[i1]=null;} System.arraycopy(line, 0, chuanranbingke, 0, line.length);break;
                	case "肛肠科":for(int i1=0;gangchangke[i1]!=null;i1++){gangchangke[i1]=null;} System.arraycopy(line, 0, gangchangke, 0, line.length);break;
                   	
                   	
                   	}
             
                       return 1;	

                      }
                       else if(order_time-nows>60){  for( i=0;line[i]!=null;i++){
                            }line[i]=patientId;
           		        System.out.println("排队成功,排在第"+(i+1)+"位"); 
           		     switch(keshi){
                    	case "内科":for(int i1=0;neike[i1]!=null;i1++){neike[i1]=null;} System.arraycopy(line, 0, neike, 0, line.length);break;
                    	case "外科":for(int i1=0;waike[i1]!=null;i1++){waike[i1]=null;} System.arraycopy(line, 0, waike, 0, line.length);break;
                 	case "儿科":for(int i1=0;erke[i1]!=null;i1++){erke[i1]=null;} System.arraycopy(line, 0, erke, 0, line.length);break;
                 	case "妇产科":for(int i1=0;fuchanke[i1]!=null;i1++){fuchanke[i1]=null;} System.arraycopy(line, 0, fuchanke, 0, line.length);break;
                 	case "五官科":for(int i1=0;wuguanke[i1]!=null;i1++){wuguanke[i1]=null;} System.arraycopy(line, 0, wuguanke, 0, line.length);break;
                 	case "皮肤科":for(int i1=0;pifuke[i1]!=null;i1++){pifuke[i1]=null;} System.arraycopy(line, 0, pifuke, 0, line.length);break;
                 	case "传染病科":for(int i1=0;chuanranbingke[i1]!=null;i1++){chuanranbingke[i1]=null;} System.arraycopy(line, 0, chuanranbingke, 0, line.length);break;
                 	case "肛肠科":for(int i1=0;gangchangke[i1]!=null;i1++){gangchangke[i1]=null;} System.arraycopy(line, 0, gangchangke, 0, line.length);break;
                    	
                    	
                    	}
           		        
           		        
           		        
           		        return (i+1);		}	    
         
         
         }

         else{  for( i=0;line[i]!=null;i++){
               } line[i]=patientId;
		        System.out.println("排队成功,排在第"+(i+1)+"位");	}
         
         switch(keshi){
        	case "内科":for(int i1=0;neike[i1]!=null;i1++){neike[i1]=null;} System.arraycopy(line, 0, neike, 0, line.length);break;
        	case "外科":for(int i1=0;waike[i1]!=null;i1++){waike[i1]=null;} System.arraycopy(line, 0, waike, 0, line.length);break;
     	case "儿科":for(int i1=0;erke[i1]!=null;i1++){erke[i1]=null;} System.arraycopy(line, 0, erke, 0, line.length);break;
     	case "妇产科":for(int i1=0;fuchanke[i1]!=null;i1++){fuchanke[i1]=null;} System.arraycopy(line, 0, fuchanke, 0, line.length);break;
     	case "五官科":for(int i1=0;wuguanke[i1]!=null;i1++){wuguanke[i1]=null;} System.arraycopy(line, 0, wuguanke, 0, line.length);break;
     	case "皮肤科":for(int i1=0;pifuke[i1]!=null;i1++){pifuke[i1]=null;} System.arraycopy(line, 0, pifuke, 0, line.length);break;
     	case "传染病科":for(int i1=0;chuanranbingke[i1]!=null;i1++){chuanranbingke[i1]=null;} System.arraycopy(line, 0, chuanranbingke, 0, line.length);break;
     	case "肛肠科":for(int i1=0;gangchangke[i1]!=null;i1++){gangchangke[i1]=null;} System.arraycopy(line, 0, gangchangke, 0, line.length);break;
        	
        	
        	}
		         return (i+1);	
}
	
	  public static String kaiYao(String s){//医生开药   j=1药品全称 ，j=2拼音
		  
		  String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
		  String patientID=strs[0];
		  int j=Integer.parseInt(strs[1]);
		  String name=strs[2];
			int tN=Integer.parseInt(strs[3]);
			int numble=Integer.parseInt(strs[4]);
    
		  
		  
		 String k;
		  hostpitalDataBase db=null;
			System.out.print(patientID+"患者开药中 …………");
         	 name=name.trim();
               k= db.DBPatientMedicine(name,patientID,j,numble);   
               return k;
	  
	  }
	 
	

}
	  


