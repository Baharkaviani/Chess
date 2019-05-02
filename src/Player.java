import java.util.Scanner;
import java.util.SplittableRandom;

public class Player {
    private String color;
    private String condition;
    private ChessPieces[] playerPieces = new ChessPieces[16];

    //constructor
    public Player(String color){
        this.color = color;
        condition = "normal";
    }

    /**
     * first make objects of pieces then put them on the ground
     * @param ground put pieces on the ground
     */
    public void putPiecesOnGround(Ground ground){
        //make objects of pieces
        if(color.equals("white")){
            for (int i = 0; i < 8 ; i++) {
                playerPieces[i] = new Pawn(Row.G.ordinal(),i,"white");
            }
            playerPieces[8] = new Rook(Row.H.ordinal(),0, "white");
            playerPieces[9] = new Knight(Row.H.ordinal(),1, "white");
            playerPieces[10] = new Bishop(Row.H.ordinal(), 2, "white");
            playerPieces[11] = new Queen(Row.H.ordinal(), 3, "white");
            playerPieces[12] = new King(Row.H.ordinal(), 4, "white");
            playerPieces[13] = new Bishop(Row.H.ordinal(), 5, "white");
            playerPieces[14] = new Knight(Row.H.ordinal(), 6, "white");
            playerPieces[15] = new Rook(Row.H.ordinal(), 7, "white");
        }
        else {
            for (int i = 0; i < 8 ; i++) {
                playerPieces[i] = new Pawn(Row.B.ordinal(), i, "Black");
            }
            playerPieces[8] = new Rook(Row.A.ordinal(), 0, "Black");
            playerPieces[9] = new Knight(Row.A.ordinal(), 1, "Black");
            playerPieces[10] = new Bishop(Row.A.ordinal(), 2, "Black");
            playerPieces[11] = new Queen(Row.A.ordinal(), 3, "Black");
            playerPieces[12] = new King(Row.A.ordinal(), 4, "Black");
            playerPieces[13] = new Bishop(Row.A.ordinal(), 5, "Black");
            playerPieces[14] = new Knight(Row.A.ordinal(), 6, "Black");
            playerPieces[15] = new Rook(Row.A.ordinal(), 7, "Black");
        }
        //put pieces on the ground
        for (int i = 0; i < 16; i++) {
            ground.setSquare(playerPieces[i].getRow(), playerPieces[i].getColumn(), playerPieces[i]);
        }
    }

    /**
     * find the current place and try to move the mohre of that square to new place.
     * @param ground get the ground to find the current place and new place;
     */
    public boolean play(Square currentSquare, Square newSquare, Ground ground){
        if(currentSquare.getMohre() == null){
            System.out.println("There is no piece to move! Try again.");
            return false;
        }
        boolean move = currentSquare.getMohre().move(ground, newSquare);
        if(move){
            ground.getSquare(newSquare.getRow(), newSquare.getColumn()).setMohre(currentSquare.getMohre());
            ground.getSquare(currentSquare.getRow(), currentSquare.getColumn()).setMohre(null);
            return true;
        }
        else
            return false;
    }

    //getter
    public String getCondition() {
        return condition;
    }
}
