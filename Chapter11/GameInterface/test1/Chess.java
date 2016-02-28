import java.lang.*;
import java.util.*;
// A Chess Game
public class Chess {
	public static void main (String[] args) {
		ChessGame game = new ChessGame();
		boolean playing = true;
		System.out.println("---------");
		System.out.println("  CHESS  ");
		System.out.println("---------");
		System.out.println();
		System.out.println("To move a piece, enter the starting square and the target square,");
		System.out.println("separated by an arrow. e.g. A2->A3");
		System.out.println();
		System.out.println("All basic rules are allowed.");
		System.out.println();
		System.out.println("White goes first.");
		System.out.println();
		System.out.println("Hit Enter to start.");
		System.out.println();
		System.out.println("Stretching the window down is recommended.");
		game.getInput("");
		while (playing) {
			game.dispBoard();
			// Infinite loop; break out once input is valid
			String result = "";
			while (!(result=game.isValidMove(game.getInput())).equals("ok")) {
				System.out.println(result);
			}
			String inCheck = game.checkForCheck();
			// Execute the move
			boolean b1 = inCheck.equals("block1");
			boolean b2 = inCheck.equals("block2");
			if (!b1 && !b2) {
				game.executeMove();
				game.nextTurn();
				if (inCheck.equals("check")) System.out.println("Check!!");
			} else {
				if (b1) System.out.println("You can't leave your king in check.");
				else if (b2) System.out.println("You can't move your king into check.");
			}
		}
	}
}
// A chess game object
class ChessGame implements Game {
	// Create a new chess board
	public ChessGame () {
		in = new Scanner(System.in);
		numPlayers = 2;
		whiteCheck = false;
		blackCheck = false;
		p1 = new Player ("W", true);  // ID = 0
		p2 = new Player ("B", false); // ID = 1
		board = new ChessPiece[8][8];
		Black = new ArrayList<ChessPiece>();
		White = new ArrayList<ChessPiece>();
		// new ChessPiece (player id, rep, y, x);
		Black.add(board[0][0] = new Rook(1, "BR", 0, 0));
		Black.add(board[0][1] = new Knight(1, "BN", 0, 1));
		Black.add(board[0][2] = new Bishop(1, "BB", 0, 2));
		Black.add(board[0][3] = new Queen(1, "BQ", 0, 3));
		Black.add(blackKing = board[0][4] = new King(1, "BK", 0, 4));
		Black.add(board[0][5] = new Bishop(1, "BB", 0, 5));
		Black.add(board[0][6] = new Knight(1, "BN", 0, 6));
		Black.add(board[0][7] = new Rook(1, "BR", 0, 7));
		Black.add(board[1][0] = new Pawn(1, "BP", 1, 0));
		Black.add(board[1][1] = new Pawn(1, "BP", 1, 1));
		Black.add(board[1][2] = new Pawn(1, "BP", 1, 2));
		Black.add(board[1][3] = new Pawn(1, "BP", 1, 3));
		Black.add(board[1][4] = new Pawn(1, "BP", 1, 4));
		Black.add(board[1][5] = new Pawn(1, "BP", 1, 5));
		Black.add(board[1][6] = new Pawn(1, "BP", 1, 6));
		Black.add(board[1][7] = new Pawn(1, "BP", 1, 7));

		White.add(board[7][0] = new Rook(0, "WR", 7, 0));
		White.add(board[7][1] = new Knight(0, "WN", 7, 1));
		White.add(board[7][2] = new Bishop(0, "WB", 7, 2));
		White.add(board[7][3] = new Queen(0, "WQ", 7, 3));
		White.add(whiteKing = board[7][4] = new King(0, "WK", 7, 4));
		White.add(board[7][5] = new Bishop(0, "WB", 7, 5));
		White.add(board[7][6] = new Knight(0, "WN", 7, 6));
		White.add(board[7][7] = new Rook(0, "WR", 7, 7));
		White.add(board[6][0] = new Pawn(0, "WP", 6, 0));
		White.add(board[6][1] = new Pawn(0, "WP", 6, 1));
		White.add(board[6][2] = new Pawn(0, "WP", 6, 2));
		White.add(board[6][3] = new Pawn(0, "WP", 6, 3));
		White.add(board[6][4] = new Pawn(0, "WP", 6, 4));
		White.add(board[6][5] = new Pawn(0, "WP", 6, 5));
		White.add(board[6][6] = new Pawn(0, "WP", 6, 6));
		White.add(board[6][7] = new Pawn(0, "WP", 6, 7));

		// The array that stores valid move data in order to execute the move
		// {x1, y1, x2, y2};
		moveInput = new int[4];
	}
	// Figure out if the input was valid
	// @param move the move to validate
	// @return "ok" if the move is valid, or an error message if not
	public String isValidMove (String move) {
		move = move.replaceAll(" ", "");
		move = move.toUpperCase();
		if (move.equals("BOARD")) {
			dispBoard();
			return "";
		}
		int arrowIndex = move.indexOf("->");
		if (arrowIndex==-1) return "Syntax error.";

		String m1 = move.substring(0, arrowIndex);
		String m2 = move.substring(arrowIndex+2);
		int d1 = -1, d2 = -1;
		char l1 = 'Z', l2 = 'Z';
		// Break apart the first string
		Character m1_c1 = new Character(m1.charAt(0));
		Character m1_c2 = new Character(m1.charAt(1));
		if (Character.isDigit(m1_c1) && !Character.isDigit(m1_c2)) {
			d1 = Character.getNumericValue(m1_c1);
			l1 = m1_c2;
		} else if (Character.isDigit(m1_c2) && !Character.isDigit(m1_c1)) {
			d1 = Character.getNumericValue(m1_c2);
			l1 = m1_c1;
		}
		// Break apart the second string
		Character m2_c1 = new Character(m2.charAt(0));
		Character m2_c2 = new Character(m2.charAt(1));
		if (Character.isDigit(m2_c1) && !Character.isDigit(m2_c2)) {
			d2 = Character.getNumericValue(m2_c1);
			l2 = m2_c2;
		} else if (Character.isDigit(m2_c2) && !Character.isDigit(m2_c1)) {
			d2 = Character.getNumericValue(m2_c2);
			l2 = m2_c1;
		}
		// Convert the values into coordinates on the board
		int x1, x2, y1, y2;
		x1 = getLetterCoordinate(l1);
		y1 = d1-1;
		x2 = getLetterCoordinate(l2);
		y2 = d2-1;
		// Make sure the two coordinates are different
		if (x1==x2 && y1==y2) return "You must move the piece.";
		// Retrieve the starting coordinate's chess piece; if there is none, return false
		ChessPiece piece = board[y1][x1];
		if (piece == null) return "There is no piece in that square.";
		if (!Player.getActivePlayer().getRep().equals(piece.getPRep())) return "That's not your piece.";
		// Determine if the target square is valid for this piece
		// Returns either "ok", "no", "attack", or "castle"
		String validTarget = piece.isValidAttempt(x2, y2);
		if (validTarget.equals("no")) return "Invalid move attempt.";
		// Trace the path
		String traceResult = piece.tracePath(x2, y2, board, validTarget);
		if (traceResult.equals("ok")) {
			// Store input data
			moveInput[0] = x1;
			moveInput[1] = y1;
			moveInput[2] = x2;
			moveInput[3] = y2;
			//System.out.printf("(%d, %d) -> (%d, %d)\n", x1, y1, x2, y2);
			moveType = validTarget;
			return "ok";
		}

		return traceResult;
	}
	// Make sure the move won't put your king in check and alert the other player if their
	// king is now in check
	// @return "block1" or "block2" to keep the king out of check, "check" if the other player's
	// king is now in check, or "n/a" if neither
	public String checkForCheck () {
		int px = moveInput[0];
		int py = moveInput[1];
		int x = moveInput[2];
		int y = moveInput[3];
		ChessPiece piece = board[py][px];
		if (piece==null) return "No piece.";
		String team = piece.getPRep();
		String type = piece.getType();
		piece.setTemp(x, y);
		// Create a temporary board object to represent what the board will look like
		// after the move
		ChessPiece[][] tempBoard = new ChessPiece[8][8];
		for (int ty = 0; ty<8; ty++) {
			for (int tx = 0; tx<8; tx++) {
				tempBoard[ty][tx] = board[ty][tx];
			}
		}
		tempBoard[py][px] = null;
		tempBoard[y][x] = piece;

		// Make sure your king is not in check after the proposed move
		ArrayList<ChessPiece> enemyRoster = Black;
		ChessPiece king = whiteKing;
		if (team.equals("B")) {
			enemyRoster = White;
			king = blackKing;
		}
		int kx = king.getX();
		int ky = king.getY();
		// Make sure it can't move into check if it's a king
		for (ChessPiece a : enemyRoster) {
			if (a.threatens(kx, ky, tempBoard)) {
				piece.clearTemp();
				if (type.equals("king")) return "block2";
				else return "block1";
			}
		}

		// Alert the other player if their king is now in check
		ChessPiece enemyKing = blackKing;
		if (team.equals("B")) enemyKing = whiteKing;
		piece.setTemp(x, y);
		if (piece.threatens(enemyKing.getX(), enemyKing.getY(), tempBoard)) {
			piece.clearTemp();
			return "check";
		}
		piece.clearTemp();

		return "n/a";
	}
	// Execute the move
	public void executeMove () {
		int x1, y1, x2, y2;
		x1 = moveInput[0];
		y1 = moveInput[1];
		x2 = moveInput[2];
		y2 = moveInput[3];
		ChessPiece piece = board[y1][x1];
		piece.moveTo(x2, y2);
		board[y2][x2] = piece;
		board[y1][x1] = null;
		if (moveType.equals("castle")) {
			int rx = 0;
			int tx = 2;
			if (x2==6) {
				rx = 7;
				tx = 5;
			}
			ChessPiece rook = board[y2][rx];
			rook.moveTo(tx, y2);
			board[y2][tx] = rook;
			board[y2][rx] = null;
		}
		String team = piece.getPRep();
		int ty = 0;
		ArrayList<ChessPiece> teamList = White;
		int p = 0;
		if (team.equals("B")) {
			p = 1;
			teamList = Black;
			ty = 7;
		}
		if (piece.getType().equals("pawn") && y2==ty) {
			// Pawn reached the end, so turn it into a queen
			String rep = piece.getPRep()+"Q";
			board[y2][x2] = null;
			for (int i = 0; i<teamList.size(); i++) {
				if (piece==teamList.get(i)) {
					teamList.remove(i);
					break;
				}
			}
			teamList.add(board[y2][x2] = new Queen(p, rep, y2, x2));
		}
	}
	// Determine if there is a victory yet
	public boolean victory () {
		return false;
	}
	// Display the game board
	public void dispBoard () {
		String disp = "\n\n   A     B     C     D     E     F     G     H\n";
		disp += "------------------------------------------------\n";
		for (int y = 0; y<8; y++) {
			disp += "|";
			for (int x = 0; x<8; x++) {
				String piece;
				if (board[y][x] != null) {
					piece = board[y][x].getRep();
				} else {
					piece = "  ";
				}
				String str = " "+piece+"  |";
				if (x==7) str += " "+(y+1);
				disp += str;
			}
			disp += "\n|     |     |     |     |     |     |     |     |\n";
			disp += "------------------------------------------------\n";
		}
		System.out.println(disp);
	}
	// Receive input from the active player
	public String getInput () {
		Player activePlayer = Player.getActivePlayer();
		//System.out.println(activePlayer);
		String rep = activePlayer.getRep();
		String disp = "("+rep+"): ";
		System.out.print(disp);
		return in.nextLine();
	}
	public String getInput (String msg) {
		System.out.print(msg);
		return in.nextLine();
	}
	public void nextTurn () {
		int id = Player.getActiveID()+1;
		if (id>=numPlayers) id = 0;
		Player.get(id).activate();
	}
	// Converts a char (A-H) into the appropriate coordinate
	private int getLetterCoordinate (char a) {
		switch (a) {
			case 'A': return 0;
			case 'B': return 1;
			case 'C': return 2;
			case 'D': return 3;
			case 'E': return 4;
			case 'F': return 5;
			case 'G': return 6;
			case 'H': return 7;
			default: return -1;
		}
	}

	private final int numPlayers;
	private Scanner in;
	private ChessPiece[][] board;
	private Player p1;
	private Player p2;
	private int[] moveInput;
	private String moveType;
	private ArrayList<ChessPiece> Black;
	private ArrayList<ChessPiece> White;
	private ChessPiece blackKing;
	private ChessPiece whiteKing;
	private boolean whiteCheck;
	private boolean blackCheck;

}
// Represents a Chess game piece
class ChessPiece {
	// Construct a new chess piece
	// @param _p the player object to which this piece belongs
	// @param _r the representative string: "W" or "B"
	// @param _y the y position of this piece on the board (1-8)
	// @param _x the x position of this piece on the board (A-H)
	public ChessPiece (int _p, String _r, int _y, int _x) {
		p = _p;
		rep = _r;
		pRep = rep.substring(0, 1);
		x = _x;
		y = _y;
		if (pRep.equals("B")) dir = 1;
		else if (pRep.equals("W")) dir = -1;
		else dir = 0;
		useTemp = false;
	}
	// Update the x and y values
	// @param x the new x-coordinate
	// @param y the new y-coordinate
	public void moveTo (int x, int y) {
		this.x = x;
		this.y = y;
		if ((this.getType().equals("king") || this.getType().equals("rook")) && this.canCastle()) {
			this.invalidateCastle();
		}
	}
	public String isValidAttempt (int x, int y) { return "Error."; }
	public String tracePath (int x, int y, ChessPiece[][] board, String method) { return "Error."; }
	public boolean threatens (int x, int y, ChessPiece[][] board) { return true; }
	public String getType () { return "none"; }
	public void invalidateCastle () { }
	public boolean canCastle () { return false; }

	// Get the player object or representative string
	public int getPlayerID () { return p; }
	public String getRep () { return rep; }
	public String getPRep () { return pRep; }
	public int getDir () { return dir; }
	public int getX () {
		if (useTemp) return tempx;
		return x;
	}
	public int getY () {
		if (useTemp) return tempy;
		return y;
	}
	public void setTemp (int tx, int ty) {
		tempx = tx;
		tempy = ty;
		useTemp = true;
	}
	public void clearTemp () {
		useTemp = false;
	}

	private int p;
	private String rep;
	private String pRep;
	private int x;
	private int y;
	private int tempx;
	private int tempy;
	private boolean useTemp;
	private int dir;

}
class Pawn extends ChessPiece {
	// Constructs a new pawn
	// public Pawn (player object, representing string, y, x)
	public Pawn (int _p, String _r, int _y, int _x) {
		super (_p, _r, _y, _x);
	}
	// Determines if the attempted move is valid
	// (x2,y2) target square
	// @return "ok" if it's valid, "attack" if valid only for attacking, or "no" if invalid
	public String isValidAttempt (int x2, int y2) {
		int x1 = this.getX();
		int y1 = this.getY();
		int d = this.getDir();
		int ystart;
		if (d==1) ystart = 1;
		else ystart = 6;
		// Find the y-distance for the attempted move
		int dist = (y2-y1)*d;
		// Invalid if it tried to move backwards or sideways or if the distance is more than 2
		if (dist<=0 || dist>2) return "no";
		// Invalid if they tried to move 2 spaces while not on the starting square
		if (y1 != ystart && dist==2) return "no";
		int xdist = x2-x1;
		if (xdist<0) xdist *= -1;
		if (dist==2 && xdist!=0) return "no";
		if (dist==1 && xdist==1) return "attack";

		return "ok";
	}
	// (x2, y2) the target square
	// @param board a reference to the chess board array
	// @param method either "ok" or "attack"
	public String tracePath (int x2, int y2, ChessPiece[][] board, String method) {
		String team = this.getPRep();
		int x1 = this.getX();
		int y1 = this.getY();
		int d = this.getDir();
		int x = x1;
		int y = y1;
		// If the piece is just moving forward and not attacking
		if (method.equals("ok")) {
			while (y != y2) {
				y += d;
				ChessPiece enemy = board[y][x];
				if (enemy != null) return "Path obstruction.";
			}
		} else if (method.equals("attack")) {
			ChessPiece enemy = board[y2][x2];
			if (enemy == null) return "No target to attack.";
			if (enemy.getPRep().equals(team)) return "You can't attack your own pieces.";
		}

		return "ok";
	}
	// Determine if this piece is threatening the given square
	// @return true or false
	public boolean threatens (int x, int y, ChessPiece[][] board) {
		int _x = this.getX();
		int _y = this.getY();
		int d = this.getDir();
		int xdist = x-_x;
		if (xdist<0) xdist *= -1;
		if (_y==(y+d) && xdist==1) return true;

		return false;
	}
	public String getType () { return "pawn"; }
}
class Rook extends ChessPiece {
	public Rook (int _p, String _r, int _y, int _x) {
			super (_p, _r, _y, _x);
			castle = true;
	}
	public String isValidAttempt (int x2, int y2) {
		int x1 = this.getX();
		int y1 = this.getY();
		if ((x1==x2 && y1!=y2) || (x1!=x2 && y1==y2)) return "ok";

		return "no";
	}
	public String tracePath (int x2, int y2, ChessPiece[][] board, String method) {
		String team = this.getPRep();
		int x1 = this.getX();
		int y1 = this.getY();
		if (x1==x2) {
			// Trace y-path
			int d = 0;
			if (y2>y1) d = 1;
			else if (y1>y2) d = -1;
			int y = y1;
			while (y!=(y2-d)) {
				y += d;
				ChessPiece enemy = board[y][x1];
				if (enemy != null) return "Path obstruction.";
			}
		} else if (y1==y2) {
			// Trace x-path
			int d = 0;
			if (x2>x1) d = 1;
			else if (x1>x2) d = -1;
			int x = x1;
			while (x!=(x2-d)) {
				x += d;
				ChessPiece enemy = board[y1][x];
				if (enemy != null) return "Path obstruction.";
			}
		}
		ChessPiece enemy = board[y2][x2];
		if (enemy != null) {
			if (enemy.getPRep().equals(team)) return "You can't attack your own pieces.";
		}

		return "ok";
	}
	public boolean threatens (int x, int y, ChessPiece[][] board) {
		if (isValidAttempt(x, y).equals("ok")) {
			if (this.tracePath(x, y, board, "attack").equals("ok")) return true;
		}
		return false;
	}
	public String getType () { return "rook"; }
	public boolean canCastle () { return castle; }
	public void invalidateCastle () { castle = false; }

	private boolean castle;

}
class Bishop extends ChessPiece {
	public Bishop (int _p, String _r, int _y, int _x) {
		super (_p, _r, _y, _x);
	}
	public String isValidAttempt (int x2, int y2) {
		int x1 = this.getX();
		int y1 = this.getY();
		int xd = x2-x1;
		int yd = y2-y1;
		if (xd<0) xd *= -1;
		if (yd<0) yd *= -1;
		if (xd==yd) return "ok";

		return "no";
	}
	public String tracePath (int x2, int y2, ChessPiece[][] board, String method) {
		String team = this.getPRep();
		int x1 = this.getX();
		int y1 = this.getY();
		int xd = 0;
		int yd = 0;
		if (x2>x1) xd = 1;
		else xd = -1;
		if (y2>y1) yd = 1;
		else  yd = -1;
		int x = x1;
		int y = y1;
		while (x!=(x2-xd) && y!=(y2-yd)) {
			x += xd;
			y += yd;
			ChessPiece enemy = board[y][x];
			if (enemy != null) return "Path obstruction.";
		}
		ChessPiece enemy = board[y2][x2];
		if (enemy != null) {
			if (enemy.getPRep().equals(team)) return "You  can't attack your own pieces.";
		}

		return "ok";
	}
	public boolean threatens (int x, int y, ChessPiece[][] board) {
		if (isValidAttempt(x, y).equals("ok")) {
			if (this.tracePath(x, y, board, "attack").equals("ok")) return true;
		}
		return false;
	}
	public String getType () { return "bishop"; }
}
class Knight extends ChessPiece {
	public Knight (int _p, String _r, int _y, int _x) {
		super (_p, _r, _y, _x);
	}
	public String isValidAttempt (int x2, int y2) {
		int x1 = this.getX();
		int y1 = this.getY();
		int xd = x2-x1;
		int yd = y2-y1;
		if (xd<0) xd *= -1;
		if (yd<0) yd *= -1;
		if ((xd==1 && yd==2) || (xd==2 && yd==1)) return "ok";

		return "no";
	}
	public String tracePath (int x2, int y2, ChessPiece[][] board, String method) {
		String team = this.getPRep();
		ChessPiece enemy = board[y2][x2];
		if (enemy != null) {
			if (enemy.getPRep().equals(team)) return "You can't attack your own pieces.";
		}

		return "ok";
	}
	public boolean threatens (int x, int y, ChessPiece[][] board) {
		if (isValidAttempt(x, y).equals("ok")) {
			if (this.tracePath(x, y, board, "attack").equals("ok")) return true;
		}
		return false;
	}
	public String getType () { return "knight"; }
}
class Queen extends ChessPiece {
	public Queen (int _p, String _r, int _y, int _x) {
		super (_p, _r, _y, _x);
	}
	public String isValidAttempt (int x2, int y2) {
		int x1 = this.getX();
		int y1 = this.getY();
		if ((x1==x2 && y1!=y2) || (x1!=x2 && y1==y2)) return "ok";
		int xd = x2-x1;
		int yd = y2-y1;
		if (xd<0) xd *= -1;
		if (yd<0) yd *= -1;
		if (xd==yd) return "ok";

		return "no";
	}
	public String tracePath (int x2, int y2, ChessPiece[][] board, String method) {
		String team = this.getPRep();
		int x1 = this.getX();
		int y1 = this.getY();
		int xd;
		int yd;
		if (x2>x1) xd = 1;
		else if (x2<x1) xd = -1;
		else xd = 0;
		if (y2>y1) yd = 1;
		else if (y2<y1) yd = -1;
		else yd = 0;
		int x = x1;
		int y = y1;
		while (x!=(x2-xd) && y!=(y2-xd)) {
			x += xd;
			y += yd;
			ChessPiece enemy = board[y][x];
			if (enemy != null) return "Path obstruction.";
		}
		ChessPiece enemy = board[y2][x2];
		if (enemy != null) {
			if (enemy.getPRep().equals(team)) return "You can't attack your own pieces.";
		}

		return "ok";
	}
	public boolean threatens (int x, int y, ChessPiece[][] board) {
		if (isValidAttempt(x, y).equals("ok")) {
			if (this.tracePath(x, y, board, "attack").equals("ok")) return true;
		}
		return false;
	}
	public String getType () { return "queen"; }
}
class King extends ChessPiece {
	public King (int _p, String _r, int _y, int _x) {
		super (_p, _r, _y, _x);
		castle = true;
	}
	public String isValidAttempt (int x2, int y2) {
		int x1 = this.getX();
		int y1 = this.getY();
		int xd = x2-x1;
		int yd = y2-y1;
		if (xd<0) xd *= -1;
		if (yd<0) yd *= -1;
		if (xd<=1 && yd<=1) return "ok";

		if (this.canCastle()) {
			if (yd==0 && (x2==1 || x2==6)) {
				return "castle";
			}
		}

		return "no";
	}
	public String tracePath (int x2, int y2, ChessPiece[][] board, String method) {
		String team = this.getPRep();
		if (method.equals("ok")) {
			ChessPiece enemy = board[y2][x2];
			if (enemy != null) {
				if (enemy.getPRep().equals(team)) return "You can't attack your own pieces.";
			}
		} else if (method.equals("castle")) {
			if (x2==6) {
				ChessPiece p1 = board[y2][5];
				ChessPiece p2 = board[y2][6];
				ChessPiece rook = board[y2][7];
				if (p1!=null || p2!=null || rook==null) return "You can't castle.";
				if (!rook.getType().equals("rook") || !rook.canCastle()) return "You can't castle.";
			} else if (x2==1) {
				ChessPiece p1 = board[y2][1];
				ChessPiece p2 = board[y2][2];
				ChessPiece p3 = board[y2][3];
				ChessPiece rook = board[y2][0];
				if (p1!=null || p2!=null || p3!=null || rook==null) return "You can't castle.";
				if (!rook.getType().equals("rook") || !rook.canCastle()) return "You can't castle.";
			}
		}

		return "ok";
	}
	public boolean threatens (int x, int y, ChessPiece[][] board) {
		if (isValidAttempt(x, y).equals("ok")) {
			if (this.tracePath(x, y, board, "attack").equals("ok")) return true;
		}
		return false;
	}
	public String getType () { return "king"; }
	public boolean canCastle () { return castle; }
	public void invalidateCasle () { castle = false; }

	private boolean castle;

}




// A game player
class Player {
	// Constructs a new player object
	// @param _r the representative string ("X" or "O" in tic-tac-toe, or "B" or "W" in chess)
	// @param _ac true if the player starts out active
	public Player (String _r, boolean _ac) {
		rep = _r;
		try {
			id = list.size();
		} catch (NullPointerException e) {
			newList();
			id = 0;
		} finally {
			active = _ac;
			if (active) activate();
			list.add(this);
		}
	}
	// Activates this Player object
	public void activate () {
		if (activePlayer != null) activePlayer.deactivate();
		active = true;
		Player.activePlayer = this;
		Player.activeID = id;
	}
	// Deactivates this Player object
	public void deactivate () {
		active = false;
	}
	// Get the player at that id
	// @return the Player object
	public static Player get (int id) {
		return list.get(id);
	}
	public static void newList () {
		list = new ArrayList<Player>();
	}
	public boolean isActive () { return active; }
	public int getID () { return id; }
	public String getRep () { return rep; }
	public static Player getActivePlayer () { return activePlayer; }
	public static int getActiveID () { return activeID; }

	private static Player activePlayer;
	private static int activeID;
	private boolean active;
	private int id;
	private String rep;
	public static ArrayList<Player> list;

}
interface Game {
	public String isValidMove(String move);
	public void executeMove();
	public boolean victory();
	public void dispBoard();
	public String getInput();
	public String getInput(String msg);
}