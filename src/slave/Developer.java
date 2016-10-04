package slave;

import product.Code;

/**
 * Created by Ekaterina on 03.10.2016.
 */
public class Developer extends Human{


    public Developer(String name, int minimalCost) {
        setName(name);
        setMinimalCost(minimalCost);
    }

    public Code generateCode(int money){
        Code code = null;


        if(money > getMinimalCost()){
            code = new Code();
            System.out.println("Дев.:Денег достаточно,код написан");
        } else {
            System.out.println("Дев.:Денег нет");
        }

        return code;
    }
}
