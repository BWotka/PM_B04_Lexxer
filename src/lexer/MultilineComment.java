package lexer;

@Prio(value = 1)
public class MultilineComment extends Token {

  public MultilineComment() {
    super("/\\*(.|[\\r\\n])*?\\*/");
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
