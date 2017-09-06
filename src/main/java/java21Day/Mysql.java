package java21Day;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/** 
 * @Title: Mysql 
 * @Description: 练习操作mysql
 * @author Administrator 
 * @CreateDate 2017年3月10日 下午2:01:00  
 */
public class Mysql {
	/** 
	 * @MethodName: execute 
	 * @Description: 执行操作
	 * @Parameter: 
	 * @return void
	 * @Example: TODO
	 * @ModificationHistory: 
	 * Author		Date		Description(Why & What is modified)
	 * -----------------------------------------------------------------------------------
	 * Administrator - 2017年3月10日 下午2:01:33 - First Release
	 * 
	 */
	public static void execute(){
		try{
			//生成 driver instance
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("成功加载MySQL驱动！");
			//产生连接对象
			Connection conn = 
	(Connection) DriverManager.getConnection("jdbc:mysql://172.20.20.104:3306", "root", "zhubajie");
			//产生发送sql指令的对象Statement
			System.out.print("成功连接到数据库！");
			Statement stmt = (Statement) conn.createStatement();
			//ResultSet rs = stmt.executeQuery(sql);
/*			while(rs.next()){
				int number = rs.getInt(1);
				String application_name = rs.getString(3);
				//System.out.println("number:"+number +","+"application_name:"+application_name);
			}
			stmt.executeUpdate("insert into demo (k1,k2,k3) values('a','b','c')");
			stmt.executeUpdate("update demo set key = 'value'");
			stmt.executeUpdate("delete form demo where id = 3");*/
			Map<Integer,String> name = new HashMap<Integer,String>();
			Map<Integer,String> level = new HashMap<Integer,String>();
			name.put(1, "SLOW COUNT");
			name.put(2, "NON DATA");
			name.put(3, "SLOW COUNT");
			name.put(4, "ERROR COUNT");
			name.put(5, "TOTAL COUNT");
			name.put(6, "HICKEY RESPONSE TIME");
			name.put(7, "ERROR COUNT TO HICKEY");
			name.put(8, "ERROR RATE");
			level.put(1, "WARNING");
			level.put(2, "SERIOUS");
			level.put(3,"REMIND");
			Integer id = 11;
			Integer threshold =11;
			String sql ="INSERT INTO `zhubajie_camille`.`camille_pp_general_rule` "
					+ "(`id`, `name`, `type`, `check_name`, `threshold`, `level`, `send_time`, `hickey`, `node`, `extend`, `user_id`, `raw_add_time`, `raw_update_time`, `raw_add_person`, `raw_update_person`) "+ "VALUES ('"
					+ id + "', '"+ name.get(1)+ "', '2', '"+ name.get(1)+ "', '"
					+ threshold+ "', '"+ level.get(2)
					+ "', 'ALL', 'ALL', 'ALL_ALL', NULL, '2', '2017-05-23 17:26:56', '2017-05-23 17:26:56', '熊明明', '熊明明');";
			
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Mysql.execute();
	}
}
