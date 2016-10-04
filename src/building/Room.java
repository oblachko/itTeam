package building;

import product.Code;
import slave.Developer;
import slave.QA;

public class Room {


    private Developer devOne;
    private Developer devTwo;
    private QA qaOne;


    public void checkTheRoom(){
        if(devOne == null){
            System.out.println("Первого нет");
        } else {
            System.out.println("Первый есть");
        }

        if(devTwo == null){
            System.out.println("Второго нет");
        }
        else {
            System.out.println("Второй есть");
        }
    }

    public void makeProcess(int money){
        System.out.println("Money: " + money);

        if(devOne == null && devTwo == null){
            System.out.println("Работать некому");
            return;
        }

        if(qaOne == null){
            System.out.println("Проверять некому");
            return;
        }

        Code code = devOne.generateCode(120);

        if(code == null){
            System.out.println("Мало денег");
            return;
        }

        if(qaOne.reviewCode(code, 200)){
            System.out.println("Проверка пройдена");
        } else {
            System.out.println("Что-то пошло не так");
        }

    }


    public void setDevOne(Developer devOne) {
        this.devOne = devOne;
    }

    public void setDevTwo(Developer devTwo) {
        this.devTwo = devTwo;
    }

    public void setQaOne(QA qaOne) {
        this.qaOne = qaOne;
    }
}


