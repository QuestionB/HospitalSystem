package hospital;

public class patient {

    public  int id;
	public 	String patientName;//����
	public int age;//����
	public String sex;//�Ա�
	public int order;//ԤԼ
	public int fee;//����
	public int pay;//����
	public int room;//���ƣ�Ƥ���ơ���ٿơ�����ơ�����
	
	public int getFee(){return fee;}
	public String getName(){return patientName;}
	public int getOrder(){return order;}
	
	
    public void changeOrder(int x){order=x;}
    public void changeFee(int money){fee=fee+money;}
	
}
