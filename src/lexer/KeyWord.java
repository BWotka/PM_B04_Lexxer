package lexer;

import java.security.Key;

@Prio(value = 2)
public class KeyWord extends Token {

  public KeyWord() {
    super("(public|private|protected|abstract|void)");
  }

  public KeyWord(KeyWord oldKW) {
    this();
    super.content = oldKW.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newKW = new KeyWord(this);
    return newKW;
  }

  @Override
  protected String getContent() {
    return super.content;
  }
}
