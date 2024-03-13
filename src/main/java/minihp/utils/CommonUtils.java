package minihp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {

    public static String encryptByMd5(String input) {
        String MD5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            MD5 = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            MD5 = null;
        }
        return MD5.toUpperCase();
    }

    public static String sha256(String rawText){

        String SHA = null;
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(rawText.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < byteData.length ; i++){
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return SHA;
    }
}
