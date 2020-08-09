package ProductModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortProductByExp implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {

        Date dateProduct1 = null;
        Date dateProduct2 = null;
        try {
            dateProduct1 = new SimpleDateFormat("dd/MM/yyyy").parse(product1.getExp());
            dateProduct2 = new SimpleDateFormat("dd/MM/yyyy").parse(product2.getExp());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert dateProduct1 != null;
        return dateProduct1.compareTo(dateProduct2);
    }
}
