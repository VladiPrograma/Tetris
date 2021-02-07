import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JPanel implements ActionListener {
    static boolean lose=false;
    int score=0;
    int multiplier;
    int line=1031;
    JLabel scoreLabel = new JLabel("Score: "+ score);

    Timer timer = new Timer(400, this);
    static JLabel[][] cubes= new JLabel[20][10];

    public Table(){
        timer.start();
        this.setLayout(null);
        this.setBackground(new Color(0x1A001A));
        this.setOpaque(false);

        int y=0;
        for (int i=0; i<20; i++){
            int x=0;
            for (int j=0; j<10; j++){
                cubes[i][j]= new JLabel();
                cubes[i][j].setBounds(x,y,40,40);
                Border borderCubes = BorderFactory.createLineBorder(new Color(0x000000), 1);
                cubes[i][j].setBorder(borderCubes);
                cubes[i][j].setOpaque(true);
                cubes[i][j].setVisible(false);
                this.add(cubes[i][j]);
                x+=40;
            }
            y+=40;
        }

        scoreLabel.setBounds(0,813,400, 29);
        scoreLabel.setOpaque(false);
        scoreLabel.setVisible(true);
        scoreLabel.setFont(new Font("Comic sans1", Font.BOLD,35 ));
        scoreLabel.setForeground(new Color(0xFFF7F7));
        this.add(scoreLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        multiplier=0;
        while (lines()!=-1){
            replaceLine(lines());
            multiplier++;
        }
        score+= line*multiplier;
        scoreLabel.setText("Score: "+ score);

        if (lose){
            score=0;
            clean();
            lose=false;
        }
    }


    public int lines(){
        for (int i=0; i<20; i++){
            int cont=0;
            for (int j=0; j<10; j++) {
                if (cubes[i][j].isVisible()){ cont++;}
            }
            if (cont==10){return i;}
        }
        return -1;
    }

    public void replaceLine(int n){
        for (int i=n; i>=0; i--){
            for (int j=0; j<10; j++) {
                if (i!=0) {
                    if (cubes[i-1][j].isVisible()) {
                        cubes[i][j].setBackground(cubes[i - 1][j].getBackground());
                        cubes[i][j].setVisible(true);
                    }
                    else{cubes[i][j].setVisible(false);}
                }
                else{
                    cubes[i][j].setVisible(false);
                }
            }
        }
    }

    public void clean(){
        for (int i=0; i<20; i++){
            for (int j=0; j<10; j++) {
                cubes[i][j].setVisible(false);
            }
        }
    }






}
