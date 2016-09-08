package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDao;
import entity.*;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(name="CartServlet",urlPatterns="/servlet/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String action;
    private ItemsDao idao = new ItemsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		response.setContentType("utf-8");
		if (request.getParameter("action") != null) {
			this.action = request.getParameter("action");
			if (action.equals("add")) {
				if (addToCart(request, response)) {
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
				}
			}
			if (action.equals("delete")) {
				if (delFromCart(request,response)) {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
			if (action.equals("show")) {
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
		}
	}
	
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String number = request.getParameter("number");
		Items item = idao.getItemById(Integer.parseInt(id));
		//第一次给购物车添加对象
		if (request.getSession().getAttribute("cart") == null) {
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (cart.addGoodsInCart(item, Integer.parseInt(number))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean delFromCart(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		Items item = idao.getItemById(Integer.parseInt(id));
		if (cart.delGoodsFromCart(item)) {
			return true;
		}
		else {
			return false;
		}
	}

}
