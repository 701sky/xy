package RedWork.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import RedWork.entity.UserEntity;

/**
 * 对user表的数据库操作
 * @author wanzh
 *
 */
public class UserDao extends BaseDao{
	/**
	 * 把账号密码插入数据库
	 * @param ue
	 * @return boolean
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean insertUser(UserEntity ue) throws ClassNotFoundException, SQLException, IOException {
		String sql= "insert into user(user_phone,user_password) values(?,?)";
		pstm = this.getPreparedStatement(sql);
		pstm.setString(1,ue.getUserphone());
		pstm.setString(2,ue.getPassword());
		return pstm.execute();
		
	}
	/**
	 * 根据账号查找密码
	 * @param ue
	 * @return Map集合
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public String selectPassword(UserEntity ue) throws ClassNotFoundException, SQLException, IOException{
		String sql = "select user_password from user where user_phone=?";
		pstm = this.getPreparedStatement(sql);
		pstm.setString(1,ue.getUserphone());
		rs=pstm.executeQuery();
		while(rs.next())
		{
		 String password = rs.getString("user_password");
		}
		
		return password;
		
	}
}
