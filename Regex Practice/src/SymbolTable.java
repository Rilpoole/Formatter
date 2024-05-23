import java.util.ArrayList;

public class SymbolTable {
    private int tableIndex;
    private ArrayList<Token> tokens = new ArrayList<Token>();

    SymbolTable() {
        tableIndex = 0;
        resetIndex();
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public Token next() {
        //Increase the index number until there is a match

        //For every possible start value increasing 
        boolean matchFound = false;
        for(int start = tokens.get(tableIndex).getStart() + 1; start < Integer.MAX_VALUE; start++){//Add one to start to avoid picking up the last one
            //Check each token to see if there is a match, break if there is
            for(int token = 0; token < tokens.size(); token++){
                if(start == tokens.get(token).getStart()){
                    matchFound = true;
                    tableIndex = token;
                }
                if(matchFound){
                    break;
                }
            }
            if(matchFound){
                break;
            }
        }
        return tokens.get(tableIndex);
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void printTable() {
        for (int i = 0; i < tokens.size(); i++) {
            Token tkn = next();
            System.out.printf("%d %d %s \n", tkn.getStart(), tkn.getEnd(), tkn.getType());
        }
    }

    public void resetIndex() {
        // Set table index to lowest start index
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getStart() < tokens.get(tableIndex).getStart()) {
                tableIndex = i;
            }
        }
    }
}
