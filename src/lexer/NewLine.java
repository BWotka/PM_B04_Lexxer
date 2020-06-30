package lexer;

@Prio(value = 3)
public class NewLine extends Token {

  public NewLine() {
    super("\\n");
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
