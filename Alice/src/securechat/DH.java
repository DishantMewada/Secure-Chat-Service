/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securechat;

// javac DH.java && java DH
// "Just use libsodium if you can," also applies for every other language below
import java.math.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.*;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author Jitender
 */

public class DH {

	int bitLength=512;	
	int certainty=20;// probabilistic prime generator 1-2^-certainty => practically 'almost sure'
        static byte [] key1;
        static String str = "",str1 = "";
        static BigInteger generatorValue,primeValue,publicA,publicB,secretA,secretB,sharedKeyA,sharedKeyB;
        static SecretKeySpec secretKeySpec;
        private static final byte[] fileKeyValue =
        new byte[] { 'G', 'h', 'i', 'L', 'e', 's', 't',
'Y', 'x', 'z', 'q','n', 'a', 'K', 'w','o' };//the bytes of the word is used here as secret key
    private static final SecureRandom rnd = new SecureRandom();
// byte[] randomBytes = new byte[32];
// csprng.nextBytes(randombytes);
// Important: Despite its name, don't use SecureRandom.getInstanceStrong()!
// On Linux, this is the equivalent to reading /dev/random which is a pointless performance killer. The default for new SecureRandom() in Java 8 is to read from /dev/urandom, which is what you want

//	public static void main(String [] args) throws Exception
//	{
//		new DH();
//                
//                //encryptFile(new File("test.jpg"));
//                //decryptFile();
//	}

	public DH() throws Exception{
            
	    Random randomGenerator = new Random();
	    
            primeValue = findPrime();
	    //primeValue = findPrime();// BigInteger.valueOf((long)g);
	    System.out.println("the prime is "+primeValue);
	     generatorValue	= findPrimeRoot(primeValue);//BigInteger.valueOf((long)p);
	    System.out.println("the generator of the prime is "+generatorValue);

		// on machine 1
	    //secretA = new BigInteger(bitLength-2,randomGenerator);
		// on machine 2
             str=new String("17406244646546647132854267170320669271502036411266300145845115021513917886648979440940734585431139967655144849061381496117016544581631320931690408903134");
	secretB = new BigInteger(str.getBytes());
	    //secretB = new BigInteger(bitLength-2,randomGenerator);
            //str = secretA.toString();
            //str = new String(secretB.toByteArray());
             //secretB = new BigInteger(str.getBytes()); 
               // System.out.println("secretB: "+secretB);
		// to be published:
//	    publicA=generatorValue.modPow(secretA, primeValue);
//	    publicB=generatorValue.modPow(secretB, primeValue);
//	    sharedKeyA = publicB.modPow(secretA,primeValue);// should always be same as:
//	    sharedKeyB = publicA.modPow(secretB,primeValue);
//
//	    System.out.println("the public key of A is "+publicA);
//	    System.out.println("the public key of B is "+publicB);
//	    System.out.println("the shared key for A is "+sharedKeyA);
//	    System.out.println("the shared key for B is "+sharedKeyB);
//	    System.out.println("The secret key for A is "+secretA);
//	    System.out.println("The secret key for B is "+secretB);
//
//            int s1 = sharedKeyA.intValue();
//	    String getAValue=Integer.toString(s1);
//	    String getBValue=sharedKeyB.toString();
//              //String str = SHA.getSHA256Hash(getAValue);
//	    
//              MessageDigest md = MessageDigest.getInstance("SHA-256");
//	    md.update(getAValue.getBytes());
//               byte [] byteData=getAValue.getBytes(); 
//	     byteData = md.digest(byteData);
//	    
//            byteData = Arrays.copyOf(byteData, 16);
//	    StringBuffer sb = new StringBuffer();
//            for(int i=0;i<byteData.length;i++)
//	    {
//	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));// ??
//	    }
//
//	    String getHexValue = sb.toString();
//	    System.out.println("hex format in SHA-256 is "+getHexValue);
//            //getHexValue.
//	    byte [] key = getAValue.getBytes("UTF-8");
//
//	    MessageDigest sha = MessageDigest.getInstance("SHA-256");
//	    key =  sha.digest(key);
//	           
//            
//                   key = Arrays.copyOf(key, 16);
//                  
//                byte[] keyValue = new byte[] { key[0], key[1], key[2], key[3], key[4], key[5], key[6], key[7], key[8], key[0], key[1], key[2], key[3], key[4], key[5], key[6] };
//                   key1 = keyValue;
//                   System.out.println("shared key of DH: "+key1);
//                   //key1 = byteData;
//	
	}
        
public static void DHEncrypt() throws Exception{

publicA=generatorValue.modPow(secretA, primeValue);
	    publicB=generatorValue.modPow(secretB, primeValue);
	    sharedKeyA = publicB.modPow(secretA,primeValue);// should always be same as:
	    sharedKeyB = publicA.modPow(secretB,primeValue);

	    System.out.println("the public key of A is "+publicA);
	    System.out.println("the public key of B is "+publicB);
	    System.out.println("the shared key for A is "+sharedKeyA);
	    System.out.println("the shared key for B is "+sharedKeyB);
	    System.out.println("The secret key for A is "+secretA);
	    System.out.println("The secret key for B is "+secretB);

            int s1 = sharedKeyA.intValue();
	    String getAValue=Integer.toString(s1);
	    String getBValue=sharedKeyB.toString();
              //String str = SHA.getSHA256Hash(getAValue);
	    
              MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(getAValue.getBytes());
               byte [] byteData=getAValue.getBytes(); 
	     byteData = md.digest(byteData);
	    
            byteData = Arrays.copyOf(byteData, 16);
	    StringBuffer sb = new StringBuffer();
            for(int i=0;i<byteData.length;i++)
	    {
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));// ??
	    }

	    String getHexValue = sb.toString();
	    System.out.println("hex format in SHA-256 is "+getHexValue);
            //getHexValue.
	    //byte [] key22 = getAValue.getBytes("UTF-8");
            //getHexValue = getHexValue.substring(0, 15);
            System.out.println("getHexValue::"+getHexValue);
             byte[] KeyValue =
        new byte[] { (byte)getHexValue.charAt(0), (byte)getHexValue.charAt(1), (byte)getHexValue.charAt(2), (byte)getHexValue.charAt(3), (byte)getHexValue.charAt(4), (byte)getHexValue.charAt(5), (byte)getHexValue.charAt(6),
(byte)getHexValue.charAt(7), (byte)getHexValue.charAt(8), (byte)getHexValue.charAt(9), (byte)getHexValue.charAt(10),(byte)getHexValue.charAt(11), (byte)getHexValue.charAt(12), (byte)getHexValue.charAt(13), (byte)getHexValue.charAt(14),(byte)getHexValue.charAt(15) };
            
            byte [] key = getHexValue.getBytes("UTF-16");
            System.out.println("KeyValue :: "+KeyValue);
	    MessageDigest sha = MessageDigest.getInstance("SHA-256");
	    key =  sha.digest(key);
	           
            
                   key = Arrays.copyOf(key, 16);
                  
                byte[] keyValue = new byte[] { key[0], key[1], key[2], key[3], key[4], key[5], key[6], key[7], key[8], key[0], key[1], key[2], key[3], key[4], key[5], key[6] };
                   key1 = KeyValue;
                   System.out.println("shared key of DH: "+key1);
                   //key1 = byteData;

}
	
	

boolean isPrime(BigInteger r){
	return miller_rabin(r);
	// return BN_is_prime_fasttest_ex(r,bitLength)==1;
}

public List<BigInteger> primeFactors(BigInteger number) {
    BigInteger n = number;
	BigInteger i=BigInteger.valueOf(2);
	BigInteger limit=BigInteger.valueOf(10000);// speed hack! -> consequences ???
   	List<BigInteger> factors = new ArrayList<BigInteger>();
   	while (!n.equals(BigInteger.ONE)){
		while (n.mod(i).equals(BigInteger.ZERO)){
        factors.add(i);
		n=n.divide(i);
		// System.out.println(i);
		// System.out.println(n);
		if(isPrime(n)){
			factors.add(n);// yes?
			return factors;
		}
     	}
		i=i.add(BigInteger.ONE);
		if(i.equals(limit))return factors;// hack! -> consequences ???
		// System.out.print(i+"    \r");
	}
		System.out.println(factors);
   return factors;
 }

boolean isPrimeRoot(BigInteger g, BigInteger p)
{
    BigInteger totient = p.subtract(BigInteger.ONE); //p-1 for primes;// factor.phi(p);
    List<BigInteger> factors = primeFactors(totient);
    int i = 0;
    int j = factors.size();
    for(;i < j; i++)
    {
        BigInteger factor = factors.get(i);//elementAt
        BigInteger t = totient.divide( factor);
		if(g.modPow(t, p).equals(BigInteger.ONE))return false;
    }
    return true;
}


BigInteger findPrimeRoot(BigInteger p){
	int start= 197;// first best probably precalculated by NSA?
	// preferably  3, 17 and 65537
	//if(start==2)compareWolfram(p);

	for(int i=start;i<100000000;i++)
		if(isPrimeRoot(BigInteger.valueOf(i),p))
			return BigInteger.valueOf(i);
			// if(isPrimeRoot(i,p))return BigInteger.valueOf(i);
	return BigInteger.valueOf(0);
}


BigInteger findPrime(){
	Random rnd=new Random();
	BigInteger p;
	// while(!isPrime(p))
	//p= new BigInteger(bitLength, certainty, rnd);
	String str1=new String("9090544902738531960002745657437180744067838480942066401939220103584370081920727489157282644335488993639311188133347859479532481916546515110189827665911933");
	p = new BigInteger(str1.getBytes());
        return p;
		
}

private static boolean miller_rabin_pass(BigInteger a, BigInteger n) {
	    BigInteger n_minus_one = n.subtract(BigInteger.ONE);
	    BigInteger d = n_minus_one;
		int s = d.getLowestSetBit();
		d = d.shiftRight(s);
	    BigInteger a_to_power = a.modPow(d, n);
	    if (a_to_power.equals(BigInteger.ONE)) return true;
	    for (int i = 0; i < s-1; i++) {
	        if (a_to_power.equals(n_minus_one)) return true;
	        a_to_power = a_to_power.multiply(a_to_power).mod(n);
	    }
	    if (a_to_power.equals(n_minus_one)) return true;
	    return false;
	}

	public static boolean miller_rabin(BigInteger n) {
	    for (int repeat = 0; repeat < 20; repeat++) {
	        BigInteger a;
	        do {
	            a = new BigInteger(n.bitLength(), rnd);
	        } while (a.equals(BigInteger.ZERO));
	        if (!miller_rabin_pass(a, n)) {
	            return false;
	        }
	    }
	    return true;
	}
}