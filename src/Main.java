public class Main {
    public static void main(String[] args) {
        GraphicChess chess = new GraphicChess();
        Ground ground = new Ground();
        Player player1 = new Player("white");
        Player player2 = new Player("Black");
        player1.putPiecesOnGround(ground);
        player2.putPiecesOnGround(ground);
    }
}