package lexer;

@Prio(value = 1)
public class MultilineComment extends Token {

  public MultilineComment() {
    super("^/\\*(.|[\\r\\n])*?\\*/");
  }

  public MultilineComment(MultilineComment oldMCom) {
    this();
    super.content = oldMCom.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newMCom = new MultilineComment(this);
    return newMCom;
  }

  @Override
  protected String getContent() {
    return super.content;
  }
}
