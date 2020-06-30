package lexer;

@Prio(value = 3)
/**
 * 
 * @author Benedikt Wotka
 *
 */
public class NewLine extends Token {

  public NewLine() {
    super("\\n");
  }

  public NewLine(NewLine oldNL) {
    this();
    super.content = oldNL.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newNL = new NewLine(this);
    return newNL;
  }

  @Override
  protected String getContent() {
    return super.content;
  }
}
