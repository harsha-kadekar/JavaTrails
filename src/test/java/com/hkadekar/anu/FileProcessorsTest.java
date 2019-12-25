package com.hkadekar.anu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FileProcessorsTest {

    private FileProcessors fp;

    @BeforeEach
    public void initiate(){
        fp = new FileProcessors();
        ClassLoader classLoader = FileProcessorsTest.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("testfile.txt")).getFile());
        fp.setPathOfFile(file.getAbsolutePath());
    }

    @Test
    public void getNameTest() throws IOException {
        String name = fp.getNameFromFile();
        Assertions.assertEquals(name, "Harsha Kadekar");
    }

    @Test
    public void getAddressTest() throws IOException{
        String address = fp.getAddressFromFile();
        Assertions.assertEquals(address, "1234 12th Ave APT 1234 Dreamcity, highstate 123456");
    }
}
