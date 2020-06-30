package lexer;

public class MultilineComment extends Token {

  public MultilineComment() {
    super("/\\*(.|[\\r\\n])*?\\*/");
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
