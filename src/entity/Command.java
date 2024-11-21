package entity;

import java.util.HashMap;

public enum Command {
    CREATE_PARKING_LOT("CREATE_PARKING_LOT"),
    DISPLAY("DISPLAY"),
    PARK_VEHICLE("PARK_VEHICLE"),
    UNPARK_VEHICLE("UNPARK_VEHICLE"),
    EXIT("EXIT"),
    HELP("HELP");

    private final String command;

    Command(String s) {
        command = s;
    }

    @Override
    public String toString() {
        return this.command;
    }

    private static final HashMap<String, Command> map = new HashMap<>(values().length, 1);

    static {
        for (Command c : values()) {
            map.put(c.command, c);
        }
    }

    public static Command of(String name) {
        return map.get(name);
    }

    // Get description and syntax for the commands
    public String getDescription() {
        switch (this) {
            case CREATE_PARKING_LOT:
                return "Creates a new parking lot.";
            case PARK_VEHICLE:
                return "Parks a vehicle in the parking lot.";
            case UNPARK_VEHICLE:
                return "Unparks a vehicle from the parking lot.";
            case DISPLAY:
                return "Displays parking lot details based on display type.";
            case EXIT:
                return "Exits the program.";
            case HELP:
                return "Displays the list of available commands with descriptions.";
            default:
                return "Unknown command.";
        }
    }

    public String getSyntax() {
        switch (this) {
            case CREATE_PARKING_LOT:
                return "CREATE_PARKING_LOT <name_of_parking_lot> <number_of_floor> <number_of_slots>";
            case PARK_VEHICLE:
                return "PARK_VEHICLE <vehicle_type> <vehicle_registration_number> <vehicle_color>";
            case UNPARK_VEHICLE:
                return "UNPARK_VEHICLE <ticket_id>";
            case DISPLAY:
                return "DISPLAY <display_type> <vehicle_type>";
            case EXIT:
                return "EXIT";
            case HELP:
                return "HELP";
            default:
                return "Unknown syntax.";
        }
    }
}
