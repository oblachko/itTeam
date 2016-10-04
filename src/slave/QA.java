package slave;

import product.Code;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public class QA extends Human {

    private final int minimalAcceptedQuality;

    public QA(String name, int minimalAcceptedQuality, int minimalCost) {
        setName(name);
        setMinimalCost(minimalCost);
        this.minimalAcceptedQuality = minimalAcceptedQuality;
    }

    public boolean reviewCode(Code code, int money){

        if(money < getMinimalCost()){
            return false;
        }

        if(minimalAcceptedQuality >= code.getQuality()){
            System.out.println("QA.Всё хуйня. Переделать");
        } else {
            System.out.println("QA.Сойдёт");
        }

        return true;
    }
}
