package savlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataclass.dataload01;
import logintest03.UserDao;
import logintest03.UserDto;

/**
 * Servlet implementation class UserRegServlet
 */
@WebServlet("/UserRegServlet")
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		 
	    String id = request.getParameter("userid");
	    String passAword = request.getParameter("password");
	    
	    System.out.println(id + passAword );
	    
	    if(id.length() < 1 ||  passAword.length() < 1) {
	    	 request.setAttribute("error", "空欄があります。\n再入力してください。");
	    	 
		 	    System.out.println(id + passAword );
		 	    
			        request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
	    }
	    
	    
	    /////////////////////////////
	    
	    String passAhassh = dataload01.hassh(passAword);
	    
	    System.out.println(passAhassh);
	    
	    String salt = "salt";//後でデータベースから読んでくに変える。
	    	    
	    String salthassh = dataload01.hassh(salt);
	    
	    System.out.println(salthassh);
	    
	    String kosyou = dataload01.PEPPER;
	    
	    String pepperhassh = dataload01.hassh(kosyou);
	    
	    System.out.println(pepperhassh);
	    
	    String password = passAhassh + salthassh + pepperhassh;
	    
	    
	 
	    UserDao dao = new UserDao();
	    UserDto user = dao.findUser(id);
	 
	    System.out.println(id + password );
	    
	    boolean isLogin = (user != null && id.equals(user.getUserid()) && 
	        password.equals(user.getPassword()));
	    HttpSession session = request.getSession();
	    session.setAttribute("isLogin", isLogin);
	    
	    System.out.println(id + password );
	 
	    if(!isLogin) {
	        int result = dao.regUser(id, password);
	        request.setAttribute("username", id);
	        request.getRequestDispatcher("/WEB-INF/jsp/user_reg_success.jsp").forward(request, response);
	    } 
	    else {
	        request.setAttribute("error", "同じIDとパスワードのユーザが既に登録されています。または空欄です。\n再入力してください。");
	        request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
	    }
	 
	    }
	}
