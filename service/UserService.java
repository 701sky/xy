package RedWork.service;

import java.io.IOException;
import java.sql.SQLException;

import RedWork.dao.UserDao;
import RedWork.entity.UserEntity;

/**
 * 用户登录注册的业务逻辑处理
 * @author wanzh
 *
 */
public class UserService {
	/**
	 * 密码的判断
	 * @param ue
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
		public int jugdePassword(UserEntity ue) throws ClassNotFoundException, SQLException, IOException {
			//获取数据库密码
			UserDao ud = new UserDao();
			String user_password = ud.selectPassword(ue);
			//密码判断
			if(user_password==null)
			{
				return 0;
			}
			if(user_password.equals(ue.getPassword()))
			{
				return 1;
			}
			return -1;
			
		}
}
