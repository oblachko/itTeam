package slave;

import building.Room;

import java.io.FileNotFoundException;
import java.util.Random;

public class HR {


    static public Room buildTeam(Room room) throws FileNotFoundException {
        System.out.println("HR набирает команду...");
        while (room.getDevOne() == null) {
            Developer developer = new Developer();
            System.out.println("Пришел dev: name = " + developer.getName() + ", desirable salary = $" + developer.getSalary());
            int hrRequirementForDev = generateRandomAcceptedSalaryDeveloper();
            System.out.println("HR оценивает " + developer.getName() + " в $" + hrRequirementForDev);
            if (hrRequirementForDev >= developer.getSalary()) {
                developer.setSalary(hrRequirementForDev);
                room.setDevOne(developer);
                System.out.println("Dev " + developer.getName() + " принят на работу.");
            } else {
                System.out.println("Dev " + developer.getName() + " зажрался, ищем дальше...");
            }
        }

        while (room.getQaOne() == null) {
            QA qa = new QA();
            System.out.println("Пришел QA: name = " + qa.getName() + ", desirable salary = $" + qa.getSalary() + ", minimalAcceptedQuality = " + qa.getMinimalAcceptedQuality());
            int hrRequirementSalaryForQa = generateRandomAcceptedSalaryQA();
            int hrRequirementAcceptedQualityForQA = 4;
            System.out.println("HR оценивает " + qa.getName() + " в " + hrRequirementSalaryForQa + ", minimalAcceptedQuality >= $" + hrRequirementAcceptedQualityForQA);

            if (hrRequirementSalaryForQa >= qa.getSalary()) {
                if (hrRequirementAcceptedQualityForQA <= qa.getMinimalAcceptedQuality()) {
                    qa.setSalary(hrRequirementSalaryForQa);
                    room.setQaOne(qa);
                    System.out.println("QA " + qa.getName() + " принят на работу.");
                } else {
                    System.out.println("QA " + qa.getName() + " слабоват, ищем поумнее...");

                }
            } else {
                System.out.println("QA " + qa.getName() + " зажрался, ищем дальше...");
            }
        }

        while (room.getPmOne() == null) {
            PM pm = new PM();
            System.out.println("Пришел PM: name = " + pm.getName() + ", desirable salary = $" + pm.getSalary());
            int hrRequirementSalaryForPM = generateRandomAcceptedSalaryPM();
            System.out.println("HR оценивает " + pm.getName() + " в $" + hrRequirementSalaryForPM);

            if (hrRequirementSalaryForPM >= pm.getSalary()) {
                pm.setSalary(hrRequirementSalaryForPM);
                room.setPmOne(pm);
                System.out.println("PM " + pm.getName() + " принят на работу.");
            } else {
                System.out.println("PM " + pm.getName() + " зажрался, ищем дальше...");
            }
        }

        System.out.println("-------------");

        if (room.getDevOne() != null && room.getQaOne() != null && room.getPmOne() != null) {
            System.out.println("Команда готова к работе. Состав команды:");
            System.out.println("Dev #1: name = " + room.getDevOne().getName() + ", salary = $" + room.getDevOne().getSalary() + ".");
            System.out.println("QA #1: name = " + room.getQaOne().getName() + ", salary = $" + room.getQaOne().getSalary() + ", minimalAcceptedQuality = " + room.getQaOne().getMinimalAcceptedQuality() + ".");
            System.out.println("PM #1: name = " + room.getPmOne().getName() + ", salary = $" + room.getPmOne().getSalary() + ".");
        } else {
            System.out.println("HR: Команда не собрана. Что-то пошло не так!!!");
            System.out.println(room);
        }
        return room;
    }

    public static int generateRandomAcceptedSalaryDeveloper() {
        int i = new Random().nextInt(Developer.MAX_SALARY_DEV - Developer.MIN_SALARY_DEV) + Developer.MIN_SALARY_DEV;

        return i;
    }

    public static int generateRandomAcceptedSalaryPM() {
        int i = new Random().nextInt(PM.MAX_SALARY_PM - PM.MIN_SALARY_PM) + PM.MIN_SALARY_PM;

        return i;
    }

    public static int generateRandomAcceptedSalaryQA() {
        int i = new Random().nextInt(QA.MAX_SALARY_QA - QA.MIN_SALARY_QA) + QA.MIN_SALARY_QA;

        return i;
    }

}
