package emart.utility;

import java.util.Base64;

/**
 *
 * @author hp
 */
public class PasswordEncryption {
    public static String getEncryptedPassword(String password ){
        Base64.Encoder encoder =Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }
    //YWRtaW4=
    public static void main(String [] args){
        String str=getEncryptedPassword("admin");
        System.out.println(str);
        String str2=getEncryptedPassword("yashi");
        System.out.println(str2);
                
    }
    
}
