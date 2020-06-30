package lexer;

public class CatchAll extends Token {
  private String content;

  public CatchAll() {
    super(".");
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
