package entity;

import java.util.HashMap;

public enum Command {
    CREATE_PARKING_LOT("CREATE_PARKING_LOT","Creates a new parking lot." ,"CREATE_PARKING_LOT <name_of_parking_lot> <number_of_floor> <number_of_slots>"),
    DISPLAY("DISPLAY","Displays the parking lot details based on the chosen display type." ,"DISPLAY <display_type> <vehicle_type>"),
    PARK_VEHICLE("PARK_VEHICLE","Parks a vehicle in the parking lot." ,"PARK_VEHICLE <vehicle_registration_number> <vehicle_color>"),
    UNPARK_VEHICLE("UNPARK_VEHICLE","Unparks a vehicle from the parking lot." ,"UNPARK_VEHICLE <ticket_id>"),
    EXIT("EXIT","Exits the program." ,"EXIT"),
    HELP("HELP","Displays the list of available commands with descriptions.","HELP or help");

    private final String command;
    private final String description;
    private final String syntax;


    Command(String s,String description ,String syntax){
        this.command = s;
        this.description = description;
        this.syntax = syntax;
    }

    @Override
    public String toString() {
        return this.command;
    }
    public String getDescription() {
        return this.description;
    }
    public String getSyntax() {
        return this.syntax;
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
}
