package lexer;

import java.util.regex.Pattern;

@Prio(value = 3)
/**
 * low priority Token, recognizes new line characters
 *
 * @author Benedikt Wotka
 */
public class NewLine extends Token {

  private String content;

  public NewLine() {
    super();
    pattern = Pattern.compile("^\\n");
  }

  /**
   * Copy Constructor, creates a new Token with the same values
   *
   * @param oldNL original Token
   */
  public NewLine(NewLine oldNL) {
    this();
    content = oldNL.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newNL = new NewLine(this);
    return newNL;
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
