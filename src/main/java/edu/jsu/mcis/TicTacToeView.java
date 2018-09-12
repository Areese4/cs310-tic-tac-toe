package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        System.out.println("   0 1 2");
        System.out.println();
        System.out.println("0  - - -");
        System.out.println("1 - - - ");
        System.out.println("2 - - - ");
        /* INSERT YOUR CODE HERE */

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
		System.out.println((Mark)" Move:");
		System.out.print("Enter the row and column numbers, separated by a space: ");
        /* INSERT YOUR CODE HERE */

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */
		System.out.println("Invalid Coordinates. Try Another");
        /* INSERT YOUR CODE HERE */

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}