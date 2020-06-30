package lexer;

public class KeyWord extends Token {

  public KeyWord() {
    super("(public|private|protected|abstract|void)");
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
