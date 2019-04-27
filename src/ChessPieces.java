import java.util.ArrayList;

abstract class ChessPieces {
    private String str, type, color;
    private boolean lose;
    private ArrayList<String> possibleToGo;

    public ChessPieces(String str, String color){
        this.str = str;
        possibleToGo = new ArrayList<>();
        lose = false;
        type = "";
        this.color = color;
    }

    //getter
    public ArrayList<String> getPossibleToGo() {
        return possibleToGo;
    }

    public String getType() {
        return type;
    }

    public String getStr() {
        return str;
    }

    public String getColor() {
        return color;
    }

    //setter
    public void setStr(String str) {
        this.str = str;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Pawn extends ChessPieces{
    public Pawn(String str, String color){
        super(str, color);
        super.setType("Pawn");
    }
}

class Rook extends ChessPieces{
    public Rook(String str, String color){
        super(str, color);
        super.setType("Rook");
    }
}

class Knigth extends ChessPieces{
    public Knigth(String str, String color){
        super(str, color);
        super.setType("Knigth");
    }
}

class Bishop extends ChessPieces{
    public Bishop(String str, String color){
        super(str, color);
        super.setType("Bishop");
    }
}

class Queen extends ChessPieces{
    public Queen(String str, String color){
        super(str, color);
        super.setType("Queen");
    }
}

class King extends ChessPieces{
    public King(String str, String color){
        super(str, color);
        super.setType("King");
    }
}