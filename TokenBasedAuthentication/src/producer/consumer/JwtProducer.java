package producer.consumer;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;


public class JwtProducer {
  
	public String getToken() throws JoseException
	{

		// Claims is the content of JWT
		JwtClaims claims = new JwtClaims();
		claims.setIssuer("RP"); 
		claims.setAudience("Client_Application"); 
		claims.setExpirationTimeMinutesInTheFuture(60); 
		claims.setGeneratedJwtId(); 
		claims.setSubject("Data_Access_Request_Token"); 
		claims.setClaim("username", "kaushal"); 

		// A JWT is a JWS  In this example it is a JWS so we create a JsonWebSignature object.
		JsonWebSignature jws = new JsonWebSignature();

		jws.setPayload(claims.toJson());

		// The JWT is signed using the private key
		jws.setKey(ExampleRSAKey.PRIVATE_KEY);

		// for integrity protection use algorithm
		jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

		String jwt = jws.getCompactSerialization();
        
		System.out.println("JWT: " + jwt);
		return jwt;
	}
}
