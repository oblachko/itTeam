package product;

import java.util.Random;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public class Code {

    private int quality;

    public Code() {
        quality = new Random().nextInt(10);
    }

    public int getQuality() {
        return quality;
    }
}
