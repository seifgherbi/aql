package tp2;



public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        int id = utilisateurApi.creerUtilisateur(utilisateur);
        utilisateur.setId(id);
    }
}


