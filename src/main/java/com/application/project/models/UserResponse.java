package com.application.project.models;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data = new ArrayList<>();

    public UserResponse(){}
    public UserResponse(int page, int per_page, int total, int total_pages, List<User> data){
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    //getters
    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public List<User> getData() {
        return data;
    }

    //setters

    public void setPage(int page) {
        this.page = page;
    }

    public void setPerPage(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotalPages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public String  to_string(){
        return "Pagina: " + getPage() + "\n" +
                            "Cantidad por pagina: " + getPerPage() + "\n"
                            + "Total: " + getTotal() + "\n" +
                            "Tipo de dato: " + getData();
        }
}