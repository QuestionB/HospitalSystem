package hospital;

import java.util.Scanner;

public class register {//�Һ��շѶ�
	
	public int newPatient(patient p,int count){//�Һ�
		 int Numble=1;
		if(p.order==1){System.out.println("�����Ѿ�ԤԼ����\r-----------������Ϣ----------");
		System.out.println("������"+p.getName());
		System.out.println("�Ա�"+p.sex);
		System.out.println("����"+p.age);
		System.out.println("���ң�"+p.room);
		System.out.println("�벡��ȷ����Ϣ���Ƿ�����޸ģ�1. ��       2. ��");
		
		 int judge=0;
		
			while(judge==0)
			{
			try
			{
				Scanner sc=new Scanner(System.in);
				Numble=sc.nextInt();
			if(Numble>=1&&Numble<=2)judge=1;
			}catch(Exception e)
			{
			System.out.println("�����������������һ��������");
			System.out.println("�벡��ȷ����Ϣ���Ƿ�����޸ģ�1. ��       2. ��");
			}
			}
		if( Numble==2) return p.id;
		
		
	}
		
		if(p.order==0||Numble==1) {System.out.println("��д���˻�����Ϣ����\r-----------������Ϣ----------");
		System.out.println("������");
		Scanner input1=new Scanner(System.in);
		p.patientName=input1.nextLine();
		System.out.println("�Ա�:");
		p.sex=input1.nextLine();
		System.out.println("����:");
		p.age=input1.nextInt();
		System.out.println("���ң�");
		p.room=input1.nextInt();
		p.id=count;
		System.out.println("���˹Һ���Ϊ:"+count);}
		return count;

	
	}
	
	public int receivable(patient p){//�շ�  �ɹ�����1ʧ�ܷ���0
		System.out.println("Ӧ����Ϊ��"+p.fee );
		System.out.println("�Ƿ��տ    ��1.�տ�ɹ�           2.�����˸��");
		int judge=0;
		int change=2;
		while(judge==0)
		{
		try
		{
			Scanner sc=new Scanner(System.in);
			change=sc.nextInt();
		if(change>=1&&change<=2)judge=1;
		}catch(Exception e)
		{
		System.out.println("�����������������һ��������");
		System.out.println("Ӧ����Ϊ��"+p.fee );
		System.out.println("�Ƿ��տ    ��1.�տ�ɹ�           2.�����˸��");
		}
		}
		if(change==1){p.pay=p.fee;p.fee=0;return 1;}
		else if (change==2) return 0;
		return 0;
		
		
	}
	
	
}
