package hospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Administrators admin = null;
       int i=  admin.yanzheng();if(i==1)System.out.println("��½�ɹ�");
      else if(i==-1) System.out.println("���벻׼ȷ");
       
       admin.addUser();
       
       
       
	}
	
	
	

}
