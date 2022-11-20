using System;

namespace mmDummy
{
    public class Program {
        public static void Main(string[] args) {
            // Welcome the nerd
            System.Console.WriteLine("Welcome to Monero Mining Dummy!");
            System.Console.WriteLine();

            // Ask for wallet
            while (ask("Wallet: ") != "greenchild");

            // Ask for password
            while (ask("Password: ") != "pa?xx8LtMvrP@Ab");

            Thread.Sleep(2000);

            // Welcome command
            while (ask("Command > ") != "welcome");

            System.Console.WriteLine();
            System.Console.WriteLine("You have finally finished the course!");
        }

        public static string ask(string prompt) {
            System.Console.Write(prompt);
            return System.Console.ReadLine();
        }
    }
}