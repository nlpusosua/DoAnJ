package service;

import entities.Account;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public interface IService<T> {
    void input(Scanner scanner, Map<Integer, T> t);
    void udate(Scanner scanner, Map<Integer, T>t);
}
