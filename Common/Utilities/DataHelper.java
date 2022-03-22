package Utilities;
import Enum.*;

import java.util.Random;

public class DataHelper {

    public static Province getArriveAt(Province departFrom) {
        Province[] arr;
        switch (departFrom) {
            case DA_NANG:
                arr = new Province[]{Province.SAI_GON, Province.NHA_TRANG, Province.HUE, Province.QUANG_NGAI};
                break;
            case HUE:
                arr = new Province[]{Province.SAI_GON, Province.NHA_TRANG, Province.DA_NANG, Province.QUANG_NGAI};
                break;
            default:
                arr = new Province[]{Province.PHAN_THIET, Province.NHA_TRANG, Province.HUE, Province.QUANG_NGAI, Province.DA_NANG};
                break;
        }
        return arr[new Random().nextInt(arr.length)];
    }
}