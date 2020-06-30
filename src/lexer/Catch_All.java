package lexer;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation only used on CatchAll token.
 *
 * @author David Nickel
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Catch_All {}
