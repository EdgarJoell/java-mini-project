import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {
    protected Scanner scan1= new Scanner(System.in);
    protected Scanner scan2 = new Scanner(System.in);
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
                System.out.println("You chose to play game\nDo you wish to play 'two vs. two' or 'vs. computer'?\nPlease type either 'two' or 'computer'");
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

    public String humanOrComputer() {
        String scanTwo = scan2.nextLine();
        return checkHumanOrComputer(scanTwo);
    }

    public String checkHumanOrComputer(String input) {
        if(input.toLowerCase().equals("two")) {
            System.out.println("You chose to 'two vs. two");
            playGameAgainstPlayer();
        } else if(input.toLowerCase().equals("computer")) {
            playGameAgainstComputer();
        }
        return input;
    }
    public void playGameAgainstPlayer() {

    }

    public void playGameAgainstComputer() {

    }

    public void viewHistory() {

    }

    public void quitGame() {

    }
}
