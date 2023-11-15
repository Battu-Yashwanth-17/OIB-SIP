import java.util.Random;
import java.util.Scanner;

 class NumberGuessing {
    private static final int Minimum = 1;
    private static final int Maximum = 100;
    private static final int Max_Attempts = 10;
    private static final int Max_Rounds = 2;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

    
        System.out.println("Total Number Of Rounds : 2");
        System.out.println("Attempts To Guess Number In Each Round : 10\n");
        for (int i = 1; i <= Max_Rounds; i++) {
            int number = random.nextInt(Maximum) + Minimum;
            int attempts = 0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, Minimum, Maximum,
                    Max_Attempts);
            while (attempts < Max_Attempts) {
                System.out.println("Enter your guess : ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_number == number) {
                    int score = Max_Attempts - attempts;
                    totalScore = totalScore + score;
                    System.out.printf("Hurray!You guessed the number successfully. Attempts = %d. Round Score = %d\n",
                            attempts, score);
                    break;
                }

                else if (guess_number < number) {
                    System.out.printf("It's too low! The number is greater than %d. No.of Attempts Left = %d.\n", guess_number,
                            Max_Attempts - attempts);
                }

                else if (guess_number > number) {
                    System.out.printf("It's too high!The number is less than %d. No.of Attempts Left = %d.", guess_number,
                            Max_Attempts - attempts);
                }

            }

            if (attempts == Max_Attempts) {
                System.out.printf("\nRound = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random Number Is : %d\n\n", number);
            }
        }
        System.out.printf("Game Over. Total Score = %d\n", totalScore);
        scanner.close();
    }
}