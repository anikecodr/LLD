package org.example.compositedesignpattern.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private final String directoryName;
    public List<FileSystem> fileSystems;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.fileSystems = new ArrayList<>();
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public List<FileSystem> getFileSystems() {
        return fileSystems;
    }

    public void setFileSystems(List<FileSystem> fileSystems) {
        this.fileSystems = fileSystems;
    }

    public void addFileSystem(FileSystem fileSystem) {
        this.fileSystems.add(fileSystem);
    }

    @Override
    public void ls() {
    System.out.println("Directory Name " + directoryName);

    for (FileSystem fileSystem: fileSystems) {
        fileSystem.ls();
    }
    }
}
