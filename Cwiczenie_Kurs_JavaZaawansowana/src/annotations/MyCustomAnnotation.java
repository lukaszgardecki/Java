package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//kiedy nasza adnotacja ma byæ wykonana
@Retention(RetentionPolicy.RUNTIME)

//do czego ma byæ to adnotacja, np. do metody
@Target(ElementType.METHOD)
public @interface MyCustomAnnotation {
    //
    int value();
}
