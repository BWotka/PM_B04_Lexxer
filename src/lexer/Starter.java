package lexer;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import lexer.Catch_All;
import lexer.Prio;
/** @author Benedikt Wotka, David Nickel */
public class Starter {
  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException, ClassNotFoundException, MalformedURLException {

    Lexer lexer = new Lexer();
    Logger lexLog = Logger.getLogger("LexLogging");

    // path of token classes
    File folder = new File("./src");
    URL[] ua = new URL[] {folder.toURI().toURL()};
    URLClassLoader ucl = URLClassLoader.newInstance(ua);

    // Lists of Tokens, sorted by Prio
    List<Token> tokenPrio1 = new ArrayList<>();
    List<Token> tokenPrio2 = new ArrayList<>();
    List<Token> tokenPrio3 = new ArrayList<>();
    // List of Tokens read in
    List<Token> tokenClasses = new ArrayList<>();

    Class<?> commentClass = ucl.loadClass("lexer.Comment");
    Class<?> keyWordClass = ucl.loadClass("lexer.KeyWord");
    Class<?> multilineCommentClass = ucl.loadClass("lexer.MultilineComment");
    Class<?> newLineClass = ucl.loadClass("lexer.NewLine");
    Class<?> stringContentClass = ucl.loadClass("lexer.StringContent");

    Constructor<?> ctorComment = commentClass.getConstructor();
    Constructor<?> ctorKeyWord = keyWordClass.getConstructor();
    Constructor<?> ctorMultiLine = multilineCommentClass.getConstructor();
    Constructor<?> ctorNewLine = newLineClass.getConstructor();
    Constructor<?> ctorStringCont = stringContentClass.getConstructor();

    tokenClasses.add((Token) ctorComment.newInstance());
    tokenClasses.add((Token) ctorKeyWord.newInstance());
    tokenClasses.add((Token) ctorMultiLine.newInstance());
    tokenClasses.add((Token) ctorNewLine.newInstance());
    tokenClasses.add((Token) ctorStringCont.newInstance());

    int prio;
    for (Token loadingClass : tokenClasses) {
      prio = loadingClass.getClass().getAnnotation(Prio.class).value();
      switch (prio) {
        case 1:
          tokenPrio1.add(loadingClass);
          break;
        case 2:
          tokenPrio2.add(loadingClass);
          break;
        case 3:
          tokenPrio3.add(loadingClass);
          break;
        default:
          lexLog.warning("Problem with sorting token by priority");
      }
    }
    // Token classen nach @Prio geordnet einfügen
    lexer.registerToken(tokenPrio1);
    lexer.registerToken(tokenPrio2);
    lexer.registerToken(tokenPrio3);

    Class<?> catchClass = ucl.loadClass("lexer.CatchAll");
    if (catchClass.isAnnotationPresent(Catch_All.class)) {
      Constructor<?> ctorCatch = catchClass.getConstructor();
      lexer.registerCatchAll((Token) ctorCatch.newInstance());
    }

    List<Token> tokensFromString = new ArrayList<>();
    tokensFromString = lexer.tokenize("// prima kommentar public \n protected 'test'");
    for (Token t : tokensFromString) {
      System.out.print(t.getContent() + "|");
    }
  }
}
