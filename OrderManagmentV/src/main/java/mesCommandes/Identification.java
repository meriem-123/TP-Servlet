package mesCommandes;
import jakarta.servlet.http.Cookie;

public class Identification {
	static String chercheNom (Cookie[] cookies) {
		// cherche dans les cookies la valeur de celui qui se nomme "nom"
		// retourne la valeur de ce nom au lieu de inconnu
		String username =null;if(cookies!=null) {
		for(Cookie ck : cookies) {
			if(ck.getName().equalsIgnoreCase("nom")) {
			 username = ck.getValue();
			 }
		}
		}
		return username;
	}
}
