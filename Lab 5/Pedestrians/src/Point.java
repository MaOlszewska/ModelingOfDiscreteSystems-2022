import java.util.ArrayList;

public class Point {

	public ArrayList<Point> neighbors;
	public static Integer []types ={0,1,2,3};
	public int type;
	public int staticField;
	public boolean isPedestrian;
	public boolean blocked;
	public int stop;

	public Point() {
		type=0;
		staticField = 100000;
		neighbors= new ArrayList<Point>();
		blocked = false;
		stop = 0;
	}
	public void stop(){
		stop = 5;
	}
	public void clear() {
		staticField = 100000;
	}

	public boolean calcStaticField() {
		if(neighbors.isEmpty() || this.type == 1){
			return false;
		}
		int smallest =1000000;
		int counter = 0;
		for(Point neigh : this.neighbors){
			if(neigh.type != 1 && neigh.staticField < smallest){
				smallest = neigh.staticField;
			}
			else{ counter += 1;}
		}
		if(this.staticField > smallest + 1 + counter){
			this.staticField = smallest + 1 + counter;
			return true;
		}
		return false;
	}
	
	public void move(){
		if(this.isPedestrian && !blocked){
			int smallest = 10000000;
			int index = 0;
			if(neighbors.size() != 0){
				for(int i = 0; i < neighbors.size() ;i++){
					Point tmp = neighbors.get(i);
					if(tmp.type != 1 && tmp.type != 3 && !tmp.isPedestrian  ) {
						if (smallest > neighbors.get(i).staticField) {
							index = i;
							smallest = neighbors.get(i).staticField;
						}
					}
				}
			}
			this.isPedestrian = false;
			if (neighbors.get(index).type != 2 && neighbors.get(index).type != 1) {
				neighbors.get(index).isPedestrian = true;
			}
		}

	}

	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}