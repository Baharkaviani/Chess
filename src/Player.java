public class Player {
    private String color;
    private String condition;
    private ChessPieces[] playerPieces = new ChessPieces[16];

    //constructor
    public Player(String color){
        this.color = color;
        this.condition = "normal";
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
     * find the current place and try to move the piece of that square to new place.
     * also set new piece to new square if it can, so if hit sth it will lose!
     * if the movement will put player in check condition it will play back and want another movement.
     * @param ground get the ground to find the current place and new place;
     */
    public String play(Square currentSquare, Square newSquare, Ground ground, Player competitor, Square king){
        if(currentSquare.getMohre() == null){
            System.out.println("There is no piece to move! Try again.");
            return "false";
        }
        currentSquare.getMohre().findAllPossibleToGo(ground);
        ChessPieces poorPiece = ground.getSquare(newSquare.getRow(), newSquare.getColumn()).getMohre();
        boolean move = currentSquare.getMohre().move(newSquare);
        if(move){
            if(currentSquare.getMohre().getType().equals("King"))
                king = newSquare;
            ground.getSquare(newSquare.getRow(), newSquare.getColumn()).setMohre(currentSquare.getMohre());
            ground.getSquare(currentSquare.getRow(), currentSquare.getColumn()).setMohre(null);
            //play
            if(checkCondition(ground, competitor, king).equals("normal")){
                return "true";
            }
            //play back!
            else if(checkCondition(ground, competitor, king).equals("check")){
                System.out.println("You are check. Try another move!");
                newSquare.getMohre().moveBack(currentSquare);
                ground.getSquare(currentSquare.getRow(), currentSquare.getColumn()).setMohre(newSquare.getMohre());
                ground.getSquare(newSquare.getRow(), newSquare.getColumn()).setMohre(poorPiece);
                if(poorPiece != null)
                    poorPiece.setLose(false);
                return "check. Can't move!";
            }
            //finish
            else{
                return "Check Mate";
            }
        }
        else
            return "false";
    }

    /**
     * check that is the player in normal or check or check Mate condition
     * @param competitor
     */
    public String checkCondition(Ground ground, Player competitor, Square king){
        condition = "normal";
        for (int i = 0; i < 16; i++) {
            //if the piece didn't lose
            if(!competitor.getPlayerPieces()[i].isLose()){
                competitor.getPlayerPieces()[i].findAllPossibleToGo(ground);
                for (Square Key: competitor.getPlayerPieces()[i].getPossibleToGo()) {
                    if(Key.equals(king)) {
                        condition = "check";
                        break;
                    }
                }
            }
            if(condition.equals("check"))
                break;
        }
        king.getMohre().findAllPossibleToGo(ground);
        String newCondition = "normal";
        for (int j = 0; j < king.getMohre().getPossibleToGo().size(); j++) {
            Square nextKing = king.getMohre().getPossibleToGo().get(j);
            for (int i = 0; i < 16; i++) {
                //if the piece didn't lose
                if(!competitor.getPlayerPieces()[i].isLose()){
                    competitor.getPlayerPieces()[i].findAllPossibleToGo(ground);
                    for (Square Key: competitor.getPlayerPieces()[i].getPossibleToGo()) {
                        //if the King can move it's not in checkMate condition
                        if(Key.equals(nextKing)) {
                            newCondition = "check";
                            break;
                        }
                        newCondition = "normal";
                    }
                }
            }
            if(newCondition.equals("normal"))
                break;
        }
        if(newCondition.equals("check"))
            condition = "checkMate";
        return condition;
    }

    public ChessPieces[] getPlayerPieces() {
        return playerPieces;
    }
}
