package RedWork.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RedWork.entity.CommentEntity;

/**
 * 对用户评论的数据库操作
 * @author wanzh
 *
 */
public class CommentDao extends BaseDao{
	/**
	 * 插入评论
	 * @return boolean
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public boolean insertComment(CommentEntity ce) throws ClassNotFoundException, SQLException, IOException {
		String sql="insert into comment(user_phone,user_comment,user_pid,Tv_id) values (?,?,?,?)";
		pstm=this.getPreparedStatement(sql);
		pstm.setString(1,ce.getUserPhone());
		pstm.setString(2,ce.getComment());
		pstm.setString(3,ce.getUserPid());
		pstm.setInt(4,ce.getTvId());
		return pstm.execute();
		
	}
	/**
	 * 获取数据库中的对应数据
	 * @return list集合
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<Map<String,Object>> selectComment(CommentEntity ce) throws ClassNotFoundException, SQLException, IOException{
		String sql="select user_phone,user_pid,user_comment from comment where Tv_id=?";
		pstm= this.getPreparedStatement(sql);
		pstm.setInt(1,ce.getTvId());
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		rs=pstm.executeQuery();
		while(rs.next()) {
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("userPhone",rs.getString("user_phone"));
		map.put("userPid",rs.getString("user_pid"));
		map.put("userComment", rs.getString("user_comment"));
		list.add(map);
		}
		return list;
		
	}
	
}
