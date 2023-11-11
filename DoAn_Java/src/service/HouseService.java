package service;

import entities.House;
import utils.Utils;

import java.util.Map;
import java.util.Scanner;

public class HouseService implements IService<House>{
    Utils utils = new Utils();
    @Override
    public void input(Scanner scanner, Map<Integer, House> houseMap) {
        System.out.println("Nhập địa chỉ cho ngôi nhà:");
        String address = scanner.nextLine();
        System.out.println("Nhập diện tích của ngôi nhà:");
        double area = utils.inputDouble(scanner);
        System.out.println("Ngôi nhà có những nội thất gì ?:");
        String interior = scanner.nextLine();
        System.out.println("Nhập gía thuê nhà:");
        double price = utils.inputDouble(scanner);
        House house = new House(address,area,interior,price);
        houseMap.put(house.getId(), house);
    }

    @Override
    public void udate(Scanner scanner, Map<Integer, House> houseMap) {
        while (true){
            System.out.println("Nhập id ngôi nhà muốn sửa");
            int id = utils.inputInt(scanner);
            if (houseMap.containsKey(id)){
                House house = houseMap.get(id);

                System.out.println("Đổi địa chỉ mới");
                String address = scanner.nextLine();
                house.setAddress(address);

                System.out.println("Đổi diện tích ngôi nhà:");
                double area = utils.inputDouble(scanner);
                house.setArea(area);

                System.out.println("Đổi nội thất:");
                String interior = scanner.nextLine();
                house.setInterior(interior);

                System.out.println("Đổi giá cho thuê ngôi nhà:");
                double price = utils.inputDouble(scanner);
                house.setPrice(price);
                break;
            } else {
                System.out.println("Không tìm thấy id căn nhà");
            }
        }
    }

    public void remove(Scanner scanner, Map<Integer, House> houseMap){
        while (true){
            System.out.println("Nhập id ngôi nhà muốn xóa:");
            int id = utils.inputInt(scanner);
            if(houseMap.containsKey(id)){
                House house = houseMap.get(id);
                houseMap.remove(id);
                System.out.println("Đã xóa căn nhà");
                break;
            } else {
                System.out.println("Không tìm thấy căn nhà có id này");
            }
        }
    }
}
