import java.util.*;

abstract class Pokemon {
    private String name;
    private String[] types = new String[2];  // Up to 2 types
    private int level;
    private String heldItem;

    public Pokemon(String name, String type1, int level, String heldItem) {
        this.name = name;
        this.types[0] = type1;
        this.level = level;
        this.heldItem = heldItem;
    }

    public String getName() {
        return name;
    }

    public String[] getTypes() {
        return types;
    }

    public int getLevel() {
        return level;
    }

    public String getHeldItem() {
        return heldItem;
    }

    public void setHeldItem(String item) {
        this.heldItem = item;
    }

    public void setTypes(String type2) {
        this.types[1] = type2;
    }

    @Override
    public String toString() {
        return name + " (Level " + level + ") - Types: " + types[0] + (types[1] != null ? ", " + types[1] : "") + " - Item: " + heldItem;
    }
}

// Subclass to demonstrate polymorphism
class SpecialPokemon extends Pokemon {
    private String specialAbility;

    public SpecialPokemon(String name, String type1, int level, String heldItem, String specialAbility) {
        super(name, type1, level, heldItem);
        this.specialAbility = specialAbility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    @Override
    public String toString() {
        // Overriding the toString method to include special ability for this subclass
        return super.toString() + " - Special Ability: " + specialAbility;
    }
}

class PokemonStorage {
    private List<List<Pokemon>> boxes;

    public PokemonStorage() {
        boxes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {  // 3 Boxes with a capacity of 2 Pokémon each
            boxes.add(new ArrayList<>());
        }
    }

    public List<List<Pokemon>> getBoxes() {
        return boxes;
    }

    public void displayBoxContents(int boxIndex) {
        List<Pokemon> box = boxes.get(boxIndex);
        if (box.isEmpty()) {
            System.out.println("No Pokémon in this box.");
        } else {
            for (int i = 0; i < box.size(); i++) {
                // Demonstrating polymorphism when displaying Pokémon info
                System.out.println((i + 1) + ". " + box.get(i));  // Calls the appropriate toString() method
            }
        }
    }
}

public class PokemonPCSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static PokemonStorage pcStorage = new PokemonStorage();
    private static List<Pokemon> party = new ArrayList<>();
    private static final Set<String> VALID_TYPES = new HashSet<>(Arrays.asList(
        "bug", "dragon", "dark", "electric", "fairy", "fighting", "fire", "flying",
        "ghost", "grass", "ground", "ice", "normal", "poison", "psychic", "rock", "steel", "water"
    ));

    public static void main(String[] args) {
        welcomeMessage();
        initializeParty();

        while (true) {
            displayMenu();
            int choice = getValidInput(1, 6);  // Adjusted range for Exit option

            switch (choice) {
                case 1:
                    viewStorage();
                    break;
                case 2:
                    depositPokemon();
                    break;
                case 3:
                    withdrawPokemon();
                    break;
                case 4:
                    depositItem();
                    break;
                case 5:
                    withdrawItem();
                    break;
                case 6:
                    exitPC();  // Exit option added
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void welcomeMessage() {
        System.out.println("WELCOME DEAR TRAINER!");
    }

    private static void initializeParty() {
        System.out.println("How many Pokémon are in your party? (1-6)");
        int partySize = getValidInput(1, 6);
        for (int i = 0; i < partySize; i++) {
            System.out.println("Enter details for Pokémon " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            String type1 = getValidType("Type 1: ");
            String type2 = null;

            while (true) {
                System.out.print("Is there a secondary type? (y/n): ");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("y")) {
                    type2 = getValidType("Type 2: ");
                    break;
                } else if (response.equals("n")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }

            System.out.print("Level (1-100): ");
            int level = getValidInput(1, 100);

            String item = "";
            while (true) {
                System.out.print("Is the Pokémon holding an item? (y/n): ");
                String holdingItem = scanner.nextLine().toLowerCase();
                if (holdingItem.equals("y")) {
                    while (true) {
                        System.out.print("Held Item: ");
                        item = scanner.nextLine().trim();
                        if (item.matches("[a-zA-Z]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input. The held item should be a word without numbers. Please try again.");
                        }
                    }
                    break;
                } else if (holdingItem.equals("n")) {
                    item = "None";
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }

            // Demonstrating polymorphism
            System.out.print("Is this a special Pokémon? (y/n): ");
            String special = scanner.nextLine().toLowerCase();

            if (special.equals("y")) {
                System.out.print("Enter special ability: ");
                String specialAbility = scanner.nextLine();
                Pokemon pokemon = new SpecialPokemon(name, type1, level, item, specialAbility);
                party.add(pokemon);
            } else {
                Pokemon pokemon = new Pokemon(name, type1, level, item) {};
                if (type2 != null) {
                    pokemon.setTypes(type2);
                }
                party.add(pokemon);
            }
        }
    }

    private static String getValidType(String prompt) {
        String type;
        while (true) {
            System.out.print(prompt);
            type = scanner.nextLine().toLowerCase();
            if (VALID_TYPES.contains(type)) {
                return type;
            } else {
                System.out.println("Invalid type. Please enter a valid Pokémon type.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Pokémon Storage PC ---");
        System.out.println("1. View Pokémon Storage");
        System.out.println("2. Deposit Pokémon");
        System.out.println("3. Withdraw Pokémon");
        System.out.println("4. Deposit Item");
        System.out.println("5. Withdraw Item");
        System.out.println("6. Exit PC");  // Exit option added
        System.out.print("Choose an option: ");
    }

    private static void viewStorage() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Box " + (i + 1) + ":");
            pcStorage.displayBoxContents(i);
        }
    }

    private static void depositPokemon() {
        if (party.size() < 2) {
            System.out.println("You need at least 2 Pokémon in your party to deposit.");
            return;
        }

        while (true) {  // Allow the user to reselect the Pokémon to deposit
            System.out.println("Select a Pokémon to deposit:");
            for (int i = 0; i < party.size(); i++) {
                System.out.println((i + 1) + ". " + party.get(i));
            }
            System.out.println("0. Go Back");

            int choice = getValidInput(0, party.size()) - 1;
            if (choice == -1) {  // User selected "Go Back"
                System.out.println("Returning to the main menu...");
                return;
            }

            Pokemon pokemon = party.get(choice);

            while (true) {  // Allow the user to reselect the box
                System.out.print("Which box would you like to deposit the Pokémon into? (1-3): ");
                int boxChoice = getValidInput(1, 3) - 1;

                System.out.println("Pokémon in Box " + (boxChoice + 1) + ":");
                pcStorage.displayBoxContents(boxChoice);

                if (pcStorage.getBoxes().get(boxChoice).size() < 2) { // Limit each box to 2 Pokémon
                    pcStorage.getBoxes().get(boxChoice).add(pokemon);
                    party.remove(choice);
                    System.out.println(pokemon.getName() + " has been deposited into Box " + (boxChoice + 1) + ".");
                    return;
                } else {
                    System.out.println("This box is full. Please choose another box or go back.");
                }
            }
        }
    }

    private static void withdrawPokemon() {
        if (party.size() >= 6) {
            System.out.println("Your party is full! Cannot withdraw.");
            return;
        }

        while (true) {  // Allow the user to reselect the box
            System.out.print("Which box would you like to withdraw from? (1-3, or 0 to go back): ");
            int boxChoice = getValidInput(0, 3) - 1;

            if (boxChoice == -1) { // User chose 0 to go back
                System.out.println("Returning to the main menu...");
                return;
            }

            List<Pokemon> selectedBox = pcStorage.getBoxes().get(boxChoice);
            if (selectedBox.isEmpty()) {
                System.out.println("This box is empty. Please choose another box or go back.");
                continue;
            }

            System.out.println("Select a Pokémon to withdraw:");
            for (int i = 0; i < selectedBox.size(); i++) {
                System.out.println((i + 1) + ". " + selectedBox.get(i));
            }
            System.out.println("0. Go Back");

            int choice = getValidInput(0, selectedBox.size()) - 1;
            if (choice == -1) { // User chose to go back
                System.out.println("Returning to box selection...");
                continue;
            }

            Pokemon pokemon = selectedBox.get(choice);
            party.add(pokemon);
            selectedBox.remove(pokemon);  // Remove Pokémon from box
            System.out.println(pokemon.getName() + " has been withdrawn into your party.");
            return;
        }
    }

    private static void depositItem() {
        System.out.println("Select an item to deposit into a Pokémon's held item slot:");
        for (int i = 0; i < party.size(); i++) {
            Pokemon pokemon = party.get(i);
            if (!pokemon.getHeldItem().equals("None")) {
                System.out.println((i + 1) + ". " + pokemon.getName() + " - Item: " + pokemon.getHeldItem());
            }
        }
        System.out.println("0. Go Back");

        int choice = getValidInput(0, party.size()) - 1;
        if (choice == -1) {
            System.out.println("Returning to the main menu...");
            return;
        }

        Pokemon selectedPokemon = party.get(choice);
        System.out.println("Choose a Pokémon from the box to receive this item:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Box " + (i + 1) + ":");
            pcStorage.displayBoxContents(i);
        }

        System.out.print("Which box would you like to deposit the item into? ");
        int boxChoice = getValidInput(1, 3) - 1;

        List<Pokemon> selectedBox = pcStorage.getBoxes().get(boxChoice);
        if (selectedBox.isEmpty()) {
            System.out.println("No Pokémon in this box.");
        } else {
            System.out.println("Choose a Pokémon to assign this item to:");
            for (int i = 0; i < selectedBox.size(); i++) {
                System.out.println((i + 1) + ". " + selectedBox.get(i));
            }
            int pokemonChoice = getValidInput(1, selectedBox.size()) - 1;
            Pokemon pokemonInBox = selectedBox.get(pokemonChoice);

            // Swap items between the selected Pokémon in the party and the selected Pokémon in the box
            String tempItem = pokemonInBox.getHeldItem();
            pokemonInBox.setHeldItem(selectedPokemon.getHeldItem());
            selectedPokemon.setHeldItem(tempItem);

            System.out.println("Items have been swapped.");
            System.out.println(pokemonInBox.getName() + " is now holding " + pokemonInBox.getHeldItem() + ".");
            System.out.println(selectedPokemon.getName() + " is now holding " + selectedPokemon.getHeldItem() + ".");
        }
    }

    private static void withdrawItem() {
        System.out.println("Select an item to withdraw from a Pokémon:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Box " + (i + 1) + ":");
            pcStorage.displayBoxContents(i);
        }

        System.out.print("Which box would you like to withdraw the item from? ");
        int boxChoice = getValidInput(1, 3) - 1;

        List<Pokemon> selectedBox = pcStorage.getBoxes().get(boxChoice);
        if (selectedBox.isEmpty()) {
            System.out.println("No Pokémon in this box.");
            return;
        }

        System.out.println("Select a Pokémon to withdraw the item from:");
        for (int i = 0; i < selectedBox.size(); i++) {
            System.out.println((i + 1) + ". " + selectedBox.get(i));
        }
        int pokemonChoice = getValidInput(1, selectedBox.size()) - 1;
        Pokemon pokemon = selectedBox.get(pokemonChoice);
        String item = pokemon.getHeldItem();

        if (item.equals("None")) {
            System.out.println("This Pokémon is not holding any item.");
            return;
        }

        System.out.println("Item: " + item + " has been withdrawn.");
        pokemon.setHeldItem("None");

        System.out.println("Where do you want to place this item?");
        System.out.println("1. Assign it to a Pokémon in your party.");
        System.out.println("2. Discard it.");
        int action = getValidInput(1, 2);
        if (action == 1) {
            // Assign item to a Pokémon in the party
            System.out.println("Here is your current party:");
            for (int i = 0; i < party.size(); i++) {
                System.out.println((i + 1) + ". " + party.get(i));
            }
            System.out.print("Choose a Pokémon to assign the item to (or 0 to go back): ");
            int partyChoice = getValidInput(0, party.size()) - 1;

            if (partyChoice == -1) {
                System.out.println("Returning to the main menu...");
                return;
            }

            Pokemon chosenPokemon = party.get(partyChoice);

            // Swap items between the party Pokémon and the withdrawn Pokémon
            String tempItem = chosenPokemon.getHeldItem();
            chosenPokemon.setHeldItem(item);
            pokemon.setHeldItem(tempItem);

            // Print the swap result
            System.out.println("Items have been swapped.");
            System.out.println(chosenPokemon.getName() + " is now holding " + chosenPokemon.getHeldItem() + ".");
            System.out.println(pokemon.getName() + " is now holding " + pokemon.getHeldItem() + ".");
        } else if (action == 2) {
            System.out.println("Item has been discarded.");
        }
    }

    private static void exitPC() {
        System.out.println("Thank you for using the Pokémon PC! Have a great adventure, Trainer!");
        return;  // Simply exit the program now
    }

    private static int getValidInput(int min, int max) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max);
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
