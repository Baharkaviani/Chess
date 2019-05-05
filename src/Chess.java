import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        Ground ground = new Ground();
        Player player1 = new Player("white");
        Player player2 = new Player("Black");
        player1.putPiecesOnGround(ground);
        player2.putPiecesOnGround(ground);
        ground.printGround();
        while (true){
            boolean play = true;
            //player1
            Square player1King = ground.getSquare(0, 0);
            for (int i = 0; i < 16; i++) {
                if(player1.getPlayerPieces()[i].getType().equals("King")) {
                    player1King = ground.getSquare(player1.getPlayerPieces()[i].getRow(), player1.getPlayerPieces()[i].getColumn());
                    break;
                }
            }
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String currentPlace = scanner.next(), newPlace = scanner.next();
                int currentRow = Row.valueOf(currentPlace.charAt(0)), currentColumn = ((int) (currentPlace.charAt(1) - '0' - 1));
                int newRow = Row.valueOf(newPlace.charAt(0)), newColumn = ((int) (newPlace.charAt(1) - '0' - 1));
                Square currentSquare = ground.getSquare(currentRow, currentColumn);
                Square newSquare = ground.getSquare(newRow, newColumn);
                //check is it player1's turn?
                if(currentSquare.getMohre().getColor().equals("white")) {
                    play = player1.play(currentSquare, newSquare, ground, player2, player1King);
                    if(play) {
                        ground.printGround();
                        break;
                    }
                    else{
                        System.out.println("White player lose!!");
                        break;
                    }
                }
                else
                    System.out.println("It's white turn");
            }
            if(!play)
                break;
            //player2
            Square player2King = ground.getSquare(0, 0);
            for (int i = 0; i < 16; i++) {
                if(player2.getPlayerPieces()[i].getType().equals("King")) {
                    player2King = ground.getSquare(player2.getPlayerPieces()[i].getRow(), player2.getPlayerPieces()[i].getColumn());
                    break;
                }
            }
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String currentPlace = scanner.next(), newPlace = scanner.next();
                int currentRow = Row.valueOf(currentPlace.charAt(0)), currentColumn = ((int) (currentPlace.charAt(1) - '0' - 1));
                int newRow = Row.valueOf(newPlace.charAt(0)), newColumn = ((int) (newPlace.charAt(1) - '0' - 1));
                Square currentSquare = ground.getSquare(currentRow, currentColumn);
                Square newSquare = ground.getSquare(newRow, newColumn);
                //check is it player1's turn?
                if(currentSquare.getMohre().getColor().equals("Black")) {
                    play = player2.play(currentSquare, newSquare, ground, player1, player2King);
                    if(play) {
                        ground.printGround();
                        break;
                    }
                    else{
                        System.out.println("Black player lose!!");
                        break;
                    }
                }
                else
                    System.out.println("It's Black turn");
            }
            if(!play)
                break;
        }
    }
}
