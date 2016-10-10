package building;

import product.Code;
import slave.Developer;
import slave.PM;
import slave.QA;

public class Room {


    private Developer devOne;
    private QA qaOne;
    private PM pmOne;

    public Developer getDevOne() {
        return devOne;
    }

    public void setDevOne(Developer devOne) {
        this.devOne = devOne;
    }

    public QA getQaOne() {
        return qaOne;
    }

    public void setQaOne(QA qaOne) {
        this.qaOne = qaOne;
    }

    public PM getPmOne() {
        return pmOne;
    }

    public void setPmOne(PM pmOne) {
        this.pmOne = pmOne;
    }

    public void checkTheRoom() {
        if (devOne == null) {
            System.out.println("Первого нет");
        } else {
            System.out.println("Первый есть");
        }
    }

    public void makeProcess(int money) {
        System.out.println("Money: " + money);


        if (qaOne == null) {
            System.out.println("Проверять некому");
            return;
        }

        Code code = devOne.generateCode();

        if (code == null) {
            System.out.println("Мало денег");
            return;
        }

        if (qaOne.reviewCode(code, 200)) {
            System.out.println("Проверка пройдена");
        } else {
            System.out.println("Что-то пошло не так");
        }

    }


    @Override
    public String toString() {
        return "Room{" +
                "devOne=" + devOne +
//                ", devTwo=" + devTwo +
                ", qaOne=" + qaOne +
                '}';
    }
}


