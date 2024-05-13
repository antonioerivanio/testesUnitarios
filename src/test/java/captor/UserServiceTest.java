package captor;

import br.com.alura.testesunitario.captor.UserData;
import br.com.alura.testesunitario.captor.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest{
    @Mock
    private UserService userServiceMock;

    @Captor
    private ArgumentCaptor<UserData> userDataArgumentCaptor;

    @Test
    public void saveUserTest() {
        UserData userData = new UserData("John Doe2");
        userServiceMock.saveUser(userData);
        // Capture the argument passed to the saveUser method
        verify(userServiceMock).saveUser(userDataArgumentCaptor.capture());
        UserData capturedUser = userDataArgumentCaptor.getValue();
        assertEquals("John Doe2", capturedUser.getName());
    }
}
