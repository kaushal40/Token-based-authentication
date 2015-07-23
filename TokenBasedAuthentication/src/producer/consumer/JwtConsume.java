package producer.consumer;

import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

public class JwtConsume {

	public boolean verifyToken(String jwt) throws JoseException {
	
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
				.setRequireExpirationTime()
				.setAllowedClockSkewInSeconds(30)
				.setRequireSubject()
				.setExpectedIssuer("RP")
				.setExpectedAudience("Client_Application")
				.setVerificationKey(ExampleRSAKey.PUBLIC_KEY)
				.build();

		try {
			JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
			System.out.println("JWT validation succeeded! " + jwtClaims);
		} catch (InvalidJwtException e) {
			System.out.println("Invalid JWT! " + e);
		}
		return false;
	}

}
