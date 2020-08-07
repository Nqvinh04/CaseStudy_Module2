package sample;

import Controller.ProductManager;
import ProductModel.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }

    public class Main {
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            String choose = null;
            boolean exit = false;
            ProductManager productManager = new ProductManager();
            int productId;

            showMenu();
            while (true) {
                choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        productManager.addProduct();
                        break;
                    case "2":
                        productId = productManager.inputId();
                        productManager.edit(productId);
                        break;
                    case "3":
                        productId = productManager.inputId();
                        productManager.delete(productId);
                        break;
                    case "4":
                        sortMenu();
                        while (true) {
                            String isChoose = scanner.nextLine();
                            switch (isChoose) {
                                case "1":
                                    productManager.sortProductByName();
                                    sortMenu();
                                    break;
                                case "2":
                                    productManager.sortProductByExp();
                                    sortMenu();
                                    break;
                                case "3":
                                    productManager.sortProductByCreatAmount();
                                    sortMenu();
                                    break;
                                case "0":
                                    showMenu();
                            }
                            break;
                        }
                        break;
                    case "6":
                        productManager.show();
                        break;
                    case "0":
                        System.out.println("Thoát!");
                    default:
                        System.out.println("Không hợp lệ! Vui lòng chọn hành động trong menu bên dưới:");
                        break;
                }
                if (exit) {
                    break;
                }
                showMenu();
            }
        }

        public static void showMenu() {
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
        }

        private static void sortMenu() {
            System.out.println("----------Sort----------");
            System.out.println("1. Theo Tên");
            System.out.println("2. Theo Ngày Sản Xuất");
            System.out.println("3. Theo Số Lượng");
            System.out.println("0. Thoát");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn: ");
        }

        private static void editMenu() {
            System.out.println("----------Edit----------");
            System.out.println("1. Mã sản phẩm");
            System.out.println("2. Sửa tên");
            System.out.println("3. Sửa giá");
            System.out.println("4. Sửa số lượng(gói/thùng)");
            System.out.println("");
            System.out.println("0. Thoát");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn: ");
        }

        private static void findMenu(){
            System.out.println("----------Find----------");
            System.out.println("1. Tìm theo tên");
            System.out.println("2. Tìm theo mã sản phẩm");
            System.out.println("0. Thoát");
            System.out.println("-----------------------");
            System.out.println("Vui lòng chọn: ");
        }

    }
