package slave;

import product.Code;

import java.io.FileNotFoundException;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public class Developer extends Human {

    static final int MIN_SALARY_DEV = 400;
    static final int MAX_SALARY_DEV = 600;


    public Developer() throws FileNotFoundException {
        super(MIN_SALARY_DEV, MAX_SALARY_DEV);
    }

    public Code generateCode() {
        Code code = new Code();

        return code;
    }

}
