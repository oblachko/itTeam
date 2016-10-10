package slave;

import building.Room;
import product.Code;
import product.Project;

import java.io.FileNotFoundException;

public class PM extends Human {
    static final int MIN_SALARY_PM = 150;
    static final int MAX_SALARY_PM = 400;
    final int amountIteration = 8;
    private int madeIterate;


    public PM() throws FileNotFoundException {
        super(MIN_SALARY_PM, MAX_SALARY_PM);
    }


    public int costProject(Room room) {
        int costProject = (room.getDevOne().getSalary() + room.getQaOne().getSalary() + room.getPmOne().getSalary()) * amountIteration;
        costProject = (int) (costProject * 1.5);
        System.out.println("Cost of project = $" + costProject);
        return costProject;
    }

    private int averageQualityCode(Project project) {
        int result = 0;
        int count = 0;
        for (Code code : project.getCodeList().keySet()) {
            result = result + code.getQuality();
            count++;
        }
        float v = (float) result / count;
        System.out.println("FLOAT: " + v);
        result = (Integer) result / count;
        return result;
    }


    public Code createTaskDev(Developer developer) {
        Code code = developer.generateCode();
        return code;

    }

    public boolean createTaskQA(QA qa, Code code) {
        boolean result = false;
        if (code.getQuality() >= qa.getMinimalAcceptedQuality()) {
            result = true;
        }
        return result;
    }

    public boolean runIteration(Project project, Room room) {
        boolean result = false;
        ++madeIterate;
        System.out.println("Iterate #" + madeIterate);
        Code code = createTaskDev(room.getDevOne());
        boolean review = createTaskQA(room.getQaOne(), code);
        while (!review) {
            code = createTaskDev(room.getDevOne());
            review = createTaskQA(room.getQaOne(), code);
        }
        project.getCodeList().put(code, madeIterate);


        return result;
    }

    public Project makeProject(Room room) {
        Project project = new Project();
        for (int i = 0; i < amountIteration; i++) {
            runIteration(project, room);
        }

        System.out.println("Project is done.");
        System.out.println("Average of quality code: " + averageQualityCode(project));

        return project;
    }


}
