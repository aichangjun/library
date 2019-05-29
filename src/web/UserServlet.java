package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;


@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//2.�����������
		String method = request.getParameter("method");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("qqqqqqqqq");
		
		UserService service = new UserServiceImpl();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		System.out.println(user);
		//3.����ҵ��
		if("register".equals(method)) {
			int rows = service.register(user);
			if(rows>0) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "ע��ʧ��");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			
			return;
		}
		
		if("login".equals(method)) {
			System.out.println("dddddd");
			User u = service.login(user);
			System.out.println(u);
			if(u==null) {//��¼ʧ��
				System.out.println("��½ʧ��");
				request.setAttribute("msg", "��¼ʧ��!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}else {//��¼�ɹ�
				System.out.println("��½�ɹ�!");
				request.getRequestDispatcher("main.html").forward(request, response);
			}
					
			return;
			
		}
	}

}
