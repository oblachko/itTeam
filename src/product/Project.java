package product;

import java.util.HashMap;

public class Project {

    private HashMap<Integer, Code> codeList;

    private int costProject;

    private int companyProfit;

    public Project() {
        this.codeList = new HashMap<>();

    }

    public HashMap<Integer, Code> getCodeList() {
        return codeList;
    }

    public void setCodeList(HashMap<Integer, Code> codeList) {
        this.codeList = codeList;
    }

    public int getCostProject() {
        return costProject;
    }

    public void setCostProject(int costProject) {
        this.costProject = costProject;
        this.companyProfit = costProject;
    }

    public int getCompanyProfit() {
        return companyProfit;
    }

    public void setCompanyProfit(int companyProfit) {
        this.companyProfit = companyProfit;
    }

    public void showCodeByIteration(int number, Project project) {
        Code code = project.getCodeList().get(number);

        System.out.println("Sprint #" + number + ":");
        System.out.println(code);
    }
}
