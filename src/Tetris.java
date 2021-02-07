import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tetris extends JLayeredPane {
    Background background = new Background();
    Table table = new Table();
    FallPieces fallPieces = new FallPieces();
    public Tetris(){
        this.setLayout(null);

        background.setBounds(0,0,400,800);
        this.add(background, new Integer(0));

        table.setBounds(0,0,400,950);
        this.add(table, new Integer(1));

        fallPieces.setBounds(0,0,400,800);
        addKeyListener(fallPieces);
        this.add(fallPieces, new Integer(2));

    }


}
