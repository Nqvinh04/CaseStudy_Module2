//package sample;
//
//import ProductModel.Product;
//
//import java.util.Scanner;
//
//public class Program {
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        do {
//            startMenu:
//            {
//                System.out.println("1: Product management");
//                System.out.println("2: Category Mangagement");
//                int choice = Integer.parseInt(input.nextLine());
//                switch (choice) {
//                    case 1:
//                        do {
//                            System.out.println("1: Add");
//                            System.out.println("1: Edit");
//                            System.out.println("1: Remove");
//                            System.out.println("1: Get All");
//                            int choice2 = Integer.parseInt(input.nextLine());
//                            switch (choice2) {
//                                case 1:
//                                    System.out.println("Enter your product id:");
//                                    int id = Integer.parseInt(input.nextLine());
//                                    Product p = new Product();
//                                    p.setId(id);
//                                    break;
//                                case 12:
//                                    break;
//                                case 3:
//                                    break;
//                                case 4:
//                                    break startMenu;
//                                default:
//                                    break;
//                            }
//                        } while (true);
//                    case 12:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
//        while (true);
//
//
//    }
//}
