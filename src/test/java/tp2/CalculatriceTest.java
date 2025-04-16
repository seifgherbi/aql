package tp2;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {

        when(calculatrice.additionner(2, 3)).thenReturn(5);


        int result = calculatrice.additionner(2, 3);


        assert result == 5;


        verify(calculatrice).additionner(2, 3);

        verifyNoMoreInteractions(calculatrice);
    }
}
