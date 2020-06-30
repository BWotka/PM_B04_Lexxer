package lexer;

public class NewLine extends Token {

  public NewLine() {
    super("\\n");
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
