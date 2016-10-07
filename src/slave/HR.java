package slave;

import building.Room;

import java.io.FileNotFoundException;

public class HR {


    static public Room buildTeam(Room room) throws FileNotFoundException {
        System.out.println("HR набирает команду...");
        if (room.getDevOne() == null) {
            room.setDevOne(new Developer());
            System.out.println("HR заполнил позицию Dev #1.");
        }
        if (room.getDevTwo() == null) {
            room.setDevTwo(new Developer());
            System.out.println("HR заполнил позицию Dev #2.");
        }
        if (room.getQaOne() == null) {
            room.setQaOne(new QA());
            System.out.println("HR заполнил позицию QA #1.");
        }
        if (room.getPmOne() == null) {
            room.setPmOne(new PM());
            System.out.println("HR заполнил позицию PM #1.");
        }

        System.out.println("-------------");

        if (room.getDevOne() != null && room.getDevTwo() != null && room.getQaOne() != null && room.getPmOne() != null) {
            System.out.println("Команда готова к работе. Состав команды:");
            System.out.println("Dev #1: name = " + room.getDevOne().getName() + ", salary = " + room.getDevOne().getSalary() + ".");
            System.out.println("Dev #2: name = " + room.getDevTwo().getName() + ", salary = " + room.getDevTwo().getSalary() + ".");
            System.out.println("QA #1: name = " + room.getQaOne().getName() + ", salary = " + room.getQaOne().getSalary() + ".");
            System.out.println("PM #1: name = " + room.getPmOne().getName() + ", salary = " + room.getPmOne().getSalary() + ".");
        } else {
            System.out.println("HR: Команда не собрана. Что-то пошло не так!!!");
            System.out.println(room);
        }
        return room;
    }

}
