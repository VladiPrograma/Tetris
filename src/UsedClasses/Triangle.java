import java.awt.*;

public class Triangle {
    Cube[] piece = new Cube[4];
    Color color = new Color(0x673586);
    int pos=0;

    public Triangle(){
        int x=3;
        piece[0]= new Cube(0,4);
        for (int i=1; i<4; i++){
            piece[i]= new Cube(1,x++);
        }
    }

    public void rotate(){

        if (pos==0) { piece[3] = new Cube(piece[3].y + 1, piece[3].x - 1 ); pos++; }
        else if (pos==1){ piece[0] = new Cube(piece[0].y + 1, piece[0].x + 1); pos++; }
        else if (pos==2){ piece[1] = new Cube(piece[1].y - 1, piece[1].x + 1); pos++; }
        else{
            piece[3]=piece[0];
            piece[0]=piece[1];
            piece[1]=new Cube(piece[1].y + 1, piece[1].x - 1);
            pos=0;
        }
    }

    //CODE JUST FOR DEBUGGING
    public void down(){
        for (int i=0; i<4; i++){ piece[i].moveDown(); }
    }



}
