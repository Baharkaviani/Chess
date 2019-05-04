import java.util.ArrayList;

abstract class ChessPieces {
    private int row, column;
    private String type, color;
    private boolean lose;
    private ArrayList<Square> possibleToGo;

    //constructor
    public ChessPieces(int row, int column, String color){
        this.row = row;
        this.column = column;
        possibleToGo = new ArrayList<>();
        lose = false;
        type = "";
        this.color = color;
    }

    /**
     * @param sq add sq to the arrayList which shows where the piece can go
     */
    public void addPossibleToGo(Square sq){
        possibleToGo.add(sq);
    }

    public void clearTheArrayList(){
        possibleToGo.clear();
    }

    public boolean move(Ground ground, Square newSquare){
        return false;
    }

    //getter
    public ArrayList<Square> getPossibleToGo() {
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

    public void setLose(boolean lose) {
        this.lose = lose;
    }
}

class Pawn extends ChessPieces{
    public Pawn(int row, int column, String color){
        super(row, column, color);
        super.setType("Pawn");
    }
    @Override
    public boolean move(Ground ground, Square newSquare){
        super.clearTheArrayList();
        //comment examples are for white pieces
        if(super.getColor().equals("white")){
            //check if the piece can go up or not. And how many steps it can go
            //if it's first move, it can go 1 or 2 steps
            if(super.getRow() == Row.G.ordinal()){
                if(ground.getGround()[super.getRow() - 1][super.getColumn()].getMohre() == null){
                    Square sq = ground.getSquare(super.getRow() - 1, super.getColumn());
                    super.addPossibleToGo(sq);
                    //print
                    System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                    //
                }
                if(ground.getGround()[super.getRow() - 2][super.getColumn()].getMohre() == null){
                    Square sq = ground.getSquare(super.getRow() - 2, super.getColumn());
                    super.addPossibleToGo(sq);
                    //print
                    System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                    //
                }
            }
            //if not, it can go just 1 step
            else {
                //normal!
                if(super.getRow() - 1 > 1) {
                    if (ground.getGround()[super.getRow() - 1][super.getColumn()].getMohre() == null) {
                        Square sq = ground.getSquare(super.getRow() - 1, super.getColumn());
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
                //if it reach to the A-Row it can change to another piece
                /*I didn't write how to change the piece yet
                 */
                if(super.getRow() - 1 == 1) {
                    if (ground.getGround()[super.getRow() - 1][super.getColumn()].getMohre() == null) {
                        Square sq = ground.getSquare(super.getRow() - 1, super.getColumn());
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
            //check if the piece can hit any pieces or not
            if(super.getColumn() == 0){
                if(ground.getGround()[super.getRow() - 1][super.getColumn() + 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() - 1][super.getColumn() + 1].getMohre().getColor().equals("Black")){
                        Square sq = ground.getSquare(super.getRow() - 1, super.getColumn() + 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
            else if(super.getColumn() == 7){
                if(ground.getGround()[super.getRow() - 1][super.getColumn() - 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() - 1][super.getColumn() - 1].getMohre().getColor().equals("Black")){
                        Square sq = ground.getSquare(super.getRow() - 1, super.getColumn() - 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
            else{
                if(ground.getGround()[super.getRow() - 1][super.getColumn() + 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() - 1][super.getColumn() + 1].getMohre().getColor().equals("Black")){
                        Square sq = ground.getSquare(super.getRow() - 1, super.getColumn() + 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
                if(ground.getGround()[super.getRow() - 1][super.getColumn() - 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() - 1][super.getColumn() - 1].getMohre().getColor().equals("Black")){
                        Square sq = ground.getSquare(super.getRow() - 1, super.getColumn() - 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
        }
        else if(super.getColor().equals("Black")){
            //check if the piece can go up or not. And how many steps it can go
            //if it's first move, it can go 1 or 2 steps
            if(super.getRow() == Row.B.ordinal()){
                if(ground.getGround()[super.getRow() + 1][super.getColumn()].getMohre() == null){
                    Square sq = ground.getSquare(super.getRow() + 1, super.getColumn());
                    super.addPossibleToGo(sq);
                    //print
                    System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                    //
                }
                if(ground.getGround()[super.getRow() + 2][super.getColumn()].getMohre() == null){
                    Square sq = ground.getSquare(super.getRow() + 2, super.getColumn());
                    super.addPossibleToGo(sq);
                    //print
                    System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                    //
                }
            }
            //if not, it can go just 1 step
            else {
                //normal!
                if(super.getRow() - 1 > 1) {
                    if (ground.getGround()[super.getRow() + 1][super.getColumn()].getMohre() == null) {
                        Square sq = ground.getSquare(super.getRow() + 1, super.getColumn());
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
                //if it reach to the A-Row it can change to another piece
                /*I didn't write how to change the piece yet
                 */
                if(super.getRow() - 1 == 1) {
                    if (ground.getGround()[super.getRow() + 1][super.getColumn()].getMohre() == null) {
                        Square sq = ground.getSquare(super.getRow() + 1, super.getColumn());
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
            //check if the piece can hit any pieces or not
            if(super.getColumn() == 0){
                if(ground.getGround()[super.getRow() + 1][super.getColumn() + 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() + 1][super.getColumn() + 1].getMohre().getColor().equals("white")){
                        Square sq = ground.getSquare(super.getRow() + 1, super.getColumn() + 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
            else if(super.getColumn() == 7){
                if(ground.getGround()[super.getRow() + 1][super.getColumn() - 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() + 1][super.getColumn() - 1].getMohre().getColor().equals("white")){
                        Square sq = ground.getSquare(super.getRow() + 1, super.getColumn() - 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
            else{
                if(ground.getGround()[super.getRow() + 1][super.getColumn() + 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() + 1][super.getColumn() + 1].getMohre().getColor().equals("white")){
                        Square sq = ground.getSquare(super.getRow() + 1, super.getColumn() + 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
                if(ground.getGround()[super.getRow() + 1][super.getColumn() - 1].getMohre() != null){
                    if(ground.getGround()[super.getRow() + 1][super.getColumn() - 1].getMohre().getColor().equals("white")){
                        Square sq = ground.getSquare(super.getRow() + 1, super.getColumn() - 1);
                        super.addPossibleToGo(sq);
                        //print
                        System.out.println("row: " + sq.getRow() + "column: " + sq.getColumn());
                        //
                    }
                }
            }
        }
        //print
        System.out.println("size: " + super.getPossibleToGo().size());
        //
        //move!!!!
        for (int i = 0; i < super.getPossibleToGo().size(); i++) {
            if(super.getPossibleToGo().get(i).equals(newSquare)){
                super.setRow(newSquare.getRow());
                super.setColumn(newSquare.getColumn());
                if(newSquare.getMohre() != null){
                    newSquare.getMohre().setLose(true);
                }
                return true;
            }
        }
        System.out.println("Can not move. Try again!");
        return false;
    }
}

class Rook extends ChessPieces{
    public Rook(int row, int column, String color){
        super(row, column, color);
        super.setType("Rook");
    }
}

class Knight extends ChessPieces{
    public Knight(int row, int column,  String color){
        super(row, column, color);
        super.setType("Knight");
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