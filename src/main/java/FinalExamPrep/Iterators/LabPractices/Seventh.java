package FinalExamPrep.Iterators.LabPractices;

import java.util.*;

class Product {
    String name;
    String category;
    double price;
    double rating;
    boolean isAvailable;

    public Product(String name, String category, double price, double rating, boolean isAvailable) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return this.name;
    }
    public String getCategory() {
        return this.category;
    }
    public double getPrice() {
        return this.price;
    }
    public double getRating() {
        return this.rating;
    }
    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Category: " + this.category + ", Price: " + this.price + ", Rating: " + this.rating + ", Is it available?: " + this.isAvailable;
    }
}

class DynamicProductIterator implements Iterator<Product> {
    List<Product> products;
    Map<String,Object> criteria;
    int currentIndex = 0;

    public DynamicProductIterator(List<Product> products, Map<String,Object> criteria) {
        this.products = products;
        this.criteria = criteria;
    }

    boolean matchesCriteria(Product product) {
        if(criteria.containsKey("category") && !product.getCategory().equals(criteria.get("category"))) {
            return false;
        }
        if(criteria.containsKey("price") && product.getPrice() < (double)criteria.get("price")) {
            return false;
        }
        if(criteria.containsKey("rating") && product.getRating() < (double)criteria.get("rating")) {
            return false;
        }
        if(criteria.containsKey("isAvailable") && product.getIsAvailable() != (boolean)criteria.get("isAvailable")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < products.size()) {
            Product product = products.get(currentIndex);
            if(matchesCriteria(product)) {
                return true;
            } currentIndex++;
        } return false;

    }

    @Override
    public Product next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        } return products.get(currentIndex++);
    }

}

class Main001 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1000.0, 4.8, true));
        products.add(new Product("Shirt", "Clothing", 25.0, 4.2, true));
        products.add(new Product("Blender", "Home", 150.0, 4.6, false));
        products.add(new Product("Smartphone", "Electronics", 800.0, 4.5, true));
        products.add(new Product("Table", "Furniture", 200.0, 4.0, true));

        Map<String,Object> criteria = new HashMap<>();
        criteria.put("category","Electronics");
        criteria.put("price",900.0);
        criteria.put("rating",4.5);
        criteria.put("isAvailable",true);

        DynamicProductIterator iterator = new DynamicProductIterator(products,criteria);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}