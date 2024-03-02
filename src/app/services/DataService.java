package app.services;

import app.data.Product;

import java.util.List;

public class DataService {
    public int search(List<Product> list, double x) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() == x) return i;
        }
        return -1;
    }
}
