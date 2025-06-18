import java.util.Scanner;

public class Q13 {
    static String getComputerChoice() {
        int num = (int) (Math.random() * 3);
        return num == 0 ? "rock" : num == 1 ? "paper" : "scissors";
    }

    static String getWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if (user.equals("rock") && comp.equals("scissors") || user.equals("paper") && comp.equals("rock") || user.equals("scissors") && comp.equals("paper")) return "User";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, compWins = 0;
        int rounds = sc.nextInt();
        for (int i = 0; i < rounds; i++) {
            String user = sc.next();
            String comp = getComputerChoice();
            String winner = getWinner(user, comp);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
            System.out.println("Round " + (i + 1) + ": User=" + user + " Comp=" + comp + " Winner=" + winner);
        }
        System.out.println("User wins: " + userWins);
        System.out.println("Computer wins: " + compWins);
    }
}
