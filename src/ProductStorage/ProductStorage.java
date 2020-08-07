package ProductStorage;

import ProductModel.Product;

import java.io.*;
import java.util.ArrayList;

public class ProductStorage {
    private static final String FileName = "D:\\CaseStudy_Module2\\src\\SourceFile\\product.txt";
    File inFile = new File(FileName);

    // Lưu danh sách sản phẩm vào file
    public void write(ArrayList<Product> productList){

        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutput = null;
        try {
            outputStream = new FileOutputStream(inFile);
            objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(productList);

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            closeStream(outputStream);
            closeStream(objectOutput);
        }
    }
    // Đọc danh sách sinh viên từ file
    public ArrayList<Product> read(){
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        FileInputStream inputStream = null;
        ObjectInputStream objectInput = null;
        try {
            inputStream = new FileInputStream(inFile);
            objectInput = new ObjectInputStream(inputStream);
            try {
                productArrayList = (ArrayList<Product>) objectInput.readObject();
            } catch (EOFException ignored) {
            }
        } catch (ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
        return productArrayList;
    }
    // Đóng luồng đầu vào
//    private void closeStream(InputStream is){
//        if (is != null){
//            try {
//                is.close();
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }

    // Đóng luồng đầu ra
    private void closeStream(OutputStream os){
        if (os != null){
            try {
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
