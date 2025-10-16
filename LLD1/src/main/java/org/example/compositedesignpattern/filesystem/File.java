package org.example.compositedesignpattern.filesystem;

public class File implements FileSystem{
    private final String filename;

    public File(String filename) {
        this.filename = filename;
    }

    @Override
    public void ls() {
    System.out.println("Filename " + filename);
    }
}
