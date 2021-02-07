package UsedClasses;

import java.awt.*;

public class ElYellow {
    Cube[] piece = new Cube[4];
    Color color = new Color(0x358649);
    int pos=0;

    public ElYellow(){
        int x=3;
        piece[0]= new Cube(0,5);
        for (int i=1; i<4; i++){
            piece[i]= new Cube(1,x++);
        }
    }

    public void rotate(){
        if (pos==0){
            piece[1] = new Cube(piece[1].y + 1, piece[1].x + 2);
            piece[2] = new Cube(piece[2].y - 1, piece[2].x);
            pos++;
        }

        else if (pos==1){
            piece[1] = new Cube(piece[1].y - 2, piece[1].x + 2);
            piece[2] = new Cube(piece[2].y, piece[2].x + 2);
            pos++;
        }

        else if (pos==2){
            piece[1] = new Cube(piece[1].y + 2, piece[1].x - 2);
            piece[2] = new Cube(piece[2].y + 2, piece[2].x);
            pos++;
        }

        else{
            piece[1] = new Cube(piece[1].y - 1, piece[1].x - 2);
            piece[2] = new Cube(piece[2].y - 1, piece[2].x - 2);
            pos = 0;
        }
    }

    //CODE JUST FOR DEBUGGING
    public void down(){
        for (int i=0; i<4; i++){ piece[i].moveDown(); }
    }
}
