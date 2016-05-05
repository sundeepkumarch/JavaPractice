package com.dybs.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * java com/dybs/main/DogYardBookStore t TransactionList.csv p PriceList.csv r 3
 * java com/dybs/main/DogYardBookStore t TransactionList.csv p PriceList.csv d 1700 c C12397
 */
public class DogYardBookStore {

    public Map<String, Integer> custVisitMap = new HashMap<>();
    public Map<String, Integer> custTransMap = new HashMap<>();
    public Map<String, Integer> quantitySold = new HashMap<>();
    public Map<String, Book> books = new HashMap<>();
    String line = "";
    final String SPLITBY = ",";
    BufferedReader br;

    public static void main(String[] args) {
        DogYardBookStore dybs = new DogYardBookStore();

        dybs.processBooks(args[3]);
        dybs.processTransaction(args[1]);

        String command = args[4];
        if (command.equals("r")) {
            int N = Integer.parseInt(args[5]);
            List<Map.Entry<String, Integer>> result = dybs.sortMapByValue(dybs.custVisitMap, true); //true for increasing
            int prev0 = 0, m = N;
            for (int i = 0; i < N; i++) {
                int curr = result.get(i).getValue();
                if (i == 0) {
                    prev0 = curr;
                }
                if (prev0 != curr) {
                    if (m <= N - 2) {
                        break;
                    } else {
                        m--;
                    }
                }
                System.out.print(result.get(i).getKey() + " " + result.get(i).getValue() + ", ");
                prev0 = result.get(i).getValue();
            }
            System.out.println();

            result = dybs.sortMapByValue(dybs.custTransMap, true);
            for (int i = 0; i < N; i++) {
                System.out.print(result.get(i).getKey() + " " + result.get(i).getValue() + ", ");
            }
            System.out.println();

            result = dybs.sortMapByValue(dybs.quantitySold, true);
            int prev = 0, j = N;
            for (int i = 0; i < result.size(); i++) {
                int curr = result.get(i).getValue();
                if (i == 0) {
                    prev = curr;
                }
                if (prev != curr) {
                    if (j <= N - 2) {
                        break;
                    } else {
                        j--;
                    }
                }

                System.out.print(result.get(i).getKey() + " " + curr + ", ");
                prev = result.get(i).getValue();
            }
            System.out.println();

            result = dybs.sortMapByValue(dybs.quantitySold, false);
            int prev1 = 0, k = N;
            for (int i = 0; i < result.size(); i++) {
                int curr = result.get(i).getValue();
                if (i == 0) {
                    prev1 = curr;
                }
                if (prev1 != curr) {
                    if (k <= N - 2) {
                        break;
                    } else {
                        k--;
                    }
                }

                System.out.print(result.get(i).getKey() + " " + result.get(i).getValue() + ", ");
                prev1 = result.get(i).getValue();
            }
            System.out.println();

        } else if (command.equals("d") && args[6].equals("c")) {
            int V = Integer.parseInt(args[5]);
            int purchases = dybs.custTransMap.get(args[7]);
            if (purchases > V) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }


    }

    private void processBooks(String priceFile) {
        try {
            br = new BufferedReader(new FileReader(priceFile));
            while ((line = br.readLine()) != null) {
                String[] s = line.split(SPLITBY);
                String bookId = s[0];
                int price = Integer.parseInt(s[1]);
                String bookName = s[2];
                books.put(bookId, new Book(bookId, price, bookName));
                quantitySold.put(bookId, 0);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DogYardBookStore.class.getName()).log(Level.SEVERE, "PriceList File is not available.", ex);
        } catch (IOException ex) {
            Logger.getLogger(DogYardBookStore.class.getName()).log(Level.SEVERE, "Error while parsing PriceList File", ex);
        }
    }

    public void processTransaction(String transactionFile) {
        try {
            br = new BufferedReader(new FileReader(transactionFile));
            while ((line = br.readLine()) != null) {
                String[] s = line.split(SPLITBY);
                String custId = s[0];
                int totalTxnAmt = 0;
                //Increment visit count
                Integer visitCount = custVisitMap.get(custId);
                if (visitCount == null) {
                    custVisitMap.put(custId, 1);
                } else {
                    custVisitMap.put(custId, visitCount + 1);
                }
                for (int i = 1; i < s.length; i++) {
                    String bookId = s[i];
                    int price = books.get(bookId).getPrice();
                    totalTxnAmt += price;

                    //Increment quantity sold for the book 
                    Integer quantity = quantitySold.get(bookId);
                    if (quantity == null) {
                        quantitySold.put(bookId, 1);
                    } else {
                        quantitySold.put(bookId, quantity + 1);
                    }
                }
                //Increment transaction amount
                Integer txnAmt = custTransMap.get(custId);
                if (txnAmt == null) {
                    custTransMap.put(custId, totalTxnAmt);
                } else {

                    custTransMap.put(custId, totalTxnAmt > txnAmt ? totalTxnAmt : txnAmt);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DogYardBookStore.class.getName()).log(Level.SEVERE, "TransactionList File is not available.", ex);
        } catch (IOException ex) {
            Logger.getLogger(DogYardBookStore.class.getName()).log(Level.SEVERE, "Error while parsing TransactionList File", ex);
        }
    }

    public List<Map.Entry<String, Integer>> sortMapByValue(Map<String, Integer> map, boolean order) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new ValueComparator(order));

        return list;
    }

    public class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

        boolean order;

        private ValueComparator(boolean o) {
            this.order = o;
        }

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            int k1 = Integer.parseInt(o1.getKey().substring(1));
            int k2 = Integer.parseInt(o2.getKey().substring(1));
            int v1 = o1.getValue();
            int v2 = o2.getValue();
            int mux = 1;
            if (!order) {
                mux = -1;
            }

            if (v1 > v2) {
                return -1 * mux;
            } else if (v1 == v2) {
                if (k1 > k2) {
                    return 1 * mux;
                } else {
                    return -1 * mux;
                }
            } else {
                return 1 * mux;
            }

        }
    }

    public class Book {

        private String bookId;
        private int price;
        private String bookName;

        public Book(String bookId, int price, String bookName) {
            this.bookId = bookId;
            this.price = price;
            this.bookName = bookName;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
    }
}