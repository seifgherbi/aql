package tp2;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest_exo2 {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@email.com");



        UserService userService = new UserService(utilisateurApiMock);

        userService.creerUtilisateur(utilisateur);


        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
}
