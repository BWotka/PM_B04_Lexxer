package lexer;

@Prio(value = 1)
/** @author Benedikt Wotka */
public class Comment extends Token {
  public Comment() {
    super("^//.*($|\\n)");
  }

  public Comment(Comment oldCom) {
    this();
    super.content = oldCom.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newCom = new Comment(this);
    return newCom;
  }

  @Override
  protected String getContent() {
    return super.content;
  }

  @Override
  protected void setContent(String pcontent) {
    content = pcontent;
  }
}
