package service;

import entities.User;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserSevice {
    Utils utils = new Utils();

    //  THAY ĐỔI THÔNG TIN CHỦ TRỌ
    public void changeInforHost(Scanner scanner, Map<Integer, User> userHost){
        System.out.println("Bạn muốn làm gì ?:");
        System.out.println("1. Điền thông tin cá nhân");
        System.out.println("2. Thay đổi thông tin cá nhân");
        int choice = utils.inputInt(scanner);
        switch (choice){
            case 1: inputInforHost(scanner,userHost);
            break;
            case 2:udateInforHost(userHost, scanner);
            break;
            }
    }

    public void inputInforHost(Scanner scanner,Map<Integer, User> userHost){
        System.out.println("Nhập tên chủ trọ: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi:");
        int age = utils.inputInt(scanner);
        System.out.println("Nhập số điện thoại:");
        String tele = scanner.nextLine();
        System.out.println("Nhập địa chỉ thường chú:");
        String address = scanner.nextLine();
        User user = new User(name,age,tele,address);
        userHost.put(user.getId(), user);
        System.out.println("Đã cập nhật thông tin "+ user);
    }

    public void udateInforHost(Map<Integer, User> userHost, Scanner scanner){
        while (true) {
            System.out.println("Nhập id:");
            int id = utils.inputInt(scanner);
            if(userHost.containsKey(id)){
                User user = userHost.get(id);
                System.out.println("Đổi họ tên");
                String name = scanner.nextLine();
                System.out.println("Đổi tuổi:");
                int age = utils.inputInt(scanner);
                System.out.println("Đổi số điện thoại");
                String tele = scanner.nextLine();
                System.out.println("Đổi địa chỉ thường chú");
                String address = scanner.nextLine();
                user.setName(name);
                user.setAge(age);
                user.setTele(tele);
                user.setAddress(address);
                userHost.put(id, user);
                System.out.println("Thay đổi thông tin thành công "+user);
            } else {
                System.out.println("Không tìm thấy id của bạn");
            }
        }
    }

//    BANKING
    public void Bank(Scanner scanner, Map<Integer, User> userHost){
        User user= new User();
        System.out.println("Số dư: "+ user.getBank());
    }

//    THAY ĐỔI THÔNG TIN CHO KHÁCH THUÊ TRỌ
//    public void inputInforGuest(Map<Integer, User> userGuest){
//        System.out.println("Nhập tên khách thuê: ");
//        String name = scanner.nextLine();
//        System.out.println("Nhập số điện thoại:");
//        String tele = scanner.nextLine();
//        System.out.println("Nhập địa chỉ thường chú:");
//        String address = scanner.nextLine();
//        User user = new User(name,tele,address);
//        userGuest.put(user.getId(), user);
//    }
}
