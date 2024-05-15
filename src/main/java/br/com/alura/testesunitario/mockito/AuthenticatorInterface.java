package br.com.alura.testesunitario.mockito;

public interface AuthenticatorInterface {
    /**
     * User authentication method definition.
     *
     * @param username The user name to authenticate.
     * @param password The password to authenticate the user.
     * @return True if the user has been authenticated; false if it has not.
     //* @throws EmptyCredentialsException If the received credentials (user name, password) ←-
    are
     * empty.
     */
    public boolean authenticateUser(String username, String password) throws EmptyCredentialsException;
    public void authenticateUser2(String username, String password) throws NotAuthenticateException;

    public void foo();
}
