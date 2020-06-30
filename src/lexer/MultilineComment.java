package lexer;

public class MultilineComment extends Token {

  public MultilineComment() {
    super("\/\*.*\*\/");
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
