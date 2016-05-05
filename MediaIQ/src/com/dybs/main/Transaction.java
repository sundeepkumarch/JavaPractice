package com.dybs.main;

import java.util.List;

public class Transaction {
    private String customerId;
    private List<String> bookIds;

    public Transaction(String customerId, List<String> bookIds) {
        this.customerId = customerId;
        this.bookIds = bookIds;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<String> bookIds) {
        this.bookIds = bookIds;
    }
    
    
}
