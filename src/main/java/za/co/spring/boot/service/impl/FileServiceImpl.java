package za.co.spring.boot.service.impl;

import org.springframework.stereotype.Service;
import za.co.spring.boot.dto.FileDTO;
import za.co.spring.boot.service.FilePathService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FilePathService {
    @Override
    public FileDTO fileFilePath(String path) {
        FileDTO dto = new FileDTO();

     Stream<Map.Entry<Object, Object>> file =  System.getProperties()
               .entrySet()
               .stream().filter(e->e.getKey().equals(path));

        StringBuilder key = new StringBuilder();
        file.forEach(e->key.append(e.getValue()));

        Path dir = Paths.get(key.toString());
        try {
            long size = Files.walk(dir)
                    .filter(k -> k.toFile().isFile())
                    .mapToLong(k -> k.toFile().length())
                    .sum();
            System.out.println("\n============= FIle Size : " + size + "  =========================================\n");
            dto.setDir(key.toString());
            dto.setPath(dir.toAbsolutePath().toString());
            dto.setFileSize(size);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dto;
    }
}
