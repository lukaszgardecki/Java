public class FirstLetterUpperCase implements Expression {
    private final NoRepeatedWords noRepeatedWords = new NoRepeatedWords();

    @Override
    public String interpret(String context) {
        context = context.substring(0,1).toUpperCase() + context.substring(1);
        return noRepeatedWords.interpret(context);
    }
}
