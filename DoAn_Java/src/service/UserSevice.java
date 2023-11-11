package service;

import entities.User;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserSevice {
    Map<Integer, User> userMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Utils utils = new Utils();

    public void inputInforGuest(Map<String, User> userMap){
        System.out.println("Nhập tên khách thuê: ");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại:");
        String tele = scanner.nextLine();
        System.out.println("Nhập địa chỉ nhà:");
        String address = scanner.nextLine();
        System.out.println("Nhập số tiền có trong ví:");
        double bank = utils.inputDouble(scanner);
        User user = new User(name,tele,address,bank);
        userMap.put(user.getTele(), user);
    }

}
