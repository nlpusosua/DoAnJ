package view;


import entities.Account;
import entities.House;
import entities.User;
import service.AccountService;
import service.HouseService;
import service.UserSevice;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Utils utils = new Utils();
//    AccountService accountService = new AccountService();
    HouseService houseService = new HouseService();
    Map<Integer, House> houseMap = new HashMap<>();

    public void displayMenu(Scanner scanner, ArrayList<Account> accounts, AccountService service) {
        while (true) {
            System.out.println("------ỨNG DỤNG TÌM PHÒNG TRỌ ONLINE------");
            System.out.println("Mời bạn lựa chọn:");
            System.out.println("1. Đăng ký tài khoản");
            System.out.println("2. Đăng nhập tài khoản");
            System.out.println("3. Thoát chương trình");
            String choice = scanner.nextLine();
            switch (choice) {
                case "2":
                    service.login(scanner, accounts);
                    break;
                case "1":
                    service.creatAccount(scanner, accounts);
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("lua chon sai, chon lai");
            }
        }
    }

    public void hostDisplay(Scanner scanner, ArrayList<Account>accounts) {
        UserSevice userSevice = new UserSevice();
        Map<Integer, User> userHost = new HashMap<>();
        while (true) {
            System.out.println("Đăng nhập thành công. Xin mời chủ trọ sử dụng:");
            System.out.println("1. Thêm phòng cho thuê");
            System.out.println("2. Sửa thông tin phòng");
            System.out.println("3. Xóa phòng cho thuê");
            System.out.println("4. Xem phản hồi từ khách hàng");
            System.out.println("5. Xem ví tiền");
            System.out.println("6. Cập nhật thông tin tài khoản");
            System.out.println("7. Đăng xuất");
            int choice = utils.inputInt(scanner);
            switch (choice) {
                case 1:
                    houseService.input(scanner, houseMap);
                    break;
                case 2:
                    houseService.udate(scanner, houseMap);
                    break;
                case 3:
                    houseService.remove(scanner,houseMap);
                case 5:
//
                    break;
                case 6:
                    userSevice.changeInforHost(scanner, userHost);
                    break;
                case 7:
                    return;
            }
        }
    }

    public void adminDisplay(Scanner scanner){
        System.out.println("alo");
    }

//    public void guestDisplay(Scanner scanner, Map<Integer, House> houseMap){
//        for (Map.Entry<Integer, House> entry : houseMap.entrySet()) {
//            Integer key = entry.getKey();
//            House house = entry.getValue();
//            System.out.println( + key + " House: " + house);
//        }
//
//    }
}