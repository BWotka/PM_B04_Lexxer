package lexer;

import java.util.regex.Pattern;

@Prio(value = 2)
/**
 * 
 * @author Benedikt Wotka
 *
 */
public class StringContent extends Token {

  public StringContent() {
    super("(([\"|\']).*\\2)");
  }

  public StringContent(StringContent oldSC) {
    this();
    super.content = oldSC.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newSC = new StringContent(this);
    return newSC;
  }

  @Override
  protected String getContent() {
    return super.content;
  }
}
