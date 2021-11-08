package logintest03;

import java.io.Serializable;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public UserDto() {}
	
		private int no;
	    private String userid;
	    
	    public int getKanri() {
			return kanri;
		}

		public void setKanri(int kanri) {
			this.kanri = kanri;
		}

		private String password;
	    private String sio;
	    private int kanri;
	    
	    public UserDto(String userid, String password) {
	        this.userid = userid;
	        this.password = password;
	    }
 
	    public String getSio() {
			return sio;
		}

		public void setSio(String sio) {
			this.sio = sio;
		}

		public int getNo() {
	        return no;
	    }
	    public String getUserid() {
	        return userid;
	    }
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setNo(int no) {
	        this.no = no;
	    }
	    public void setUserid(String userid) {
	        this.userid = userid;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }

	 
	}