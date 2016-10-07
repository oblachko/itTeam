package slave;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public abstract class Human {

    private String name;
    private int salary;


    public Human(int minSalary, int maxSalary) throws FileNotFoundException {
        this.name = generateRandomName();
        this.salary = generateRandomSalary(minSalary, maxSalary);
    }

    public static String generateRandomName() throws FileNotFoundException {
        String randomName = null;
        int amountNames = 0;
        int randomNumber;
        final String FILENAME = "resources/PopularNames";

        List<String> names = new ArrayList<>();
        File file = new File(FILENAME);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    names.add(s);
                    amountNames = names.size() - 1;
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        randomNumber = new Random().nextInt(amountNames);
        randomName = names.get(randomNumber);
        return randomName;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getSalary() {
        return salary;
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

    public int generateRandomSalary(int minSalary, int maxSalary) {
        int randomSalary = new Random().nextInt(maxSalary - minSalary) + minSalary;
        return randomSalary;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
