package lexer;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abstract Class for all Tokens.
 *
 * @author Benedikt Wotka
 */
public abstract class Token {
  protected Pattern pattern;
  protected Matcher matcher;
  Logger lexerLog;

  public Token() {

    lexerLog = Logger.getLogger("LexLogging");
  }

  /**
   * Matches the beginning of the string to one token.
   *
   * @param matchString String that it will test to match
   * @return Token if the pattern matches the string, else null
   */
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

  /**
   * Creates new identical Token and returns it.
   *
   * @return new Token with content being the text it matched
   */
  protected abstract Token getToken();

  /**
   * String to which it matched.
   *
   * @return String from content:String
   */
  protected abstract String getContent();

  /**
   * Sets content to param String.
   *
   * @param pcontent String that becomes the content
   */
  protected abstract void setContent(String pcontent);
}
