package java21Day;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/** 
 * @Title: ConnectMysql 
 * @Description: 封装操作
 * @author Administrator 
 * @CreateDate 2017年3月10日 下午2:04:03  
 */
public class ConnectMysql {
	public static String driver ="com.mysql.jdbc.Driver";
	public static String host;
	public static String user;
	public static String pwd;
	public static Connection conn;
	public static Statement stmt = null;
	public static void connect (String host,String user,String pwd){
		//ConnectMysql.close();
		ConnectMysql.host = host;
		ConnectMysql.user = user;
		ConnectMysql.pwd = pwd;
	}
	private static void connectMysql(){
		try{
			Class.forName(driver).newInstance();
			conn = (Connection)DriverManager.getConnection("jdbc:mysql://"
					+host,user,pwd);
		}catch(InstantiationException e){//当应用程序试图使用 Class 类中的 newInstance 方法创建一个类的实例
			e.printStackTrace();
		}catch(IllegalAccessException e){//当应用程序试图反射性地创建一个实例（而不是数组）、设置或获取一个字段，或者调用一个方法，但当前正在执行的方法无法访问指定类、字段、方法或构造方法的定义时，抛出 IllegalAccessException。 
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void statement(){
		if(conn == null){
			ConnectMysql.connectMysql();
		}
		try{
			stmt = (Statement) conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private static ResultSet resultSet(String sql){
		ResultSet rs = null;
		if(stmt == null){
			ConnectMysql.statement();
		}
		try{
			rs =stmt.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	private static List<Map<String,String>> result(String sql){
		ResultSet rs = ConnectMysql.resultSet(sql);
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		try{
			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
			int count = md.getColumnCount();
			while(rs.next()){
				Map<String,String> columnMap = new HashMap<String,String>();
				for(int i=1;i<count;i++){
					columnMap.put(md.getColumnName(i), rs.getString(i));
				}
				result.add(columnMap);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public static synchronized List<Map<String,String>> query(String sql){
		return ConnectMysql.result(sql);
	}
	private static void resultUpdate(String sql){
		if(stmt == null){
			ConnectMysql.statement();
		}
		try{
			stmt.executeUpdate("insert,update,delete");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static synchronized void update(String sql){
		ConnectMysql.resultUpdate(sql);
	}
	public static synchronized void close(){
		try{
			if(stmt != null){
				stmt.close();
				stmt = null;
			}if(conn != null){
				conn.close();
				conn = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		ConnectMysql.connect("172.26.4.43:3306", "root", "");
		List<Map<String,String>> rs = ConnectMysql.query("SELECT * FROM pinpoint.pp_alarm_message WHERE application_name = 'pinpoint-java-tester'");
		System.out.println(rs.get(0).get("number"));
		ConnectMysql.close();
	}
}
