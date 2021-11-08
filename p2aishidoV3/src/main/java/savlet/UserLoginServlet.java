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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		 
	    String userid = request.getParameter("userid");
	    String passAword = request.getParameter("password");
	 
	    System.out.println(userid + passAword );
	    
	    /////////////////////////////
	    
	    String passAhassh = dataload01.hassh(passAword);
	    
	    System.out.println(passAhassh);
	    
	    String salt = "salt";//後でデータベースから読んでくるに変える。
	    	    
	    String salthassh = dataload01.hassh(salt);
	    
	    System.out.println(salthassh);
	    
	    String kosyou = dataload01.PEPPER;
	    
	    String pepperhassh = dataload01.hassh(kosyou);
	    
	    System.out.println(pepperhassh);
	    
	    String password = passAhassh + salthassh + pepperhassh;
	    
	    //////////////////////////////
	    
	    
	    // Userインスタンス（ユーザー情報）の生成
	    UserDto userse = new UserDto(userid, password);
	    
	    UserDao dao = new UserDao();
	    UserDto user = dao.findUser(userid);
	
	    boolean isLogin = (user != null && userid.equals(user.getUserid()) && 
	        password.equals(user.getPassword()));
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("isLogin", isLogin);
	    
	 
	    if (isLogin) {
	        request.setAttribute("username", user.getUserid());
	        
	        String username = (String)request.getAttribute("username");
	        //
	        System.out.println(username);
	        
		      // ユーザー情報をセッションスコープに保存
	//	      HttpSession session = request.getSession();
		      session.setAttribute("loginUser", userse);
	        
	        request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp").forward(request, response);
	        
	    } else {
	        request.setAttribute("error", "IDかパスワードが間違っています。\n再入力してください。");
	        request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp").forward(request, response);
	    }
	 
	    }
	}