public class Player {
    // Fields
    private String name;
    private int score;
    private String input;

    // Constructors
    public Player() {

    }

    public Player(String name, int score, String input) {
        this.name = name;
        this.score = score;
        this.input = input;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
