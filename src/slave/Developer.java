package slave;

import product.Code;

import java.io.FileNotFoundException;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public class Developer extends Human {

    static final int MIN_SALARY_DEV = 200;
    static final int MAX_SALARY_DEV = 300;


    public Developer() throws FileNotFoundException {
        super(MIN_SALARY_DEV, MAX_SALARY_DEV);
    }

    public Code generateCode(int money) {
        Code code = null;


        if (money > getSalary()) {
            code = new Code();
            System.out.println("Дев.:Денег достаточно,код написан");
        } else {
            System.out.println("Дев.:Денег нет");
        }

        return code;
    }

}
