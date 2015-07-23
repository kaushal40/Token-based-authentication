
package producer.consumer;

import org.jose4j.lang.JoseException;

/*
 * Author: kaushal 
 */

public class MainClass {

	public static void main(String args[])
	{
		String jwt = null;
		JwtProducer tokenProcducer = new JwtProducer();
		try {
			jwt = tokenProcducer.getToken();
		} catch (JoseException e1) {
			e1.printStackTrace();
		}
		
		JwtConsume jwtVerifier = new JwtConsume();
		try {
			jwtVerifier.verifyToken(jwt);
		} catch (JoseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
