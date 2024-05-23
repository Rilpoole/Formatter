public class TextFormatter {

    private int col = -1;
    private StringBuilder formatted = new StringBuilder();
    private StringBuilder group = new StringBuilder();
    private Boolean makePunctuation= false;
    private Boolean makeWord = false;

    public String formatText(String unformatted, SymbolTable symbolTable) {

        formatted.append(newParagraph());

        for (int i = 0; i < symbolTable.getTokens().size(); i++) {

            Token tkn = symbolTable.next();

            // Build punctuation group
            if (tkn.getType() == "PUN") {
                
            }

            // Build word and punctuation group
            else if (tkn.getType() == "WORD") {

            }

            // Could be no group
            else if (tkn.getType() == "PAR") {
                newParagraph();
            }

            // If the group will fit append else newline

        }

        return formatted.toString();
    }

    public String newParagraph() {
        col = 3;
        return "\n  ";
    }

    public void appendGroup(String group) {
        formatted.append(group);
        makePunctuation = false;
        makeWord = false;
    }
}
