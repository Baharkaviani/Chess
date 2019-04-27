public class Ground {
    private Square[][] ground = new Square[8][8];

    public Ground(){
        for (int j = 0; j < 8; j++) {
            String str = "";
            switch (j){
                case 0:
                    str += "A";
                    break;
                case 1:
                    str += "B";
                    break;
                case 2:
                    str += "C";
                    break;
                case 3:
                    str += "D";
                    break;
                case 4:
                    str += "E";
                    break;
                case 5:
                    str += "F";
                    break;
                case 6:
                    str += "G";
                    break;
                case 7:
                    str += "H";
                    break;
            }
            for (int i = 0; i < 8; i++) {
                String strNum = str + Integer.toString(i + 1);
                ground[j][i] = new Square(strNum, null);
            }
        }
    }

    public void printGround(){
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                //print
                if(ground[j][i].getMohre() != null)
                    System.out.print(j + " " + i + ": " + ground[j][i].getMohre().getColor() + "-" + ground[j][i].getStr() + ground[j][i].getMohre().getType() +  " | ");
                else
                    System.out.print(j + " " + i + ": " + ground[j][i].getStr() +  "null | ");
                //
            }
            System.out.println();
        }
    }

    //getter
    public Square[][] getGround() {
        return ground;
    }

    //setter
    public void setSquare(int row, int column, ChessPieces piece){
        Square sq = new Square(ground[row][column].getStr(), piece);
        ground[row][column] = sq;
    }
}