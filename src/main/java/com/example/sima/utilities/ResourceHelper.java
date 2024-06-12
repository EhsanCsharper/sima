package com.example.sima.utilities;

import java.io.InputStream;
import java.util.Objects;

public class ResourceHelper {

    public static InputStream getResourceAsStream(String path) {
        try {
            InputStream stream = ResourceHelper.class.getClassLoader().getResourceAsStream(path);
            if (Objects.isNull(stream)) {
                throw new RuntimeException("can not load file < " + path + ">");
            }
            return stream;
        } catch (Exception e) {
            throw new RuntimeException("can not load file < " + path + ">");
        }
    }
}
