package RedWork.service;

import java.io.IOException;
import java.sql.SQLException;

import RedWork.dao.UserDao;
import RedWork.entity.UserEntity;

/**
 * �û���¼ע���ҵ���߼�����
 * @author wanzh
 *
 */
public class UserService {
	/**
	 * ������ж�
	 * @param ue
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
		public int jugdePassword(UserEntity ue) throws ClassNotFoundException, SQLException, IOException {
			//��ȡ���ݿ�����
			UserDao ud = new UserDao();
			String user_password = ud.selectPassword(ue);
			//�����ж�
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
