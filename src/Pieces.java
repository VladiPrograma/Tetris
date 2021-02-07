import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.awt.*;

public class Pieces {

    Cube[] piece = new Cube[4];
    Color color;
    int type=0;
    int pos=0;
    //Line=0, Triangle=1, ZigZagGreen=2, ZigZagRed=3, ElYellow=4, ElYellow=5, Block=6;

    public Pieces(){
        type = (int) (Math.random() * 7);

        if (type==0){
            color = new Color(0x23C484);
            int x = 3;
            for (int i=0; i<4; i++){
                piece[i] = new Cube(0, x++);
            }
        }
        else if (type==1){
            color = new Color(0x8D20D2);
            int x=3;
            piece[0]= new Cube(0,4);
            for (int i=1; i<4; i++){
                piece[i]= new Cube(1,x++);
            }
        }
        else if (type==2){
            color = new Color(0x24D43C);
            int x=3;
            piece[0]= new Cube(0,4);
            piece[1]= new Cube(0,5);
            for (int i=2; i<4; i++){
                piece[i]= new Cube(1,x++);
            }
        }
        else if (type==3){
            color = new Color(0xC71818);
            int x=4;
            piece[0]= new Cube(0,3);
            piece[1]= new Cube(0,4);
            for (int i=2; i<4; i++){
                piece[i]= new Cube(1,x++);
            }

        }
        else if (type==4){
            color = new Color(0xE2DB29);
            int x=3;
            piece[0]= new Cube(0,5);
            for (int i=1; i<4; i++){
                piece[i]= new Cube(1,x++);
            }
        }
        else if (type==5){
            color = new Color(0x234BD9);
            int x=3;
            piece[0]= new Cube(0,3);
            for (int i=1; i<4; i++){
                piece[i]= new Cube(1,x++);
            }
        }
        else{
            color = new Color(0xDE239B);
            piece[0]= new Cube(0,4);
            piece[1]= new Cube(0,5);
            piece[2]= new Cube(1,4);
            piece[3]= new Cube(1,5);


        }

    }

    public boolean valid(){
        for (int i=0; i<4; i++){
            if (!piece[i].valid()){return false;}
        }
        return true;
    }

    public void rotate(){
        if (type==0){
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

        else if(type==1){
            
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
        else if(type==2){
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
        else if(type==3){
            if (pos==0){
                piece[1] = new Cube(piece[1].y, piece[1].x + 1 );
                piece[0] = new Cube(piece[0].y+2, piece[0].x + 1 );
                pos++;
            }

            else{
                piece[1] = new Cube(piece[1].y, piece[1].x - 1 );
                piece[0] = new Cube(piece[0].y-2, piece[0].x - 1 );
                pos--;
            }
        }
        else if(type==4){
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
        else if(type==5){
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
        if(!valid()) {
            unrestrictedLeft();
            if (!valid()) {
                unrestrictedLeft();
                if (!valid()) {
                    unrestrictedRight();    unrestrictedRight();    unrestrictedRight();
                    if (!valid()) {
                        unrestrictedRight();
                        if (!valid()) {
                            unrestrictedLeft();     unrestrictedLeft();
                            if (!valid()) {
                                for (int i = 0; i < 3; i++) {
                                    unrestrictedRotate();
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    public void down(){
        if (!FallPieces.dead) {
            for (int i = 0; i < 4; i++) {
                piece[i].moveDown();
            }
            if (!valid()) {
                this.up();
                FallPieces.dead = true;
            }
        }
    }

    public void up(){
        if (!FallPieces.dead) {
            for (int i = 0; i < 4; i++) {
                piece[i].moveUp();
            }
            if (!valid()) {
                this.down();
            }
        }
    }

    public void left(){
        if (!FallPieces.dead) {
            for (int i=0; i<4; i++){
                piece[i].moveLeft();
            }
            if (!valid()) {
                this.right();
            }
        }
    }

    public void right(){
        if (!FallPieces.dead) {
            for (int i = 0; i < 4; i++) {
                piece[i].moveRight();
            }
            if (!valid()) {
                this.left();
            }
        }
    }


    public void unrestrictedRotate(){
        if (type==0){
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

        else if(type==1){

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
        else if(type==2){
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
        else if(type==3){
            if (pos==0){
                piece[1] = new Cube(piece[1].y, piece[1].x + 1 );
                piece[0] = new Cube(piece[0].y+2, piece[0].x + 1 );
                pos++;
            }

            else{
                piece[1] = new Cube(piece[1].y, piece[1].x - 1 );
                piece[0] = new Cube(piece[0].y-2, piece[0].x - 1 );
                pos--;
            }
        }
        else if(type==4){
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
        else if(type==5){
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
    }

    public void unrestrictedUp(){
        for (int i = 0; i < 4; i++) {
            piece[i].moveUp();
        }
    }

    public void unrestrictedDown(){
        for (int i = 0; i < 4; i++) {
            piece[i].moveDown();
        }
    }

    public void unrestrictedLeft(){
        for (int i = 0; i < 4; i++) {
            piece[i].moveLeft();
        }
    }

    public void unrestrictedRight(){
        for (int i = 0; i < 4; i++) {
            piece[i].moveRight();
        }
    }

}
