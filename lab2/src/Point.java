public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer[] types = {0, 1, 2};
	int type = 0;
	int sinInput;
	public Point() {
		clear();
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		pressure = 0;
		nVel = 0;
		eVel = 0;
		wVel = 0;
		sVel = 0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		if (type == 0) {
			nVel = nVel - (nNeighbor.pressure - pressure);
			eVel = eVel - (eNeighbor.pressure - pressure);
			wVel = wVel - (wNeighbor.pressure - pressure);
			sVel = sVel - (sNeighbor.pressure - pressure);
		}
	}

	public void updatePresure() {
		// TODO: pressure update
		sinInput+=3;
		if ( type == 2){
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
		else if (type == 0) {
			float c = 0.5f;
			pressure = pressure - c * (nVel + eVel + sVel + wVel);
		}
		else return;
	}

	public float getPressure() {
		return pressure;
	}
}