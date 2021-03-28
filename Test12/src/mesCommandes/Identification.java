package mesCommandes;

import javax.servlet.http.Cookie;

public class Identification {

	
	public static String chercheNom(Cookie[] cookies) {
		// cherche dans les cookies la valeur de celui qui se nomme "nom"
				String nom=null;
				if(cookies!=null) {
					for(Cookie cookie : cookies) {
						if(cookie.getName().equals("nom")) {
							nom=cookie.getValue();
						}
					}
				}
				// retourne la valeur de ce nom au lieu de inconnu
				return nom;
			}

	
	}

