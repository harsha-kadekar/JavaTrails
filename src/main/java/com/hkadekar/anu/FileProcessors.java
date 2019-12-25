package com.hkadekar.anu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessors {
    private String pathOfFile = "";

    public String getPathOfFile() {
        return pathOfFile;
    }

    public void setPathOfFile(String pathOfFile) {
        this.pathOfFile = pathOfFile;
    }

    private String processFile(FileProcessFunction fp) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(pathOfFile))){
            return fp.processFile(br);
        }
    }

    public String getNameFromFile() throws IOException {
        return processFile((br) -> br.readLine());
    }

    public String getAddressFromFile() throws IOException {
        return processFile((br) -> {
            br.readLine();
            return String.join(" ", br.readLine(), br.readLine(), br.readLine());
        });
    }
}
