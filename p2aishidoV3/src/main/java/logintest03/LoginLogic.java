package logintest03;
//未使用クラス
public class LoginLogic {
	  public boolean execute(UserDto userse) {
	//dbから読み込む 別で作成　クラスは未使用  
		  		  
	//比較
		  System.out.println(userse.getPassword());
		  
	    if (userse.getPassword().equals("12345")) {
	      return true;
	    }
	    else {	        
	    return false;
	  }
	}
}
