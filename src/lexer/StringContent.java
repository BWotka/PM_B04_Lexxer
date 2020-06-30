package lexer;

import java.util.regex.Pattern;

@Prio(value = 2)
public class StringContent extends Token {

  public StringContent() {
    super(" (([\"|\']).*\\2)?");
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    return this;
  }

  @Override
  protected String getContent() {
    return super.content;
  }
}
