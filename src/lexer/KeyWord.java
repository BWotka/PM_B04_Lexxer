package lexer;

public class KeyWord extends Token{
    private String content;
    @Override
    protected Token getToken() {
        return null;
    }

    @Override
    protected String getContent() {
        return content;
    }
}