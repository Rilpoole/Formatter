public class TextFormatterApp {
    /*
     * Basic Strategy
     * 1. Build symbol table of just the parts of the text I want to preserve
     * 2. Step through the symbol table rebuilding the new text.
     * 
     * I know that my method is complex, but it makes sense to me to separate it
     * this way, like a basic parser pattern style solution.
     * 
     * My symbol table contains tokens of the start and end indexes to conserve
     * memory, so each parser/table will not include a full copy of the original
     * text.
     * 
     * Known limitation: SymbolTable.next() needs a lower time complexity solution.
     */
    public static void main(String[] args) throws Exception {
        String test = "This  is the   test! ! Test!!t. \r\n \n .";
        Parser parser = new Parser(test);
        parser.getSymbolTable().printTable();
    }
}
