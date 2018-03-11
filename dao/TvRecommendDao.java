package RedWork.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 视频筛选的数据录操作
 * @author wanzh
 *
 */
public class TvRecommendDao extends BaseDao{
	/**
	 * 按热度对视频进行排序
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Map<String,String> orderTv() throws ClassNotFoundException, SQLException, IOException {
		String sql="select TV_name ,TV_url from Tv oder TV_value asc where TV_id=1 limit 10 ";
		pstm=this.getPreparedStatement(sql);
		rs=pstm.executeQuery();
		Map<String,String> map = new HashMap<String,String>();
		while(rs.next())
		{
			map.put(rs.getString("TV_name"),rs.getString("TV_url"));
		}
		return map;
		
	}
}
