package hospital;

import java.util.Scanner;

public class patient {

    public  int id;
	public 	String patientName;//姓名
	public int age;//年龄
	public String sex;//性别
	public int order;//预约
	public int fee;//费用
	public int pay;//付款
	public int room;//病科：皮肤科、五官科、五脏科、……
	
	public int getFee(){return fee;}
	public String getName(){return patientName;}
	public int getOrder(){return order;}
	
	
    public void changeOrder(int x){order=x;}
    public void changeFee(int money){fee=fee+money;}
    
    
    
	 public static void addUser(String infomation) {//增加用户   infomation=账号，密码，类型
	
	
		 int Numble=1;
		 String strs[]=infomation.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=类型
		
			
			
			String name=strs[0];
		
	        String password=strs[1];
	        Numble=Integer.parseInt(strs[2]);
	        hostpitalDataBase db=null;
		    int x;	 		
		 	x=db.DBAddUsers(name, password,Numble);
	        
	       
	    }
	
}
