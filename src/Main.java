import building.Room;
import slave.HR;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Ekaterina on 16.09.2016.
 */
public class Main {

    private Room room;

    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        main.init();
    }


    public void init() throws FileNotFoundException {
        room = new Room();
        int inputMoney = 0;
        System.out.println("Input a sum for project:");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            inputMoney = sc.nextInt();
        }


        HR.buildTeam(room);

        room.getPmOne().isEnoughMoney(inputMoney, room);

//        QA qa = new QA("Дмитрий", 5, 80);
//
//
//
//        room.makeProcess(inputMoney);

    }
}
