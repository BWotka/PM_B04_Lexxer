package lexer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lexer {
  private List<Token> token;
  private Token catchAll;

  public Lexer() {
    token = new ArrayList<>();
  }

  public void registerToken(Token toke) {
    token.add(toke);
  }

  public void registerToken(List<Token> tokenList) {
    token.addAll(tokenList);
  }

  public void registerCatchAll(Token allCatcher) {
    catchAll = allCatcher;
  }

  public List<Token> tokenize(String toTokens) {
    List<Token> tokenFromString = new ArrayList<>();
    while (!toTokens.isEmpty()) {
      tokenFromString.add(testTokens(toTokens));
      toTokens =
          toTokens.substring(tokenFromString.get(tokenFromString.size()).getContent().length());
    }
    return tokenFromString;
  }

  private Token testTokens(String toToken) {
    for (Token t : token) {
      if (t.match(toToken) != null) {
        return t;
      }
    }
    return catchAll.match(toToken);
  }
}
