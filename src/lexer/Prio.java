/**
 * 
 */
package lexer;

import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE_USE)
/**
 * @author admin
 *
 */
public @interface Prio {

}