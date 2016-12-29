package hospital;
import java.sql.*;
import java.util.Scanner;

public class hostpitalDataBase {

	public static String DBTestUser(String name,String password){//验证用户  //登录
	   Connection con=null;
			//加载数据库驱动程序
	           try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           //建立数据库连接
	           try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           Statement st=null;
			//if(con!=null)System.out.println("连接成功！");
	           try {
				 st=con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	        String sql1="select * from USERS where name='"+name+"'";   
	           
	           String sql="select * from USERS";
	   		ResultSet rs=null;//存放查询结果
	   		
	   		try {
				rs=st.executeQuery(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	   		String passw = null;
	   		String names;
	   		String keshi=null;
	   		int type=0;
	   		int id,symbol=0;
	   		System.out.println("text66666");
	   		try {
				while(rs.next()){
					 //id=rs.getInt("id");
					 names=rs.getString("name");
					 passw=rs.getString("password");
					 keshi=rs.getString("keshi");
					passw=passw.trim();//去除字符串后空格
					 symbol=1;
					 type=rs.getInt("type");
					
				}if(symbol==0){System.out.println("用户名不存在");return 2+","+keshi+","+type; }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		
	   		
	   		//关闭连接
		   
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((password.compareTo(passw))==0){System.out.println("登录成功");return 1+","+keshi+","+type;}
	 		else {System.out.println("密码错误");return 3+","+keshi+","+type;	} 	
		
		
		
}
	

	public static int DBAddUsers(String name,String password,int type){ //注册
		   Connection con=null;
				//加载数据库驱动程序
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //建立数据库连接
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
				//if(con!=null)System.out.println("连接成功！");
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           
		 
		        String sql2="select * from USERS where name='"+name+"'";   
	
		   		ResultSet rs=null;//存放查询结果
		   		
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
						System.out.println("用户名已存在");return  4;
		
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		name=name.trim();
		   		password=password.trim();
		   		//String sql="insert into student values(3333,'龙王','女','军工路','0215527111',"+age+")";
		   		String sql3="insert into USERS values('"+name+"','"+password+"','"+type+"',0,0,0,0,0)";
		   		try {
				  symbol=	st.executeUpdate(sql3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
		   		//关闭连接
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(symbol==1){System.out.println("添加用户成功");return 1;}
			 else return 4;
		
	}

	
	public static int DBDeleteUsers(String name){
		   Connection con=null;
				//加载数据库驱动程序
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //建立数据库连接
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
				//if(con!=null)System.out.println("连接成功！");
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           
		 
		        String sql2="select * from USERS where name='"+name+"'";   
	
		   		ResultSet rs=null;//存放查询结果
		   		
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
						System.out.println("用户不存在!"); 
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
	
		   		//关闭连接
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(symbol!=0){System.out.println("删除用户成功");return 1;}
			 else return -1;
		
	}

	public static void DBPrintUser(){//显示用户
		   Connection con=null;
				//加载数据库驱动程序
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //建立数据库连接
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
   		        ResultSet rs=null;//存放查询结果
		   		
		   		try {
					rs=st.executeQuery(sql5);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   	
		   		int symbol=0;
		   		try {
					while(rs.next()){
						System.out.print("用户名："+rs.getString("name")+"账户类型:");
						switch(rs.getInt("type")){
						case 1:System.out.println("管理员"); break;
						case 2:System.out.println("医生"); break;
						case 3:System.out.println("院长"); break;
						case 4:System.out.println("药师"); break;
						case 5:System.out.println("收费人员"); break;		
						}
                    	 symbol=1;
						
					}if(symbol==0)System.out.println("当前无用户！");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 		
		   		
		   		//关闭连接
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
	}
	

	public static String DBPatientMedicine(String name,String patientID,int x,int numble){//给病人开药单  x=1时 name为药品名  x=2时，name为拼音
		   Connection con=null;                                          //开药成功返回1，否则返回0 所需数量
				//加载数据库驱动程序
		System.out.println("开药……");
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //建立数据库连接
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
		        ResultSet rs=null;//存放查询结果
		   		
		   		try {
					rs=st.executeQuery(sql6);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		int judge=0;
		   		//int numble=0;
		   		int price=0;
		   		String Mname=null;//药品名称
		   		
		   		String information=null;//传往客户端信息   =药品名，单价，类型		
  		
		   		
		   		int symbol=0;
		   		try {
					while(rs.next()){
						
						price=rs.getInt("price");
						Mname=rs.getString("name");
				   		Mname=Mname.trim();
				   		symbol=1;
		;		   		
						}
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(symbol==0){System.out.println("查无此药！");
				  information=0+","+0+","+6;
				return information;}
				String sql7="insert into patientMedicine values("+patientID+",'"+Mname+"',"+numble+","+price+","+price*numble+")";
				
				try {
					  symbol=	st.executeUpdate(sql7);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
		   		
		   		//关闭连接
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			information=Mname+","+price+","+7;
		return information;
			
			
	}
	
	public static void DBChange(String name,int x,int bianLiang,String keshi){//更改数据库信息
		   Connection con=null;
				//加载数据库驱动程序
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //建立数据库连接
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
				//if(con!=null)System.out.println("连接成功！");
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           
		 
		       //String sql2="select * from USERS where name='"+name+"'";   
	
		   		//ResultSet rs=null;//存放查询结果
		   		
		   		/*try {
					rs=st.executeQuery(sql2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
		   		
		  	String names;
		   		int id,symbol=0;
		   		
		   		/*try {
					if(!rs.next()){					
						System.out.println("用户不存在!"); 
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
		   		name=name.trim();
		   		String sql4=null;
		   	if(x==3){sql4="update USERS set payOff=1"; } 
		   	else {sql4="update USERS set isorder='"+x+"',order_time='"+bianLiang+"',keshi='"+keshi+"' where name='"+name+"'";  }
		   	
		   		try {
				  symbol=	st.executeUpdate(sql4);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
		   		//关闭连接
			   
			try {
				//rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(symbol!=0){System.out.println("更新成功");}
			
		
	}


	public static String DBPMedicine(String name,int x){//输入用户名输出药单    药名，数量，单价，总价，药名，数量，单价,总价
		   Connection con=null;
	   
				//加载数据库驱动程序
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //建立数据库连接
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
				//if(con!=null)System.out.println("连接成功！");
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           name=name.trim();
		        String sql1="select * from patientMedicine where patientID='"+name+"'";   
		           
		         
		   		ResultSet rs=null;//存放查询结果
		   		
		   		try {
					rs=st.executeQuery(sql1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		
		   		String passw = null;
		   		String names;
		   		String keshi=null;
		   String xinxi=null;
		   		if(x==1) xinxi=""+",";
		   		else if(x==2)xinxi=Server.patientName+",";
		   		int type=0;
		   		int id,symbol=0;
		   		try {
					while(rs.next()){
						 //id=rs.getInt("id");
						xinxi=xinxi+rs.getString("name").trim()+","+rs.getInt("numble")+","+rs.getInt("price")+","+rs.getInt("allprice")+",";
						 symbol=1;
						 
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 		
		   		
		   		//关闭连接
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(symbol==0){System.out.println("无药品");return xinxi; }
		 	return xinxi;	
			
			
			
	}
	
	public static int DBMedicine(String s){ //药房库
		   Connection con=null;
				//加载数据库驱动程序
		           try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           //建立数据库连接
		           try {
					con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=users","sa","sa");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Statement st=null;
				//if(con!=null)System.out.println("连接成功！");
		           try {
					 st=con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           String strs[]=s.split(",");      //strs[0]=账号  ，strs[1]=密码，strs[2]=账户类型，strs[3]=服务端类型号
				      
				      
					
					
	              String name=strs[0]; 
	              String pinyin=strs[1];
	              int numble=Integer.parseInt(strs[2]); 
	              int xuanzhe=Integer.parseInt(strs[4]); 
		          int price=Integer.parseInt(strs[5]); 
		        String sql2="select * from Medicine where name='"+name+"'";   
	
		   		ResultSet rs=null;//存放查询结果
		   		
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
						System.out.println("药品名已存在");if(xuanzhe==1)return  -1;
		
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		name=name.trim();
		   		pinyin=pinyin.trim();String sql3=null;
		   		//String sql="insert into student values(3333,'龙王','女','军工路','0215527111',"+age+")";
		   		if(xuanzhe==1) { sql3="insert into Medicine values('"+name+"','"+pinyin+"','"+numble+"','"+price+"')";}
		   		else if(xuanzhe==2) { sql3="delete from Medicine where name='"+name+"'";   }
		   		try {
				  symbol=	st.executeUpdate(sql3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
		   		//关闭连接
			   
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(symbol==1){System.out.println("添加药品成功");return 1;}
			 else return -1;
		
	}

	
	

}
