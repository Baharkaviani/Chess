import java.lang.management.PlatformLoggingMXBean;

public class Chess {
    public static void main(String[] args) {
        Ground play = new Ground();
        Player player1 = new Player("white");
        Player player2 = new Player("Black");
        player1.putPiecesOnGround(play);
        player2.putPiecesOnGround(play);
        play.printGround();
    }
}
