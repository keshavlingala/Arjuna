package com;

class Page {
    int number;
    private String content;

    public Page(int number, String content) {
        this.number = number;
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Page{" +
                "number=" + number +
                ", content='" + content + '\'' +
                '}';
    }
}

class Book {
    int numberOfPages;
    private Page[] pages;

    public Book(int numberOfPages) {
        for (int i = 0; i < pages.length; i++) {
            pages[i] = new Page(i + 1, "Page Content " + (i + 1));
        }
        this.numberOfPages = numberOfPages;
    }

    public Page getPage(int index) {
        if (pages == null) {
            return null;
        }
        return pages[index - 1];
    }
}

public class Temp {
    public static void main(String[] args) {
        Book b = new Book(650);
        System.out.println(b.getPage(333));
    }
}
