import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState() {
		//TODO: insert logic which updates according to currentState and 
		//number of active neighbors
		int aliveNeighbours = countNeighbour();
		System.out.println(currentState +" "+ aliveNeighbours);
		if(currentState > 0){
			nextState = currentState -1;
		}
		else if(currentState == 0 && neighbors.size() >= 1 && neighbors.get(0).getState() > 0){
			nextState = 6;
		}

	}
	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
	public void drop(){
		Random randomNumber = new Random();
		if(randomNumber.nextInt(100) <= 5){
			currentState = 6;
		}
	}
	private int countNeighbour() {
		int aliveNeighbours = 0;
		for (Point neighbor : neighbors) {
			if (neighbor.currentState > 0) aliveNeighbours += 1;
		}
		return aliveNeighbours;
	}
}
