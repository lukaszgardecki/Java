public class Client {

  public static void main(String[] args) {
    DocumentHandler chain = new SlideshowHandler(new SpreadsheetHandler(new TextDocumentHandler(null)));
    chain.openDocument("ppt");
    chain.openDocument("txt");
  }

}
