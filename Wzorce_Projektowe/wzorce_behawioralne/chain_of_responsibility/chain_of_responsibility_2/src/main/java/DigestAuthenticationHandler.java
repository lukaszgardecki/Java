public class DigestAuthenticationHandler extends AuthenticationHandler {

  public DigestAuthenticationHandler(AuthenticationHandler handler) {
    super(handler);
  }

  public void handleRequest(String requestType) {
    if (requestType.equals("dig")) {
      System.out.println("Handling digest authentication");
    } else {
      super.handleRequest(requestType);
    }
  }

}
