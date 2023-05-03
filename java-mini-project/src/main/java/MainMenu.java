import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    // Fields
    protected Scanner scan1= new Scanner(System.in);
    protected Scanner scan2 = new Scanner(System.in);
    protected Scanner scan3 = new Scanner(System.in);
    protected Scanner scan4 = new Scanner(System.in);

    protected Scanner scan5 = new Scanner(System.in);

    protected Scanner scan6 = new Scanner(System.in);
    protected ArrayList<String> history = new ArrayList<>();

    Human playerOne = new Human("Player One", 0, "");

    Human playerTwo = new Human("Player Two", 0, "");

    Computer computer = new Computer("Computer", 0, "");

    public void play() {
        System.out.println("Main Menu: \n\nWelcome to the Rock, Paper, Scissors Game! \n\nPlay Game \nView History \nQuit \n\nPlease type either 'play', 'history', or 'quit'");
        takeMenuInput();
    }

// methods takeMenuInput AND checkMenuInput check if whether their input is right. If not, prompt them over and over until they get it right ----------------
    public String takeMenuInput() {
        String scanOne = scan1.nextLine();
        return checkMenuInput(scanOne);
    }

    /**
     *
     * @param input
     * @return
     */
    public String checkMenuInput(String input) {
        switch (input.toLowerCase()) {
            case "play" -> {
                System.out.println("\nYou chose to play game\nDo you wish to play 'player vs. player' or 'vs. computer'?\nPlease type either 'two' or 'computer'");
                humanOrComputer();
            }
            case "history" -> {
                System.out.println("\nYou chose to view history\n");
                viewHistory();
            }
            case "quit" -> {
                System.out.println("\nYou chose to quit. Hope to see you next time.");
                quitGame();
            }
            default -> {
                System.out.println("\nYou did not choose an correct option, please try again\n");
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
            System.out.println("\nYou chose to play 'player vs. player");
            setupPlayerGame(playerOne, playerTwo);
        } else if(input.toLowerCase().equals("computer")) {
            System.out.println("\nYou chose to play 'vs. computer");
            setupComputerGame(playerOne, computer);
        }
        return input;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * This method creates two Human player objects and asks each player in the console if they wish to change their name settings.
     */
    public void setupPlayerGame(Human playerOne, Human playerTwo) {
        System.out.println("\n" + playerOne.getName() + ", would you like to change your name? Please type either 'yes' or 'no'");
        String scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updatePlayerOne(playerOne);
        } else {
            System.out.println("\nPlayer One's name is still Player One");
        }

        System.out.println("\n|" + playerTwo.getName() + ", would you like to change your name?");
        scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updatePlayerTwo(playerTwo);
        } else {
            System.out.println("\nPlayer Two's name is still Player Two");
        }
        playGameWithPlayer(playerOne, playerTwo);
    }

    /**
     * This method updates Player One's name.
     * @param playerOne is the player object 'playerOne' passed down from the setupPlayerGame() method.
     */
    public void updatePlayerOne(Human playerOne) {
        System.out.println("\nWhat would you like to change it to?");
        String scanThree = scan3.nextLine();
        playerOne.setName(scanThree);
        System.out.println("\nPlayer One's new name is " + playerOne.getName());
    }

    /**
     * This method updates Player One's name.
     * @param playerTwo is the player object 'playerTwo' passed down from the setupPlayerGame() method.
     */
    public void updatePlayerTwo(Human playerTwo) {
        System.out.println("\nWhat would you like to change it to?");
        String scanThree = scan3.nextLine();
        playerTwo.setName(scanThree);
        System.out.println("\nPlayer Two's new name is " + playerTwo.getName());
    }

    /**
     * Creates one Human object and one Computer object and asks the player if they wish to change playerOne's name or the Computer's name.
     */
    public void setupComputerGame(Human player, Computer computer) {
        System.out.println("\n" + playerOne.getName() + ", would you like to change your name? Please type either 'yes' or 'no'");
        String scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updatePlayerOne(playerOne);
        } else {
            System.out.println("\nPlayer One's name is still Player One");
        }

        System.out.println("\nWould you like to change the computers name?");
        scanThree = scan3.nextLine();
        if(scanThree.toLowerCase().equals("yes")) {
            updateComputer(computer);
        } else {
            System.out.println("\nComputer's name is still Computer");
        }
        playGameWithComputer(playerOne, computer);
    }

    /**
     * Updates the computers name settings if the player wishes to change the computers name.
     * @param computer is the Computer object passed in from the setupComputerGame() method.
     */
    public void updateComputer(Computer computer) {
        System.out.println("\nWhat would you like to change it to?");
        String scanThree = scan3.nextLine();
        computer.setName(scanThree);
        System.out.println("\nPlayer One's new name is " + computer.getName());
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------

    public void playGameWithComputer(Human playerOne, Computer computer) {
        System.out.println("\nNEW GAME STARTING...\nARE YOU READY?...\nSHOOT\n" + playerOne.getName() + " it's your turn! Type either 'rock', 'paper', or 'scissors'");
        takePlayerInput(playerOne);
        computerChooses(computer);
        System.out.println(playerOne.getName() + " chose " + playerOne.getInput() +" AND " + computer.getName() + " chose " + computer.getInput());
        if(playerOne.getInput().equals(computer.getInput())) {
            System.out.println("\nIt was a draw! Nobody wins.");
        } else if((playerOne.getInput() + computer.getInput()).equals("rockscissors") || (playerOne.getInput() + computer.getInput()).equals("paperrock") || (playerOne.getInput() + computer.getInput()).equals("scissorspaper")) {
            playerOne.setScore();
            System.out.println(playerOne.getName() + " won this round!\n" + "Their new score is " + playerOne.getScore());
            history.add(playerOne.getName() + " was the winner");
        } else {
            computer.setScore();
            System.out.println(computer.getName() + " won this round!\n" + "Their new score is " + computer.getScore());
        }
        System.out.println("\nWould you like to play again, go to the main menu, or quit? Please type either 'again', 'menu', or 'quit'.");
        String scan = scan1.nextLine();
        if(scan.toLowerCase().equals("again")) {
            playerOne.setInput("");
            computer.setInput("");
            playGameWithComputer(playerOne, computer);
        } else if(scan.toLowerCase().equals("menu")) {
            playerOne.setInput("");
            computer.setInput("");
            play();
        } else {
            quitGame();;
        }
        System.out.println("\n");
    }

    public void takePlayerInput(Human player) {
        String scanFour = scan4.nextLine();
        player.setInput(scanFour);
        checkPlayerValidity(player);
    }

    public String computerChooses(Computer computer) {
        double random = Math.floor(Math.random() * 3);
        String choice = "";
        if(random == 0) choice = "rock";
        else if(random == 1) choice = "paper";
        else if(random == 2) choice = "scissors";
        else System.out.println("doesn't work matey");
        computer.setInput(choice);

        return choice;
    }

    public void playGameWithPlayer(Human playerOne, Human playerTwo) {
        System.out.println("\nNEW GAME STARTING...\nARE YOU READY?...\nSHOOT\n" + playerOne.getName() + " it's your turn! Type either 'rock', 'paper', or 'scissors'");
        takePlayerInput(playerOne);
        System.out.println("\n" + playerTwo.getName() + " it's your turn. Type either 'rock', 'paper', or 'scissors'");
        takePlayerInput(playerTwo);
        System.out.println(playerOne.getName() + " chose " + playerOne.getInput() +" AND " + playerTwo.getName() + " chose " + playerTwo.getInput());
        if(playerOne.getInput().equals(playerTwo.getInput())) {
            System.out.println("\nIt was a draw! Nobody wins.");
            history.add(playerOne.getName() + " vs. " + playerTwo.getName() + "results. It was a draw");
        } else if((playerOne.getInput() + playerTwo.getInput()).equals("rockscissors") || (playerOne.getInput() + playerTwo.getInput()).equals("paperrock") || (playerOne.getInput() + playerTwo.getInput()).equals("scissorspaper")) {
            playerOne.setScore();
            System.out.println(playerOne.getName() + " won this round!\n" + "Their new score is " + playerOne.getScore());
            history.add(playerOne.getName() + " vs. " + playerTwo.getName() + " results. " + playerOne.getName() + " was the winner");
        } else {
            playerTwo.setScore();
            System.out.println(playerTwo.getName() + " won this round!\n" + "Their new score is " + playerTwo.getScore());
            history.add(playerOne.getName() + " vs. " + playerTwo.getName() + " results. " + playerTwo.getName() + " was the winner");
        }
        System.out.println("\nWould you like to play again, go to the main menu, or quit? Please type either 'again', 'menu', or 'quit'.");
        String scan = scan1.nextLine();
        if(scan.toLowerCase().equals("again")) {
            playerOne.setInput("");
            playerTwo.setInput("");
            playGameWithPlayer(playerOne, playerTwo);
        } else if(scan.toLowerCase().equals("menu")) {
            playerOne.setInput("");
            playerTwo.setInput("");
            play();
        } else {
            quitGame();;
        }

        System.out.println("\n");
    }

    public void checkPlayerValidity(Human player) {
        if(player.getInput().toLowerCase().equals("rock") || player.getInput().toLowerCase().equals("paper") || player.getInput().toLowerCase().equals("scissors")) {
        } else {
            System.out.println("\n" + player.getName() + " it appears you had a wrong input. Please try again");
            takePlayerInput(player);
        }
    }

    public void viewHistory() {
        for (String s : history) {
            System.out.println(s);
        }
        System.out.println("\nType 'menu' to return back to the main menu.");
        String scan = scan1.nextLine();
        if(scan.toLowerCase().equals("menu")) {
            play();
        } else {
            viewHistory();
        }
    }

    public void quitGame() {
    }
}
