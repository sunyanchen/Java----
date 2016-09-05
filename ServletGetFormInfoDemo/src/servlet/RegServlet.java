package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import entitu.Users;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet(name="Regservlet",urlPatterns="servlet/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		Users u = new Users();
		String username,mypassword,gender,email,introduce,isAccept;
		Date birthday = null;
		String[] favorites;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			username = request.getParameter("username");
			mypassword = request.getParameter("mypassword");
			gender = request.getParameter("gender");
			email = request.getParameter("email");
			introduce = request.getParameter("introduce");
			birthday = sdf.parse(request.getParameter("birthday"));
			if (request.getParameter("isAccept") != null) {
				isAccept = request.getParameter("isAccept");
			} else {
				isAccept = "false";
			}
			favorites = request.getParameterValues("favorite");

			u.setUsername(username);
			u.setMypassword(mypassword);
			u.setBirthday(birthday);
			u.setFavorites(favorites);
			u.setEmail(email);
			u.setGender(gender);
			u.setIntroduce(introduce);
			if (isAccept != null && isAccept.equals("true")) {
				u.setFlag(true);
			} else {
				u.setFlag(false);
			}
			
			//把注册成功的信息保存到session中
			request.getSession().setAttribute("regUser", u);
			//跳转到注册页面
			request.getRequestDispatcher("../userinfo.jsp").forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
