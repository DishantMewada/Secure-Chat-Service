/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package securechat;

import javax.crypto.Cipher;


import java.security.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;
/**
 *
 * @author Jitender
 */



public class AES {



     private static final String ALGO = "AES";
//    private static final byte[] keyValue = DH.key1 ;
    private static final byte[] keyValue =
        new byte[] { 'G', 'h', 'i', 'L', 'e', 's', 't',
'Y', 'x', 'z', 'q','n', 'a', 'K', 'w','o' };//the bytes of the word is used here as secret key

    public AES() throws Exception {         // default constructor
        //DH dh=new DH();
        //keyValue = dh.key1;
    }

public static String encrypt(String Data) throws Exception {    // AES Encryption method
        SecretKeySpec key = generateKey();                      // call to generate a secret Key
        
        System.out.println("Encryted key : " + key);
        Cipher c = Cipher.getInstance(ALGO);                    // declare Cipher object 'c'
        c.init(Cipher.ENCRYPT_MODE, key);                       // initiate Cipher object 'c'
  //      byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(Data.getBytes()); //binary-to-text encoding
        return encryptedValue;                                  // return encrypted value as String
    }

    public static String decrypt(String encryptedData) throws Exception {   // AES Decryption method
        SecretKeySpec key = generateKey();                      // call to generate a secret Key
        //SecretKeySpec key = new SecretKeySpec(Server.tranferKey, ALGO);
        
        System.out.println("Decryted key : " + key);
        Cipher c = Cipher.getInstance(ALGO);                    // declare Cipher object 'c'
        c.init(Cipher.DECRYPT_MODE, key);                       // initiate Cipher object 'c'
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);  // text-to-binary encoding
//       byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decordedValue);
        return decryptedValue;                                  // return decrypted value as String
    }
    //We use "generateKey()" method to generate a secret key for AES algorithm with a given key.
    private static SecretKeySpec generateKey() throws Exception {  // secret key generation method
        System.out.println("keyValue--------------------------"+DH.key1);
        SecretKeySpec key = new SecretKeySpec(DH.key1, ALGO);       // make a secretkey by calling SecretKeySpec() with two argument a shared key(by DH) and AES 
        return key;                                                 // return a secret key 
}
}
