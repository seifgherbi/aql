package tp2;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestexo3 {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    // 📝 SCENARIO 1 : Lever une exception lors de la création de l'utilisateur avec l’exception
    @Test
    public void testCreerUtilisateur_Echec() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("GHERBI", "SEIF", "SEIF@email.com");


        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);


        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });


        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    // 📝 SCENARIO 2 : Tester le comportement en cas d'erreur de validation. Penser à utiliser la
    //méthode never()
    @Test
    public void testCreerUtilisateur_ValidationEchouee() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("GHERBI", "SEIF", "SEIF@email.com");

        UserService userService = new UserService(utilisateurApiMock);

        verify(utilisateurApiMock, never()).creerUtilisateur(utilisateur);
    }

    // 📝 SCENARIO 3 : Supposons que l'API renvoie un identifiant unique pour l'utilisateur créé
    @Test
    public void testCreerUtilisateur_AvecID() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("GHERBI", "SEIF", "SEIF@email.com");


        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(123);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        assertEquals(123, utilisateur.getId());
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    // 📝 SCENARIO 4 :  utiliser des arguments capturés pour vérifier les arguments exacts.
    @Test
    public void testCreerUtilisateur_ArgumentCapture() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("GHERBI", "SEIF", "SEIF@email.com");


        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(123);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);


        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("GHERBI", utilisateurCapture.nom);
        assertEquals("SEIF", utilisateurCapture.prenom);
        assertEquals("SEIF@email.com", utilisateurCapture.email);
    }
}

