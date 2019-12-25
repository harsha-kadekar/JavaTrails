package com.hkadekar.anu;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface FileProcessFunction {
    String processFile(BufferedReader br) throws IOException;
}
