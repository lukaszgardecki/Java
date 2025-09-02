public abstract class DocumentHandler {

  private final DocumentHandler next;

  public DocumentHandler(DocumentHandler next) {
    this.next = next;
  }

  void openDocument(String fileExtension) {
    if(next != null) {
      next.openDocument(fileExtension);
    }
  }

}
