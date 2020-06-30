package lexer;

@Catch_All
/**
 * 
 * @author Benedikt Wotka
 *
 */
public class CatchAll extends Token {
  private String content;

  public CatchAll() {
    super(".");
  }

  public CatchAll(CatchAll oldCA) {
    this();
    super.content = oldCA.getContent();
  }

  @Override
  protected Token getToken() {
    super.lexerLog.info("Token " + this.getClass().getName() + " was used.");
    Token newCA = new CatchAll(this);
    return newCA;
  }

  @Override
  protected String getContent() {
    return super.content;
  }
}
