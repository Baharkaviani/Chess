public class Chess {
    public static void main(String[] args) {
        Ground play = new Ground();
        Player player1 = new Player("white");
        Player player2 = new Player("Black");
        player1.putPiecesOnGround(play);
        player2.putPiecesOnGround(play);
        play.printGround();
        while (true){
            if(player1.getCondition().equals("normal"))
                player1.play(play);
            else if(player1.getCondition().equals("kish"))
                ;//player1.play;
            else if(player1.getCondition().equals("check Mate")) {
                System.out.println("White player lose!");
                break;
            }
            if(player2.getCondition().equals("normal"))
                ;//player1.play;
            else if(player2.getCondition().equals("kish"))
                ;//player1.play;
            else if(player2.getCondition().equals("check Mate")) {
                System.out.println("Black player lose!");
                break;
            }
        }
    }
}
