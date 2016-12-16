package hospital;

import java.util.Scanner;

public class register {//挂号收费端
	
	public int newPatient(patient p,int count){//挂号
		 int Numble=1;
		if(p.order==1){System.out.println("病人已经预约。！\r-----------基本信息----------");
		System.out.println("姓名："+p.getName());
		System.out.println("性别"+p.sex);
		System.out.println("年龄"+p.age);
		System.out.println("科室："+p.room);
		System.out.println("请病人确认信息。是否进行修改（1. 是       2. 否）");
		
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
			System.out.println("输入错误，请重新输入一个整数：");
			System.out.println("请病人确认信息。是否进行修改（1. 是       2. 否）");
			}
			}
		if( Numble==2) return p.id;
		
		
	}
		
		if(p.order==0||Numble==1) {System.out.println("填写病人基本信息。！\r-----------基本信息----------");
		System.out.println("姓名：");
		Scanner input1=new Scanner(System.in);
		p.patientName=input1.nextLine();
		System.out.println("性别:");
		p.sex=input1.nextLine();
		System.out.println("年龄:");
		p.age=input1.nextInt();
		System.out.println("科室：");
		p.room=input1.nextInt();
		p.id=count;
		System.out.println("病人挂号数为:"+count);}
		return count;

	
	}
	
	public int receivable(patient p){//收费  成功返回1失败返回0
		System.out.println("应付款为："+p.fee );
		System.out.println("是否收款：    （1.收款成功           2.待病人付款）");
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
		System.out.println("输入错误，请重新输入一个整数：");
		System.out.println("应付款为："+p.fee );
		System.out.println("是否收款：    （1.收款成功           2.待病人付款）");
		}
		}
		if(change==1){p.pay=p.fee;p.fee=0;return 1;}
		else if (change==2) return 0;
		return 0;
		
		
	}
	
	
}
