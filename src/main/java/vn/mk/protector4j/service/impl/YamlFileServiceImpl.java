package vn.mk.protector4j.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import vn.mk.protector4j.entity.YamlFileEntity;
import vn.mk.protector4j.entity.request.YamlFileRequest;
import vn.mk.protector4j.repository.YamlFileRepository;
import vn.mk.protector4j.service.YamlFileService;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
@Service
public class YamlFileServiceImpl implements YamlFileService {

    @Autowired
    YamlFileRepository yamlFileRepository;

    @Override
    public Page<YamlFileEntity> get(Pageable pageable) {
        return yamlFileRepository.findAll(pageable);
    }

    @Override
    public byte[] save(YamlFileRequest request) {
        Map<String, Object> yamlValues = new HashMap<>();
        yamlValues.put("springBootJarFile", request.getSpringBootJarFile());
        yamlValues.put("outputFolder", request.getOutputFolder());
        yamlValues.put("exeFileName", request.getExeFileName());
        yamlValues.put("productName", request.getProductName());
        yamlValues.put("productVersion", request.getProductVersion());

        DumperOptions options = new DumperOptions();
        options.setPrettyFlow(true);

        try {
            Yaml yaml = new Yaml(options);
            String yamlString = yaml.dump(yamlValues);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);

            writer.write(yamlString);
            writer.flush();
            byte[] yamlBytes = outputStream.toByteArray();
            YamlFileEntity yamlFileEntity = new YamlFileEntity();
            yamlFileEntity.setYamlContent(yamlBytes);
            yamlFileRepository.save(yamlFileEntity);
            return yamlBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
