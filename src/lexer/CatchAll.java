package lexer;

public class CatchAll extends Token {
  private String content;

  public CatchAll() {
    super(".");
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
