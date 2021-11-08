package savlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataclass.dataload01;
import logintest03.UserDao;
import logintest03.UserDto;

/**
 * Servlet implementation class UserDelServlet
 */
@WebServlet("/UserDelServlet")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UserDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		 @Override
		    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
		 
		    String id = request.getParameter("userid");
		    String passAword = request.getParameter("password");
		    
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
		    
		    
		    
		 
		    UserDao dao = new UserDao();
		    UserDto user = dao.findUser(id);
		 
		    boolean isLogin = (user != null && id.equals(user.getUserid()) &&       
		        password.equals(user.getPassword()));
		 
		    if (isLogin) {
		        int result = dao.delUser(id, password);
		        request.setAttribute("username", id);
		        request.getRequestDispatcher("/WEB-INF/jsp//user_del_success.jsp").forward(request, response);
		    } else {
		        request.setAttribute("error", "該当するIDとパスワードのユーザは登録されていません。\n再入力してください。");
		        request.getRequestDispatcher("/WEB-INF/jsp//user_delete.jsp").forward(request, response);
		    }
		 
		    }
		}
