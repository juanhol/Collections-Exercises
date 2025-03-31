package Exercise4.Interfaces;

import Exeptions.NotFoundException;
import Exercise4.Model.Product;

public interface Catalogable {
    boolean addProduct(Product product);
    double getPrice(String name)throws NotFoundException;
    boolean updatePrice(String name,double price) throws NotFoundException;
    boolean softDelete(Product product)throws NotFoundException;
    void listAllAlphabetically();
}
