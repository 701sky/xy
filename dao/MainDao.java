package RedWork.dao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 进行主页面的相关操作
 * @author wanzh
 *
 */
public class MainDao extends BaseDao{
	/**
	 * 查找视屏连接
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public String selectTv(String TvName) throws ClassNotFoundException, SQLException, IOException {
		String sql ="select TV_url from TV where TV_name=? ";
		pstm=this.getPreparedStatement(sql);
		pstm.setString(1,TvName);
		rs=pstm.executeQuery();
		String url=null;
		while(rs.next()) {
			url=rs.getString("TV_url");
		}
		
		return url;
		
	}
}
