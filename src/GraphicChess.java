import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MoseMove implements MouseListener{
    private Square[][] buttons;

    public MoseMove(Square[][] buttons){
        this.buttons = buttons;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean find = false;
        int i = 0, j = 0;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                if(buttons[i][j] == ((Square)(e.getSource()))) {
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }
        for (int k = i - 1; k >= 0; k--) {
            buttons[k][j].setBackground(new Color(0xF04624));
        }
        for (int k = i + 1; k < 8; k++) {
            buttons[k][j].setBackground(new Color(0xF04624));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

public class GraphicChess {
    private JFrame frame;
    private JPanel line, chess, white, black, turn;
    private Square[][] buttons;

    public GraphicChess (){
        frame = new JFrame();
        GridLayout g = new GridLayout(8, 8, 10, 4);
        GridLayout g2 = new GridLayout(3, 0, 10 , 10);
        BorderLayout b = new BorderLayout();
        line = new JPanel();
        chess = new JPanel();
        white = new JPanel();
        black = new JPanel();
        turn = new JPanel();
        buttons = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new Square(0, 0, new ChessPieces(0, 0, "white") {
                    @Override
                    public void findAllPossibleToGo(Ground ground) {

                    }
                });
            }
        }

        frame.setLayout(new BorderLayout());
        frame.setLayout(b);

        line.setBackground(new Color(0xF0C373));
        chess.setBackground(new Color(0xC67D10));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i + j) % 2 == 0)
                    buttons[i][j].setBackground(new Color(0x000000));
                else
                    buttons[i][j].setBackground(new Color(0xFFFFFF));
            }
        }
        white.setBackground(new Color(0x6BF0E5));
        black.setBackground(new Color(0x6BF0E5));
        turn.setBackground(new Color(0xC67D10));

        line.setPreferredSize(new Dimension(400, 100));
        chess.setPreferredSize(new Dimension(100, 100));
        white.setPreferredSize(new Dimension(100, 100));
        black.setPreferredSize(new Dimension(100, 100));
        turn.setPreferredSize(new Dimension(100, 100));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                MoseMove mouseListener = new MoseMove(buttons);
                buttons[i][j].addMouseListener(mouseListener);
            }
        }

        chess.setLayout(g);
        line.setLayout(g2);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chess.add(buttons[i][j]);
            }
        }
        line.add(white);
        line.add(turn);
        line.add(black);

        frame.getContentPane().add(line,BorderLayout.WEST);
        frame.getContentPane().add(chess, BorderLayout.CENTER);
        frame.setSize(1500,700);
        frame.setVisible(true);
    }

    //getter

    public JButton[][] getButtons() {
        return buttons;
    }
}