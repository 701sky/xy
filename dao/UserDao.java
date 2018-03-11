package RedWork.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import RedWork.entity.UserEntity;

/**
 * ��user������ݿ����
 * @author wanzh
 *
 */
public class UserDao extends BaseDao{
	/**
	 * ���˺�����������ݿ�
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
	 * �����˺Ų�������
	 * @param ue
	 * @return Map����
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
