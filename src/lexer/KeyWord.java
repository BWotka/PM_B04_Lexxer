package lexer;

@Prio(value = 2)
/** @author Benedikt Wotka */
public class KeyWord extends Token {

  private String content;

  public KeyWord() {
    super("^(public|private|protected|abstract|void)");
  }

  public KeyWord(KeyWord oldKW) {
    this();
    content = oldKW.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newKW = new KeyWord(this);
    return newKW;
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
