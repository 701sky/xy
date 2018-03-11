package RedWork.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RedWork.dao.CommentDao;
import RedWork.entity.CommentEntity;

/**
 * Servlet implementation class UserCommentServlet
 */
@WebServlet("/UserCommentServlet")
public class UserCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCommentServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf=8");
		//��ȡ����
		String userPhone=request.getParameter("userPhone");
		String userPid = request.getParameter("userPid");
		String comment = new String(request.getParameter("comment").getBytes("iso-8859-1"),"utf-8");
		int TvId = Integer.parseInt(request.getParameter("TvId"));
		
		CommentEntity ce = new CommentEntity();
		ce.setComment(comment);
		ce.setTvId(TvId);
		ce.setUserPhone(userPhone);
		ce.setUserPid(userPid);
		//���۴洢
		CommentDao cd = new CommentDao();
		try {
			if(cd.insertComment(ce)==false)
			{
				request.setAttribute("userComment1","���۳ɹ�");
				request.getRequestDispatcher("").forward(request, response);;
			}
			else {
				request.setAttribute("userComment2","����ʧ��");
				request.getRequestDispatcher("").forward(request, response);
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
