// package Chess1;

import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Creates an empty chess board.
     */
    public Board() { }

    /**
     * Adds a piece to the board.
     * 
     * @param piece the chess piece to add
     */
    public void addPiece(Piece piece) {
        if (piece == null) {
            return;
        } else if (!validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            return;
        } else {
            if (this.getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) != null) {
                return;
            }
        }
        
        pieces.add(piece);
    }

    /**
     * Validates if the given coordinates are inside the board.
     * 
     * @param x column position (1–8)
     * @param y row position (1–8)
     * @return true if the coordinates are valid, false otherwise
     */
    public boolean validate(int x, int y) {
        return x <= WIDTH && x >= 1 
            && y <= HEIGHT && y >= 1;
    }

    /**
     * Removes a piece at the given coordinates, if any.
     * 
     * @param x column position
     * @param y row position
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(i);
                break;
            }
        }
    }

    /**
     * Gets the piece at the given coordinates.
     * 
     * @param x column position
     * @param y row position
     * @return the piece at the coordinates, or null if empty
     */
    public Piece getAt(int x, int y) {
        for (Piece p : pieces) {
            if (p.getCoordinatesX() == x && p.getCoordinatesY() == y) {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns all pieces on the board.
     * 
     * @return list of pieces
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Sets the list of pieces on the board.
     * 
     * @param pieces the list of pieces
     */
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
