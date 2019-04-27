import java.util.ArrayList;

abstract class ChessPieces {
    private int row, column;
    private String type, color;
    private boolean lose;
    private ArrayList<String> possibleToGo;

    //constructor
    public ChessPieces(int row, int column, String color){
        this.row = row;
        this.column = column;
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

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getColor() {
        return color;
    }

    //setter
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Pawn extends ChessPieces{
    public Pawn(int row, int column, String color){
        super(row, column, color);
        super.setType("Pawn");
    }
}

class Rook extends ChessPieces{
    public Rook(int row, int column, String color){
        super(row, column, color);
        super.setType("Rook");
    }
}

class Knigth extends ChessPieces{
    public Knigth(int row, int column,  String color){
        super(row, column, color);
        super.setType("Knigth");
    }
}

class Bishop extends ChessPieces{
    public Bishop(int row, int column, String color){
        super(row, column, color);
        super.setType("Bishop");
    }
}

class Queen extends ChessPieces{
    public Queen(int row, int column, String color){
        super(row, column, color);
        super.setType("Queen");
    }
}

class King extends ChessPieces{
    public King(int row, int column, String color){
        super(row, column, color);
        super.setType("King");
    }
}