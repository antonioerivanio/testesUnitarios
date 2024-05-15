package mockito;

import br.com.alura.testesunitario.mockito.AuthenticatorApplication;
import br.com.alura.testesunitario.mockito.AuthenticatorInterface;
import br.com.alura.testesunitario.mockito.EmptyCredentialsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class AuthenticatorApplicationTest {
    @Test
    public void testAuthenticate() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password ="unsafePassword";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);
        //Mockito.verify(authenticatorMock).authenticateUser(username, password);
        //Mockito.verify(authenticatorMock).authenticateUser(username, "not the original password");
        Mockito.verify(authenticatorMock, Mockito.times(1)).authenticateUser(username, password);
        Mockito.verify(authenticatorMock, Mockito.atLeastOnce()).authenticateUser(username, password);
        Mockito.verify(authenticatorMock, Mockito.atLeast(1)).authenticateUser(username, password);
        Mockito.verify(authenticatorMock, Mockito.atMost(1)).authenticateUser(username, password);
        Mockito.verify(authenticatorMock, Mockito.never()).authenticateUser(username, password);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testOrder() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password ="unsafePassword";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);
        InOrder inOrder = Mockito.inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).foo();
        inOrder.verify(authenticatorMock).authenticateUser(username, password);
    }

    @Test
    public void testTimeout() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password ="unsafePassword";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
        boolean actual = authenticator.authenticate(username, password);

        Mockito.verify(authenticatorMock, Mockito.timeout(100)).authenticateUser(username, password);
    }

    @Test
    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        when(authenticatorMock.authenticateUser("", ""))
                .thenThrow(new EmptyCredentialsException());

        assertThrows(EmptyCredentialsException.class, () -> authenticator.authenticate("", ""));
    }
}
