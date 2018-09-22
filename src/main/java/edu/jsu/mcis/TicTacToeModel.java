package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
        
        grid = new Mark[width][width];
        for (Mark[] grid1 : grid) {
            for (int col = 0; col < grid.length; col++) {
                grid1[col] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        if (isValidSquare(row,col) == false) {
            return false;
        
        } else if (isSquareMarked(row,col) == true) {
            return false;
        
        } else { 
            if (isXTurn() == true) {
                grid[row][col] = Mark.X;
                xTurn = false;
            
            } else if(isXTurn() == false) {
                grid[row][col] = Mark.O;
                xTurn = true;
            }
            return true;
        }
        
        
    }
	
    private boolean isValidSquare(int row, int col) {

        /* Return true if specified location is within grid bounds */
        return (-1 < row) && (row < width) && (-1 < col) && (col < width);
    
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        return grid[row][col] != Mark.EMPTY;
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        return grid[row][col];

            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        if ((isMarkWin(Mark.X) == true)) {
            return Result.X;
        
        } else if ((isMarkWin(Mark.O) == true)) {
            return Result.O;
        
        } else if (isTie() == true) {
            return Result.TIE;
        
        } else {
            return Result.NONE;
        
        }
    }
	
    private boolean isMarkWin(Mark mark) {
    	
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        int counter = 0;
        for (int i = 0; i < width; i++) {
            counter = 0;
            for (int j = 0; j < width; j++) {
                if (getMark(i,j) == mark) {
                    counter++;
                }
            }
            if (counter == width) {
                return true;
            }
        }

        for (int a = 0; a < width; a++) {
            counter = 0;
            for (int b = 0; b < width; b++){
                if (getMark(b,a) == mark) {
                    counter++;
                }
                if (counter == width) {
                    return true;
                }
            }
        }

        counter = 0;
        for (int c = 0; c < width; c++) {
            if (getMark(c,c) == mark) {
                counter++;
            }
        }
        if (counter == width) {
            return true;
        } 

        counter = 0;
        for(int d = 0; d < width; d++) {
            if (getMark(d,width-d-1) == mark) {
                counter++;
            }
        }
        return counter == width;
    }

	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        int num = 0;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == Mark.EMPTY) {
                    num = num + 1;
                }
            }
        }

        if( num == 0) {
            return true;
        } else {
            return false;
        }
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}