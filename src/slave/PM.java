package slave;

import building.Room;

import java.io.FileNotFoundException;

public class PM extends Human {
    static final int MIN_SALARY_PM = 150;
    static final int MAX_SALARY_PM = 400;
    final int amountIteration = 8;
    int countIteration = 1;
    int costIteration;

    public PM() throws FileNotFoundException {
        super(MIN_SALARY_PM, MAX_SALARY_PM);
    }

    public boolean isEnoughMoney(int money, Room room) {
        boolean result = false;
        while (countIteration <= amountIteration && money > 0) {
            costIteration = room.getDevOne().getSalary() +
                    room.getDevTwo().getSalary() +
                    room.getQaOne().getSalary() +
                    room.getPmOne().getSalary();
            money = money - costIteration;
            countIteration++;
        }
        if (money > 0) {
            result = true;
            System.out.println("-------------");
            System.out.print("PM: Денег достаточно для выполнения проекта. " +
                    "Стоимость проекта: " + (costIteration * amountIteration) +
                    "\n Прибыль компании = " + money);
        } else {
            System.out.println("-------------");
            System.out.println("PM: Денег недостаточно для выполнения проекта. " +
                    " Стоимость проекта: " + (costIteration * amountIteration));
            System.out.println("Команда готова провести итераций: " + (countIteration - 1));
            result = false;
        }


        return result;
    }


}
