package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import service.FileService;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.uploadFile(file);
        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Object> downloadFile(@PathVariable Long fileId) {
        // Retrieve the file entity from the database
        return fileService.getFile(fileId)
                .map(fileEntity -> ResponseEntity.ok().header("Content-Disposition", "attachment; filename=" + fileEntity.getFileName())
                        .body(null/* Retrieve file content as byte array */))
                .orElse(ResponseEntity.notFound().build());
    }
}
