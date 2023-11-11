package service;


import entities.Account;
import utils.Utils;
import view.Menu;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountService {
    Menu menu = new Menu();
    Utils utils = new Utils();
    public static boolean emailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean passwordValid(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[\\W_]).{7,15}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void login(Scanner scanner, ArrayList<Account> accounts) {
        System.out.println("Nhập username: ");
        String userName = scanner.nextLine();
        System.out.println("Nhập password: ");
        String passWord = scanner.nextLine();
        System.out.println("Nhập role:");
        int role = utils.inputInt(scanner);
        Account findAccount = findAccountUsername(userName, accounts);
        if (findAccount != null) {
            if (findAccount.getPassWord().equals(passWord)){
                if (findAccount.getRole()==2){
                    menu.hostDisplay(scanner, accounts);
                } else if (findAccount.getRole()==1) {
                    menu.adminDisplay(scanner);
                } else if (findAccount.getRole()==3){
//                    menu.guestDisplay(scanner, houseMap);
                }
            } else {
                wrongPassword(scanner, accounts);
            }
        } else {
            System.out.println("Tài khoản không tồn tại, vui lòng thử lại");
        }
    }





    private Account findAccountEmail(String email, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getEmail().equals(email)) {
                return account;
            }
        }
        return null;
    }

    private Account findAccountUsername(String userName, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;
    }

    private void wrongPassword(Scanner scanner, ArrayList<Account> accounts) {
        System.out.println("Sai mật khẩu");
        System.out.println("1. Đăng nhập lại");
        System.out.println("2. Quên mật khẩu");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                login(scanner, accounts);
                break;
            case "2":
                forgetPassword(scanner,accounts);
                break;
            default:
                System.out.println("lựa chọn sai");
        }
    }

    private boolean userNameExit(String newUsername, ArrayList<Account> accounts) {
        for (Account existUser : accounts) {
            if (existUser.getUserName().equals(newUsername)) {
                return false;
            }
        }
        return true;
    }

    private boolean emailExit(String newEmail, ArrayList<Account> accounts, Account account) {
        for (Account existUser : accounts) {
            if (existUser != account && existUser.getEmail().equals(newEmail)) {
                return false;
            }
        }
        return true;
    }

    public void changeUsername(Scanner scanner, ArrayList<Account> accounts, Account account) {
        System.out.println("Nhập username mới");
        String newUsername = scanner.nextLine();
        if (userNameExit(newUsername, accounts)) {
            account.setUserName(newUsername);
            System.out.println("username đã được đổi");
        } else {
            System.out.println("username đã tồn tại");
            changeUsername(scanner, accounts, account);
        }
    }

    private void changeEmail(Scanner scanner, ArrayList<Account> accounts, Account account) {
        System.out.println("Nhập email mới");
        String newEmail = scanner.nextLine();
        if (emailValid(newEmail)) {
            if (emailExit(newEmail, accounts, account)) {
                account.setEmail(newEmail);
                System.out.println("email đã được đổi");
            } else {
                System.out.println("email đã tồn tại");
                changeEmail(scanner, accounts, account);
            }
        } else {
            System.out.println("email không hợp lệ");
            changeEmail(scanner, accounts, account);
        }
    }

    public void changePassword(Scanner scanner,Account account) {
        System.out.println("Nhập pass mới (độ dài 7-15 ký tự có chữ in hoa và 1 ký tự đặc biệt");
        String newPassword = scanner.nextLine();
        if (passwordValid(newPassword)) {
            account.setPassWord(newPassword);
            System.out.println("pass đổi thành công");
        } else {
            System.out.println("pass không hợp lệ");
            changePassword(scanner, account);
        }
    }

    public void forgetPassword(Scanner scanner, ArrayList<Account> accounts) {
        System.out.println("Nhập username");
        String username = scanner.nextLine();

        Account account = findAccountUsername(username, accounts);
        if (account != null) {
            System.out.println("Nhập email đã đăng ký");
            String registeredEmail = scanner.nextLine();

            if (registeredEmail.equals(account.getEmail())) {
                System.out.println("Nhập pass mới (độ dài từ 7-15 ký tự có chữ in hoa và 1 ký tự đặc biệt)");
                String newPassword = scanner.nextLine();

                if (passwordValid(newPassword)) {
                    account.setPassWord(newPassword);
                    System.out.println("pass đã được đổi");
                    login(scanner, accounts);
                } else {
                    System.out.println("pass không hợp lệ");
                    forgetPassword(scanner, accounts);
                }
            } else {
                System.out.println("Email không khớp với tài khoản");
                forgetPassword(scanner, accounts);
            }
        } else {
            System.out.println("Username không tồn tại");
            forgetPassword(scanner, accounts);
        }
    }

    public void creatAccount(Scanner scanner, ArrayList<Account> accounts) {
        System.out.println("Nhập username");
        String userName = scanner.nextLine();
        if (userNameExit(userName, accounts)) {
            System.out.println("Nhập Email");
            String email = scanner.nextLine();
            if (emailExit(email, accounts, null) && emailValid(email)) {
                System.out.println("Nhập pass (độ dài từ 7-15 ký tự có chữ in hoa và 1 ký tự đặc biệt):");
                String passWord = scanner.nextLine();

                System.out.println("Nhập role (2.Chủ trọ 3.Khách thuê trọ):");
                int role = utils.inputInt(scanner);
                Account account= new Account(userName, email, passWord, role);

                if (account.getRole() == 2 || account.getRole() == 3) {
                    if (passwordValid(passWord)) {
                        accounts.add(account);
                        System.out.println("Tạo tài khoản thành công"+account);
                    } else {
                        System.out.println("pass không hợp lệ");
                    }
                } else {
                    System.out.println("Nhập sai role, vui lòng nhập lại");
                    return;
                }

            } else {
                if (!emailValid(email)) {
                    System.out.println("email không hợp lệ");
                } else {
                    System.out.println("email đã tồn tại");
                }
            }
        } else {
            System.out.println("Username đã tổn tại");
        }
    }


//    public void update(Scanner scanner, ArrayList<Account> accounts) {
//        while (true) {
//            System.out.println("1. thay doi username");
//            System.out.println("2. thay doi email");
//            System.out.println("3. thay doi password");
//            System.out.println("4. dang xuat");
//            System.out.println( "0. thoat chuong trinh");
//            String choice = scanner.nextLine();
//            switch (choice) {
//                case "1": changeUsername(scanner, accounts, findAccount);
//                break;
//                case "2": changeEmail(scanner, accounts, findAccount);
//                break;
//                case "3": changePassword(scanner, findAccount);
//                break;
//                case "4": return;
//                case "0":
//                    System.out.println("Chương trình đã thoát");
//                    System.exit(0);
//                    break;
//                    default:
//                        System.out.println("Lựa chọn sai, vui lòng chọn lại");
//                    }
//                }
//    }
}


