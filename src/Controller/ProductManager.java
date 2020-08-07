package Controller;

import ProductModel.Product;
import ProductStorage.ProductStorage;
import javafx.scene.chart.ScatterChart;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    public static Scanner scanner = new Scanner(System.in);
//    private Product product = null;
    private final ProductStorage productStorage;
    private ArrayList<Product> productArrayList;



    public ProductManager(){
        productStorage = new ProductStorage();
        productArrayList = productStorage.read();
    }

    public void addProduct(){
        int id = (productArrayList.size() > 0) ? (productArrayList.size() + 1) : 1;
        System.out.println("Mã Sản Phẩm: " + id);
        String name = inputName(); // PT thêm tên sản phẩm
        String exp = inputExp(); // Thêm ngày tháng sản xuất
        float price = inputPrice(); // Thêm giá sản phẩm
        int amount = inputAmount(); // Thêm số lượng sản phẩm trong 1 thùng hàng
        int creatAmount = inputCreatAmount(); // Thêm số lượng thùng hàng có trong kho
        Product product = new Product(id, name, exp, price, amount, creatAmount); //Tạo đối tượn sản phẩm
        productArrayList.add(product); // thêm đối tượng sản phẩm vào list
        productStorage.write(productArrayList); // Thêm list danh sách sản phẩm vào file
    }

    // Chỉnh sửa thông tin sản phẩm
    // Chỉnh sửa theo id
    public void edit(int id) {
        boolean isExisted = false; // kiểm tra mã số sp có tồn tại
        int size = productArrayList.size();
        for (int i = 0; i < size; i++) {
            if (productArrayList.get(i).getId() == id){
                isExisted = true;
                productArrayList.get(i).setName(inputName());
                productArrayList.get(i).setExp(inputExp());
                productArrayList.get(i).setPrice(inputPrice());
                productArrayList.get(i).setAmount(inputAmount());
                productArrayList.get(i).setCreatAmount(inputCreatAmount());
                break;
            }
        }
        if (!isExisted){
            System.out.printf("id = %d không tồn tại.\n", id);
        } else {
            productStorage.write(productArrayList);
        }
    }

    // Xóa phần tử
    public void delete(int id){
        Product product = null;
        int size = productArrayList.size();
        for (int i = 0; i < size; i++){
            if(productArrayList.get(i).getId() == id){
                product = productArrayList.get(i);
                break;
            }
        }
        if (product != null){
            productArrayList.remove(product);
            productStorage.write(productArrayList);
        } else {
            System.out.printf("id = %d không tồn tại.\n", id);
        }
    }
    // sắp xếp danh sách sản phẩm ra màn hình
    public  void sortProduct(){

    }

    // Hiển thị danh sách sản phẩm ra màn hình
    public void show(){
        //ArrayList<Product> productList = productArrayList;
        productArrayList = productStorage.read();
//        System.out.println(productArrayList);
        for (Product productL: productArrayList){
            System.out.printf("%5d,", productL.getId());
            System.out.printf("%20s,", productL.getName());
            System.out.printf("%20s,",productL.getExp());
            System.out.printf("%10.1f,", productL.getPrice());
            System.out.printf("%5d,", productL.getAmount());
            System.out.printf("%5d%n",productL.getCreatAmount());
        }
    }

    // Nhập mã sản phẩm
    public int inputId(){
        System.out.println("Mã Sản Phẩm: ");
        while (true){
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException e){
                System.out.print("Không hợp lệ! Nhập lại mã sản phẩm: ");
            }
        }
    }

    // Nhập tên sản phẩm
    public String inputName(){
        System.out.print("Nhập tên sản phẩm: ");
        return scanner.nextLine();
    }

    // Nhập ngày sản xuất
    public String inputExp(){
        System.out.print("Nhập ngày sản xuất: ");
        return scanner.nextLine();
    }

    // Nhập giá tiền sản phẩm
    public float inputPrice(){
        System.out.print("Nhập giá tiền sản phẩm: ");
        while (true){
            try {
                float exp = Float.parseFloat(scanner.nextLine());
                if (exp < 0.0 && exp > 20.0){
                    throw new NumberFormatException();
                }
                return exp;
            } catch (NumberFormatException e) {
                System.out.print("Không hợp lệ! Nhập lại giá tiền: ");
            }
        }
    }

    // Nhập số  lượng sản phẩm
    public  int inputAmount(){
        System.out.print("Nhập số lượng sản phẩm: ");
        while (true){
            try {
                int amount = Integer.parseInt(scanner.nextLine());
                return amount;
            } catch (Exception e){
                System.out.println("Không hợp lệ! nhập lại: ");
            }
        }

    }

    // Nhập số lượng thùng hàng có trong kho
    public int inputCreatAmount(){
        System.out.print("Nhập số lương hàng: ");
        while (true) {
            try {
                int creatAmount = Integer.parseInt(scanner.nextLine());
                return creatAmount;
            } catch (Exception e) {
                System.out.print("Không hợp lệ! Vui lòng nhập lại: ");
            }

        }
    }
}
