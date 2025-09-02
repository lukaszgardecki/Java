public class ClientCertificateAuthenticationHandler extends AuthenticationHandler {

  public ClientCertificateAuthenticationHandler(AuthenticationHandler handler) {
    super(handler);
  }

  public void handleRequest(String requestType) {
    if (requestType.equals("cert")) {
      System.out.println("Handling client certificate authentication");
    } else {
      super.handleRequest(requestType);
    }
  }

}
