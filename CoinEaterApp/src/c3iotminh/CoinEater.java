package c3iotminh;

import java.util.ArrayList;

/**
 * @author Minh Ly
 * @version 1.0
 * 
 */
public class CoinEater {
	private Position initialPosition;
	private Position endPosition;
	private int coinsPickedUp;
	private char[] movements;

	CoinEater(ArrayList<String> lines) throws Exception {
		try {
			this.initialPosition = Position.getPositionFromLine(lines.get(1));
			this.setEndPosition(this.initialPosition);
			setCoinsPickedUp(0);
			movements = lines.get(2).toCharArray();
		} catch (Exception e) {
			System.out.println(Board.class.getName()+" Error: " + e.getMessage());
		}
	}

	public void eatCoins(Board board) throws Exception {
		try {
			for (char directions : movements) {
				if (board.checkValidPosition(endPosition)) {
					if (!board.coinList.isEmpty()) {
						for (Position position:board.coinList) {
							if (position.equal(endPosition)) {
								this.coinsPickedUp++;
								board.coinList.remove(position);
								break;
							}
						}
					}
				}
				//System.out.println("Number of coins eaten: " + this.coinsPickedUp);
				
				switch (directions) {
				case 'N':
				case 'n':
					endPosition.setY(endPosition.getY() + 1);
					if (board.checkWallList(endPosition)) {
						endPosition.setY(endPosition.getY() - 1);
					} else if (board.checkWallPosition(endPosition)) {
						endPosition.setY(endPosition.getY() - 1);
					}
					break;
				case 'S':
				case 's':
					endPosition.setY(endPosition.getY() - 1);
					if (board.checkWallList(endPosition)) {
						endPosition.setY(endPosition.getY() + 1);
					} else if (board.checkWallPosition(endPosition)) {
						endPosition.setY(endPosition.getY() + 1);
					}
					break;
				case 'E':
				case 'e':
					endPosition.setX(endPosition.getX() + 1);
					if (board.checkWallList(endPosition)) {
						endPosition.setX(endPosition.getX() - 1);
					} else if (board.checkWallPosition(endPosition)) {
						endPosition.setX(endPosition.getX() - 1);
					}
					break;
				case 'W':
				case 'w':
					endPosition.setX(endPosition.getX() - 1);
					if (board.checkWallList(endPosition)) {
						endPosition.setX(endPosition.getX() + 1);
					} else if (board.checkWallPosition(endPosition)) {
						endPosition.setX(endPosition.getX() + 1);
					}
					break;
				default:
					throw new Exception(CoinEater.class.getName()+" Invalid movements - cadinal directions");
				}

			}
			board.checkValidPosition(endPosition);
			//check final location of coin eater
			if (board.checkValidPosition(endPosition)) {
				if (!board.coinList.isEmpty()) {
					for (Position p : board.coinList) {
						if (p.equal(endPosition)) {
							this.coinsPickedUp++;
							board.coinList.remove(p);
							break;
						}
					}
				}
			}
			//System.out.println("Final number of coins eaten: " + this.coinsPickedUp);
		} catch (Exception e) {
			throw new Exception(CoinEater.class.getName()+ " " + e.getMessage());
		}
	}

	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}
	
	public Position getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Position endPosition) {
		this.endPosition = endPosition;
	}

	public int getCoinsPickedUp() {
		return coinsPickedUp;
	}

	public void setCoinsPickedUp(int coinsPickedUp) {
		this.coinsPickedUp = coinsPickedUp;
	}

	public char[] getMovements() {
		return movements;
	}

	public void setMovements(char[] movements) {
		this.movements = movements;
	}

}
