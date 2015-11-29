package edu.csupomona.cs480;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String hash(String s) throws NoSuchAlgorithmException{
		
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        
        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
		
		return hexString.toString();	
	}
}
