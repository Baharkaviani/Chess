import java.util.Scanner;

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
                playerPieces[i] = new Pawn(Row.G.ordinal(),i,"W");
            }
            playerPieces[8] = new Rook(Row.H.ordinal(),0, "W");
            playerPieces[9] = new Knigth(Row.H.ordinal(),1, "W");
            playerPieces[10] = new Bishop(Row.H.ordinal(), 2, "W");
            playerPieces[11] = new Queen(Row.H.ordinal(), 3, "W");
            playerPieces[12] = new King(Row.H.ordinal(), 4, "W");
            playerPieces[13] = new Bishop(Row.H.ordinal(), 5, "W");
            playerPieces[14] = new Knigth(Row.H.ordinal(), 6, "W");
            playerPieces[15] = new Rook(Row.H.ordinal(), 7, "W");
        }
        else {
            for (int i = 0; i < 8 ; i++) {
                playerPieces[i] = new Pawn(Row.B.ordinal(), i, "B");
            }
            playerPieces[8] = new Rook(Row.A.ordinal(), 0, "B");
            playerPieces[9] = new Knigth(Row.A.ordinal(), 1, "B");
            playerPieces[10] = new Bishop(Row.A.ordinal(), 2, "B");
            playerPieces[11] = new Queen(Row.A.ordinal(), 3, "B");
            playerPieces[12] = new King(Row.A.ordinal(), 4, "B");
            playerPieces[13] = new Bishop(Row.A.ordinal(), 5, "B");
            playerPieces[14] = new Knigth(Row.A.ordinal(), 6, "B");
            playerPieces[15] = new Rook(Row.A.ordinal(), 7, "B");
        }
        //put pieces on the ground
        for (int i = 0; i < 16; i++) {
            ground.setSquare(playerPieces[i].getRow(), playerPieces[i].getColumn(), playerPieces[i]);
        }
    }

    /**
     *
     * @param ground
     */
    public void play(Ground ground){
        Scanner scanner = new Scanner(System.in);
        String currentPlace = scanner.next(), newPlace = scanner.next();

    }
    //getter
    public String getCondition() {
        return condition;
    }
}
