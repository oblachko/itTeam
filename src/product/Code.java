package product;

import java.util.Random;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public class Code {

    private int quality;
    private int[] historyQuality;

    public Code() {
        quality = new Random().nextInt(10);
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int[] getHistoryQuality() {
        return historyQuality;
    }

    public void setHistoryQuality(int[] historyQuality) {
        this.historyQuality = historyQuality;
    }

    @Override
    public String toString() {
        return "Code{" +
                "quality=" + quality +
                '}';
    }
}
