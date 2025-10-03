// package Chess1;

public class Rook extends Piece {

    /**
     * Creates a rook at the given coordinates.
     *
     * @param x the column position
     * @param y the row position
     */
    public Rook(int x, int y) {
        super(x, y);
    }

    /**
     * Creates a rook at the given coordinates with a specific color.
     *
     * @param x     the column position
     * @param y     the row position
     * @param color the color of the rook ("white" or "black")
     */
    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    /**
     * Returns the symbol used to represent the rook.
     *
     * @return "R"
     */
    public String getSymbol() {
        return "R";
    }

    /**
     * Checks if the rook can legally move to the given position.
     * Rook moves only horizontally or vertically, without jumping over pieces.
     *
     * @param board the board on which the move is attempted
     * @param x     destination column
     * @param y     destination row
     * @return true if the move is valid, false otherwise
     */
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }
        if (this.getCoordinatesX() != x && this.getCoordinatesY() != y) {
            return false;
        }
        if (checkIfBlocked(board, this.getCoordinatesX(), this.getCoordinatesY(), x, y)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the rook's path is blocked by other pieces.
     *
     * @param board  the board
     * @param startX starting column
     * @param startY starting row
     * @param endX   destination column
     * @param endY   destination row
     * @return true if the path is blocked, false otherwise
     */
    private boolean checkIfBlocked(Board board, int startX, int startY, int endX, int endY) {
        // If destination square has a piece of the same color, move is invalid
        if (board.getAt(endX, endY) != null
            && board.getAt(endX, endY).getColor().equals(this.getColor())) {
            return true;
        }

        if (startX == endX) { // vertical move
            int step = (endY > startY) ? 1 : -1;
            for (int y = startY + step; y != endY; y += step) {
                if (board.getAt(startX, y) != null) {
                    return true;
                }
            }
        } else if (startY == endY) { // horizontal move
            int step = (endX > startX) ? 1 : -1;
            for (int x = startX + step; x != endX; x += step) {
                if (board.getAt(x, startY) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
