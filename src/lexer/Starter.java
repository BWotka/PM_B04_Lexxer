package lexer;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Starter {
  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException, ClassNotFoundException, MalformedURLException {
    Lexer lexer = new Lexer();
    List<Token> tokenSortPrio = new ArrayList<>();

    // Token classen nach @Prio geordnet einfügen

    lexer.registerToken(tokenSortPrio);

    // loading the CatchAll Class from Path
    File folder = new File("./src");
    URL[] ua = new URL[] {folder.toURI().toURL()};
    URLClassLoader ucl = URLClassLoader.newInstance(ua);
    Class<?> catchClass = ucl.loadClass("lexer.CatchAll");
    Constructor<?> ctorCatch = catchClass.getConstructor();
    lexer.registerCatchAll((Token) ctorCatch.newInstance());

    List<Token> tokensFromString = new ArrayList<>();
    tokensFromString = lexer.tokenize("public void // test \n ");
    for (Token t : tokensFromString) {
      System.out.println(t.getContent());
    }
  }
}
