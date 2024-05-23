import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private SymbolTable symbolTable = new SymbolTable();
    private String unformatted;
    private final String WINDOWS_NEWLINE = "\n";
    private final String UNIX_NEWLINE = "\r\n";

    Parser(String unformatted) {
        this.unformatted = unformatted;
        buildSymbolTable();
    }

    private void buildSymbolTable() {

        // Patterns
        Pattern wordPattern = Pattern.compile("\\w+");
        Pattern punPattern = Pattern.compile("\\p{Punct}+");
        String parPatternString = "[" + UNIX_NEWLINE + "|" + WINDOWS_NEWLINE + "]";
        Pattern parPattern = Pattern.compile(parPatternString);

        // Matchers
        Matcher wordMatcher = wordPattern.matcher(unformatted);
        Matcher punMatcher = punPattern.matcher(unformatted);
        Matcher parMatcher = parPattern.matcher(unformatted);

        // Get words
        while (wordMatcher.find()) {
            int start = wordMatcher.start();
            int end = start + wordMatcher.group().length() - 1;// Minus 1 for 0 based indexing
            String type = "WORD";
            symbolTable.addToken(new Token(start, end, type));
        }

        // Get punctuation
        while (punMatcher.find()) {
            int start = punMatcher.start();
            int end = start + punMatcher.group().length() - 1;// Minus 1 for 0 based indexing
            String type = "PUN";
            symbolTable.addToken(new Token(start, end, type));
        }

        // Get newline (paragraph marker)
        while (parMatcher.find()) {
            int start = parMatcher.start();
            int end = start + parMatcher.group().length() - 1;// Minus 1 for 0 based indexing
            String type = "PAR";
            symbolTable.addToken(new Token(start, end, type));
        }
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }
}
