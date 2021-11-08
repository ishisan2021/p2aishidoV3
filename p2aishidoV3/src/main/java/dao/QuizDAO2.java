package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class QuizDAO2 {

	//接続用の情報
		private static final String RDB_DRIVE="com.mysql.cj.jdbc.Driver";
	 	private static final String URL="jdbc:mysql://localhost/wordquiz";
	 	private static final String USER="root";
	 //	private static final String PASSWD="xxxx";
		private static final String PASSWD="root";
	 
	 	// データベース接続
	 	// 
	 	private static Connection getConnection(){
	 		try{
	 			Class.forName(RDB_DRIVE);
	 			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
	 			return con;
	 		}catch(Exception e){
	 			throw new IllegalStateException(e);
	 		}
	 	}
//	 	
	 	// 
	 	public ArrayList<QuizDTO> findAll(){
	 	
	 		// 変数
	 		Connection con = null;	// 
	 		Statement smt = null;	// 
	 
	 		// 配列
	 		ArrayList<QuizDTO> quizList = new ArrayList<QuizDTO>();
	 
	 		// SQL文作成
	 		String sql = "SELECT * FROM question01";
	 
	 		try{
	 			// DBに接続
	 			con = QuizDAO2.getConnection();
	 			smt = con.createStatement();
	 
	 			// SQL文発行
	 			ResultSet rs = smt.executeQuery(sql);
	 
	 			// 
	 			while(rs.next()){
	 				int id = rs.getInt("id");
	 				String question = rs.getString("question");
	 				String Answer = rs.getString("Answer");
	 				String subject01 = rs.getString("subject01");
	 				String subject02 = rs.getString("subject02");
	 				String subject03 = rs.getString("subject03");
	 				
//	 				
	 				QuizDTO quizDTO = new QuizDTO(id, question, Answer, subject01, subject02, subject03);
	 				
	 				quizList.add(quizDTO);
	 			}
	 
	 		}catch(SQLException e){
	 			System.out.println("Errorが発生しました！\n"+e);
	 		}finally{
	 			// リソースの開放
	 			if(smt != null){
	 				try{smt.close();}catch(SQLException ignore){}
	 			}
	 			if(con != null){
	 				try{con.close();}catch(SQLException ignore){}
	 			}
	 		}
	 		return quizList;
	 	}
	 ////////////////////
//	 	 
	 	
	 	///////////////////
	 	
	 	
}
