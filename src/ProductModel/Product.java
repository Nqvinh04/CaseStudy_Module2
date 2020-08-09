package ProductModel;

import java.io.Serializable;

public class Product implements Serializable {
    private int id ;
    private String name;
    private String exp;
    private float price;
    private int amount;
    private int creatAmount;

    public Product(){
    };

    public Product(int id, String name, String exp, float price, int amount, int creatAmount){
        this.id = id;
        this.name = name;
        this.exp = exp;
        this. price = price;
        this.amount = amount;
        this.creatAmount = creatAmount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExp() {
        return exp;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCreatAmount() {
        return creatAmount;
    }

    public void setCreatAmount(int creatAmount) {
        this.creatAmount = creatAmount;
    }

    public float creatPrice(){
        return this.price * this.amount;
    }


    @Override
    public String toString() {
        return "Product: " +
                "Mã sản phẩm =" + id +
                ", Tên sẩn phẩm = '" + name + '\'' +
                ", Ngày sản xuất = '" + exp + '\'' +
                ", Giá = " + price +
                ", Số lượng (trong 1 thùng) = " + amount +
                ", Số thùng = " + creatAmount +
                '.';
    }
}
