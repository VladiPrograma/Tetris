import java.awt.*;

public class ZigZagGreen {
    Cube[] piece = new Cube[4];
    Color color = new Color(0x358649);
    int pos=0;

    public ZigZagGreen(){
        int x=3;
        piece[0]= new Cube(0,4);
        piece[1]= new Cube(0,5);
        for (int i=2; i<4; i++){
            piece[i]= new Cube(1,x++);
        }
    }

    public void rotate(){
        if (pos==0){
            piece[0] = new Cube(piece[0].y, piece[0].x - 1 );
            piece[1] = new Cube(piece[1].y+2, piece[1].x - 1 );
            pos++; 
        }
        
        else{
            piece[0] = new Cube(piece[0].y, piece[0].x + 1 );
            piece[1] = new Cube(piece[1].y-2, piece[1].x + 1 );
            pos--;
        }
    }

        //CODE JUST FOR DEBUGGING
    public void down(){
        for (int i=0; i<4; i++){ piece[i].moveDown(); }
    }
}
