package lexer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token {
  protected Pattern pattern;
  protected Matcher matcher;

  protected String content;

  public Token(String regExp) {
    pattern = Pattern.compile(regExp);
  }

  public final Token match(String matchString) {
    matcher = pattern.matcher(matchString);
    if (matcher.find()) {

      content = matcher.group();
      // Matcher erstellt und abgespeichert, Token erstellt und abgespeichert

      return getToken();
    } else {
      return null;
    }
  }

  protected abstract Token getToken();

  protected abstract String getContent();
}
