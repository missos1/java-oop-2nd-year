// package Chess1;

import java.util.ArrayList;

public class Game {
    private Board board = new Board();
    private final ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Creates a game with a given board.
     *
     * @param board the board to be used for the game
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Attempts to move a piece to a new position.
     * If the move is valid according to the piece's rules,
     * the piece is moved and the move is recorded.
     *
     * @param piece the piece to move
     * @param x     the destination column
     * @param y     the destination row
     */
    public void movePiece(Piece piece, int x, int y) {
        if (!piece.canMove(board, x, y)) {
            return;
        }

        int currentX = piece.getCoordinatesX();
        int currentY = piece.getCoordinatesY();
        Piece killedPiece = board.getAt(x, y);

        if (killedPiece != null) {
            moveHistory.add(new Move(currentX, currentY, x, y, piece, killedPiece));
            board.removeAt(x, y);
            board.removeAt(currentX, currentY);
        } else {
            moveHistory.add(new Move(currentX, currentY, x, y, piece));
            board.removeAt(currentX, currentY);
        }
        
        piece.setCoordinatesX(x);
        piece.setCoordinatesY(y);
        board.addPiece(piece);
    }

    /**
     * Gets the board used in this game.
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gets the history of moves made in the game.
     *
     * @return a list of moves
     */
    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

    /**
     * Sets a new board for the game.
     *
     * @param board the new board
     */
    public void setBoard(Board board) {
        this.board = board;
    }
}
