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
                    System.out.print(ground[j][i].getMohre().getColor() + "-" + row + "" + (ground[j][i].getColumn() + 1) + "-" + ground[j][i].getMohre().getType() + " | ");
                } else {
                    char row = (char)(ground[j][i].getRow() + 65);
                    System.out.print(row + "" + (ground[j][i].getColumn() + 1) + "-" + "null | ");
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

    //getter
    public Square[][] getGround() {
        return ground;
    }
}