package UsedClasses;
public class Cube {
    int y;
    int x;
    public Cube(int y, int x){
        this.y=y;
        this.x=x;

    }


    public void moveDown(){ this.y++; }
    public void moveUp(){
        this.y++;
    }

    public void moveLeft(){
        this.x--;
    }

    public void moveRight(){
        this.x++;
    }


    public boolean valid(){
        if (this.x<0||this.x>9||this.y<0||this.y>19){return false;}
        return true;
    }
}
