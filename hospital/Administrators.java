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
	 	  	 	if((x.compareTo(passw))==0){System.out.println("��¼�ɹ�");return 1;}
	 	 		else {System.out.println("�������");return  -1;	} 		
	 		 		
			}catch(Exception e)
			{
			System.out.println("�û��������ڣ�");
			}		
           	 return 0;
			
		  }
 
	 public static void addUser() {//�����û�
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
			switch(Numble){
			case 1: System.out.print("����Ա�˺ſ�ͷΪa��  ");
			case 2:System.out.print("ҽ���˺ſ�ͷΪd��  ");
			case 3:System.out.print("Ժ���˺ſ�ͷΪp��  ");
			case 4:System.out.print("ҩʦԱ�˺ſ�ͷΪm��  ");
			case 5:System.out.print("�շ���Ա�˺ſ�ͷΪf��  ");	
	
			}
			System.out.print("�����˺ţ�  ");
			Scanner input1=new Scanner(System.in);
			String name=input1.nextLine();
			System.out.println();
			System.out.print("�������룺");
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
     

