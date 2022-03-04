import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	private Integer[] alive = new Integer[]{3};                // game of life
	private Integer[] dead = new Integer[]{2, 3};
	private Integer[] alive1 = new Integer[]{4, 5, 6, 7, 8};   //  cities
	private Integer[] dead1 = new Integer[]{2, 3, 4, 5};
	private Integer[] alive2 = new Integer[]{3};               // coral
	private Integer[] dead2 = new Integer[]{4, 5, 6, 7, 8};


	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

		public void clicked () {
			currentState = (++currentState) % numStates;
		}

		public int getState () {
			return currentState;
		}

		public void setState ( int s){
			currentState = s;
		}

		public void calculateNewState () {
			//TODO: insert logic which updates according to currentState and
			//number of active neighbors
			int aliveNeighbours = countNeighbour();
			if (currentState == 1) {
				if (Arrays.asList(dead1).contains(aliveNeighbours)) nextState = 1;
				else nextState = 0;
			}
			else {
				if (Arrays.asList(alive1).contains(aliveNeighbours)) nextState = 1;
				else nextState = 0;
			}
		}


		public void changeState () {
			currentState = nextState;
		}

		public void addNeighbor (Point nei){
			neighbors.add(nei);
		}

		//TODO: write method counting all active neighbors of THIS point


		private int countNeighbour() {
			int aliveNeighbours = 0;
			for (Point neighbor : neighbors) {
				if (neighbor.currentState == 1) aliveNeighbours += 1;
			}
			return aliveNeighbours;
		}
}
