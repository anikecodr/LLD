package org.example.compositedesignpattern.filesystem;

public class ClientCode {

    public static void main(String[] args){

        Directory parent = new Directory("Movie");

        FileSystem file = new File("Border");

        parent.addFileSystem(file);

        Directory directory = new Directory("Comedy Movies");
        FileSystem file2 = new File("Heri-Peri");
        directory.addFileSystem(file2);
        parent.addFileSystem(directory);

        parent.ls();

    }
}
