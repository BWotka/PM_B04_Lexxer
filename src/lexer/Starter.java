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

import lexer.Catch_All;
import lexer.Prio;

public class Starter {
  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
          InstantiationException, ClassNotFoundException, MalformedURLException {
    Lexer lexer = new Lexer();
    
    File folder = new File("./src");
    URL[] ua = new URL[] {folder.toURI().toURL()};
    URLClassLoader ucl = URLClassLoader.newInstance(ua);
    List<Token> tokenPrio1 = new ArrayList<>();
    List<Token> tokenPrio2 = new ArrayList<>();
    List<Token> tokenPrio3 = new ArrayList<>();
    Class<?> commentClass = ucl.loadClass("lexer.Comment");
    int prio = commentClass.getAnnotation(Prio.class).value();
    Class<?>[] paramT = new Class<?>[] {};
    Method method = commentClass.getMethod("getToken", paramT);
    /*if (prio == 1) {
      tokenPrio1.append();
    }else if(prio == 2) {
      tokenPrio2.append();
    }else if (prio ==3) {
      tokenPrio3.append();
    }*/
    Class<?> keyWordClass = ucl.loadClass("lexer.Comment");
    prio = keyWordClass.getAnnotation(Prio.class).value();
    Class<?> multilineCommentClass = ucl.loadClass("lexer.Comment");
    prio = multilineCommentClass.getAnnotation(Prio.class).value();
    Class<?> newLineClass = ucl.loadClass("lexer.Comment");
    prio = newLineClass.getAnnotation(Prio.class).value();
    Class<?> stringContentClass = ucl.loadClass("lexer.Comment");
    prio = stringContentClass.getAnnotation(Prio.class).value();
    List<Token> tokenSortPrio = new ArrayList<>();

    
    // Token classen nach @Prio geordnet einfügen

    lexer.registerToken(tokenSortPrio);

    // loading the CatchAll Class from Path
    //File folder = new File("./src");
    //URL[] ua = new URL[] {folder.toURI().toURL()};
    //URLClassLoader ucl = URLClassLoader.newInstance(ua);

    Class<?> catchClass = ucl.loadClass("lexer.CatchAll");
    if (catchClass.isAnnotationPresent(Catch_All.class)) {
      
    }
    /*boolean a = catchClass.isAnnotationPresent(Catch_All.class);
    Annotation b = catchClass.getAnnotation(Prio.class);
    System.out.println(a);
    System.out.println(b);*/
    Constructor<?> ctorCatch = catchClass.getConstructor();
    lexer.registerCatchAll((Token) ctorCatch.newInstance());

    List<Token> tokensFromString = new ArrayList<>();
    tokensFromString = lexer.tokenize("public void // test \n ");
    for (Token t : tokensFromString) {
      System.out.println(t.getContent());
    }
  }
}
