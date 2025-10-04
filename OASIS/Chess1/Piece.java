// package Chess1;

public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Creates a piece at the given coordinates with default color "white".
     *
     * @param x the column position
     * @param y the row position
     */
    public Piece(int x, int y) {
        coordinatesX = x;
        coordinatesY = y;
        color = "white";
    }

    /**
     * Creates a piece at the given coordinates with a specific color.
     *
     * @param x     the column position
     * @param y     the row position
     * @param color the color of the piece ("white" or "black")
     */
    public Piece(int x, int y, String color) {
        coordinatesX = x;
        coordinatesY = y;
        this.color = color;
    }

    /**
     * Returns the symbol used to represent this piece (e.g., "R" for rook).
     *
     * @return the symbol string
     */
    public abstract String getSymbol();

    /**
     * Checks if this piece can move to the given position according
     * to its movement rules and the state of the board.
     *
     * @param board the chess board
     * @param x     destination column
     * @param y     destination row
     * @return true if the move is valid, false otherwise
     */
    public abstract boolean canMove(Board board, int x, int y);

    /**
     * Gets the current X (column) coordinate of the piece.
     *
     * @return the x-coordinate
     */
    public int getCoordinatesX() {
        return coordinatesX;
    }

    /**
     * Sets the X (column) coordinate of the piece.
     *
     * @param coordinatesX the new x-coordinate
     */
    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    /**
     * Gets the current Y (row) coordinate of the piece.
     *
     * @return the y-coordinate
     */
    public int getCoordinatesY() {
        return coordinatesY;
    }

    /**
     * Sets the Y (row) coordinate of the piece.
     *
     * @param coordinatesY the new y-coordinate
     */
    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    /**
     * Gets the color of the piece.
     *
     * @return "white" or "black"
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the piece.
     *
     * @param color the new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Checks whether this piece is at the same position
     * as another piece.
     *
     * @param piece the piece to compare with
     * @return true if both pieces have the same coordinates, false otherwise
     */
    public boolean checkPosition(Piece piece) {
        return this.coordinatesX == piece.coordinatesX
            && this.coordinatesY == piece.coordinatesY;
    }
}

