package com.revature.commands;

public class CommandWords {
		private static final String[] validCommands = {
            "go", "quit", "help"
        };
		
		private static  final String[] commandGo = { "foward", "left", "right", "back" };
        public CommandWords() {}

        public static boolean isCommand(String input) {
            for (int i = 0; i < validCommands.length; i++) {
                if (validCommands[i].equals(input)) {
                    return true;
                }
            }
            //If we get here, string was not found in commands
            return false;
        }

        public static void showAll() {
        	System.out.print("Command words: ");
            for (String command : validCommands) {
                System.out.print(command + " ");
            }
            System.out.print("\nGo command words: ");
            for (String command : commandGo) {
            	System.out.print(command + " ");
            }
            
            System.out.println();
        }
}
