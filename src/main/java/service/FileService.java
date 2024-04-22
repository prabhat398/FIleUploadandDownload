package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import entity.FileEntity;
import repository.FileRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public void uploadFile(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        // Save the file metadata to the database
        fileRepository.save(fileEntity);
        // Save the file content to a directory
        // You can use FileUtils or any other utility to handle file saving
        // For simplicity, we're not covering the file content saving logic here
    }

    public Optional<FileEntity> getFile(Long fileId) {
        return fileRepository.findById(fileId);
    }
}

