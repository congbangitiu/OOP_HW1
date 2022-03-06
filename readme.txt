OPTION 1

1. Project explanation
    - The project includes 1 file "Lottery.java" to generate methods, 1 file "Entry.java" to generate an object and run the program
    - In file "Lottery.java":
        + Import several libraries and declare variables, arrays which is necessary
        + randomUserNumbers(): random a sequence of 6 numbers from 1 to 49 which is not concide when users choose the second option
        + randomWinnerNumbers(): random a sequence of 6 numbers from 1 to 49 which is not concide
        + inputTicket(): request users input 6 numbers if they choose the first option
        + buyTicket(): request users choose one out of two options, input by themselves or random automatically
        + preCheckValidTicket(): when users choose the first option, but they input one out of six numbers which beyond the range 1 and 49; then this method will be called and return true or false value
        + checkValidTicket(): check the method preCheckValidTicket() return true or false value
        + printTicket(): print out the sequence of 6 numbers of user ticket
        + jackpot(): random and print out the sequence of 6 numbers of winning ticket
        + checkWinner(): check user ticket how many numbers do they match with the winning ticket
        + currentProfit(): calculate and print out the current profit after each turn
        + getFinalProfit(): calculate and print out the final profit
        + getNumberWin(): count the number of wins by users 
    - In file "Entry.java":
        + Import several libraries, declare variables, arrays which is necessary and the object
        + Call the methods in file "Lottery.java"
2. Operation
    - Firstly, the program will ask users the numbers of turns that they want to play (How many turns do you want to play ?)
    - Secondly, it will show 2 options and ask user choose one out of them (Do you want to pick your own ticket numbers ? (1.Yes  2.No))
        + If users choose 1, they will input their own 6 numbers
        + If they choose 2, they will receive a sequence of 6 random numbers
    - Thirdly, it will show 
        + the user ticket, 
        + the winning ticket, 
        + the matched number
        + the total money won
        + the total ticket cost
        + the current profit/loss
    - After the last turn, it will print the number of winning turns and annouce the profit/loss
3. New features
    - The program will check whether the number entered by the user exceeds the range from 0 to 49. If so, ask the user to re-enter until the sequence contains all valid numbers
    - When the user chooses option 2, the program will randomly output non-identical numbers in a sequence of numbers
    - The sequence of numbers when printed out will be arranged in ascending order for users to easily detect the number
    - The program will calculate the profit/loss after each turn and print out the number of times the user won between 1 and 6 numbers as well as the profit/loss amount after the last turn.
