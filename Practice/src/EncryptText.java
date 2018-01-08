import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class EncryptText {
	/**
	 * 
	 * @param args
	 *            <a href = "https://www.facebook.com">See Documentation</a> ;)
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter plain text:");
		String plain = br.readLine();
		System.out.format("%s%n%s%n%s%n", "Choose Encryption:", "1 for MD-5", "2 for SHA-256");
		int type = Integer.parseInt(br.readLine());
		if (type != 1 && type != 2) {
			System.out.println("Invalid choice");
		} else {
			String algo = (type == 1) ? "md5" : "sha-256";
			MessageDigest md = MessageDigest.getInstance(algo);
			md.update(plain.getBytes());
			System.out.println(algo.toUpperCase() + " Encrypted text:");
			System.out.println(DatatypeConverter.printHexBinary(md.digest()).toLowerCase());
		}
	}
}
