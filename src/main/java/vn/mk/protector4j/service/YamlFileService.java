package vn.mk.protector4j.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.mk.protector4j.entity.YamlFileEntity;
import vn.mk.protector4j.entity.request.YamlFileRequest;


public interface YamlFileService {
    Page<YamlFileEntity> get(Pageable pageable);
    byte[] save(YamlFileRequest request);

}
