import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int matchChoice = 0;
        int totalRound = 0;
        int roundsToWin =0;
        int userChoice=0;
        int userScore=0;
        int computerScore=0;
        int computerChoice=0;
        String userName;
        String computerName;
        String userFirstName;
        String computerFirstName;
        String userChoiceName;
        String computerChoiceName;

        System.out.println("!***** Welcome To The Game Of Stone ,Paper & Scissor *****!");
        System.out.println("\nRules:\n This game has 3 match modes: Best of 3, Best of 5, and Best of 7. \n The player who wins the majority of the rounds is declared the winner.");
        System.out.println("NOTE : If you enter an invalid choice, you lose the round.");
        System.out.println();
        System.out.print("Enter your name : ");
        userName=sc.nextLine();
        System.out.print("Enter your Opponent name : ");
        computerName = sc.nextLine();

        if(userName.contains(" ")){
            int spaceIndex=userName.indexOf(" ");
            userFirstName =userName.substring(0,spaceIndex);
        }else{
            userFirstName = userName;
        }

        if(computerName.contains(" ")){
            int spaceIndex=computerName.indexOf(" ");
            computerFirstName =computerName.substring(0,spaceIndex);
        }else{
            computerFirstName = computerName;
        }

        System.out.println("\n!*** Select Match Mode ***!");
        System.out.println("NOTE : Default mode (Best Of 3 )");
        System.out.println("\n 1. Best Of 3\n 2. Best Of 5\n 3. Best Of 7");
        System.out.print("Enter Match Choice : ");
        matchChoice=sc.nextInt();

        System.out.println("\nBattle between \n"+userFirstName+" vs "+computerFirstName);

        //Game Start

        switch(matchChoice){
            case 1:
                totalRound = 3;
                roundsToWin=2;
                break;
            case 2:
                totalRound = 5;
                roundsToWin=3;
                break;
            case 3:
                totalRound = 7;
                roundsToWin=4;
                break;
            default :
                totalRound = 3;
                roundsToWin=2;
        }
        System.out.println("Total 0"+totalRound+" Rounds Match ");
        System.out.println("NOTE : The player who wins the majority of the rounds will be declared the winner.");
        //for loop
        for(int i=1;i<=totalRound;i++){
            if(userScore == roundsToWin || computerScore == roundsToWin){
                break;
            }
            System.out.println();
            System.out.println("    #Round 0"+i+"#");
            System.out.println("1. Stone \n2. Paper \n3. Scissor ");
            System.out.print("Enter User Choice : ");
            userChoice = sc.nextInt();
            //user Not input
            if(userChoice < 1 || userChoice > 3){
                System.out.println("# Ye kya User ne input hi galat dia  ");
                System.out.println(userFirstName+" ka input 1 aur 3 ke bich me nahi hai to ye round ke winner hue "+computerFirstName);
                computerScore++;
            }else{
                //User Choice
                switch(userChoice){
                    case 1:
                        userChoiceName = "Stone";
                        break;
                    case 2:
                        userChoiceName = "Paper";
                        break;
                    case 3:
                        userChoiceName = "Scissor";
                        break;
                    default  :
                        userChoiceName = null;
                }

                computerChoice = random.nextInt(3)+1;
                //Computer Choice
                switch(computerChoice){
                    case 1:
                        computerChoiceName = "Stone";
                        break;
                    case 2:
                        computerChoiceName = "Paper";
                        break;
                    case 3:
                        computerChoiceName = "Scissor";
                        break;
                    default :
                        computerChoiceName = null;
                }

                System.out.println();
                System.out.println(userFirstName+" Choice : "+userChoiceName);
                System.out.println(computerFirstName+" Choice : "+computerChoiceName);

                //Special Case 1 & 3
                if((userChoice == 1 &&  computerChoice == 3)|| (computerChoice == 1  && userChoice == 3)|| userChoice == computerChoice ){
                    //Condition
                    if(userChoice > computerChoice){
                        System.out.println("||"+computerChoiceName+" > "+userChoiceName+"||");
                        System.out.println(computerFirstName+" Win this round !");
                        computerScore++;
                    }else if(computerChoice > userChoice){
                        System.out.println("||"+userChoiceName+" > "+computerChoiceName+"||");
                        System.out.println(userFirstName+" Win this round !");
                        userScore++;
                    }else if(userChoice == computerChoice){
                        System.out.println("||"+userChoiceName+" == "+computerChoiceName+"||");
                        System.out.println("Both are equal round tie!");
                    }
                }else {
                    if(userChoice > computerChoice){
                        System.out.println("||"+userChoiceName+" > "+computerChoiceName+"||");
                        System.out.println(userFirstName+" Win this round !");
                        userScore++;
                    }
                    else if(computerChoice > userChoice){
                        System.out.println("||"+computerChoiceName+" > "+userChoiceName+"||");
                        System.out.println(computerFirstName+" Win this round !");
                        computerScore++;
                    }
                }
            }
            //Score Count & Winner Decide
            System.out.println(userName+" : 0"+userScore+" || "+computerName+" : 0"+computerScore);
        }
        System.out.println();
        if(userScore > computerScore){
            System.out.println("The Winner of the Match : "+userName);
        }else if(computerScore > userScore){
            System.out.println("The Winner of the Match : "+computerName);
        }else{
            System.out.println("Match Tie Between "+userFirstName+" & "+computerFirstName);
        }
    }
}