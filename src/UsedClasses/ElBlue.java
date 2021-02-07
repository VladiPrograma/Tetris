import java.awt.*;

public class ElBlue {
    Cube[] piece = new Cube[4];
    Color color = new Color(0x354086);
    int pos=0;

    public ElBlue(){
        int x=3;
        piece[0]= new Cube(0,3);
        for (int i=1; i<4; i++){
            piece[i]= new Cube(1,x++);
        }
    }

    public void rotate(){
        if (pos==0){
            piece[3] = new Cube(piece[3].y - 2, piece[3].x - 1);
            piece[2] = new Cube(piece[2].y - 2, piece[2].x - 1);
            pos++;
        }

        else if (pos==1){
            piece[3] = new Cube(piece[3].y + 1, piece[3].x - 3);
            piece[2] = new Cube(piece[2].y + 1, piece[2].x - 1);
            pos++;
        }

        else if (pos==2){
            piece[3] = new Cube(piece[3].y - 1, piece[3].x + 2);
            piece[2] = new Cube(piece[2].y + 1, piece[2].x);
            pos++;
        }

        else{
            piece[3] = new Cube(piece[3].y + 2, piece[3].x + 2);
            piece[2] = new Cube(piece[2].y, piece[2].x + 2);
            pos = 0;
        }
    }

    //CODE JUST FOR DEBUGGING
    public void down(){
        for (int i=0; i<4; i++){ piece[i].moveDown(); }
    }
}

