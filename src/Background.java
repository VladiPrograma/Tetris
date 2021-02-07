import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Background extends JPanel {
    JLabel[][] cubes= new JLabel[20][10];
    public Background() {
        this.setLayout(null);
        this.setBackground(new Color(0x1A001A));
        this.setOpaque(false);
        int x = 0;
        int y = 0;
        for (int i = 0; i < 20; i++) {
            x = 0;

            for (int j = 0; j < 10; j++) {
                cubes[i][j] = new JLabel();
                cubes[i][j].setBounds(x, y, 40, 40);
                Border borderCubes = BorderFactory.createLineBorder(new Color(0x26A1A1), 1);
                cubes[i][j].setBorder(borderCubes);
                cubes[i][j].setBackground(new Color(0x4852AA));
                cubes[i][j].setOpaque(true);
                cubes[i][j].setVisible(true);
                this.add(cubes[i][j]);
                x += 40;
            }
            y += 40;
        }
        this.setVisible(true);
    }


}
