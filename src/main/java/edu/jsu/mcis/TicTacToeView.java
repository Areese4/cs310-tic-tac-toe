package edu.jsu.mcis;


public class TicTacToeView {

    private TicTacToeModel model;
    public String Board;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */ 
        Board = "  ";
        Board = Board.concat("\n\n");
        System.out.println(" ");
        for (int bc = 0; bc < model.getWidth(); bc++) {
            Board = Board + bc;
        }
        Board = Board.concat("\n\n");
        for(int ab = 0; ab < model.getWidth(); ab++) {
            Board = Board + ab;
            Board = Board.concat(" ");
            for(int cd = 0; cd < model.getWidth(); cd++) {
                Board = Board + model.getMark(cd,ab).toString(); 
            }
            Board = Board.concat("\n");
        }
        System.out.println(Board);

            
    }
    public void showNextMovePrompt() {

        // Display a prompt for the player's next move (see examples) */
       
        if (model.isXTurn() == true) {
            System.out.println("Player 1 (X): Move ");
            System.out.print("Enter the row and column numbers, "
                    + "separated by a space: "); 
        } else { 
            System.out.println("Player 2 (O): Move ");
            System.out.print("Enter the row and column numbers, "
                    + "separated by a space: ");
        }
    }

    public void showInputError() {
        
        /* Display an error if input is invalid (see examples) */
		System.out.println("\n");
        System.out.println("Invalid coordinates for input. ");
        System.out.println("Try again. ");
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");
    }
	
}