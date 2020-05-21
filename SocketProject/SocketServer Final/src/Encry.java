
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** */
/**
 * <p>
 * RSA��Կ/˽Կ/ǩ�����߰�
 * </p>
 * <p>
 * ���ɵ¡���ά˹�أ�Ron [R]ivest�������ϡ���Ī����Adi [S]hamir�������ɵ¡���������Leonard [A]dleman��
 * </p>
 * <p>
 * �ַ�����ʽ����Կ��δ������˵������¶�ΪBASE64�����ʽ<br/>
 * ���ڷǶԳƼ����ٶȼ��仺����һ���ļ���ʹ���������ܶ���ʹ�öԳƼ��ܣ�<br/>
 * �ǶԳƼ����㷨���������ԶԳƼ��ܵ���Կ���ܣ�������֤��Կ�İ�ȫҲ�ͱ�֤�����ݵİ�ȫ
 * </p>
 * 
 * @author IceWee
 * @date 2012-4-26
 * @version 1.0
 */
public class Encry {

	public static final String ALGORITHM = "AES";
	/** */
	/**
	 * �����㷨RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";

	/** */
	/**
	 * ǩ���㷨
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/** */
	/**
	 * ��ȡ��Կ��key
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/** */
	/**
	 * ��ȡ˽Կ��key
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/** */
	/**
	 * RSA���������Ĵ�С
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/** */
	/**
	 * RSA���������Ĵ�С
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	/** */
	/**
	 * <p>
	 * ������Կ��(��Կ��˽Կ)
	 * </p>
	 * 
	 * @return
	 * @throws Exception
	 */

	public Map<String, Object> genKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

	/** */
	/**
	 * <P>
	 * ˽Կ����
	 * </p>
	 * 
	 * @param encryptedData
	 *            �Ѽ�������
	 * @param privateKey
	 *            ˽Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public String decryptByPrivateKey(String res, String privateKey) throws Exception {
		byte[] encryptedData = Base64Utils.decode(res);
		byte[] keyBytes = Base64Utils.decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶν���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		String targ = new String(decryptedData);
		return targ;
	}

	/** */
	/**
	 * <p>
	 * ��Կ����
	 * </p>
	 * 
	 * @param encryptedData
	 *            �Ѽ�������
	 * @param publicKey
	 *            ��Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public String decryptByPublicKey(String res, String publicKey) throws Exception {
		byte[] encryptedData = Base64Utils.decode(res);
		byte[] keyBytes = Base64Utils.decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶν���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		String targ = new String(decryptedData);
		return targ;
	}

	/** */
	/**
	 * <p>
	 * ��Կ����
	 * </p>
	 * 
	 * @param data
	 *            Դ����
	 * @param publicKey
	 *            ��Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public String encryptByPublicKey(String targ, String publicKey) throws Exception {
		byte[] data = targ.getBytes();
		byte[] keyBytes = Base64Utils.decode(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// �����ݼ���
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶμ���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		String res = Base64Utils.encode(encryptedData);
		return res;
	}

	/** */
	/**
	 * <p>
	 * ˽Կ����
	 * </p>
	 * 
	 * @param data
	 *            Դ����
	 * @param privateKey
	 *            ˽Կ(BASE64����)
	 * @return
	 * @throws Exception
	 */
	public String encryptByPrivateKey(String targ, String privateKey) throws Exception {
		byte[] data = targ.getBytes();
		byte[] keyBytes = Base64Utils.decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// �����ݷֶμ���
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		String res = Base64Utils.encode(encryptedData);
		return res;
	}

	/** */
	/**
	 * <p>
	 * ��ȡ˽Կ
	 * </p>
	 * 
	 * @param keyMap
	 *            ��Կ��
	 * @return
	 * @throws Exception
	 */
	public String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return Base64Utils.encode(key.getEncoded());
	}

	/** */
	/**
	 * <p>
	 * ��ȡ��Կ
	 * </p>
	 * 
	 * @param keyMap
	 *            ��Կ��
	 * @return
	 * @throws Exception
	 */
	public String getPublicKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return Base64Utils.encode(key.getEncoded());
	}

	public byte[] byteMerger(byte[] bt1, byte[] bt2) {
		byte[] bt3 = new byte[bt1.length + bt2.length];
		System.arraycopy(bt1, 0, bt3, 0, bt1.length);
		System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
		return bt3;
	}

	public String md5Encrypt(String info) throws NoSuchAlgorithmException {
		// ����MD5�㷨����MessageDigest����
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] srcBytes = info.getBytes();
		// ʹ��srcBytes����ժҪ
		md5.update(srcBytes);
		// ��ɹ�ϣ���㣬�õ�result
		byte[] hashBytes = md5.digest();
		return new String(hashBytes);
	}

	public String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			// System.out.println(number);
			// System.out.println(str.charAt(number));
			sb.append(str.charAt(number));
			// System.out.println(sb.toString());
		}
		return sb.toString();
	}

	public String AESEncrypt(String src, String keyAB) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128, new SecureRandom(keyAB.getBytes()));
		SecretKey secretKey = keyGen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKey key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] raw = src.getBytes();
		byte[] encrypted = cipher.doFinal(raw);
		String AES_encrypted = new String(new BASE64Encoder().encode(encrypted));
		return AES_encrypted;
	}

	public String AESDecrypt(String src, String keyAB) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128, new SecureRandom(keyAB.getBytes()));
		SecretKey secretKey = keyGen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKey key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] raw = new BASE64Decoder().decodeBuffer(src);
		byte[] decrypted = cipher.doFinal(raw);
		String AES_decrypted = new String(decrypted, "utf-8");
		// String originalString = new String(original);
		return AES_decrypted;
	}

	public static Cipher initAESCipher(String sKey, int cipherMode) {
		// ����Key gen
		KeyGenerator keyGenerator = null;
		Cipher cipher = null;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128, new SecureRandom(sKey.getBytes()));
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] codeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(codeFormat, "AES");
			cipher = Cipher.getInstance("AES");
			// ��ʼ��
			cipher.init(cipherMode, key);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (NoSuchPaddingException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (InvalidKeyException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		return cipher;
	}

	/**
	 * ���ļ�����AES����
	 * 
	 * @param sourceFile
	 * @param fileType
	 * @param sKey
	 * @return
	 */
	public File encryptFile(File sourceFile, File encrypfile, String sKey) {

		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(sourceFile);

			outputStream = new FileOutputStream(encrypfile);
			Cipher cipher = initAESCipher(sKey, Cipher.ENCRYPT_MODE);
			// �Լ�����д���ļ�
			CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
			byte[] cache = new byte[1024];
			int nRead = 0;
			while ((nRead = cipherInputStream.read(cache)) != -1) {
				outputStream.write(cache, 0, nRead);
				outputStream.flush();
			}
			cipherInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
			}
		}
		return encrypfile;
	}

	/**
	 * AES��ʽ�����ļ�
	 * 
	 * @param sourceFile
	 *            Ҫ���ܵ��ļ�·��
	 * @param decryptFile
	 *            ���ܺ���ļ�·��
	 * @param sKey
	 * @return
	 */
	public File decryptFile(File sourceFile, File decryptFile, String sKey) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			Cipher cipher = initAESCipher(sKey, Cipher.DECRYPT_MODE);
			inputStream = new FileInputStream(sourceFile);
			outputStream = new FileOutputStream(decryptFile);
			CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
			byte[] buffer = new byte[1024];
			int r;
			while ((r = inputStream.read(buffer)) >= 0) {
				cipherOutputStream.write(buffer, 0, r);
			}
			cipherOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
			}
		}
		return decryptFile;
	}
}