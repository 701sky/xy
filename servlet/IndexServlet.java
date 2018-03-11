package RedWork.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RedWork.dao.UserDao;
import RedWork.entity.UserEntity;
import RedWork.service.UserService;

/**
 * Servlet implementation class IndexServket
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		String userPhone = request.getParameter("userPhone");
		String password = request.getParameter("password");
		UserEntity ue = new UserEntity();
		ue.setUserphone(userPhone);
		ue.setPassword(password);
		//Âß¼­´¦Àí
		UserService us= new UserService();
		int found=1;
		try {
			found =us.jugdePassword(ue);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(found==0)
		{
			request.setAttribute("message","ÄãÉÐÎ´×¢²á");
			request.getRequestDispatcher("").forward(request,response);
		}
		else if(found==-1)
		{
			request.setAttribute("message","ÃÜÂë´íÎó");
			request.getRequestDispatcher("").forward(request, response);
		}
		else
		{
			response.sendRedirect("");
		}
	}

}
