public class EndsWithPeriod implements Expression {

    @Override
    public String interpret(String context) {
        if(!context.endsWith(".")) {
            context = context + ".";
        }
        return context;
    }
}
