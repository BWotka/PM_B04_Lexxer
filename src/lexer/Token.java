package lexer;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** @author Benedikt Wotka */
public abstract class Token {
  protected Pattern pattern;
  protected Matcher matcher;
  Logger lexerLog;

  public Token(String regExp) {
    pattern = Pattern.compile(regExp);
    lexerLog = Logger.getLogger("LexLogging");
  }

  public final Token match(String matchString) {
    matcher = pattern.matcher(matchString);
    if (matcher.find()) {

      this.setContent(matcher.group());
      lexerLog.info("Token for " + matcher.group() + " was found.");
      // Matcher erstellt und abgespeichert, Token erstellt und abgespeichert

      return getToken();
    } else {
      return null;
    }
  }

  protected abstract Token getToken();

  protected abstract String getContent();

  protected abstract void setContent(String pcontent);
}
