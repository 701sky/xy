package RedWork.servlet;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RedWork.entity.UserEntity;
import RedWork.util.SendMessageutil;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//��ȡ����
		String userPhone = request.getParameter("userPhone");
		String password = request.getParameter("password");
		//MessageDigest md = MessageDigest.getInstance("MD5");
		//md.
		System.out.println(userPhone);
		//���������
		int code = (int)(Math.random()*9+1)*10000;
		//���Ͷ���
		String data = SendMessageutil.sendMessage(userPhone,code);
	
		HttpSession hs= request.getSession();
		hs.setAttribute("userPhone",userPhone);
		hs.setAttribute("password", password);
		hs.setAttribute("code", code);
		
		//����ҳ������
				request.setAttribute("message","��������֤��");
				request.getRequestDispatcher("/zhuce.jsp").forward(request, response);
		
	}

}
