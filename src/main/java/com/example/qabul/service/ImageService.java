package com.example.qabul.service;

import com.example.qabul.dto.ImageDto;
import com.example.qabul.entity.Image;
import com.example.qabul.exception.BadRequest;
import com.example.qabul.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.UUID;

@Service
public class ImageService {
    private String fileUrl = "uploads/images/";
    @Value("${serverAddress}")
    private String serverAddress;
    @Autowired
    private ImageRepository imageRepository;

    public ImageDto saveToSystem(MultipartFile file) {
        try {
            String YMD = getYMD();// year month day
            String type = file.getContentType().split("/")[1];
            String token = UUID.randomUUID().toString();

            String URL = YMD + "/" + token + "." + type;
            File folder = new File(fileUrl + YMD);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            Path path = Paths.get(fileUrl).resolve(URL);
            Files.copy(file.getInputStream(), path);

            return createImage(YMD, type, file.getSize(), token);
        } catch (IOException e) {
            throw new BadRequest("File not created");
        }
    }

    private ImageDto createImage(String ymd, String type, long size, String token) {
        Image image = new Image();
        image.setPath(ymd);
        image.setSize(size);
        image.setToken(token);
        image.setType(type);
        image.setURL(serverAddress + "api/v1/image/get/" + token);
        image.setCreatedAt(LocalDateTime.now());
        imageRepository.save(image);
        ImageDto imageDto = new ImageDto();
        convertImageToDto(image,imageDto);
        return imageDto;
    }

    private void convertImageToDto(Image image, ImageDto imageDto) {
        imageDto.setSize(image.getSize());
        imageDto.setPath(image.getPath());
        imageDto.setUrl(image.getURL());
        imageDto.setId(image.getId());
        imageDto.setToken(image.getToken());
        imageDto.setType(image.getType());
    }

    public String getYMD() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        return String.format("%s/%s/%s", year, month + 1, day);
    }

    public Resource load(String token) {
        try {
            Image entity = getImage(token);
            Path file = Paths.get(fileUrl).resolve(entity.getPath() + "/" + entity.getToken() + "." + entity.getType());
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Image getImage(String token) {
        return imageRepository.findByToken(token).orElseThrow(() -> new IllegalArgumentException("Image not found"));
    }

    public byte[] getImg(String token) {
        try {
            Image entity = getImage(token);
            String path = fileUrl + "/" + entity.getPath() + "/" + entity.getToken() + "." + entity.getType();

            byte[] imageInByte;
            BufferedImage originalImage;
            try {
                originalImage = ImageIO.read(new File(path));
            } catch (Exception e) {
                return new byte[0];
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ImageIO.write(originalImage, "png", baos);

            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

}
