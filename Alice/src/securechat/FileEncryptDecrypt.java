/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securechat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static securechat.DH.secretKeySpec;
/**
 *
 * @author Jitender
 */

public class FileEncryptDecrypt {
    
     private static final String ALGO = "AES";
       private static final byte[] keyValue =
        new byte[] { 'G', 'h', 'i', 'L', 'e', 's', 't',
'Y', 'x', 'z', 'q','n', 'a', 'K', 'w','o' };//the bytes of the word is used here as secret key

     
     public static File encryptFile(File file) throws Exception{
            //secretKeySpec =  new SecretKeySpec(fileKeyValue,"AES");
         SecretKeySpec key = generateKey();   
         String ext = file.getName();
         String s[] = ext.split("\\.");
         File f;
         if(s.length == 2){
         f = new File("Encrypt_"+s[0]+"."+s[1]);
         }else{
         f = new File("testEncrypt");
         }
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(ALGO);
            System.out.println("2 secretKeySpec"+key);
            cipher.init(Cipher.ENCRYPT_MODE, key);

	    CipherInputStream cipt = new CipherInputStream(new FileInputStream(file),cipher); // enter your filename here
	    FileOutputStream fop=new FileOutputStream(f);
            
	    int i;
	       while((i=cipt.read())!= -1)
	           fop.write(i);
               fop.close();
               return f;
        }
        
        public static void decryptFile(File dfile) throws Exception{
            //secretKeySpec =  new SecretKeySpec(fileKeyValue,"AES");
            SecretKeySpec key = generateKey();
            System.out.println("d 1");
          String ext = dfile.getName();
         String s[] = ext.split("\\.");
         File f;
         if(s.length == 2){
             String s1[] = s[0].split("_");
         f = new File("Decrypt_"+s1[1]+"."+s[1]);
         }else{
         f = new File("testDecrypt");
         }  
        Cipher cipher = Cipher.getInstance(ALGO);
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
	System.out.println("2 d cipher"+cipher.toString());  
        System.out.println("2 d secretKeySpec"+key);  
        cipher.init(Cipher.DECRYPT_MODE,key);
            System.out.println("3 d ");
	    CipherInputStream cipt2 = new CipherInputStream(new FileInputStream(dfile),cipher); // encryption of image
	    System.out.println("4 d");
            FileOutputStream fop2 = new FileOutputStream(f);//decryption of images
                System.out.println("5 d cipt2"+cipt2.toString());
	    int j;
            
	    while((j=cipt2.read())!=-1)
	        fop2.write(j);
            fop2.close();
            System.out.println("6 d");
        }
        
        private static SecretKeySpec generateKey() throws Exception {
        System.out.println("keyValue--------------------------"+DH.key1);
        SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
        return key;
     
        }
}