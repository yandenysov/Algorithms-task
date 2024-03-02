package app;

import app.data.DataProvider;
import app.data.Product;
import app.services.DataService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class App {

    public static void main(String[] args) {
        try {
            double priceSearch = getSearchValue();
            DataProvider provider = new DataProvider();
            List<Product> list = provider.getData();
            displayProductList(list);
            DataService service = new DataService();
            int index = service.search(list, priceSearch);
            displaySearchResult(list, priceSearch, index);
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e);
        }
    }

    private static double getSearchValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter price value to search (x.xx): ");
        return Double.parseDouble(scanner.next());
    }

    private static void displayProductList(List<Product> list) {
        System.out.print("Initial data:\n");
        AtomicInteger count = new AtomicInteger(1);
        for (Product product : list) {
            System.out.println(count.getAndIncrement() + ") " +
                    product.getName() + ", USD " + product.getPrice());
        }
    }

    private static void displaySearchResult(List<Product> list, double priceSearch, int index) {
        System.out.println("------------------------");
        if (index == -1)
            System.out.print("No product found with this price.\n");
        else
            System.out.print("Product: " + list.get(index).getName() +
                    ", USD " + priceSearch + "\n");
    }
}
