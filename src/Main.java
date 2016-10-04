import building.Room;
import slave.Developer;
import slave.QA;

import java.util.Scanner;

/**
 * Created by Ekaterina on 16.09.2016.
 */
public class Main {

    private Room room;

    public static void main(String[] args) {
       Main main = new Main();
        main.init();
    }


    public void init(){
        room = new Room();


        Developer developer  = new Developer("Ваня", 100);
        QA qa = new QA("Дмитрий", 5, 80);

        room.setDevOne(developer);
        room.setQaOne(qa);
        System.out.println("Input the sum for project");
        Scanner sc = new Scanner(System.in);

        int inputMoney = 0;

        if (sc.hasNext()) {
            inputMoney = sc.nextInt();
        }

        room.makeProcess(inputMoney);

    }
}
