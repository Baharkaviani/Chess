public class Square {
    private int row, column;
    private ChessPieces mohre;

    //constructor
    public Square(int row, int column, ChessPieces mohre){
        this.row = row;
        this.column = column;
        this.mohre = mohre;
    }

    //getter
    public ChessPieces getMohre() {
        return mohre;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    //setter
    public void setMohre(ChessPieces mohre) {
        this.mohre = mohre;
    }
}