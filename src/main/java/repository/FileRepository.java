package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
