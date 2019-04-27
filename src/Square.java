public class Square {
    private String str;
    private ChessPieces mohre;

    public Square(String str, ChessPieces mohre){
        this.str = str;
        this.mohre = mohre;
    }

    //getter
    public ChessPieces getMohre() {
        return mohre;
    }

    public String getStr() {
        return str;
    }

    //setter
    public void setMohre(ChessPieces mohre) {
        this.mohre = mohre;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

//each square of ground