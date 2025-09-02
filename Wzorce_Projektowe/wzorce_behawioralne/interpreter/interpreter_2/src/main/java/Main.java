public class Main {

  public static void main(String[] args) {

    String context = "this is a a sentence";

    FirstLetterUpperCase firstLetterUpperCase = new FirstLetterUpperCase();
    context = firstLetterUpperCase.interpret(context);

    System.out.println(context);

  }

}
