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
            if(player1.getCondition().equals("normal")) {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String currentPlace = scanner.next(), newPlace = scanner.next();
                    int currentRow = Row.valueOf(currentPlace.charAt(0)), currentColumn = ((int) (currentPlace.charAt(1) - '0' - 1));
                    int newRow = Row.valueOf(newPlace.charAt(0)), newColumn = ((int) (newPlace.charAt(1) - '0' - 1));
                    Square currentSquare = ground.getSquare(currentRow, currentColumn);
                    Square newSquare = ground.getSquare(newRow, newColumn);
                    //check is it player1's turn?
                    if(currentSquare.getMohre().getColor().equals("white")) {
                        boolean play = player1.play(currentSquare, newSquare, ground);
                        if(play) {
                            ground.printGround();
                            break;
                        }
                    }
                    else
                        System.out.println("It's white turn");
                }
            }
            else if(player1.getCondition().equals("kish"))
                ;//player1.play;
            else if(player1.getCondition().equals("check Mate")) {
                System.out.println("White player lose!");
                break;
            }
            if(player2.getCondition().equals("normal")) {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String currentPlace = scanner.next(), newPlace = scanner.next();
                    int currentRow = Row.valueOf(currentPlace.charAt(0)), currentColumn = ((int) (currentPlace.charAt(1) - '0' - 1));
                    int newRow = Row.valueOf(newPlace.charAt(0)), newColumn = ((int) (newPlace.charAt(1) - '0' - 1));
                    Square currentSquare = ground.getSquare(currentRow, currentColumn);
                    Square newSquare = ground.getSquare(newRow, newColumn);
                    //check is it player1's turn?
                    if(currentSquare.getMohre().getColor().equals("Black")) {
                        boolean play = player2.play(currentSquare, newSquare, ground);
                        if(play) {
                            ground.printGround();
                            break;
                        }
                    }
                    else
                        System.out.println("It's Black turn");
                }
            }
            else if(player2.getCondition().equals("kish"))
                ;//player1.play;
            else if(player2.getCondition().equals("check Mate")) {
                System.out.println("Black player lose!");
                break;
            }
        }
    }
}
