package hospital;

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
	
}
