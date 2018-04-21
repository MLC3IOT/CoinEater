package c3iotminh;

/**
 * @author Minh Ly
 * @version 1.0
 * 
 */
public class Position {
	private int X;
	private int Y;
	
	public static Position getPositionFromLine(String string) throws Exception{
		String[] array = string.split(" ");
		int[] xycoords = new int[2];
		int count = 0;
		
		if (array.length < 2)
			throw new Exception(Position.class.getName()+" Input File Error: Not enough numbers to define a two-number-defined position");
		if (array.length > 2)
			throw new Exception(Position.class.getName()+" Input File Error: Numbers are too many to define a two-number-defined position");
		
		for(int i=0; i<array.length; i++){
			String coords = array[i];
			try{
				 xycoords[count] = Integer.parseInt(coords);
				 count++;
			} catch(Exception e) {
				System.out.println(Position.class.getName()+" Error: " + e.getMessage());
			}
		}
		
		return new Position(xycoords[0], xycoords[1]);
	}

	public int getX(){
		return X;
	}
	
	public void setX(int X) {
		this.X = X;
	}
	
	public int getY() {
		return Y;
	}
	
	public void setY(int Y) {
		this.Y = Y;
	}
	
	Position(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	public boolean equal(Position position){
		if (this.X==position.getX() && this.Y==position.getY()) {
			return true;
		} else {
			return false;
		}
	}
}
