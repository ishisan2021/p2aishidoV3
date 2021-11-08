package dataclass;

import org.apache.commons.codec.digest.DigestUtils;

public class dataload01 {

	//public static final String csvans = "C:/Users/　　　/Documents/workspace/p2aishidoV3/src/main/webapp/WEB-INF/dataq/writers.csv";
	public static final String csvans = "C:writers.csv";

//	
//
//
	public static final String PEPPER = "p2a";
	

			
    public static String hassh(String motodata) {
    	String hasshB1 = DigestUtils.sha256Hex(motodata);
    	return hasshB1;
    }
    

	

}
