package savlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sentaku01
 */
@WebServlet("/sentaku01")
public class sentaku01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sentaku01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    // ログイン結果画面にフォワード
		    RequestDispatcher dispatcher =
		        request.getRequestDispatcher
		            ("/WEB-INF/jsp/loginResult2.jsp");
		    dispatcher.forward(request, response);
		  }
		
protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {


	request.setCharacterEncoding("UTF-8");

	// 押されたボタンを判定して分岐
	if (request.getParameter("loginUser") != null) {
	
		// 
		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp");
		rd.forward(request, response);

		
	} else if(request.getParameter("upUser") != null){
		// 

	// 
	RequestDispatcher rd = request
			.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
	rd.forward(request, response);
}

}
}
