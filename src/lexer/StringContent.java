package lexer;

import java.util.regex.Pattern;

@Prio(value = 2)
/** @author Benedikt Wotka */
public class StringContent extends Token {

  private String content;

  public StringContent() {
    super();
    pattern = Pattern.compile("^(([\"|\']).*\\2)");
  }

  public StringContent(StringContent oldSC) {
    this();
    content = oldSC.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newSC = new StringContent(this);
    return newSC;
  }

  @Override
  protected String getContent() {
    return content;
  }

  @Override
  protected void setContent(String pcontent) {
    content = pcontent;
  }
}
