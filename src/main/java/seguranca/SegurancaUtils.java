package seguranca;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * @author Luiz Felipe Nazari
 * @since 08/04/2015
 * @see http://howtodoinjava.com/2013/07/22/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
 */
@SuppressWarnings("unused")
public class SegurancaUtils {
	
	/**
	 * @Algorítmo MD5
	 * @Nível 128-bit (16-bytes)
	 * @Tamanho 32 caracteres
	 * @Descrição O algorítmo de encriptação MD5 gera hashs relativamente fracos. As principais vantagens são que é
	 *            rápido e de fácil implementação. Os hashs gerados são suscetíveis a ataques de força-bruta e
	 *            ataques de dicionários, que podem, facilmente, encontrar a palavra encriptada.<br>
	 *            Além disso, não é resistente à colisões, o que significa que diferentes palavras podem gerar o mesmo
	 *            hash.
	 * @param passwordToHash
	 * @return
	 */
	private static String encriptacaoComMD5(String passwordToHash) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				Integer temp = (bytes[i] & 0xff);
				temp += 0x100;
				sb.append(Integer.toString(temp, 16).substring(1));
			}
			
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return generatedPassword;
	}
	
	/**
	 * @Algorítmo Salt, ou sal, no português + SHA1PRNG
	 * @Descrição É uma técnica utilizada para fortalecer os hashs oriundos de encriptação.<br>
	 *            Segundo a Wikipédia, Salt são dados aleatórios (Strings aleatórias) que são utilizadas como entrada
	 *            para uma função de "mão única" (quando não há como descriptografar) utilizada para gerar hash em cima
	 *            de palavras, senhas ou frases.<br>
	 *            Ou seja, é um texto aleatório que é "somado" à palavra original antes de gerar o hash. O que ajuda a
	 *            proteger contra ataques de dicionário.<br>
	 * <br>
	 *            O algorítimo SHA1PRNG é usado para criar números criptograficamente pseudo-aleatórios baseados no
	 *            algorítimo SHA-1.<br>
	 * <br>
	 *            <b>IMPORTANTE: </b> é necessário armazenar o valor gerado pelo algorítimo Salt, pois apenas com esse
	 *            valor será possível criptografar a mesma palavra e atingir o hashcode gerado previamente.
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	private static String getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
		// Always use a SecureRandom generator
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		
		// Create array for salt
		byte[] salt = new byte[16];
		
		// Get a random salt
		sr.nextBytes(salt);
		
		// return salt
		return new String(salt);
	}
	
	/**
	 * @Algorítmo MD5 + Salt
	 * @Nível 128-bit (16-bytes)
	 * @Tamanho 32 caracteres
	 * @Descrição Encriptação com algorítimo MD5 "fortificado" por Salt. @param passwordToHash
	 * @param salt
	 * @return
	 * @see SegurancaUtils#encriptacaoComMD5(String)
	 * @see SegurancaUtils#getSalt()
	 */
	private static String encriptacaoComMD5_Salt(String passwordToHash, String salt) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			// Add password bytes to digest
			md.update(salt.getBytes());
			
			// Get the hash's bytes
			byte[] bytes = md.digest(passwordToHash.getBytes());
			// This bytes[] has bytes in decimal format;
			
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	
	/**
	 * @Algorítmo SHA
	 * @Nível 160-bit, 256-bit, 384-bit, 512-bit (Depende a implementação)
	 * @Tamanho 40, 64, 96, 128 caracteres, respectivamente
	 * @Descrição O algorítimo SHA (Secure Hash Algorithm) é uma família de funções para criptografar hashs. É similar
	 *            ao MD5, porém, gera hashs mais fortes. Parte do princípio que hashs maiores representam maior
	 *            segurança. Também não são resistentes à colisões, mas, neste caso, ocorremmuito raramente.
	 * @param passwordToHash
	 * @param salt
	 * @return
	 */
	private static String encriptacaoComSha(String passwordToHash, String salt) {
		String generatedPassword = null;
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-1"); // "SHA-256", "SHA-384", "SHA-512"
			md.update(salt.getBytes());
			byte[] bytes = md.digest(passwordToHash.getBytes());
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
	
	/**
	 * @Algorítimo PBKDF2 + SHA
	 * @Nível 512-bit
	 * @Tamanho 128 caracteres
	 * @Descrição A ideia principal do algorítimo é diminuir a velocidade e, consequentemente, a eficácia dos programas
	 *            hackers e ataques de força bruta fazendo com que a geração dos hashs sejam mais lentas, delimitadas
	 *            por iterações, mas não tão lentas a ponto de causar algum impacto ao usuário.<br>
	 * <br>
	 *            As iterações são denominadas fator de trabalho ou fator de segurança, e determinam o quão demorada a
	 *            geração de hashs será. Como os compitadores tornam-se mais rápidos a cada ano, é interessante
	 *            atualizar esse valor quando necessário.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchProviderException
	 */
	private static String encriptacaoComPBKDF2WithHmacSHA1(String password, String salt) throws NoSuchAlgorithmException,
	    InvalidKeySpecException, NoSuchProviderException {
		int iterations = 1000;
		char[] chars = password.toCharArray();
		byte[] bytesSalt = salt.getBytes();
		
		PBEKeySpec spec = new PBEKeySpec(chars, bytesSalt, iterations, 64 * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		return iterations + ":" + toHex(bytesSalt) + ":" + toHex(hash);
	}
	
	private static String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}
	
	/**
	 * Valida se ambos hashs são iguais.
	 * 
	 * @param original
	 * @param novo
	 * @return
	 */
	public static boolean validaHashs(String original, String novo) {
		// 1 = tem diferença / 0 = não tem diferença
		int diff = original.length() ^ novo.length();
		if (diff == 1)
			return false;
		
		byte[] bytesOriginal = original.getBytes();
		byte[] bytesNovo = novo.getBytes();
		
		for (int i = 0; i < bytesOriginal.length && i < bytesNovo.length; i++)
			diff |= bytesOriginal[i] ^ bytesNovo[i];
		
		return diff == 0;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		String passwordOriginal = "123456";
		String salt = getSalt();
		String hashcode = encriptacaoComSha(passwordOriginal, salt);
//		String hashcode = encriptacaoComMD5(passwordOriginal);
		// Salva o hashcode e o salt.
		
		// ---
		
		// Exemplo de login
		String hashcodeBanco = hashcode;
		String passwordLogin = "654321";
		String hashcodeLogin = encriptacaoComSha(passwordLogin, salt);
//		String hashcodeLogin = encriptacaoComMD5(passwordLogin);
		
		if (validaHashs(hashcodeBanco, hashcodeLogin))
			System.out.println("As senhas são iguais.");
		else
			System.out.println("As senhas são diferentes.");
		
		System.out.println("Banco: " + hashcodeBanco + "\nLogin: " + hashcodeLogin);
	}
}
