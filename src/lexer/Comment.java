package lexer;

public class Comment extends Token{
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