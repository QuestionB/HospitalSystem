package hospital;
import java.sql.*;
import java.util.Scanner;

public class userDataBase {

	public static int DBTestUser(String name,String password){//��֤�û�
	   Connection con=null;
			//�������ݿ���������
	           try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           //�������ݿ�����
	           try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           Statement st=null;
			//if(con!=null)System.out.println("���ӳɹ���");
	           try {
				 st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	        String sql1="select * from USERS where name='"+name+"'";   
	           
	           String sql="select * from USERS";
	   		ResultSet rs=null;//��Ų�ѯ���
	   		
	   		try {
				rs=st.executeQuery(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   		String passw = null;
	   		String names;
	   		int id,symbol=0;
	   		try {
				while(rs.next()){
					 //id=rs.getInt("id");
					 names=rs.getString("name");
					 passw=rs.getString("password");
					passw=passw.trim();//ȥ���ַ�����ո�
					 symbol=1;
					
				}if(symbol==0)System.out.println("�û���������");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		
	   		
	   		//�ر�����
		   
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((password.compareTo(passw))==0){System.out.println("��¼�ɹ�");return 1;}
	 		else {System.out.println("�������");return  -1;	} 	
		
		
		
}
	

	public static int DBAddUsers(String name,String password,int type){
		   Connection con=null;
				//�������ݿ���������
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //�������ݿ�����
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
				//if(con!=null)System.out.println("���ӳɹ���");
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           
		 
		        String sql2="select * from USERS where name='"+name+"'";   
	
		   		ResultSet rs=null;//��Ų�ѯ���
		   		
		   		try {
					rs=st.executeQuery(sql2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		
		   		String names;
		   		int id,symbol=0;
		   		
		   		try {
					while(rs.next()){
						 //id=rs.getInt("id");
						System.out.println("�û����Ѵ���");return  -1;
		
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		name=name.trim();
		   		password=password.trim();
		   		//String sql="insert into student values(3333,'����','Ů','����·','0215527111',"+age+")";
		   		String sql3="insert into USERS values('"+name+"','"+password+"','"+type+"')";
		   		try {
				  symbol=	st.executeUpdate(sql3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
		   		//�ر�����
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(symbol==1){System.out.println("�����û��ɹ�");return 1;}
			 else return -1;
		
	}

	
	public static int DBDeleteUsers(String name){
		   Connection con=null;
				//�������ݿ���������
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //�������ݿ�����
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
				//if(con!=null)System.out.println("���ӳɹ���");
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           
		 
		        String sql2="select * from USERS where name='"+name+"'";   
	
		   		ResultSet rs=null;//��Ų�ѯ���
		   		
		   		try {
					rs=st.executeQuery(sql2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		
		   		String names;
		   		int id,symbol=0;
		   		
		   		try {
					if(!rs.next()){					
						System.out.println("�û�������!"); 
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		name=name.trim();
		   	
		   	
		   		String sql4="delete from USERS where name='"+name+"'";   
		   		try {
				  symbol=	st.executeUpdate(sql4);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
		   		//�ر�����
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(symbol!=0){System.out.println("ɾ���û��ɹ�");return 1;}
			 else return -1;
		
	}

	public static void DBPrintUser(){//��ʾ�û�
		   Connection con=null;
				//�������ݿ���������
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //�������ݿ�����
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           
		        String sql5="select * from USERS ";   
   		        ResultSet rs=null;//��Ų�ѯ���
		   		
		   		try {
					rs=st.executeQuery(sql5);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   	
		   		int symbol=0;
		   		try {
					while(rs.next()){
						System.out.print("�û�����"+rs.getString("name")+"�˻�����:");
						switch(rs.getInt("type")){
						case 1:System.out.println("����Ա"); break;
						case 2:System.out.println("ҽ��"); break;
						case 3:System.out.println("Ժ��"); break;
						case 4:System.out.println("ҩʦ"); break;
						case 5:System.out.println("�շ���Ա"); break;		
						}
                    	 symbol=1;
						
					}if(symbol==0)System.out.println("��ǰ���û���");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 		
		   		
		   		//�ر�����
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
	}
	

	public static int DBPatientMedicine(String name,int patientID,int x){//�����˿�ҩ��  x=1ʱ nameΪҩƷ�� x=0ʱ��nameΪƴ��
		   Connection con=null;                                          //��ҩ�ɹ�����1�����򷵻�0
				//�������ݿ���������
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //�������ݿ�����
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           
		        String sql6=null;   
		        if(x==1)sql6="select * from Medicine where  name='"+name+"'";  
		        if(x==2)sql6="select * from Medicine where  PinYin='"+name+"'";  
		        ResultSet rs=null;//��Ų�ѯ���
		   		
		   		try {
					rs=st.executeQuery(sql6);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		int judge=0;
		   		int numble=0;
		   		int price=0;
		   		String Mname=null;//ҩƷ����
		   		
		   				
  		
		   		
		   		int symbol=0;
		   		try {
					while(rs.next()){
						
						price=rs.getInt("price");
						Mname=rs.getString("name");
				   		Mname=Mname.trim();
				   		System.out.println("������Ҫ   "+Mname+"  ����:");
				   		
		;		   		while(judge==0)
						{
						try
						{
							Scanner sc=new Scanner(System.in);
							numble=sc.nextInt();
						if(numble>0)judge=1;
						}catch(Exception e)
						{
						System.out.println("�����������������һ��������");
						}if(numble<=0)System.out.println("������������"); 
						} symbol=1;
						}
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(symbol==0){System.out.println("���޴�ҩ��");return 0;}
				String sql7="insert into patientMedicine values("+patientID+",'"+Mname+"',"+numble+","+price+","+price*numble+")";
				
				try {
					  symbol=	st.executeUpdate(sql7);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
		   		
		   		//�ر�����
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 1;
			
			
	}
	



}