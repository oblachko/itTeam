import building.Room;
import product.Project;
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

//        System.out.println("Input a sum for project:");
//        Scanner sc = new Scanner(System.in);
//        if (sc.hasNext()) {
//            inputMoney = sc.nextInt();
//        }

        HR.buildTeam(room);
        Project project = room.getPmOne().makeProject(room);

        System.out.println("Для отображения данных по спринту, укажите его номер:");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int sprint = scanner.nextInt();
                if (sprint >= 1 && sprint <= project.getCodeList().size()) {
                    project.showCodeByIteration(sprint, project);
                } else {
                    System.out.println("Всего было " + project.getCodeList().size() + " спринтов. Повторите ввод:");
                }
            } else {
                System.out.println("Неправильный ввод! Вводить можно только цифры. Введите номер спринта заново:");
            }
        }


    }
}
