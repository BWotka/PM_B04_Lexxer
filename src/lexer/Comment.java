package lexer;

@Prio(value = 1)
public class Comment extends Token {
  public Comment() {
    super("//.*$");
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
