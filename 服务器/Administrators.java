package hospital;

import java.io.IOException;
import java.util.Scanner;

public class Administrators {
	
	 public 	String accountName[]=new String[10];//账户名
     public  String  password;//密码
     public  String type;//类型  {管理员admin、医生doctor、院长president、药师medicine、收费人员fee}
     

	public static String yanzheng(String infomation) throws IOException {
		
		 String strs[]=infomation.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]="" ，strs[3]=tN;
		 String name=strs[0];
		 String passw=strs[1];
         hostpitalDataBase db=null;
	     String x;	 		
	 	 x=db.DBTestUser(name,passw) ;	//数据库调用		
 		 return  x;			
		
		   }
 
	 public static int addUser() {//增加用户
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
			
			System.out.print("输入账号：  ");
			Scanner input1=new Scanner(System.in);
			String name=input1.nextLine();
			System.out.println();
			System.out.print("输入密码：");
			Scanner input2 =new Scanner(System.in);
	        String password=input2.nextLine();
	        System.out.println();
	        hostpitalDataBase db=null;
		    int x;	 		
		 	x=db.DBAddUsers(name, password,Numble);
	        
	        return x;
	        
	    }
	 
	 public static int delUser() {//删除用户
		 System.out.print("输入要删除的账号： \t");
			Scanner input1=new Scanner(System.in);
			String name=input1.nextLine();
		 
			   hostpitalDataBase db=null;
			    int x;	 		
			 	x=db.DBDeleteUsers(name);
                return x;
	
	 }
	 
	 public static void  printUser() {//显示用户
		 hostpitalDataBase db=null;
		 db.DBPrintUser();     }
}

