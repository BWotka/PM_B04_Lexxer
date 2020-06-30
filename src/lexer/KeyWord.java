package lexer;

public class KeyWord extends Token {

  public KeyWord() {
    super("(public|private|protected|abstract|void)");
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
