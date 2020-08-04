package com.telecom.user.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.telecom.user.exception.UserPermissionException;

public class JWTTokenUtil {

	public String validateAuthorizationDetails(String token, String userId) throws UserPermissionException {
		String owner = decodeJWT(token, userId);
		return owner;
	}

	private String decodeJWT(String input, String userId) throws UserPermissionException {
		try {
		String[] splitInput = input.split("[.]", 0);
		byte[] decoded = Base64.getDecoder().decode(splitInput[1]);
		String decodedString = new String(decoded, StandardCharsets.UTF_8);
		String outPutStr= "";
		if(decodedString.indexOf("owner", 1) >0)
		{
		decodedString = decodedString.substring(decodedString.indexOf("owner", 1));
		decodedString = decodedString.substring(0, decodedString.indexOf(","));
		decodedString = decodedString.replace("\"", "");
		String output[] = decodedString.split(":");
		outPutStr = output[1];
		if (!output[1].equalsIgnoreCase(userId)) {
			throw new UserPermissionException("PERMISSION_DENNIED", "Invalid authentication userId not matching");
		}
		}
		else
		{
			throw new UserPermissionException("PERMISSION_DENNIED", "Invalid authentication token received");
		}
		
		return outPutStr;
		}catch(UserPermissionException ex) {
			throw ex;
		}
        catch(IllegalArgumentException ex) {
        	throw new UserPermissionException("PERMISSION_DENNIED", "Invalid authentication token received");
	   }
		catch(Exception ex) {
			throw ex;
		   }
	}

}