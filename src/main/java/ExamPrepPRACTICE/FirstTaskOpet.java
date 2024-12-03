//package ExamPrepPRACTICE;
//
//import java.util.*;
//
//enum HoneyType {
//    BAGREMOV,
//    LIVADSKI
//}
//
//interface Sellable {
//    double calculateDiscount(double discountRate);
//    String getDescription();
//}
//
//class Item implements Sellable {
//    private String barcode;
//    private String name;
//    private double price;
//
//    public Item(String barcode, String name, double price) {
//        this.barcode = barcode;
//        this.name = name;
//        this.price = price;
//    }
//
//    public String getBarCode() {
//        return this.barcode;
//    }
//    public void setBarCode(String barcode) {
//        this.barcode = barcode;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return this.price;
//    }
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public double calculateDiscount(double discountRate) {
//        return this.price - (this.price * discountRate);
//    }
//
//    public String getDescription() {
//        return this.barcode + this.name + this.price;
//    }
//}
//
//class Milk extends Item {
//    private double fat;
//
//    public Milk(String barcode, String name, double price, double fat) {
//        super(barcode,name,price);
//        this.fat = fat;
//    }
//
//    public double getFat() {
//        return this.fat;
//    }
//    public void setFat(double fat) {
//        this.fat = fat;
//    }
//
//    @Override
//    public String getDescription() {
//        return super.getDescription() + this.fat;
//    }
//}
//
//class Honey extends Item {
//    private HoneyType honeyType;
//
//    public Honey(String barcode, String name, double price, HoneyType honeyType) {
//        super(barcode,name,price);
//        this.honeyType = honeyType;
//    }
//
//    public HoneyType getHoneyType() {
//        return this.honeyType;
//    }
//    public void setHoneyType(HoneyType honeyType) {
//        this.honeyType = honeyType;
//    }
//
//    @Override
//    public String getDescription() {
//        return super.getDescription() + this.honeyType;
//    }
//}
//
//class Order<T extends Item> {
//    private String orderNo;
//    private Date createAt;
//    private HashMap items;
//
//    public Order(String orderNo, Date createAt, HashMap items) {
//        this.orderNo = orderNo;
//        this.createAt = createAt;
//        this.items = new HashMap<T, Integer>();
//    }
//
//    public String getOrderNo() {
//        return this.orderNo;
//    }
//    public void setOrderNo(String orderNo) {
//        this.orderNo = orderNo;
//    }
//
//    public Date getCreateAt() {
//        return this.createAt;
//    }
//    public void setCreateAt(Date createAt) {
//        this.createAt = createAt;
//    }
//
//    public HashMap<T,Integer> getItems() {
//        return this.items;
//    }
//    public void setItems(HashMap<T,Integer> items) {
//        this.items = items;
//    }
//
//    public void addItem(T item, int quantity) {
//        boolean itemExists = false;
//
//        for (T existingItem : items.keySet()) {
//            if(existingItem.getBarCode().equals(item.getBarCode())) {
//                items.put(existingItem, this.items.get(existingItem) + quantity);
//                break;
//            }
//        }
//
//    }
//}