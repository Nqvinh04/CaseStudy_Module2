package Controller;

import ProductModel.Product;
import ProductStorage.ProductStorage;

import java.util.ArrayList;
import java.util.Collections;
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

//    // Chỉnh sửa thông tin sản phẩm
//    // Chỉnh sửa theo id
//    public void editId(int id) {
//        boolean isExisted = false; // kiểm tra mã số sp có tồn tại
//        int size = productArrayList.size();
//        for (Product product : productArrayList) {
//            if (product.getId() == id) {
//                isExisted = true;
//                product.setName(inputName());
//                product.setExp(inputExp());
//                product.setPrice(inputPrice());
//                product.setAmount(inputAmount());
//                product.setCreatAmount(inputCreatAmount());
//                break;
//            }
//        }
//        if (!isExisted){
//            System.out.printf("id = %d không tồn tại.\n", id);
//        } else {
//            productStorage.write(productArrayList);
//        }
//    }

     //Chỉnh sửa thông tin id
    public void editProductById(ArrayList<Product> productArrayList){
        boolean isExisted = false;
        System.out.println("Nhập mã sản phẩm bạn cần thay đổi: ");
        int Id = Integer.parseInt(scanner.nextLine());
        for (Product product: productArrayList){
            if (product.getId() == Id){
                isExisted = true;
                product.setId(inputId());
                break;
            }
        }
        if (!isExisted){
            System.out.println("id: %d không tồn tại");
        } else  {
            productStorage.write(productArrayList);
        }
    }

    // Chỉnh sửa thông tin  tên
    public void editProductByName(ArrayList<Product> productArrayList){
        boolean isExisted = false;
        System.out.println("Nhập tên sản phẩm bạn cần thay đổi");
        String Name = scanner.nextLine();
        for (Product product: productArrayList){
            if (product.getName().equals(Name)){
                isExisted = true;
                product.setName(inputName());
            }
        }
        if (!isExisted){
            System.out.println("Name: %20s không tồn tại");
        } else {
            productStorage.write(productArrayList);
        }
    }
    // Chỉnh sửa giá sản phẩm
    public void editProductByPrice(ArrayList<Product> productArrayList){
        boolean isExisted = false;
        System.out.println("Nhập mã sản phẩm bạn cần thay đổi: ");
        int Id = Integer.parseInt(scanner.nextLine());
        for (Product product: productArrayList){
            if (product.getId() == Id){
                isExisted = true;
                product.setPrice(inputPrice());
                break;
            }
        }
        if (!isExisted){
            System.out.println("id: %d không tồn tại");
        } else  {
            productStorage.write(productArrayList);
        }
    }
    // Chỉnh sửa số lượng(gói/ thùng)
    public void editProductByAmount(ArrayList<Product> productArrayList){
        boolean isExisted = false;
        System.out.println("Nhập mã sản phẩm bạn cần thay đổi: ");
        int Id = Integer.parseInt(scanner.nextLine());
        for (Product product: productArrayList){
            if (product.getId() == Id){
                isExisted = true;
                product.setAmount(inputAmount());
                break;
            }
        }
        if (!isExisted){
            System.out.println("id: %d không tồn tại");
        } else  {
            productStorage.write(productArrayList);
        }
    }

    // Tìm sản phẩm theo tên
    public void findProductByName(String name){
        for (Product productNameList : productArrayList){
            if (productNameList.getName().equals(name)){
                System.out.println(productNameList);
            }
        }
    }

    // Tìm sản phẩm theo mã sản phẩm
    public void findProductById(int id){
        for (Product productInt : productArrayList){
            if (productInt.getId() == id){
                System.out.println(productInt);
            }
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
//    // Xóa phần tử 1
//    public void delete(ArrayList<Product> productArrayList){
//        Product product = new Product();
//        int size = productArrayList.size();
//        System.out.println("Nhập Mã số sản phẩm bạn muốn xóa: ");
//        int deleteId = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < size; i++){
//            if(productArrayList.get(i).getId() == deleteId){
//                product = productArrayList.get(i);
//                productArrayList.remove(product);
//                break;
//            }
//        }
//        productStorage.write(productArrayList);


    // sắp xếp danh sách sản phẩm ra màn hình
    public  void sortProductByName(){
        Collections.sort(productArrayList, new SortProductByName());
        System.out.println(productArrayList);
    }

    // Sắp xếp danh sách sp theo ngày sản xuất
    public void sortProductByExp(){
        Collections.sort(productArrayList, new SortProductByExp());
        System.out.println(productArrayList);
    }

    // Sắp xếp danh sách theo số lượng thùng hàng tồn tại trong kho
    public void sortProductByCreatAmount(){
        Collections.sort(productArrayList, new SortProductByCreatAmount());
        System.out.println(productArrayList);
    }

    // Hiển thị danh sách sản phẩm ra màn hình
    public void show(){
        //ArrayList<Product> productList = productArrayList;
        productArrayList = productStorage.read();

//        System.out.println(productArrayList);
        for (Product productL: productArrayList){
            System.out.printf("%5d," , productL.getId());
            System.out.printf("%20s,", productL.getName());
            System.out.printf("%20s,",productL.getExp());
            System.out.printf("%10.1f " + "VND,", productL.getPrice());
            System.out.printf("%5d " + "gói/Thùng,", productL.getAmount());
            System.out.printf("%5d " + "Thùng%n",productL.getCreatAmount());
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
