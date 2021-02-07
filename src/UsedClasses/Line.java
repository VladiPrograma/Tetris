import java.awt.*;

public class Line{

    Cube[] piece = new Cube[4];
    Color color = new Color(0x358680);
    int pos=0;

    public Line(){
        int x=3;
        for (int i=0; i<4; i++){
            piece[i]= new Cube(0,x++);
        }
    }

    public void rotate(){

        if (pos==0) {
            piece[0] = new Cube(piece[0].y - 2, piece[0].x + 2);
            piece[1] = new Cube(piece[1].y - 1, piece[1].x + 1);
            piece[3] = new Cube(piece[3].y + 1, piece[3].x - 1 );
            pos++;
        }
        else{
            piece[0] = new Cube(piece[0].y + 2, piece[0].x - 2);
            piece[1] = new Cube(piece[1].y + 1, piece[1].x - 1);
            piece[3] = new Cube(piece[3].y - 1, piece[3].x + 1 );
            pos--;
        }
    }


    //METODOS IGUALES EN TODAS LAS PIEZAS QUE IRAN A LA CLASE FALLPIECES


}
