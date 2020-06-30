package lexer;

import java.util.regex.Pattern;

public class StringContent extends Token {

  public StringContent() {
    super(" (([\"|\']).*\\1)?");
  }

  @Override
  protected Token getToken() {
    return this;
  }

  @Override
  protected String getContent() {
    return super.content;
  }
}
