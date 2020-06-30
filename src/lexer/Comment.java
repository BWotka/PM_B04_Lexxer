package lexer;

import java.util.regex.Pattern;

@Prio(value = 1)
/** @author Benedikt Wotka */
public class Comment extends Token {
  private String content;

  public Comment() {
    super();
    pattern = Pattern.compile("^//.*($|\\n)");
  }

  public Comment(Comment oldCom) {
    this();
    content = oldCom.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newCom = new Comment(this);
    return newCom;
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
