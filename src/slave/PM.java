package slave;

import building.Room;
import product.Code;
import product.Project;

import java.io.FileNotFoundException;

public class PM extends Human {
    protected static final int MIN_SALARY_PM = 150;
    protected static final int MAX_SALARY_PM = 400;
    private final int amountIteration = 8;
    private int madeIterate;


    public PM() throws FileNotFoundException {
        super(MIN_SALARY_PM, MAX_SALARY_PM);
    }

    public int countCostProject(Room room) {
        int costProject = (room.getDevOne().getSalary() + room.getQaOne().getSalary() + room.getPmOne().getSalary()) * amountIteration;
        costProject = (int) (costProject * 2);
        System.out.println("Cost of project = $" + costProject);
        System.out.println("-------------");
        return costProject;
    }


    private Code createTaskDev(Developer developer) {
        Code code = developer.generateCode();
        return code;

    }

    private boolean createTaskQAReview(QA qa, Code code, Project project) {
        boolean result = qa.reviewCode(qa, code, project);
        return result;
    }

    private int createTaskQAAverageQualityCode(QA qa, Project project) {

        int i = qa.averageQualityCode(project);
        return i;
    }

    private boolean runIteration(Project project, Room room) {
        boolean result = false;
        ++madeIterate;
        System.out.println("Iterate #" + madeIterate);

        Code code = createTaskDev(room.getDevOne());
        giveSalaryDev(room.getDevOne(), project);
        boolean review = createTaskQAReview(room.getQaOne(), code, project);
        giveSalaryQA(room.getQaOne(), project);
        while (!review) {
            code = createTaskDev(room.getDevOne());
            review = createTaskQAReview(room.getQaOne(), code, project);
            giveSalaryQA(room.getQaOne(), project);
        }
        project.getCodeList().put(madeIterate, code);

        System.out.println("Temporary data about profit: $" + project.getCompanyProfit());
        return result;
    }

    public Project makeProject(Room room) {
        Project project = new Project();
        project.setCostProject(countCostProject(room));
        for (int i = 0; i < amountIteration; i++) {
            runIteration(project, room);
        }
        giveSalaryPM(room.getPmOne(), project);
        System.out.println("-------------");
        System.out.println("Project is done.");
        System.out.println("Average quality of the code: " + createTaskQAAverageQualityCode(room.getQaOne(), project));
        System.out.println("Company profit: $" + project.getCompanyProfit());

        return project;
    }

    public void giveSalaryQA(QA qa, Project project) {
        project.setCompanyProfit(project.getCompanyProfit() - qa.getSalary());
    }

    public void giveSalaryDev(Developer developer, Project project) {
        project.setCompanyProfit(project.getCompanyProfit() - developer.getSalary());
    }

    public void giveSalaryPM(PM pm, Project project) {
        project.setCompanyProfit(project.getCompanyProfit() - pm.getSalary());
    }


}
