package c3iotminh;

import java.util.ArrayList;

/**
 * @author Minh Ly
 * @version 1.0
 * 
 */
public class Board {
	private int X; 
	private int Y;
	public Position initialPosition;
	public ArrayList<Position> wallList;
	public ArrayList<Position> coinList;
	
	Board(ArrayList<String> lines) throws Exception{
		initialPosition = null;
		wallList = new ArrayList<Position>();
		coinList = new ArrayList<Position>();
		initialBoardSize(lines);
		initialPosition(lines, initialPosition);
		initialWallList(lines, wallList);
		initialCoinList(lines, coinList);
	}
	
	private void initialBoardSize(ArrayList<String> lines) throws Exception {
		if ((lines != null && !lines.isEmpty())) {
			Position position = Position.getPositionFromLine(lines.get(0));
			this.setX(position.getX());
			this.setY(position.getY());
			System.out.println("Board Size: "+position.getX()+":"+position.getY());
		} else {
			throw new Exception(Board.class.getName()+" initialBoardSize missing/invalid board information.");
		}
		return;
	}
	
	private void initialWallList(ArrayList<String> lines, ArrayList<Position> wallList) throws Exception {
		int line = 3;
		
		while (line < lines.size()) {
			Position position = Position.getPositionFromLine(lines.get(line));
			checkValidPosition(position);
			this.wallList.add(position);
			line++;
			System.out.println("Wall: "+position.getX()+":"+position.getY());
		}
		return;
	}
	
	private void initialPosition(ArrayList<String> lines, Position initialPosition) throws Exception {
		int line = 1;
		
		if (line < lines.size()) {
			Position position = Position.getPositionFromLine(lines.get(line));
			checkValidPosition(position);
			this.initialPosition=position;
		}
		return;
	}
	
	private void initialCoinList(ArrayList<String> lines,ArrayList<Position> coinList) throws Exception {
		Position position = null;
		
		for (int i = 0; i < getX(); i++) {
	        for (int j = 0; j < getY(); j++) {
	        	position = new Position(i, j);
	        	if ((!this.checkWallList(position)) && !this.initialPosition.equal(position)) {
	        		this.coinList.add(position);
	        		//System.out.println("Initial Coin X:Y "+Position.getX()+":"+Position.getY());
	        	}
	    		
	        }
		}
		
	}
	
	public boolean checkValidPosition(Position position) throws Exception{
		if (position.getX()<=this.X-1 && position.getY()<=this.Y-1 && position.getX()>=0 && position.getY()>=0){
			return true;
		} else {
			throw new Exception(Board.class.getName()+" checkValidPosition board position is not valid.");
		}
	}
	
	public boolean checkWallPosition(Position position) throws Exception{
		if (position.getX()<=this.X-1 && position.getY()<=this.Y-1 && position.getX()>=0 && position.getY()>=0){
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkWallList(Position position) {
		for (Position p: wallList) {
			if(p.equal(position)){
				//System.out.println("YES Wall X:Y "+Position.getX()+":"+Position.getY());
				return true;
			}
		}
		return false;
	}
	
	public int getX() {
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

	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}

	public ArrayList<Position> getWallList() {
		return wallList;
	}

	public void setWallList(ArrayList<Position> wallList) {
		this.wallList = wallList;
	}

	public ArrayList<Position> getCoinList() {
		return coinList;
	}

	public void setCoinList(ArrayList<Position> coinList) {
		this.coinList = coinList;
	}
	
}
