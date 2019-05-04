public class Ground {
    private Square[][] ground = new Square[8][8];

    //constructor
    public Ground(){
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                ground[j][i] = new Square(j, i, null);
            }
        }
    }

    /**
     * print the information of the ground on this order 'color-position-typeOfPiece'. Separated by '|'.
     */
    public void printGround(){
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (ground[j][i].getMohre() != null) {
                    char row = (char)(ground[j][i].getRow() + 65);
                    System.out.print(ground[j][i].getMohre().getColor() + "-" + row + "" + (ground[j][i].getColumn() + 1) + "-");
                    if(ground[j][i].getMohre().getType().equals("Bishop"))
                        System.out.print(ground[j][i].getMohre().getType() + " | ");
                    else if(ground[j][i].getMohre().getType().equals("King"))
                        System.out.print(ground[j][i].getMohre().getType() + "   | ");
                    else if(ground[j][i].getMohre().getType().equals("Knight"))
                        System.out.print(ground[j][i].getMohre().getType() + " | ");
                    else if(ground[j][i].getMohre().getType().equals("Pawn"))
                        System.out.print(ground[j][i].getMohre().getType() + "   | ");
                    else if(ground[j][i].getMohre().getType().equals("Queen"))
                        System.out.print(ground[j][i].getMohre().getType() + "  | ");
                    else if(ground[j][i].getMohre().getType().equals("Rook"))
                        System.out.print(ground[j][i].getMohre().getType() + "   | ");
                } else {
                    char row = (char)(ground[j][i].getRow() + 65);
                    System.out.print(row + "" + (ground[j][i].getColumn() + 1) + "-" + "null         | ");
                }
            }
            System.out.println();
        }
    }

    /**
     * put the piece on the ground
     * @param row the row of our ground
     * @param column the column of our ground
     * @param piece the piece that we want to put on the square
     */
    public void setSquare(int row, int column, ChessPieces piece){
        Square sq = new Square(row, column, piece);
        ground[row][column] = sq;
    }

    /**
     * @param row get the row of square
     * @param column get the column of square
     * @return return the row-column square
     */
    public Square getSquare(int row, int column){
        return ground[row][column];
    }

    //getter
    public Square[][] getGround() {
        return ground;
    }
}