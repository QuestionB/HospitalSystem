package hospital;

import java.io.IOException;
import java.util.Scanner;

public class Administrators {
	
	 public 	String accountName[]=new String[10];//�˻���
     public  String  password;//����
     public  String type;//����  {����Աadmin��ҽ��doctor��Ժ��president��ҩʦmedicine���շ���Աfee}
     

	public static int yanzheng() throws IOException {
		System.out.println("��½�˺ţ�");
		Scanner input1=new Scanner(System.in);
		String name=input1.nextLine();
		System.out.println("��½���룺");
		Scanner input2 =new Scanner(System.in);
        String passw=input2.nextLine();
        userDataBase db=null;
	    int x;	 		
	 	x=db.DBTestUser(name,passw) ;			
	 	if(x==1){System.out.println("��¼�ɹ�");return 1;}
 		else {return  -1;	} 		
		
		  }
 
	 public static int addUser() {//�����û�
		 System.out.println("ѡ���û����ͣ�");
		 System.out.println("1������Ա  2��ҽ��  3��Ժ��  4��ҩʦ  5���շ���Ա");
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
			System.out.println("�����������������һ��������");
			}
			}
			
			System.out.print("�����˺ţ�  ");
			Scanner input1=new Scanner(System.in);
			String name=input1.nextLine();
			System.out.println();
			System.out.print("�������룺");
			Scanner input2 =new Scanner(System.in);
	        String password=input2.nextLine();
	        System.out.println();
	        userDataBase db=null;
		    int x;	 		
		 	x=db.DBAddUsers(name, password,Numble);
	        
	        return x;
	        
	    }
	 
	 public static int delUser() {//ɾ���û�
		 System.out.print("����Ҫɾ�����˺ţ� \t");
			Scanner input1=new Scanner(System.in);
			String name=input1.nextLine();
		 
			   userDataBase db=null;
			    int x;	 		
			 	x=db.DBDeleteUsers(name);
                return x;
	
	 }
	 
	 public static void  printUser() {//��ʾ�û�
		 userDataBase db=null;
		 db.DBPrintUser();     }
}

