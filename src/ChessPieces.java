import java.util.ArrayList;

abstract class ChessPieces {
    private String str;
    private boolean lose;
    private ArrayList<String> possibleToGo;

    public ChessPieces(String str){
        this.str = str;
        possibleToGo = new ArrayList<>();
        lose = false;
    }

    //getter
    public ArrayList<String> getPossibleToGo() {
        return possibleToGo;
    }

    //setter
    public void setStr(String str) {
        this.str = str;
    }
}

class Pawn extends ChessPieces{
    public Pawn(String str){
        super(str);
    }
}

class Rook extends ChessPieces{
    public Rook(String str){
        super(str);
    }
}

class Knigth extends ChessPieces{
    public Knigth(String str){
        super(str);
    }
}

class Bishop extends ChessPieces{
    public Bishop(String str){
        super(str);
    }
}

class Queen extends ChessPieces{
    public Queen(String str){
        super(str);
    }
}

class King extends ChessPieces{
    public King(String str){
        super(str);
    }
}