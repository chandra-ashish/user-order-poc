package com.telecom.user.config;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.telecom.user.exception.UserPermissionException;
public class JWTTokenUtil {
  
   public String validateAuthorizationDetails(String token,String userId) throws UserPermissionException{
	   JWTTokenUtil djt = new JWTTokenUtil();
	 //  String input="eyJhdWQiOiJodHRwOlwvXC9vcmcud3NvMi5hcGltZ3RcL2dhdGV3YXkiLCJzdWIiOiJkZXZwb3J0YWxAY2FyYm9uLnN1cGVyIiwiYXBwbGljYXRpb24iOnsib3duZXIiOiJkZXZwb3J0YWwiLCJ0aWVyUXVvdGFUeXBlIjoicmVxdWVzdENvdW50IiwidGllciI6IlVubGltaXRlZCIsIm5hbWUiOiJEZXZQb3J0YWxVc2VyQXBwIiwiaWQiOjUsInV1aWQiOm51bGx9LCJzY29wZSI6ImFtX2FwcGxpY2F0aW9uX3Njb3BlIHByb2R1Y3QtbWFuYWdlbWVudC1vcmRlcnMtdXNlci1yZWFkIiwiaXNzIjoiaHR0cHM6XC9cLzE4LjIxOC4xMC4yMDQ6OTQ0M1wvb2F1dGgyXC90b2tlbiIsInRpZXJJbmZvIjp7IkJyb256ZSI6eyJ0aWVyUXVvdGFUeXBlIjoicmVxdWVzdENvdW50Iiwic3RvcE9uUXVvdGFSZWFjaCI6dHJ1ZSwic3Bpa2VBcnJlc3RMaW1pdCI6MCwic3Bpa2VBcnJlc3RVbml0IjpudWxsfX0sImtleXR5cGUiOiJTQU5EQk9YIiwic3Vic2NyaWJlZEFQSXMiOlt7InN1YnNjcmliZXJUZW5hbnREb21haW4iOiJjYXJib24uc3VwZXIiLCJuYW1lIjoiQ3VzdG9tZXJEYXRhIiwiY29udGV4dCI6IlwvdXNlciIsInB1Ymxpc2hlciI6Im1hbmkiLCJ2ZXJzaW9uIjoiMS4wLjAiLCJzdWJzY3JpcHRpb25UaWVyIjoiQnJvbnplIn1dLCJjb25zdW1lcktleSI6ImRycXVORGJSQmkyUWhsQVZqSU1NUEZvTlJ0WWEiLCJleHAiOjE1OTU3NTUwMDEsImlhdCI6MTU5NTc1MTQwMSwianRpIjoiOTAxODg1NmMtY2IxYS00MDRmLTg3YzQtYWE2Nzg2ZTdkYzcxIn0";
	   //djt.decodeJWT(input);
	  // System.out.println(djt.decodeJWT(token,userId));
	   String owner = decodeJWT(token,userId);
	   return owner;
   }
   
   private String decodeJWT(String input,String userId) throws UserPermissionException {
//	   byte[] decoded = Base64.getDecoder().decode(input);
//	   String s = new String(decoded, StandardCharsets.UTF_8);
//	   s.indexOf("owner",1);
//	   s=s.substring(s.indexOf("owner",1));
//	   s= s.substring(0 , s.indexOf(","));
//	   s=s.replace("\"", "");
//	   String output[] = s.split(":");
	   String []splitInput = input.split("[.]",0);
	   byte[] decoded = Base64.getDecoder().decode(splitInput[1]);
	   String s = new String(decoded, StandardCharsets.UTF_8);
	   //System.out.println(s);
	   s.indexOf("owner",1);
	   s=s.substring(s.indexOf("owner",1));
	   s= s.substring(0 , s.indexOf(","));
	   s=s.replace("\"", "");
	   String output[] = s.split(":");
	   if(!output[1].equalsIgnoreCase(userId))
	   {
		   throw new UserPermissionException("PERMISSION_DENNIED","Invalid authentication userId not matching");
	   }
		   
	   return output[1];
   }
   
//   public String validateAuthorizationDetails(String token){
//	   JWTTokenUtil djt = new JWTTokenUtil();
//	 //  String input="eyJhdWQiOiJodHRwOlwvXC9vcmcud3NvMi5hcGltZ3RcL2dhdGV3YXkiLCJzdWIiOiJkZXZwb3J0YWxAY2FyYm9uLnN1cGVyIiwiYXBwbGljYXRpb24iOnsib3duZXIiOiJkZXZwb3J0YWwiLCJ0aWVyUXVvdGFUeXBlIjoicmVxdWVzdENvdW50IiwidGllciI6IlVubGltaXRlZCIsIm5hbWUiOiJEZXZQb3J0YWxVc2VyQXBwIiwiaWQiOjUsInV1aWQiOm51bGx9LCJzY29wZSI6ImFtX2FwcGxpY2F0aW9uX3Njb3BlIHByb2R1Y3QtbWFuYWdlbWVudC1vcmRlcnMtdXNlci1yZWFkIiwiaXNzIjoiaHR0cHM6XC9cLzE4LjIxOC4xMC4yMDQ6OTQ0M1wvb2F1dGgyXC90b2tlbiIsInRpZXJJbmZvIjp7IkJyb256ZSI6eyJ0aWVyUXVvdGFUeXBlIjoicmVxdWVzdENvdW50Iiwic3RvcE9uUXVvdGFSZWFjaCI6dHJ1ZSwic3Bpa2VBcnJlc3RMaW1pdCI6MCwic3Bpa2VBcnJlc3RVbml0IjpudWxsfX0sImtleXR5cGUiOiJTQU5EQk9YIiwic3Vic2NyaWJlZEFQSXMiOlt7InN1YnNjcmliZXJUZW5hbnREb21haW4iOiJjYXJib24uc3VwZXIiLCJuYW1lIjoiQ3VzdG9tZXJEYXRhIiwiY29udGV4dCI6IlwvdXNlciIsInB1Ymxpc2hlciI6Im1hbmkiLCJ2ZXJzaW9uIjoiMS4wLjAiLCJzdWJzY3JpcHRpb25UaWVyIjoiQnJvbnplIn1dLCJjb25zdW1lcktleSI6ImRycXVORGJSQmkyUWhsQVZqSU1NUEZvTlJ0WWEiLCJleHAiOjE1OTU3NTUwMDEsImlhdCI6MTU5NTc1MTQwMSwianRpIjoiOTAxODg1NmMtY2IxYS00MDRmLTg3YzQtYWE2Nzg2ZTdkYzcxIn0";
//	   //djt.decodeJWT(input);
//	   System.out.println(djt.decodeJWT(token));
//	   String owner = decodeJWT(token);
//	   return owner;
//   }
}