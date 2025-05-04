package tp3_Fpart.exo1;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {

    @Test
    void testGetUserById() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        User mockUser = new User(1L, "John Doe");
        when(userRepository.findUserById(1L)).thenReturn(mockUser);

        // Act
        User user = userService.getUserById(1L);

        // Assert
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getName());

        // Verify
        verify(userRepository).findUserById(1L);
    }
}
