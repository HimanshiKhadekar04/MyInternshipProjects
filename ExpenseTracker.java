import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    private static final String DATA_FILE = "expenses.dat";
    private static List<Expense> expenses = new ArrayList<>();
    private static Map<String, Double> categorySum = new HashMap<>();

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. List Expenses");
            System.out.println("3. Category Sum");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    listExpenses();
                    break;
                case 3:
                    categorySummation();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        saveData();
    }

    private static void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date (dd/MM/yyyy): ");
        String date = scanner.next();
        System.out.print("Enter category: ");
        String category = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        Expense expense = new Expense(date, category, amount);
        expenses.add(expense);
        updateCategorySum(category, amount);
    }

    private static void listExpenses() {
        System.out.println("\nExpenses:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private static void categorySummation() {
        System.out.println("\nCategory Summation:");
        for (Map.Entry<String, Double> entry : categorySum.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void updateCategorySum(String category, double amount) {
        categorySum.put(category, categorySum.getOrDefault(category, 0.0) + amount);
    }

    private static void loadData() {
        try {
            File file = new File(DATA_FILE);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                expenses = (List<Expense>) ois.readObject();
                categorySum = (Map<String, Double>) ois.readObject();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private static void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream(DATA_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(expenses);
            oos.writeObject(categorySum);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}

class Expense {
    private String date;
    private String category;
    private double amount;

    public Expense(String date, String category, double amount) {
        this.date = date;
    }
}
