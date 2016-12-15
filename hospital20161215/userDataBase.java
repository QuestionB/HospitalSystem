package hospital;
import java.sql.*;

public class userDataBase {

	public static int DBTestUser(String name,String password){//验证用户
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
	   		int id,symbol=0;
	   		try {
				while(rs.next()){
					 //id=rs.getInt("id");
					 names=rs.getString("name");
					 passw=rs.getString("password");
					passw=passw.trim();//去除字符串后空格
					 symbol=1;
					
				}if(symbol==0)System.out.println("用户名不存在");
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
		if((password.compareTo(passw))==0){System.out.println("登录成功");return 1;}
	 		else {System.out.println("密码错误");return  -1;	} 	
		
		
		
}
	

	public static int DBAddUsers(String name,String password,int type){
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
						System.out.println("用户名已存在");return  -1;
		
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		name=name.trim();
		   		password=password.trim();
		   		//String sql="insert into student values(3333,'龙王','女','军工路','0215527111',"+age+")";
		   		String sql3="insert into USERS values('"+name+"','"+password+"','"+type+"')";
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
			 else return -1;
		
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
	





}
