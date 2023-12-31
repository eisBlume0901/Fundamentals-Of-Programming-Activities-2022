package oneTwoCharge;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GameLogic
{
    static Scanner scanner = new Scanner(in);
    static Player player = new Player();
    static Computer computer = new Computer();

    public static int readInt(String prompt, int userChoices)
    {
        int input;
        do
        {
            out.print(prompt);
            try
            {
                input = Integer.parseInt(scanner.next());
            }
            catch(Exception e)
            {
                input = -1;
                out.println("Please enter integers only!");
            }
        }
        while(input < 1 || input > userChoices || input > playerSkills().size());
        return input;
    }

    public static void printSeparator(int n)
    {
        for (int i = 0; i < n; i++)
        {
            out.print("-");
        }
        out.println();
    }

    public static void printHeading(String title)
    {
        out.println(title);
    }

    public static int chargeP()
    {
        return player.playerSP += 1;
    }

    public static int chargeC()
    {
        return computer.computerSP += 1;
    }

    public static void automaticChargeUp()
    {
        if (computer.computerSP <= 0)
        {
            chargeC();
            printSeparator(70);
            printSeparator(20);
            out.println("Automatically charged up for computer!");
            printSeparator(20);
            printSeparator(70);
        }
    }
    
    public static ArrayList<Integer> playerSkills()
    {
        ArrayList<Integer> skills = new ArrayList<>();
        if (player.playerSP >= 0) skills.add(1); //charge
        if (player.playerSP >= 1) skills.add(2); //shield
        if (player.playerSP >= 1) skills.add(3); //wave
        if (player.playerSP >= 2) skills.add(4); //axe
        if (player.playerSP >= 3) skills.add(5); //kamekameha
        if (player.playerSP >= 5) skills.add(6); //amen
        return skills;
    }

    public static void damage()
    {
        out.println();
        out.println("You received a damage!");
    }

    public static void noDamage()
    {
        out.println();
        out.println("No damage was received!");
    }

    public static void choseCharge()
    {
        out.println("Computer chose charge");
    }

    public static void choseShield()
    {
        out.println("Computer chose shield");
    }
    public static void choseWave()
    {
        out.println("Computer chose wave");
    }
    public static void choseKamekameha()
    {
        out.println("Computer chose kamekameha");
    }
    public static void choseAxe()
    {

        out.println("Computer chose axe");
    }
    public static void choseAmen()
    {
        out.println("Computer chose amen");
    }

    public static void printPlayerStats()
    {
        if (player.playerHP <= 0)
        {
            player.playerHP = 0;
            out.println("    You lose...");
            out.println();
        }
        printHeading("     Player \nHP: " + "          " + player.playerHP + "\nSP: " + "          " + player.playerSP);
    }

    public static void printComputerStats()
    {
        if (computer.computerHP <= 0)
        {
            computer.computerHP = 0;
            out.println("    You win!");
            out.println();
        }
        printHeading("    Computer \nHP: " + "          " + computer.computerHP + "\nSP: " + "          " + computer.computerSP);
    }
    public static void battle()
    {
        int round = 0;
        out.println("Round " + round);
        printHeading("\nChoose your move!");

        for (Integer n: playerSkills())
        {
            if (n == 1)
                out.println(n + " charge");
            else if (n == 2)
                out.println(n + " shield");
            else if (n == 3)
                out.println(n + " wave");
            else if (n == 4)
                out.println(n + " axe");
            else if (n == 5)
                out.println(n + " kamekameha");
            else if (n == 6)
                out.println(n + " amen");
        }

        automaticChargeUp();

        ArrayList<Integer> skills = new ArrayList<>();
        if (computer.computerSP >= 1) skills.add(1); //charge
        if (computer.computerSP >= 1) skills.add(2); //shield
        if (computer.computerSP >= 1) skills.add(3); //wave
        if (computer.computerSP >= 2) skills.add(4); //axe
        if (computer.computerSP >= 3) skills.add(5); //kamekameha
        if (computer.computerSP >= 5) skills.add(6); //amen

        ArrayList<Integer> computerMoves;
        computerMoves = skills;
        int random = (int) (Math.random()*(computerMoves.size()));
        int computerMove = computerMoves.get(random);
        /* Please remove /* if you want to check the computer move.
        out.println("Computer move: " + computerMove);
        out.println();
        for (Integer n: skills)
        {
            if (n == 1)
                out.println(n + " charge");
            else if (n == 2)
                out.println(n + " shield");
            else if (n == 3)
                out.println(n + " wave");
            else if (n == 4)
                out.println(n + " axe");
            else if (n == 5)
                out.println(n + " kamekameha");
            else if (n == 6)
                out.println(n + " amen");
        }
        */
        int input = readInt("-> ", 6);
        out.println("You chose " + input);


        //CHARGE
        if (input == 1)
        {
            if (computerMove == 1) //charge
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                chargeP();
                printPlayerStats();

                chargeC();
                printComputerStats();

            }
            else if (computerMove == 2) //shield
            {
                printSeparator(70);
                printSeparator(20);
                choseShield();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                chargeP();
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 3) //wave
            {
                printSeparator(70);
                printSeparator(20);
                choseWave();
                damage();
                printSeparator(20);
                printSeparator(70);

                chargeP();
                player.playerHP -= 2;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 4) //axe
            {
                printSeparator(70);
                printSeparator(20);
                choseAxe();
                damage();
                printSeparator(20);
                printSeparator(70);

                chargeP();
                player.playerHP -= 3;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 5) //kamekameha
            {
                printSeparator(70);
                printSeparator(20);
                choseKamekameha();
                damage();
                printSeparator(20);
                printSeparator(70);

                chargeP();
                player.playerHP -= 4;
                printPlayerStats();

                computer.computerSP -= 3;
                printComputerStats();
            }
            else if (computerMove == 6) //amen
            {
                printSeparator(70);
                printSeparator(20);
                choseAmen();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                chargeP();
                printPlayerStats();

                computer.computerHP += 5;
                computer.computerSP -= 5;
                printComputerStats();
            }
        }
        //SHIELD
        else if (input == 2)
        {
            if (computerMove == 1) //charge
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                chargeC();
                printComputerStats();
            }
            else if (computerMove == 2) //shield
            {
                printSeparator(70);
                printSeparator(20);
                choseShield();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 3) //wave
            {
                printSeparator(70);
                printSeparator(20);
                choseWave();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 4) //axe
            {
                printSeparator(70);
                printSeparator(20);
                choseAxe();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                computer.computerSP -= 2;
                printComputerStats();
            }
            else if (computerMove == 5) //kamekameha
            {
                printSeparator(70);
                printSeparator(20);
                choseKamekameha();
                damage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                player.playerHP -= 4;
                printPlayerStats();

                computer.computerSP -= 3;
                printComputerStats();
            }
            else if (computerMove == 6) //amen
            {
                printSeparator(70);
                printSeparator(20);
                choseAmen();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                computer.computerHP += 5;
                computer.computerSP -= 5;
                printComputerStats();
            }
        }
        //WAVE
        else if(input == 3)
        {
            if (computerMove == 1) //charge
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                chargeC();
                computer.computerHP -= 2;
                printComputerStats();
            }
            else if (computerMove == 2) //shield
            {
                printSeparator(70);
                printSeparator(20);
                choseShield();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 3) //wave
            {
                printSeparator(70);
                printSeparator(20);
                choseWave();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 4) //axe
            {
                printSeparator(70);
                printSeparator(20);
                choseAxe();
                damage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                player.playerHP -= 1;
                printPlayerStats();

                computer.computerSP -= 2;
                printComputerStats();
            }
            else if (computerMove == 5) //kamekameha
            {
                printSeparator(70);
                printSeparator(20);
                choseKamekameha();
                damage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                player.playerHP -= 2;
                printPlayerStats();

                computer.computerSP -= 3;
                printComputerStats();
            }
            else if (computerMove == 6) //amen
            {
                printSeparator(70);
                printSeparator(20);
                choseAmen();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 1;
                printPlayerStats();

                computer.computerHP += 5;
                computer.computerSP -= 5;
                printComputerStats();
            }
        }
        //AXE
        else if (input == 4)
        {
            if (computerMove == 1) //charge
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 2;
                printPlayerStats();

                chargeC();
                computer.computerHP -= 3;
                printComputerStats();
            }
            else if (computerMove == 2) //shield
            {
                printSeparator(70);
                printSeparator(20);
                choseShield();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 2;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 3) //wave
            {
                printSeparator(70);
                printSeparator(20);
                choseWave();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 2;
                printPlayerStats();

                computer.computerHP -= 1;
                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 4) //axe
            {
                printSeparator(70);
                printSeparator(20);
                choseAxe();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 2;
                printPlayerStats();

                computer.computerSP -= 2;
                printComputerStats();
            }
            else if (computerMove == 5) //kamekameha
            {
                printSeparator(70);
                printSeparator(20);
                choseKamekameha();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 2;
                player.playerHP -= 2;
                printPlayerStats();

                computer.computerSP -= 3;
                printComputerStats();
            }
            else if (computerMove == 6) //amen
            {
                printSeparator(70);
                printSeparator(20);
                choseAmen();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 2;
                printPlayerStats();

                computer.computerHP += 5;
                computer.computerSP -= 5;
                printComputerStats();
            }
        }
        //KAMEKAMEHA
        else if(input == 5)
        {
            if (computerMove == 1) //charge
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 3;
                printPlayerStats();

                chargeC();
                computer.computerHP -= 4;
                printComputerStats();
            }
            else if (computerMove == 2) //shield
            {
                printSeparator(70);
                printSeparator(20);
                choseShield();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 3;
                printPlayerStats();

                computer.computerHP -= 4;
                printComputerStats();
            }
            else if (computerMove == 3) //wave
            {
                printSeparator(70);
                printSeparator(20);
                choseWave();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 3;
                printPlayerStats();

                computer.computerHP -= 2;
                printComputerStats();
            }
            else if (computerMove == 4) //axe
            {
                printSeparator(70);
                printSeparator(20);
                choseAxe();
                damage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 3;
                printPlayerStats();

                computer.computerHP -= 1;
                printComputerStats();
            }
            else if (computerMove == 5) //kamekameha
            {
                printSeparator(70);
                printSeparator(20);
                choseKamekameha();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 3;
                printPlayerStats();

                computer.computerSP -= 3;
                printComputerStats();
            }
            else if (computerMove == 6) //amen
            {
                printSeparator(70);
                printSeparator(20);
                choseAmen();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerSP -= 3;
                printPlayerStats();

                computer.computerHP += 5;
                computer.computerSP -= 5;
                printComputerStats();
            }
        }
        //AMEN
        else if (input == 6)
        {
            if (computerMove == 1) //charge
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerHP += 5;
                player.playerSP -= 5;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 2) //shield
            {
                printSeparator(70);
                printSeparator(20);
                choseShield();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerHP += 5;
                player.playerSP -= 5;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 3) //wave
            {
                printSeparator(70);
                printSeparator(20);
                choseWave();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerHP += 5;
                player.playerSP -= 5;
                printPlayerStats();

                computer.computerSP -= 1;
                printComputerStats();
            }
            else if (computerMove == 4) //axe
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerHP += 5;
                player.playerSP -= 5;
                printPlayerStats();

                computer.computerSP -= 2;
                printComputerStats();
            }
            else if (computerMove == 5) //kamekameha
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerHP += 5;
                player.playerSP -= 5;
                printPlayerStats();

                computer.computerSP -= 3;
                printComputerStats();
            }
            else if (computerMove == 6) //amen
            {
                printSeparator(70);
                printSeparator(20);
                choseCharge();
                noDamage();
                printSeparator(20);
                printSeparator(70);

                player.playerHP += 5;
                player.playerSP -= 5;
                printPlayerStats();

                computer.computerHP += 5;
                computer.computerSP -= 5;
                printComputerStats();
                round++;
            }

        }
    }


    public static void startGame()
    {
        //One Two Charge!!!
        out.println();
        out.println("Welcome to One, Two, Charge! ");
        printSeparator(70);
        printSeparator(20);
        out.println("Here is the mechanics of the game!");
        out.println("You and the computer has a maximum health points(HP) of 10.");
        out.println("Whoever reaches the health points of the other opponent wins!");
        out.println();
        out.println("Skill points and damage table:");
        out.println();
        out.println("Charge - recharges your SP by 1. \nYou do not need any skill points to access this.");
        out.println("Shield - costs 1 SP. \nYou are immune to any attacks except, \"Kamekameha\".");
        out.println("Wave - costs 1 SP. \nIt deals 2 damage to enemy attacks");
        out.println("Axe - costs 2 SP. \nIt deals 3 damage to enemy attacks.");
        out.println("Kamekameha - costs 4 SP. \nIt deals 6 damage to enemy attacks.");
        out.println("Amen - costs 5 SP. \nNegates all damage attacks and heals 5 HP.");
        out.println();
        out.println("Legend: ");
        out.println("SP = Skill Point/s");
        out.println("HP = Health Point/s");
        printSeparator(20);
        printSeparator(70);

        //Automatic charge computer and player to start the game
        chargeP();
        chargeC();
        while (player.playerHP > 0 && computer.computerHP > 0)
        {
            battle();
        }
    }

}