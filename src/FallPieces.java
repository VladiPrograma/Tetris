import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FallPieces extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(400, this);
    JLabel[][] arr= new JLabel[20][10];
    Pieces pieces = new Pieces();
    static boolean dead=false;
    public FallPieces(){
        timer.start();
        this.setLayout(null);
        this.setOpaque(false);
        this.addKeyListener(this);
        int y=0;
        for (int i=0; i<20; i++){
            int x=0;
            for (int j=0; j<10; j++){
                arr[i][j]= new JLabel();
                arr[i][j].setBounds(x,y,40,40);
                Border borderCubes = BorderFactory.createLineBorder(new Color(0x131313), 1);
                arr[i][j].setBorder(borderCubes);
                arr[i][j].setOpaque(true);
                arr[i][j].setVisible(false);
                this.add(arr[i][j]);
                x+=40;
            }
            y+=40;
        }
        for (int i=0; i<4; i++){
            arr[pieces.piece[i].y][pieces.piece[i].x].setBackground(pieces.color);
            arr[pieces.piece[i].y][pieces.piece[i].x].setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!pieces.valid()){
            Table.lose=true;
        }
        else {
            if (!dead) {
                clean();
                pieces.down();
                movePiece();
                repaint();
            }
            if (dead) {
                clean();
                dead = false;
                paintTable();
                pieces = new Pieces();


            }
        }
    }

    public void movePiece(){
        for (int i = 0; i < 4; i++) {
            arr[pieces.piece[i].y][pieces.piece[i].x].setBackground(pieces.color);
            arr[pieces.piece[i].y][pieces.piece[i].x].setVisible(true);
        }
    }

    public void clean(){
        for (int i=0; i<4; i++){
                arr[pieces.piece[i].y][pieces.piece[i].x].setVisible(false);
            }
    }



    public void paintTable(){
        for (int i=0; i<4; i++){
            Table.cubes[pieces.piece[i].y][pieces.piece[i].x].setBackground(pieces.color);
            Table.cubes[pieces.piece[i].y][pieces.piece[i].x].setVisible(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        if (e.getKeyChar()=='a'){
            System.out.println(e.getKeyChar());
            clean();
            pieces.left();
            movePiece();

        }
        if (e.getKeyChar()=='d'){
            System.out.println(e.getKeyChar());
            clean();
            pieces.right();
            movePiece();

        }
        if (e.getKeyChar()=='s'){
            System.out.println(e.getKeyChar());
            clean();
            pieces.down();
            movePiece();

        }

        if (e.getKeyChar()=='c'){
            System.out.println(e.getKeyChar());
            clean();
            pieces.rotate();
            movePiece();

        }

        if (e.getKeyChar()==' '){
            clean();
            while (!dead){
               pieces.down();
           }
            movePiece();

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
