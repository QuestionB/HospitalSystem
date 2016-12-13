package hospital;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Administrators {
	
	 public 	String accountName[]=new String[10];//账户名
     public  String  password;//密码
     public  String type;//类型  {管理员admin、医生doctor、院长president、药师medicine、收费人员fee}
     

	public static int yanzheng() throws IOException {
		System.out.println("登陆账号：");
		Scanner input1=new Scanner(System.in);
		String name=input1.nextLine();
		System.out.println("登陆密码：");
		Scanner input2 =new Scanner(System.in);
        String passw=input2.nextLine();
    	    HashMap<String,String> hashmap=new HashMap<String,String>();
	        FileReader fileReader = null;  
			BufferedReader bufferedReader = null; 
			fileReader = new FileReader(".\\user.txt");
			bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			String line2;
			while (line != null) {
      	                           line2 = bufferedReader.readLine();
			                       hashmap.put(line,line2);
			                       line = bufferedReader.readLine();}			
	 		String x;	 		
	 		try
			{
	 			x=hashmap.get(name);	 			
	 	  	 	if((x.compareTo(passw))==0){System.out.println("登录成功");return 1;}
	 	 		else {System.out.println("密码错误");return  -1;	} 		
	 		 		
			}catch(Exception e)
			{
			System.out.println("用户名不存在：");
			}		
           	 return 0;
			
		  }
 
	 public static void addUser() {//增加用户
		 System.out.println("选择用户类型：");
		 System.out.println("1：管理员  2：医生  3：院长  4：药师  5：收费人员");
		 int judge=0;
		 int Numble=1;
			while(judge==0)
			{
			try
			{
				Scanner sc=new Scanner(System.in);
				Numble=sc.nextInt();
			if(Numble>=1&&Numble<=5)judge=1;
			}catch(Exception e)
			{
			System.out.println("输入错误，请重新输入一个整数：");
			}
			}
			switch(Numble){
			case 1: System.out.print("管理员账号开头为a：  ");
			case 2:System.out.print("医生账号开头为d：  ");
			case 3:System.out.print("院长账号开头为p：  ");
			case 4:System.out.print("药师员账号开头为m：  ");
			case 5:System.out.print("收费人员账号开头为f：  ");	
	
			}
			System.out.print("输入账号：  ");
			Scanner input1=new Scanner(System.in);
			String name=input1.nextLine();
			System.out.println();
			System.out.print("输入密码：");
			Scanner input2 =new Scanner(System.in);
	        String password=input2.nextLine();
	        System.out.println();
	        
	        BufferedWriter bufferedWriter = null;

	        try {

	        
	        bufferedWriter = new BufferedWriter(new FileWriter(".\\user.txt",true));

	        bufferedWriter.newLine();
	        bufferedWriter.write(name);
	        bufferedWriter.newLine();
	        bufferedWriter.write(password);

	        } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	        } catch (IOException ex) {
	        ex.printStackTrace();
	        } finally {
	        //Close the BufferedWriter
	        try {
	        if (bufferedWriter != null) {
	        bufferedWriter.flush();
	        bufferedWriter.close();
	        }
	        } catch (IOException ex) {
	        ex.printStackTrace();
	        }
	        }
	        
	        
	    }
     
    	 
     }
     

