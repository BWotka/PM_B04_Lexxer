package lexer;

@Prio(value = 1)
/** @author Benedikt Wotka */
public class MultilineComment extends Token {

  private String content;

  public MultilineComment() {
    super("^/\\*(.|[\\r\\n])*?\\*/");
  }

  public MultilineComment(MultilineComment oldMCom) {
    this();
    content = oldMCom.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newMCom = new MultilineComment(this);
    return newMCom;
  }

  @Override
  protected String getContent() {
    return content;
  }

  @Override
  protected void setContent(String pcontent) {
    content = pcontent;
  }
}
