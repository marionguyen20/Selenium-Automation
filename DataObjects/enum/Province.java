package DataObjects.enum;

public enum Province {
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    NHA_TRANG("Nha Trang"),
    PHAN_THIET("Phan Thiết"),
    QUANG_NGAI("Quảng Ngãi"),
    SAI_GON("Sài Gòn");

    private String location;
    public String getLocation(){
        return this.location;
    }
    Province(String location){
        this.location = location;
    }
    public static Province random () {
        return Province.values()[new Random().nextInt(Province.values().length)];
    }
}