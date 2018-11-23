/**
 * 
 */
package com.prs.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Isura
 *
 */
public class CryptoService {

	private static CryptoService cryptoService;
	
	private CryptoService(){}
	/**
	 * 
	 * @param strClearText
	 * @param strKey
	 * @return
	 * @throws Exception
	 */
	public synchronized String encrypt(String plainText,String publicKey) throws Exception{
		String cipherText="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(publicKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(plainText.getBytes());
			cipherText=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return cipherText;
	}
	
	
	/**
	 * <h2>Decryption Method</h2>
	 * @param <p><b>cipherText</b> Cipher Text(Encrypted)</p>
	 * @param <p><b>publicKey</b> public key used in encryption and decryption</p>
	 * @return <p><b>plainString<b><p> Plain Text
	 * @throws Exception
	 */
	public synchronized String decrypt(String cipherText,String publicKey) throws Exception{
		String plainString="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(publicKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(cipherText.getBytes());
			plainString=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return plainString;
	}

	
	  public static synchronized CryptoService getInstance() //step 1
	  {
	    if(cryptoService == null)
	    {
	      return new CryptoService();
	    } 
	    else    
	    {
	      return cryptoService;
	    }
	  }	
	
	  
}
