package transaction;

import java.util.Random;

public class ProductFactory {
    Random rando;

    public ProductFactory(){
        rando = new Random();
    }

    Product generateRandomProdcut(){
        Product output = new Product();
        switch( rando.nextInt(3) ){
            case 0:
                output.name = "hat";
                break;
            case 1:
                output.name = "banana";
                break;
            case 2:
                output.name = "flamethrower";
                break;
        }
        return output;
    }
}
