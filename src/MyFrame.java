import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Tetris tetris = new Tetris();
    MyFrame(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,950);
        this.getContentPane().setBackground( new Color(0x270128) );
        this.addKeyListener(tetris.fallPieces);
        tetris.setBounds(50,37,400,1000);
        this.add(tetris);









        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
