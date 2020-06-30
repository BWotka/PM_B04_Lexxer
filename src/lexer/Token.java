package lexer;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Benedikt Wotka
 *
 */
public abstract class Token {
  protected Pattern pattern;
  protected Matcher matcher;
  Logger lexerLog;

  protected String content;

  public Token(String regExp) {
    pattern = Pattern.compile(regExp);
    lexerLog = Logger.getLogger("LexLogging");
  }

  public final Token match(String matchString) {
    matcher = pattern.matcher(matchString);
    if (matcher.find()) {

      content = matcher.group();
      lexerLog.info("Token for " + matcher.group() + " was found.");
      // Matcher erstellt und abgespeichert, Token erstellt und abgespeichert

      return getToken();
    } else {
      return null;
    }
  }

  protected abstract Token getToken();

  protected abstract String getContent();
}
