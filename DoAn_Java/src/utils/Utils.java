package utils;

import java.util.Scanner;
public class Utils {
    public int inputInt(Scanner scanner){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e){
                System.out.println("Bạn đã nhập sai định dạng, xin vui lòng nhập chữ số");
            }
        }
    }

    public double inputDouble(Scanner scanner){
        while (true){
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e){
                System.out.println("Bạn đã nhập sai định dạng, xin vui lòng nhập lại");
            }
        }
    }
}
