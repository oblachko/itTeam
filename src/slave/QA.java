package slave;

import product.Code;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public class QA extends Human {

    static final int MIN_SALARY_QA = 100;
    static final int MAX_SALARY_QA = 300;
    private int minimalAcceptedQuality;

    public QA() throws FileNotFoundException {
        super(MIN_SALARY_QA, MAX_SALARY_QA);
        setMinimalAcceptedQuality(new Random().nextInt(10));
    }

    public int getMinimalAcceptedQuality() {
        return minimalAcceptedQuality;
    }

    public void setMinimalAcceptedQuality(int minimalAcceptedQuality) {
        this.minimalAcceptedQuality = minimalAcceptedQuality;
    }

    public boolean reviewCode(Code code, int money) {

        if (money < getSalary()) {
            return false;
        }

        if (minimalAcceptedQuality >= code.getQuality()) {
            System.out.println("QA.Всё хуйня. Переделать");
        } else {
            System.out.println("QA.Сойдёт");
        }

        return true;
    }

    public float averageQualityCode(List<Code> codeList) {
        float average = 0f;

        return average;
    }
}
