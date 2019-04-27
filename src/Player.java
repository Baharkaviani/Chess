public class Player {
    private String color;
    private ChessPieces[] playerPieces = new ChessPieces[16];

    public Player(String color){
        this.color = color;
    }

    public void putPiecesOnGround(Ground ground){
        if(color.equals("white")){
            for (int i = 0; i < 8 ; i++) {
                String str = "G" + Integer.toString(i + 1);
                playerPieces[i] = new Pawn(str, "W");
            }
            playerPieces[8] = new Rook("H1", "W");
            playerPieces[9] = new Knigth("H2", "W");
            playerPieces[10] = new Bishop("H3", "W");
            playerPieces[11] = new Queen("H4", "W");
            playerPieces[12] = new King("H5", "W");
            playerPieces[13] = new Bishop("H6", "W");
            playerPieces[14] = new Knigth("H7", "W");
            playerPieces[15] = new Rook("H8", "W");
        }
        else {
            for (int i = 0; i < 8 ; i++) {
                String str = "B" + Integer.toString(i + 1);
                playerPieces[i] = new Pawn(str, "B");
            }
            playerPieces[8] = new Rook("A1", "B");
            playerPieces[9] = new Knigth("A2", "B");
            playerPieces[10] = new Bishop("A3", "B");
            playerPieces[11] = new Queen("A4", "B");
            playerPieces[12] = new King("A5", "B");
            playerPieces[13] = new Bishop("A6", "B");
            playerPieces[14] = new Knigth("A7", "B");
            playerPieces[15] = new Rook("A8", "B");
        }
        //put pieces on the ground
        for (int i = 0; i < 16; i++) {
            int row = -1, column;
            switch (playerPieces[i].getStr().charAt(0)){
                case 'A':
                    row = 0;
                    break;
                case 'B':
                    row = 1;
                    break;
                case 'C':
                    row = 2;
                    break;
                case 'D':
                    row = 3;
                    break;
                case 'E':
                    row = 4;
                    break;
                case 'F':
                    row = 5;
                    break;
                case 'G':
                    row = 6;
                    break;
                case 'H':
                    row = 7;
            }
            column = (int)(playerPieces[i].getStr().charAt(1) - '0') - 1;
            ground.setSquare(row, column, playerPieces[i]);
        }
     }
}
