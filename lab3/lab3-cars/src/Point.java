import java.util.Random;

public class Point {

    public int type;
    public Point next;
    public boolean moved;
    public int speed;
    public Point left;
    public Point right;
    private double p = 5;
    private Random random = new Random();
    public static Integer[] types = {0,1,2,3,5};

    public void move() {
        if(moved == false){
            int maxSpeed = 2 * this.type + 1;

            if(speed < maxSpeed ) speed++;   // speed up

            Point curr_car = this;
            int distance = 0;
            while (distance < maxSpeed){
                if (curr_car.next.type != 0) {
                    break;
                }
                curr_car = curr_car.next;
                distance++;
            }

            curr_car = this;
            int i = 0;
            while (i < distance){
                curr_car = curr_car.next;
                i++;
            }

            curr_car.type = type;
            curr_car.moved = true;
            curr_car.speed = distance;
            clear();
            moved = true;
        }
    }

    public void overtaking(){
        moved = true;
        this.left.type = this.type;
        clear();
        this.left.speed = this.speed + 1;
        this.speed = 0;
    }

    public void back(){
        moved = true;
        this.right.type = this.type;
        clear();
        this.right.speed = this.speed ;
        this.speed = 0;
    }

    public void clicked() {
        this.type = 1;
    }

    public void clear() {
        this.type = 0;
    }
}