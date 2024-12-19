import java.sql.*;
import java.util.*;

abstract class Pokemon {
    private String name;
    private String[] types = new String[2];
    private int level;
    private String heldItem;

    public Pokemon(String name, String type1, int level, String heldItem) {
        this.name = name;
        this.types[0] = type1;
        this.level = level;
        this.heldItem = heldItem;
    }

    public Pokemon(String name, String type1, String type2, int level, String heldItem) {
        this(name, type1, level, heldItem);
        this.types[1] = type2;
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

class PokemonStorage {
    public static void savePokemon(Pokemon pokemon, int boxId) {
        String sql = "INSERT INTO pokemons (name, type1, type2, level, held_item, box_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pokemon.getName());
            pstmt.setString(2, pokemon.getTypes()[0]);
            pstmt.setString(3, pokemon.getTypes()[1]);
            pstmt.setInt(4, pokemon.getLevel());
            pstmt.setString(5, pokemon.getHeldItem());
            pstmt.setInt(6, boxId);

            pstmt.executeUpdate();
            System.out.println(pokemon.getName() + " saved to Box " + boxId);
        } catch (SQLException e) {
            System.err.println("Error saving Pokémon: " + e.getMessage());
        }
    }

    public static List<Pokemon> loadPokemon(int boxId) {
        List<Pokemon> pokemons = new ArrayList<>();
        String sql = "SELECT * FROM pokemons WHERE box_id = ?";

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, boxId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String type1 = rs.getString("type1");
                String type2 = rs.getString("type2");
                int level = rs.getInt("level");
                String heldItem = rs.getString("held_item");

                Pokemon pokemon = type2 == null
                        ? new Pokemon(name, type1, level, heldItem) {}
                        : new Pokemon(name, type1, type2, level, heldItem) {};

                pokemons.add(pokemon);
            }
        } catch (SQLException e) {
            System.err.println("Error loading Pokémon: " + e.getMessage());
        }

        return pokemons;
    }
}

public class PokemonPCSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Set<String> VALID_TYPES = new HashSet<>(Arrays.asList(
        "bug", "dragon", "dark", "electric", "fairy", "fighting", "fire", "flying",
        "ghost", "grass", "ground", "ice", "normal", "poison", "psychic", "rock", "steel", "water"
    ));

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getValidInput(1, 3);

            switch (choice) {
                case 1:
                    viewStorage();
                    break;
                case 2:
                    depositPokemon();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Pokémon Storage PC ---");
        System.out.println("1. View Pokémon Storage");
        System.out.println("2. Deposit Pokémon");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static void viewStorage() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Box " + i + ":");
            List<Pokemon> boxContents = PokemonStorage.loadPokemon(i);
            if (boxContents.isEmpty()) {
                System.out.println("  No Pokémon in this box.");
            } else {
                for (Pokemon pokemon : boxContents) {
                    System.out.println("  - " + pokemon);
                }
            }
        }
    }

    private static void depositPokemon() {
        System.out.print("Enter Pokémon Name: ");
        String name = scanner.nextLine();

        String type1 = getValidType("Type 1: ");

        System.out.print("Does this Pokémon have a second type? (y/n): ");
        String type2 = null;
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            type2 = getValidType("Type 2: ");
        }

        System.out.print("Level (1-100): ");
        int level = getValidInput(1, 100);

        System.out.print("Held Item: ");
        String heldItem = scanner.nextLine();

        Pokemon pokemon = type2 == null
                ? new Pokemon(name, type1, level, heldItem) {}
                : new Pokemon(name, type1, type2, level, heldItem) {};

        System.out.print("Which box to deposit into? (1-3): ");
        int boxId = getValidInput(1, 3);
        PokemonStorage.savePokemon(pokemon, boxId);
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

class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/pokemon_pc";
    private static final String USER = "root";
    private static final String PASSWORD = "pagdudu";  

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
