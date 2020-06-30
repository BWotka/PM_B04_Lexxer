/** */
package lexer;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE) // kann nicht nur bei Klassendeklarationen genutzt werden.
/** @author David Nickel */
public @interface Prio {
  int value() default 1;
}
