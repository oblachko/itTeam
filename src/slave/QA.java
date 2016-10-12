package slave;

import product.Code;
import product.Project;

import java.io.FileNotFoundException;
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

    protected boolean reviewCode(QA qa, Code code, Project project) {
        boolean result = false;
        if (code.getQuality() >= qa.getMinimalAcceptedQuality()) {
            System.out.println("QA: Сойдёт код.");
            result = true;
        } else {
            System.out.println("QA: Всё хуйня. Переделать!");
        }

        return result;
    }

    protected int averageQualityCode(Project project) {
        int result = 0;
        for (int i = 0; i < project.getCodeList().size(); i++) {
            result = result + project.getCodeList().get(i + 1).getQuality();

        }
        result = result / project.getCodeList().size();

        return result;
    }
}
