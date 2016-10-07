package building;

import product.Code;
import slave.Developer;
import slave.PM;
import slave.QA;

public class Room {


    private Developer devOne;
    private Developer devTwo;
    private QA qaOne;
    private PM pmOne;


    public void checkTheRoom() {
        if (devOne == null) {
            System.out.println("Первого нет");
        } else {
            System.out.println("Первый есть");
        }

        if (devTwo == null) {
            System.out.println("Второго нет");
        } else {
            System.out.println("Второй есть");
        }
    }

    public void makeProcess(int money) {
        System.out.println("Money: " + money);

        if (devOne == null && devTwo == null) {
            System.out.println("Работать некому");
            return;
        }

        if (qaOne == null) {
            System.out.println("Проверять некому");
            return;
        }

        Code code = devOne.generateCode(120);

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

    public PM getPmOne() {
        return pmOne;
    }

    public void setPmOne(PM pmOne) {
        this.pmOne = pmOne;
    }

    public Developer getDevOne() {
        return devOne;
    }

    public void setDevOne(Developer devOne) {
        this.devOne = devOne;
    }

    public Developer getDevTwo() {
        return devTwo;
    }

    public void setDevTwo(Developer devTwo) {
        this.devTwo = devTwo;
    }

    public QA getQaOne() {
        return qaOne;
    }

    public void setQaOne(QA qaOne) {
        this.qaOne = qaOne;
    }

    @Override
    public String toString() {
        return "Room{" +
                "devOne=" + devOne +
                ", devTwo=" + devTwo +
                ", qaOne=" + qaOne +
                '}';
    }
}


