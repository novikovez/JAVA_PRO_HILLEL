package org.dz28;

import org.dz28.entity.Sales;

import java.util.List;

public class Main {
    private static final DataBase dataBase = new DataBase();

    public static void main(String[] args) {
        SaleList salesList = new SaleList();
        salesList.add("Laptop", 1000, 5);
        salesList.add("Phone", 700, 3);
        salesList.add("Tablet", 500, 2);
        salesList.add("Printer", 300, 4);
        salesList.add("Laptop", 2100, 5);
        salesList.add("Phone", 750, 3);
        salesList.add("Tablet", 560, 2);
        salesList.add("Printer", 310, 4);

        salesList.saveDataBase();
        printer("Вставте наступні дані в таблицю sales: Готово!");
        printer("Вибірка даних:");
        printFor(dataBase.index(Sales.class, 100, 0));
        printer("Вибірка з обмеженням (LIMIT):");
        printFor(dataBase.index(Sales.class, 2, 0));
        printer("Обчислення суми (SUM):" +  dataBase.getSum(Sales.class, "price"));
        printer("Групування даних (GROUP BY):");

        List<Object[]> groupedData = dataBase.rawGroupBy(
          "sales", "product", "quantity", "price"
        );

        for (Object[] row : groupedData) {
            String product = (String) row[0];
            long totalCount = ((Number) row[1]).longValue();
            double avgPrice = ((Number) row[2]).doubleValue();

            System.out.println("Товар: " + product +
                    ", Кількість: " + totalCount +
                    ", Середня ціна: " + avgPrice);
        }

        dataBase.close();
    }

    private static void printer(String string) {
        System.out.println(string);
    }

    private static void printFor(List<Sales> data) {
        for (Sales saleItem : data) {
            System.out.println(saleItem.getId() + " | " +saleItem.getProduct() + " | " +
                    "" + saleItem.getPrice() + " | " + saleItem.getQuantity());
        }
    }


}
