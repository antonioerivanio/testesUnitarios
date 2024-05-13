package mockito;

import br.com.alura.testesunitario.mockito.AuthenticatorApplication;
import br.com.alura.testesunitario.mockito.AuthenticatorInterface;
import br.com.alura.testesunitario.mockito.EmptyCredentialsException;
import br.com.alura.testesunitario.mockito.NotAuthenticateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticatorApplication2Test {
    @Mock
    AuthenticatorInterface authenticatorMock;
    @InjectMocks
    AuthenticatorApplication authenticator;

    @Test
    public void testAuthenticate() throws EmptyCredentialsException {
        String username = "JavaCodeGeeks";
        String password = "unsafePassword";

        when(authenticatorMock.authenticateUser(username, password)).thenReturn(true);
        boolean actual = authenticator.authenticate("JavaCodeGeeks", "unsafePassword");
        assertTrue(actual);
    }

    @Test
    public void testAuthenticateVoidReturn() throws EmptyCredentialsException, NotAuthenticateException {
        String username = "JavaCodeGeeks";
        String password = "wrong password";

        doThrow(NotAuthenticateException.class).when(authenticatorMock)
                .authenticateUser2(username, password);

        assertThrows(NotAuthenticateException.class, () -> authenticator.authenticate2(username, password));
    }
}