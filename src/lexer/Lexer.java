package lexer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Lexer Class, saves tokens and finds matching tokens for String.
 *
 * @author Benedikt Wotka
 */
public class Lexer {

  private List<Token> token;
  private Token catchAll;

  Logger lexerLog;

  public Lexer() {
    token = new ArrayList<>();
    lexerLog = Logger.getLogger("LexLogging");
  }

  public void registerToken(Token toke) {
    token.add(toke);
    lexerLog.info("Token: " + toke.getClass().getName() + " was added.");
  }

  /**
   * Adds a complete list of tokens to the list of useable tokens.
   *
   * @param tokenList List of tokens to be added
   */
  public void registerToken(List<Token> tokenList) {
    token.addAll(tokenList);
    for (Token toke : tokenList) {

      lexerLog.info("Token: " + toke.getClass().getName() + " was added as part of a list.");
    }
  }

  /**
   * Saves the default token.
   *
   * @param allCatcher Token which should be used as default
   */
  public void registerCatchAll(Token allCatcher) {
    catchAll = allCatcher;

    lexerLog.info("CatchAll token: " + allCatcher.getClass().getName() + " was added.");
  }

  /**
   * Complete String is transformed to List of Tokens.
   *
   * @param toTokens String that should be scanned for tokens
   * @return List of Tokens found in string, in order of occurrence
   */
  public List<Token> tokenize(String toTokens) {
    List<Token> tokenFromString = new ArrayList<>();
    while (!toTokens.isEmpty()) {

      lexerLog.info("Tokenizing: Still " + toTokens.length() + " characters remaining.");
      tokenFromString.add(testTokens(toTokens));
      toTokens =
          toTokens.substring(tokenFromString.get(tokenFromString.size() - 1).getContent().length());
    }

    lexerLog.info("Tokenizing complete!");
    return tokenFromString;
  }

  private Token testTokens(String toToken) {
    for (Token t : token) {
      if (t.match(toToken) != null) {
        return t.getToken();
      }
    }
    lexerLog.info("CatchAll benutzt.");
    return catchAll.match(toToken);
  }
}
