package Exercise4.Repsitories;
import Exeptions.NotFoundException;
import Exercise4.Interfaces.Catalogable;
import Exercise4.Model.Product;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Inscriptions<T extends Product> implements Catalogable {
        private Set<T> productsList;

    public Inscriptions() {
        this.productsList=new TreeSet<>();
    }

    @Override
    public boolean addProduct(Product product) {
        return productsList.add((T)product);
    }

    @Override
    public double getPrice(String name) throws NotFoundException{
        T product=productsList.stream()
                .filter(t-> Objects.equals(t.getName(),name))
                .findFirst()
                .orElseThrow(()->new NotFoundException("Not on the list"));
        return product.getPrice();
    }

    @Override
    public boolean updatePrice(String name,double price) throws NotFoundException{
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name is null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price is negative.");
        }
        T listItem=productsList.stream()
                .filter(t->Objects.equals(t.getName(),name))
                .findFirst()
                .orElseThrow(()->new NotFoundException("Not on the list"));
        listItem.setPrice(price);
        return true;
    }

    @Override
    public boolean softDelete(Product product) throws NotFoundException{
        if (productsList.remove(product)) {
            return true;
        } else {
            throw new NotFoundException("Product not found on the list");
        }
    }

    @Override
    public void listAllAlphabetically() {
        System.out.println(productsList);
    }
}
