package RedWork.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.api.jdbc.Statement;

/**
 * 一些基础的数据库连接
 * @author wanzh
 *
 */
public class BaseDao {
	String driver = "com.mysql.jdbc.Driver";
	//String url="jdbc:mysql://139.199.15.137:3306/travelwork?useUnicode=true&characterEncoding=utf-8";
	String url = "jdbc:mysql://localhost:3306/travelwork?useUnicode=true&characterEncoding=utf-8";
	String user = "root";
	String password = "";
	private Connection conn;
	public ResultSet rs;
	public Statement stm;
	public PreparedStatement pstm;

	public Statement getStatement() throws ClassNotFoundException, SQLException, IOException {
		if (stm == null) {
			if (conn == null) {
				creatConnection();
			}
			stm = (Statement) conn.createStatement();
		}

		return stm;
	}

	public PreparedStatement getPreparedStatement(String sql)
			throws SQLException, ClassNotFoundException, IOException {
		if (pstm == null) {
			if (conn == null) {
				creatConnection();
			}
		}else{
			pstm.close();
		}
		pstm = conn.prepareStatement(sql);
		return pstm;

	}

	public void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
		if (pstm != null) {
			pstm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	private void creatConnection() throws ClassNotFoundException, SQLException, IOException {
		Class.forName(driver);
		conn = (Connection) DriverManager.getConnection(url, user, password);
	}

}
