package com.pixelcan.emotionanalysisapi.util;

import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by David Pacioianu on 1/13/16.
 */
public class FileUtils {

    public static byte[] toBinary(Uri uri) throws IOException, URISyntaxException {
        // convert the image to bytes array
        InputStream inputStream = new FileInputStream(new File(new URI(uri.toString())));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];

        int bytesRead;
        while ((bytesRead = inputStream.read(bytes)) > 0) {
            byteArrayOutputStream.write(bytes, 0, bytesRead);
        }

        byte[] data = byteArrayOutputStream.toByteArray();

        return  data;
    }

}
