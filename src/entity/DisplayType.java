package entity;

import java.util.HashMap;

public enum DisplayType {
    FREE_COUNT("free_count"),
    FREE_SLOTS("free_slots"),
    OCCUPIED_SLOTS("occupied_slots");

    private final String diaplay;
    DisplayType(String s){
        diaplay = s;
    }
    public String toStirng(){
        return this.diaplay;
    }

    private static final HashMap<String, DisplayType> map = new HashMap<>(values().length,1);

    static {
        for(DisplayType d : values()){
            map.put(d.toStirng(),d);
        }
    }


}
