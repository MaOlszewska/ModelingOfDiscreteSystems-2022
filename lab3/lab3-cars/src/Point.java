import java.util.Random;

public class Point {

    public int type;
    public Point next;
    public boolean moved;
    private int speed;
    private double p = 5;
    private Random random = new Random();

    public void move() {
        if (!moved && type == 1 && next.type == 0)
        {
            if(speed < 5 ) speed++;
            if (speed > 0 && random.nextInt(10) < p ) speed--;

            Point curr_car = this;
            int i = 0;
            while (i < speed){
                if (curr_car.next.type == 1) {
                    speed = i;
                    break;
                }
                curr_car = curr_car.next;
                i++;
            }


            type = 0;
            moved = true;
            curr_car.moved = true;
            curr_car.type = 1;
            curr_car.speed = speed;
            speed = 0;
        }
    }

    public void clicked() {
        this.type = 1;
    }

    public void clear() {
        this.type = 0;
    }
}