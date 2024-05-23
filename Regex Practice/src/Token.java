public class Token {
    private int start = 0;
    private int end = 0;
    private String type = "";

    Token(int start, int end, String type){
        this.start = start;
        this.end = end; 
        this.type = type;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public String getType() {
        return type;
    }
}
