import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {
    // Fields
    protected Scanner scan1= new Scanner(System.in);
    protected Scanner scan2 = new Scanner(System.in);
    protected Scanner scan3 = new Scanner(System.in);
    protected Scanner scan4 = new Scanner(System.in);

    protected Scanner scan5 = new Scanner(System.in);

    protected Scanner scan6 = new Scanner(System.in);

    public void play() {
        System.out.println("Main Menu: \n\nPlay Game \nView History \nQuit \nPlease type either 'play', 'history', or 'quit'\n");
        takeMenuInput();
    }

// methods takeMenuInput AND checkMenuInput check if whether their input is right. If not, prompt them over and over until they get it right ----------------
    public String takeMenuInput() {
        String scanOne = scan1.nextLine();
        return checkMenuInput(scanOne);
    }

    public String checkMenuInput(String input) {
        switch (input.toLowerCase()) {
            case "play" -> {
                System.out.println("You chose to play game\nDo you wish to play 'player vs. player' or 'vs. computer'?\nPlease type either 'two' or 'computer'");
                humanOrComputer();
            }
            case "history" -> {
                System.out.println("You chose to view history\n");
                viewHistory();
            }
            case "quit" -> {
                System.out.println("You chose to quit. Hope to see you next time.");
                quitGame();
            }
            default -> {
                System.out.println("You did not choose an correct option, please try again\n");
                takeMenuInput();
            }
        }
        return input;
    }
// -----------------------------------------------------------------------------------------------------------------------------------------------
// Check user input about whether they want to play against the computer or another human-----------------------------------------------------------------

    /**
     * takes in the users input of whether they wish to play against another player or against the computer and sends it to checkHumanOrComputer for validity.
     * @return the value of the users input
     */
    public String humanOrComputer() {
        String scanTwo = scan2.nextLine();
        return checkHumanOrComputer(scanTwo);
    }

    /**
     * Checks the validity of the value the user entered in humanOrComputer().
     * @param input is the value that was entered in humanOrComputer().
     * @return If the user chooses to play against another player, or the computer. But if the input is in the wrong format, this method will send the user back to humanOrComputer() to reenter their choice.
     */
    public String checkHumanOrComputer(String input) {
        if(input.toLowerCase().equals("two")) {
            System.out.println("You chose to play 'player vs. player");
            setupPlayerGame();
        } else if(input.toLowerCase().equals("computer")) {
            System.out.println("You chose to play 'vs. computer");
            setupComputerGame();
        }
        return input;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method creates two Human player objects and asks each player in the console if they wish to change their name settings.
     */
    public void setupPlayerGame() {
        Human playerOne = new Human("Player One", 0, "");
        Human playerTwo = new Human("Player Two", 0, "");

        System.out.println(playerOne.getName() + ", would you like to change your name? Please type either 'yes' or 'no'");
        String scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updatePlayerOne(playerOne);
        } else {
            System.out.println("Player One's name is still Player Two");
        }

        System.out.println(playerTwo.getName() + ", would you like to change your name?");
        scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updatePlayerTwo(playerTwo);
        } else {
            System.out.println("Player Two's name is still Player Two");
        }
    }

    /**
     * This method updates Player One's name.
     * @param playerOne is the player object 'playerOne' passed down from the setupPlayerGame() method.
     */
    public void updatePlayerOne(Human playerOne) {
        System.out.println("What would you like to change it to?");
        String scanThree = scan3.nextLine();
        playerOne.setName(scanThree);
        System.out.println("Player One's new name is " + playerOne.getName());
    }

    /**
     * This method updates Player One's name.
     * @param playerTwo is the player object 'playerTwo' passed down from the setupPlayerGame() method.
     */
    public void updatePlayerTwo(Human playerTwo) {
        System.out.println("What would you like to change it to?");
        String scanThree = scan3.nextLine();
        playerTwo.setName(scanThree);
        System.out.println("Player One's new name is " + playerTwo.getName());
    }

    /**
     * Creates one Human object and one Computer object and asks the player if they wish to change playerOne's name or the Computer's name.
     */
    public void setupComputerGame() {
        Human playerOne = new Human("Player One", 0, "");
        Computer computer = new Computer("Computer", 0, "");

        System.out.println(playerOne.getName() + ", would you like to change your name? Please type either 'yes' or 'no'");
        String scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updatePlayerOne(playerOne);
        } else {
            System.out.println("Player One's name is still Player Two");
        }

        System.out.println("Would you like to change the computers name?");
        scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updateComputer(computer);
        } else {
            System.out.println("Computer's name is still Computer");
        }
    }

    /**
     * Updates the computers name settings if the player wishes to change the computers name.
     * @param computer is the Computer object passed in from the setupComputerGame() method.
     */
    public void updateComputer(Computer computer) {
        System.out.println("What would you like to change it to?");
        String scanThree = scan3.nextLine();
        computer.setName(scanThree);
        System.out.println("Player One's new name is " + computer.getName());
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    public void playGame(Object playerOne, Object playerTwo) {
        
    }
    public void viewHistory() {

    }

    public void quitGame() {

    }
}
