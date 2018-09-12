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
		System.out.println("Enter Next Move. ");
		System.out.print("Example Form for Your Move: ");
		System.out.print("(0, 1)");
        /* INSERT YOUR CODE HERE */

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}