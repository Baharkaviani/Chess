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
                //print
                System.out.print(j + " " + i + ": " + strNum + " | ");
                //
                ground[i][j] = new Square(str, null);
            }
            System.out.println();
        }
    }

    //getter
    public Square[][] getGround() {
        return ground;
    }
}