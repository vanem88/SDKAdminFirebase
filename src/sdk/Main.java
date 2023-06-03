package sdk;

import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserRecord;

public class Main {

	
	public static void main(String[] args) {
		try {
			SDKAdminFB sdk = new SDKAdminFB();			
			//sdk.inicializarFirebase("C:\\Users\\Vane\\eclipse-workspace\\SDKAdminFirebase\\claveSeguridadFirebase.json");
			sdk.inicializarFirebase();
	    
		    UserRecord userRecord = sdk.obtenerUsuario("vanesa.montagna@gmail.com");			
			System.out.println("Successfully fetched user data: " + userRecord.getEmail());
			System.out.println("Successfully fetched user data: " + userRecord.getDisplayName());	
			System.out.println("Successfully fetched user data: " +userRecord.getProviderId());
			UserInfo[] userInfo = userRecord.getProviderData();
			System.out.println("Successfully fetched user data: " +userInfo[0].getProviderId());
			
			//sdk.inicializarFirebase("C:\\Users\\Vane\\eclipse-workspace\\SDKAdminFirebase\\claveSeguridadFirebase.json");
			sdk.inicializarFirebase("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\siat2\\jsonSDKAdminFirebase\\claveSeguridadFirebase.json");
			
			System.out.println("ok");
			userInfo = userRecord.getProviderData();
			System.out.println("Successfully fetched user data: " +userInfo[0].getProviderId());
			//userRecord = sdk.borrarUsuario(userRecord.getUid());
			
			//FirebaseAuth.getInstance().deleteUser(userRecord.getUid());
			//System.out.println("Successfully deleted user.");
	  }catch(Exception ex) {
		  System.out.println("exception: " + ex.getMessage());
	  }

	}

}
