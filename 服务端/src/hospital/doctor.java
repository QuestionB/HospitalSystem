package hospital;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class doctor {
	
	public int room;//科室
	 public static 	int line[]=new int[20];//病人队列
	
	 public static int line(int patientId){//病人排队 
		 int symbol=0;
		 int i=0;
		for( i=0;line[i]!=0;i++){}
		line[i]=patientId;
		 System.out.println("排队成功,排在第"+i+1+"位");		 
		 return symbol;	 
	 }
	
	  public static void kaiYao(int patientID){//医生开药
		  int i=2,j=0,k,m=0,judge=0;
		  String name;
		  hostpitalDataBase db=null;
			
			while(judge==0)
			{
			try
			{
				  System.out.print("选择输入法：  1.药品全名     2.药品拼音首字母  ");
					Scanner input1=new Scanner(System.in);
					j=input1.nextInt();
					System.out.println();
			if(j==1||j==2)judge=1;
			else System.out.println("选择错误，重新选择"); 
			}catch(Exception e)
			{
			System.out.println("输入错误，请重新输入一个整数：");
			}
			}

			
		  do{   
			  
			  
			  
			  BufferedReader buf = null;
				buf = new BufferedReader(new InputStreamReader(System.in));
				 name = null;
				System.out.print("输入药品名称：  ");
				try {
					name = buf.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			  
			  
			  /*
			  
			  
			  
			  
				System.out.print("输入药品名称：  ");
				Scanner input1=new Scanner(System.in);
				 name=input1.nextLine();*/
				 name=name.trim();
				System.out.println();
				k= db.DBPatientMedicine(name,patientID,j);   
				
				
                 judge=0;
				while(judge==0)
				{
				try
				{
					  System.out.print("继续添加药品？：  1.继续     2.否  ");
						Scanner input2=new Scanner(System.in);
						m=input2.nextInt();
						System.out.println();
				if(m==1||m==2)judge=1;
				else System.out.println("选择错误，重新选择"); 
				}catch(Exception e)
				{
				System.out.println("输入错误，请重新输入一个整数：");
				}
				}
				
				
				
				
				
				
			  
		  }while(m==1);
		
							
	
		  
	  }
	 
	

}
	  


