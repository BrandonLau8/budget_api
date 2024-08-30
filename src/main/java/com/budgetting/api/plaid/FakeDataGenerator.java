//package com.budgetting.api.plaid;
//
//import com.budgetting.api.plaid.model.transaction.AddedTransaction;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class FakeDataGenerator {
//
//    private static final String[] CURRENCY_CODES = {"USD", "EUR", "GBP", "JPY"};
//    private static final String[] NAMES = {"Coffee", "Groceries", "Rent", "Utilities"};
//
//    public static List<AddedTransaction> generateFakeTransactions(int count) {
//        List<AddedTransaction> transactions = new ArrayList<>();
//        Random random = new Random();
//
//        for (int i = 0; i < count; i++) {
//            AddedTransaction transaction = new AddedTransaction(
//                    "account" + random.nextInt(1000),
//                    random.nextDouble() * 1000,
//                    CURRENCY_CODES[random.nextInt(CURRENCY_CODES.length)],
//                    LocalDate.now().minusDays(random.nextInt(30)),
//                    NAMES[random.nextInt(NAMES.length)]
//            );
//            transactions.add(transaction);
//        }
//
//        return transactions;
//    }
//}
