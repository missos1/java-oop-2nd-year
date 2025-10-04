// package Chess1;

public class Move {
    private int startX;
    private int startY; 
    private int endX; 
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Creates a normal move.
     *
     * @param startX      starting column
     * @param startY      starting row
     * @param endX        destination column
     * @param endY        destination row
     * @param movedPiece  the piece that moved
     * @param killedPiece the piece that was captured
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
    }

    /**
     * Creates a move with a captured piece.
     *
     * @param startX      starting column
     * @param startY      starting row
     * @param endX        destination column
     * @param endY        destination row
     * @param movedPiece  the piece that moved
     * @param killedPiece the piece that was captured
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * Returns a string representation of the move in algebraic-like notation.
     * Example: "white-Ra4" for a white rook moving to a4.
     *
     * @return a string describing the move
     */
    @Override
    public String toString() {
        String xpos = "";
        switch (endX) {
            case 1:
                xpos = "a";
                break;
            case 2:
                xpos = "b";
                break;
            case 3:
                xpos = "c";
                break;
            case 4:
                xpos = "d";
                break;
            case 5:
                xpos = "e";
                break;
            case 6:
                xpos = "f";
                break;
            case 7:
                xpos = "g";
                break;
            case 8:
                xpos = "h";
                break;
        }

        return movedPiece.getColor() + "-" + movedPiece.getSymbol()
            + xpos + endY;
    }


    /**
     * Gets the starting column (file) of the move.
     * For example, in "Ra4", this would be the rook's initial file.
     *
     * @return the starting column index (1–8)
     */
    public int getStartX() { 
        return startX; 
    }

    /**
     * Sets the starting column (file) of the move.
     *
     * @param startX the starting column index (1–8)
     */
    public void setStartX(int startX) { 
        this.startX = startX; 
    }

    /**
     * Gets the starting row (rank) of the move.
     * For example, in "Ra4", this would be the rook's initial rank.
     *
     * @return the starting row index (1–8)
     */
    public int getStartY() { 
        return startY; 
    }

    /**
     * Sets the starting row (rank) of the move.
     *
     * @param startY the starting row index (1–8)
     */
    public void setStartY(int startY) { 
        this.startY = startY; 
    }

    /**
     * Gets the destination column (file) of the move.
     *
     * @return the destination column index (1–8)
     */
    public int getEndX() { 
        return endX; 
    }

    /**
     * Sets the destination column (file) of the move.
     *
     * @param endX the destination column index (1–8)
     */
    public void setEndX(int endX) { 
        this.endX = endX; 
    }

    /**
     * Gets the destination row (rank) of the move.
     *
     * @return the destination row index (1–8)
     */
    public int getEndY() { 
        return endY; 
    }

    /**
     * Sets the destination row (rank) of the move.
     *
     * @param endY the destination row index (1–8)
     */
    public void setEndY(int endY) { 
        this.endY = endY; 
    }

    /**
     * Gets the piece that was moved.
     *
     * @return the piece that executed the move
     */
    public Piece getMovedPiece() { 
        return movedPiece; 
    }

    /**
     * Sets the piece that was moved.
     *
     * @param movedPiece the piece that executed the move
     */
    public void setMovedPiece(Piece movedPiece) { 
        this.movedPiece = movedPiece; 
    }

    /**
     * Gets the piece that was captured during the move, if any.
     *
     * @return the captured piece, or {@code null} if none
     */
    public Piece getKilledPiece() { 
        return killedPiece; 
    }

    /**
     * Sets the piece that was captured during the move.
     *
     * @param killedPiece the captured piece, or {@code null} if none
     */
    public void setKilledPiece(Piece killedPiece) { 
        this.killedPiece = killedPiece; 
    }
}
