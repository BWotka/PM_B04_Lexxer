package lexer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token {
    protected Pattern pattern;
    protected Matcher matcher;

    public Token(){

    }
    public final Token match(String matchString){
        if(false){
            // Matcher erstellt und abgespeichert, Token erstellt und abgespeichert

            return getToken();
        }
        else{
            return null;
        }
    }
    protected abstract Token getToken();

    protected abstract String getContent();

}
