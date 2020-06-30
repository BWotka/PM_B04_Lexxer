package lexer;

public class Comment extends Token {
  public Comment() {
    super("//.*$");
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
