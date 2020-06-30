package lexer;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation used to specify the Targets Token Priority.
 *
 * @author David Nickel
 */
@Retention(RUNTIME)
@Target(TYPE) // kann nicht nur bei Klassendeklarationen genutzt werden.
public @interface Prio {
  int value() default 1;
}
