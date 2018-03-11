package RedWork.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RedWork.entity.FollowEntity;

/**
 * ����Ƶ��ע�ղؽ������ݿ����
 * @author wanzh
 *
 */
public class FollowDao extends BaseDao{
   /**
    * �����ղ�����
    * @param fe
    * @return
 * @throws IOException 
 * @throws SQLException 
 * @throws ClassNotFoundException 
    */
	public boolean insertTv(FollowEntity fe) throws ClassNotFoundException, SQLException, IOException {
		String sql ="insert into follow (user_phone,Tv_name) values (?,?)";
		pstm=this.getPreparedStatement(sql);
		pstm.setString(1,fe.getUserPhone());
		pstm.setString(2,fe.getTvName());
		
		return pstm.execute();
	   
   }
	/**
	 * ��������ɸѡ��Ӧ������
	 * @param fe
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Map<String,Object>> selectFollow(FollowEntity fe) throws ClassNotFoundException, SQLException, IOException{
		String sql = "select Tv_name from follow where user_phone=?";
		pstm=this.getPreparedStatement(sql);
		pstm.setString(1,fe.getUserPhone());
		rs=pstm.executeQuery();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		while(rs.next()) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("TvName",rs.getString("Tv_name"));
			list.add(map);
		}
		return list;
		
	}
	
	
}
