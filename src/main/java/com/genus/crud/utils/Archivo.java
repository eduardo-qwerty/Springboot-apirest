package com.genus.crud.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.*;

public class Archivo {

    /**
     * Encargadp de guardar un archivo
     *
     * @param file El archivo img
     * @param path Ruta del archivo img
     */
    public static void saveFile(MultipartFile file, String path){
        Path destino = Paths.get(path).normalize().toAbsolutePath();
        File parent = new File(destino.toUri()).getParentFile();
        if(!parent.exists()){
            parent.mkdirs();
        }
        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, destino, StandardCopyOption.REPLACE_EXISTING);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    public static byte[] getArchivo(String path) throws IOException {
        InputStream inputStream = Files.newInputStream(new File(path).toPath());
        byte[] bytes = IOUtils.toByteArray(inputStream);
        inputStream.close();
        return bytes;
    }
}
