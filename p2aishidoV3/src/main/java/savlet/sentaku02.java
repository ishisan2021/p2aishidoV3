package savlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sentaku02
 */
@WebServlet("/sentaku02")
public class sentaku02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sentaku02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("admain") != null){
			// 

		// 
		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/jsp/login_main.jsp");
		rd.forward(request, response);
	
	}else if(request.getParameter("dell") != null){
		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/jsp/user_delete.jsp");
		rd.forward(request, response);
		
	}else if(request.getParameter("upUser") != null){
		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		rd.forward(request, response);
	}

}
}
