package Enum;

import java.util.Random;

public enum SeatType {
    HARD_SEAT ("Hard seat"),
    SOFT_SEAT ("Soft seat"),
    SOFT_SEAT_WITH_AIR_CONDITIONER ("Soft seat with air conditioner"),
    HARD_BED ("Hard bed"),
    SOFT_BED ("Soft bed"),
    SOFT_BED_WITH_AIR_CONDITIONER ("Soft bed with air conditioner");

    private String value;
    public String getValue (){
        return this.value;
    }
    SeatType (String value) {
        this.value = value;
    }
    public static SeatType random () {
        return SeatType.values()[new Random().nextInt(SeatType.values().length)];
    }
}