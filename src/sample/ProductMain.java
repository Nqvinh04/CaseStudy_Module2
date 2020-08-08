package sample;

import Controller.ProductManager;
import ProductModel.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        boolean exit = false;
        ProductManager productManager = new ProductManager();
        ArrayList<Product> products = new ArrayList<>();
        int productId;

        while (true) {
            System.out.println("----------Menu----------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Cập nhật");
            System.out.println("3. Xóa");
            System.out.println("4. Sắp xếp");
            System.out.println("5. TÌm kiếm");
            System.out.println("6. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn: ");

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    int editChoose = Integer.parseInt(scanner.nextLine());
                    System.out.println("----------Edit----------");
                    System.out.println("1. Mã sản phẩm");
                    System.out.println("2. Sửa tên");
                    System.out.println("3. Sửa giá");
                    System.out.println("4. Sửa số lượng(gói/thùng)");
                    System.out.println("");
                    System.out.println("0. Thoát");
                    System.out.println("-----------------------");
                    System.out.println("Vui lòng chọn: ");
                    while (true) {
                        switch (editChoose) {
                            case 1:
                                productManager.editProductById(products);
                                break;
                            case 2:
                                productManager.editProductByName(products);
                                break;
                            case 3:
                                productManager.editProductByPrice(products);
                                break;
                            case 4:
                                productManager.editProductByAmount(products);
                                break;
                            case 0:
                                System.out.println("Thoát chỉnh sửa! Quay lại màn hình chính");
                                break;
                        }
                        break;
                    }
                    break;

                case 3:
                    productId = productManager.inputId();
                    productManager.delete(productId);
                    break;

                case 4:
                    System.out.println("----------Sort----------");
                    System.out.println("1. Theo Tên");
                    System.out.println("2. Theo Ngày Sản Xuất");
                    System.out.println("3. Theo Số Lượng");
                    System.out.println("0. Thoát");
                    System.out.println("-----------------------");
                    System.out.println("Vui lòng chọn: ");
                    int isChoose = Integer.parseInt(scanner.nextLine());
                    while (true) {
                        switch (isChoose) {
                            case 1:
                                productManager.sortProductByName();
                                break;
                            case 2:
                                productManager.sortProductByExp();
                                break;
                            case 3:
                                productManager.sortProductByCreatAmount();
                                break;
                            case 0:
                                System.out.println("Thoát sắp xếp! Quay lại màn hình chính");
                        }
                        break;
                    }
                    break;


                case 5:
                    System.out.println("----------Find----------");
                    System.out.println("1. Tìm theo tên");
                    System.out.println("2. Tìm theo mã sản phẩm");
                    System.out.println("0. Thoát");
                    System.out.println("-----------------------");
                    System.out.println("Vui lòng chọn: ");
                    int findChoose = Integer.parseInt(scanner.nextLine());

                    while (true){
                        switch (findChoose) {
                            case 1:
                                System.out.println("Nhập tên sản phẩm cần tìm: ");
                                String productName = scanner.nextLine();
                                productManager.findProductByName(productName);
                                break;
                            case  2:
                                System.out.println("Nhập mã số sản phầm cần tìm: ");
                                int productInt = Integer.parseInt(scanner.nextLine());
                                productManager.findProductById(productInt);
                                break;
                            case 0:
                                System.out.println("Thoát tìm kiếm! Quay lại màn hình chính");
                              break;
                        }
                        break;
                    }
                    break;


                case 6:
                    productManager.show();
                    break;
                case 0:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Không hợp lệ! Vui lòng chọn hành động trong menu bên dưới:");
                    break;
            }
        }
    }

}
