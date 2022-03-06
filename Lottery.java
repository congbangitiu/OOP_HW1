import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.out;

public class Lottery {
    private int ticketType;
    private int[] userTicket = new int[6];
    private int[] winnerTicket = new int[6];
    private static int totalBuy=0;
    private static int totalWin=0;
    private static int countWin0=0;
    private static int countWin1=0;
    private static int countWin2=0;
    private static int countWin3=0;
    private static int countWin4=0;
    private static int countWin5=0;
    private static int countWin6=0;
    private final static int ticketPrice=4;
    private final static int min=1;
    private final static int max=49;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    // random 6 numbers do not coincide
    public void randomUserNumbers() {
        int cur = 0;
        int remaining = max;
        int count = userTicket.length;
        for (int i = min; i <= max; i++) {
            double probability = random.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                userTicket[cur++] = i;
            }
            remaining--;
        }          
    }
    public void randomWinnerNumbers() {
        int cur = 0;
        int remaining = max;
        int count = winnerTicket.length;
        for (int i = min; i <= max; i++) {
            double probability = random.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                winnerTicket[cur++] = i;
            }
            remaining--;
        }          
    }
    
    
    public void inputTicket(){
        out.print("Enter your own 6 numbers (1 to 49): ");
        for(int i=0;i<userTicket.length;i++){
            userTicket[i]=input.nextInt();
        }
    }

    public int buyTicket(){
        out.println("Do you want to pick your own ticket numbers ? (1.Yes  2.No)");
        out.print("You choose: ");
        ticketType = input.nextInt();
        // ticketType=2;
        if (ticketType == 1){
            totalBuy-=ticketPrice;
            inputTicket();
        }
        else if(ticketType == 2){
            totalBuy-=ticketPrice;
            randomUserNumbers();
        }
        else {
            out.println("Your choice is invalid !!! Choose again");
            buyTicket();
        }
        return totalBuy;
    }
    
    //check if the user enters a number between 1 and 49
    public int preCheckValidTicket(){
        for(int i=0;i<userTicket.length;i++){
            if(userTicket[i]<min || userTicket[i]>max){
                out.println("Number in the "+(i+1)+" position is not valid !!! Please input again !");
                inputTicket();
                // break;
                return 0;
            }
        }
        return 1;
    }
    public void checkValidTicket(){
        if(preCheckValidTicket()==0)
            checkValidTicket();
    }

    public void printTicket(){
        out.print("Your ticket is: ");
        Arrays.sort(userTicket);
        for(int i=0;i<userTicket.length;i++)
            out.print(userTicket[i]+" ");
    }

    // print out the winning ticket
    public void jackpot() {
        out.print("\nThe winning ticket is: ");
        // for(int i=0;i<winnerTicket.length;i++){
        //     winnerTicket[i]=random.nextInt(49)+1;   
        //     // out.print(winnerTicket[i]+" ");
        // }
        randomWinnerNumbers();
        // for (int a=0;a<winnerTicket.length;a++){
        //     for(int b=a+1;b<winnerTicket.length;b++){
        //         if(winnerTicket[a]>winnerTicket[b]){
        //             int temp=winnerTicket[a];
        //             winnerTicket[a]=winnerTicket[b];
        //             winnerTicket[b]=temp;
        //         }
        //     }
        // }
        Arrays.sort(winnerTicket);
        for(int i=0;i<winnerTicket.length;i++){
            out.print(winnerTicket[i]+" ");
        }
    }


    public void checkWinner(){
        int countMatch=0;
        for(int i=0;i<6;i++){
            if(winnerTicket[i]==userTicket[i])
                countMatch++;
        }
        out.println("\nYour ticket has matched "+countMatch+" number(s)");
        switch(countMatch){
            case 0:
                out.println("Better luck next time !");
                countWin0++;
                break;
            case 1:
                out.println("Congratulations! You have won $10");
                countWin1++;
                totalWin+=10;
                break;
            case 2:
                out.println("Congratulations! You have won $10");
                countWin2++;
                totalWin+=10;
                break;
            case 3: 
                out.println("Congratulations! You have won $100");
                countWin3++;
                totalWin+=100;
                break;
            case 4:
                out.println("Congratulations! You have won $1000");
                countWin4++;
                totalWin+=1000;
                break;
            case 5:
                out.println("Congratulations! You have won $5000");
                countWin5++;
                totalWin+=5000;
                break;
            case 6:
                out.println("Congratulations! You have won $5 million");
                countWin6++;
                totalWin+=5000000;
                break;
        }
    }

    // print out the current profit
    public void currentProfit(){
        out.println("The total money won is: $"+totalWin);
        out.println("The total ticket cost is: $"+(0-totalBuy));
        out.println("Your current profit/loss is: $"+(totalBuy+totalWin));
    }

    // print out the final profit
    public int getFinalProfit(){
        int profit=totalBuy+totalWin;
        return profit;
    }

    // print out the number of winning turns (match at least 1 number)
    public void getNumberWin(){
        out.println("  The number of games matched 0 number is: "+countWin0);
        out.println("  The number of games matched 1 number is: "+countWin1);
        out.println("  The number of games matched 2 numbers is: "+countWin2);
        out.println("  The number of games matched 3 numbers is: "+countWin3);
        out.println("  The number of games matched 4 numbers is: "+countWin4);
        out.println("  The number of games matched 5 numbers is: "+countWin5);
        out.println("  The number of games matched all 6 numbers is: "+countWin6); 
    }
}