package lexer;

import java.util.regex.Pattern;

@Catch_All
/** @author Benedikt Wotka */
public class CatchAll extends Token {
  private String content;

  public CatchAll() {
    super();
    pattern = Pattern.compile("^.");
  }

  public CatchAll(CatchAll oldCA) {
    this();
    content = oldCA.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newCA = new CatchAll(this);
    return newCA;
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
