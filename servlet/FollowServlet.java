package RedWork.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RedWork.dao.FollowDao;
import RedWork.entity.FollowEntity;

/**
 * Servlet implementation class FoolowServlet
 */
@WebServlet("/FoolowServlet")
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession hs= request.getSession();
		String userPhone = (String) hs.getAttribute("userPhone");
		String TvName = request.getParameter("TvName");
		//添加关注
		FollowEntity fe = new FollowEntity();
		fe.setUserPhone(userPhone);
		fe.setTvName(TvName);
		
		FollowDao fd = new FollowDao();
		try {
			if(fd.insertTv(fe)==false) {
				request.setAttribute("followMessage1","收藏成功");
			}
			else {
				request.setAttribute("followMessage2","收藏失败");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
