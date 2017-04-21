package library;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Stringlibrary {
	public static String md5(String change){
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(change.getBytes());
			BigInteger bigInteger = new BigInteger(1, md.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result ;
	}
}
