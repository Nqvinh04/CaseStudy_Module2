package ProductModel;

import java.util.Comparator;

public class SortProductByCreatAmount implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        if (product1.getCreatAmount() < product2.getCreatAmount()){
            return -1;
        } else if (product1.getCreatAmount() == product2.getCreatAmount()){
            return 0;
        } else {
            return 1;
        }
    }
}
