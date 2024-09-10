package com.practice.java.DesignPatterns.Creational;

// Creates new objects by copying an existing object.
// Can be used in a scenario where creating a new instance is complex
public class PrototypeDesign {
    public static void main(String[] args) {
        // Create an original Document
        Document original = new Document("Original Content");
        System.out.println("Original: " + original);

        // Clone the original Document
        Document copy = (Document) original.clone();
        copy.setContent("Cloned Content");

        // Print both documents
        System.out.println("Original after clone: " + original);
        System.out.println("Copy: " + copy);
    }
}

interface Prototype {
    Prototype clone();
}

class Document implements Prototype{
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Prototype clone() {
        return new Document(this.content);
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                '}';
    }
}
