package br.com.alura.testesunitario.mockito;

public class AuthenticatorApplication {
    private AuthenticatorInterface authenticator;

    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    public boolean authenticate(String username, String password) throws
    EmptyCredentialsException{

        boolean authenticated;
        //this.authenticator.foo();
        authenticated = this.authenticator.authenticateUser(username, password);
        return authenticated;
    }

    public void authenticate2(String username, String password) throws NotAuthenticateException {
        this.authenticator.authenticateUser2(username, password);
    }
}
