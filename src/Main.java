import building.Room;
import slave.Developer;
import slave.QA;

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

        room.makeProcess(1);

    }
}
