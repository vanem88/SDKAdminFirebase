package sdk;

import java.io.FileInputStream;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;

public class SDKAdminFB {
	
	public SDKAdminFB() {}
	
	public void inicializarFirebase(String claveSeguridad) throws Exception{
	    	boolean hasBeenInitialized = false;
	        List<FirebaseApp> fbsLcl = FirebaseApp.getApps();
	        for (FirebaseApp app : fbsLcl) {
	            if (app.getName().equals("[DEFAULT]")) {
	                hasBeenInitialized = true;
	            }
	        }

	        FileInputStream serviceAccount =  new FileInputStream(claveSeguridad);
		    FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
			  .build();
	      	        
	        if (!hasBeenInitialized) 
	        	FirebaseApp.initializeApp(options);	
	}

	public void inicializarFirebase() throws Exception{
    	boolean hasBeenInitialized = false;
        List<FirebaseApp> fbsLcl = FirebaseApp.getApps();
        for (FirebaseApp app : fbsLcl) {
            if (app.getName().equals("[DEFAULT]")) {
                hasBeenInitialized = true;
            }
        }

	    FirebaseOptions options = new FirebaseOptions.Builder()
	      .setCredentials(GoogleCredentials.getApplicationDefault())
		  .build();
      	        
        if (!hasBeenInitialized) 
        	FirebaseApp.initializeApp(options);	
}

	
	
	//Recupera un Usuario a partir de su email
	public UserRecord obtenerUsuario(String email) {
		try {
			UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);
			return userRecord;
		}catch(Exception ex) {
			  return null;
		}
	}
	
	//Borra el usuario con su uid
	public boolean borrarUsuario(String uid) {
		try {
			FirebaseAuth.getInstance().deleteUser(uid);			
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	
	
}
