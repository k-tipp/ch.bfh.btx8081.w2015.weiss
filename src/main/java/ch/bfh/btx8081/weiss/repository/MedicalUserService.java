package ch.bfh.btx8081.weiss.repository;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Query;

import ch.bfh.btx8081.weiss.model.MedicalUser;
import ch.bfh.btx8081.weiss.model.Patient;

public class MedicalUserService {

	public Patient getUserById(int id) {
		return DatabaseHandler.entityManager.find(Patient.class, id);
	}

	public MedicalUser getUserByUsernamePassword(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		// TODO Optimize by generating a random salt for each user.
		// Same password should not result in the same hash.
		
		String passwordHash = PasswordHash.createHash(password, "MyNewSalt");

		Query query = DatabaseHandler.entityManager.createQuery(
				"SELECT u FROM MedicalUser u WHERE u.username LIKE :username AND u.password = :password");
		
		query.setParameter("username", username);
		query.setParameter("password", passwordHash);
		
		@SuppressWarnings("unchecked")
		List<MedicalUser> users = query.setMaxResults(1).getResultList();
		if(users.isEmpty()) {
			return null;
		}		
		
		return (MedicalUser) users.get(0);
	}

	private static class PasswordHash {
		private static String createHash(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {

			byte[] hash = getPBKDF2Hash(password.toCharArray(), salt.getBytes(), 1000, 24);
			return byteToHex(hash);
		}

		/**
		 * Get the PBKDF2 hash of a password.
		 * @param password the password to hash.
		 * @param salt the salt
		 * @param iterations the iteration count
		 * @param bytes the length of the hash
		 * @return the PBDKF2 hash of the password
		 */
		private static byte[] getPBKDF2Hash(char[] password, byte[] salt, int iterations, int bytes)
				throws NoSuchAlgorithmException, InvalidKeySpecException {
			PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			return skf.generateSecret(spec).getEncoded();
		}

		/**
		 * Converts a byte array to a hex string.
		 * @param array the byte array to convert
		 * @return a hex string
		 */
		private static String byteToHex(byte[] array) {
			BigInteger bigInt = new BigInteger(1, array);
			String hex = bigInt.toString(16);
			int paddingLength = (array.length * 2) - hex.length();
			if (paddingLength > 0)
				return String.format("%0" + paddingLength + "d", 0) + hex;
			else
				return hex;
		}
	}
}
