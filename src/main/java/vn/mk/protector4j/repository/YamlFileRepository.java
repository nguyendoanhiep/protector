package vn.mk.protector4j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.mk.protector4j.entity.YamlFileEntity;

public interface YamlFileRepository extends JpaRepository<YamlFileEntity,Long> {
}
