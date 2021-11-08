package savlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuizDAO2;
import dao.QuizDTO;
import dataclass.dataload01;
import logintest03.UserDto;

/**
 * Servlet implementation class Quizishi2
 */
@WebServlet("/Quizishi2")
public class Quizishi2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quizishi2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession(false);
		 UserDto loginUser = (UserDto) session.getAttribute("loginUser");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8' />");
		out.println("<title>●●クイズ</title>");
		out.println("<p>" + loginUser.getUserid() + "<br><a href=\"Logout\">ログアウト</a></p>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"Quizishi2\" method=\"post\">");
		//
		
		String rightAnswer;
		int rightAnswerCount;
		int quizCount = 1;
		ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

		 QuizDAO2 dao = new QuizDAO2();
		 List<QuizDTO> quizList = dao.findAll();
//	    
//
//	
		for (int i = 0; i < quizList.size(); i++) {
	//
		ArrayList<String> tmpArray = new ArrayList<>();
	//
		tmpArray.add(quizList.get(i).getQuestion()); // 
		tmpArray.add(quizList.get(i).getAnswer()); // 正解
		tmpArray.add(quizList.get(i).getSubject01()); // 選択肢１
		tmpArray.add(quizList.get(i).getSubject02()); // 選択肢２
		tmpArray.add(quizList.get(i).getSubject03()); // 選択肢３
		// 
		quizArray.add(tmpArray);
	}
//	

//

//	
		// 
		//
		
		String[] ans2 = new String[5];

		for (int j=0;j<5;j++) {
			
			// ランダム
		Random random = new Random();
		int randomNum = random.nextInt(quizArray.size());
		// randomNum：quizArrayからクイズを一つ取り出す
		ArrayList<String> quiz = quizArray.get(randomNum);
		// 
		String mondai = quiz.get(0);
		
	//
		
		// 正解をセット
		rightAnswer = quiz.get(1);
		// クイズ配列からセットした問題文を削除
		quiz.remove(0);
		// シャッフル
		Collections.shuffle(quiz);
		// 
		String answerB1 = quiz.get(0);
		String answerB2 = quiz.get(1);
		String answerB3 = quiz.get(2);
		String answerB4 = quiz.get(3);
		
		//quizArrayから削除
		quizArray.remove(randomNum);
		

		String radiob = null;
		
		if(rightAnswer == answerB1) { radiob="A";}
		else if(rightAnswer == answerB2) {radiob="B";}
		else if(rightAnswer == answerB3) {radiob="C";}
		else if(rightAnswer == answerB4) {radiob="D";}
		
		ans2[j] = radiob;
		
		
		
	//	
	//   
//		
//		
//		
//		
//	
//	
		
		out.println("<p>問題" + j+1 + "</p>"); 
		
		out.println( mondai + "<br>");
		out.println("<div>");
		 
		out.println("<tr>");
		out.println("<td><label><input type=\"radio\" name=\"" + "qans" + j + "\" value=\"A\">" + answerB1 + "</label></td><br>");
		out.println("<td><label><input type=\"radio\" name=\"" + "qans" + j + "\" value=\"B\">" + answerB2 + "</label></td><br>");
		out.println("<td><label><input type=\"radio\" name=\"" + "qans" + j + "\" value=\"C\">" + answerB3 + "</label></td><br>");
		out.println("<td><label><input type=\"radio\" name=\"" + "qans" + j + "\" value=\"D\">" + answerB4 + "</label></td><br>");
		out.println("</tr>");
		
		out.println("</div><br>");
		}
//	
//		
//		
//		
//		
		
//////////////////////////////////////////////////////////////////
		
		try {
		      File csv = new File(dataload01.csvans); //
		     // 
			 //
		      //
		      // 
		      BufferedWriter bw 
		        = new BufferedWriter(new FileWriter(csv, true)); 
		      // 新たなデータ行の追加
		      bw.write(ans2[0]+ "," + ans2[1] + "," + ans2[2] + "," + ans2[3] + "," + ans2[4]);
		      bw.newLine();
		      bw.close();
		 
		    } catch (FileNotFoundException e) {
		      // Fileオブジェクト生成時の例外捕捉
		      e.printStackTrace();
		    } catch (IOException e) {
		      // BufferedWriterオブジェクトのクローズ時の例外捕捉
		      e.printStackTrace();
		    }
		
/////////////////////////////////////////////////////////////////
		
		
		out.println("<input type=\"submit\" value=\"送信\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Qans0 =request.getParameter("qans0");
		String Qans1 =request.getParameter("qans1");
		String Qans2 =request.getParameter("qans2");
		String Qans3 =request.getParameter("qans3");
		String Qans4 =request.getParameter("qans4");
				
		response.setContentType("text/html; charset=UTF-8");
		
		
		if(Qans0 == null) {Qans0 = "Z";}
		if(Qans1 == null) {Qans1 = "Z";}
		if(Qans2 == null) {Qans2 = "Z";}
		if(Qans3 == null) {Qans3 = "Z";}
		if(Qans4 == null) {Qans4 = "Z";}

		
		
//////////////////////////////////////////////////////////////////

		
		BufferedReader br = null;
		  String file_name = dataload01.csvans; // 入力ファイル
	//	  
	//	  
		  
		  try {
		  File file = new File(file_name);
		  br = new BufferedReader(new FileReader(file));
		  // readLineで一行ずつ読み込む
		  String line; // 読み込み行
		  String[] ansdata; // 分割後のデータを保持する配列
		  
		//  
		  // 
//		  
		  ansdata = br.readLine().split(",");
		  
	//	  
		  // 
//		  
//		  	  
//		  		  }
////////////////////////////////////////////////////////////////////////////		  
		  response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='utf-8'>");
			out.println("<title>点数</title><br>");
			out.println("</head>");
			out.println("<body>");
		  

		  int score = 0;
		  		  
		  if(Qans0.equals(ansdata[0])) {
	//		  
			  out.println("1 正解");
		   score = score+1;}
	//	  
	//		   
	//	  
		   else {
		//	   
			   out.println("1 不正解");
			   }
		  out.println("<br>");
		  
		  if(Qans1.equals(ansdata[1])) {
			  out.println("2 正解");
			  score = score+1;}
	//	  
	//		  
	//	  
			   else {
			//	   
				   out.println("2 不正解");
			   }
		  out.println("<br>");
			  
		  if(Qans2.equals(ansdata[2])) {
			  out.println("3 正解");
		  	   score = score+1;}
	//	  
	//		   
	//	  
		   else {
		//	   
			   out.println("3 不正解");
		   }
		  out.println("<br>");
		  
		  if(Qans3.equals(ansdata[3])) {
			  out.println("4 正解");
				   score = score+1;}
	//	  
	//		   
	//	  
		   else {
	//		   
			   out.println("4 不正解");
		   }
		  out.println("<br>");
		  
		  if(Qans4.equals(ansdata[4])) {
			  out.println("5 正解");
					   score = score+1;}
	//	  
	//		  
	//	  }
		   else {
	//		  
			   out.println("5 不正解");
			   }
		  out.println("<br>");
		  out.println("<br>");
		
		  out.println("合計" + score +"点<br>");
		  out.println("<br>");
		  
					   	   
		  out.println("<a href=\"sentaku01\">選択画面兼ログイン成功画面に戻る</a>");
			
	//	  
			
		  out.println("<br><br><p><a href=\"Logout\">ログアウト</a></p>");
		  out.println("</body>");
		  out.println("</html>");   
		  
		  
		 // 
		  
		  } catch (Exception e) {
		  System.out.println(e.getMessage());
		  } finally {
		  try {
		  br.close();
		  } catch (Exception e) {
		  System.out.println(e.getMessage());
		  }
		  }
		  

			  
		
		 
		  //
		  File file = new File(dataload01.csvans);
		  
	        //existsメソッドを使用してファイルの存在を「確認する
	        if (file.exists()) {
	            //deleteメソッドを使用してファイルを削除する
	            if (file.delete()) {
	//                
	            } else {
	//                コンソールにエラーが出る！
	            }
	        } else {
	//            コンソールにエラーが出る！
	        }
	    }
}
		
	
//		
//			
//		
		
		
		
		
	


