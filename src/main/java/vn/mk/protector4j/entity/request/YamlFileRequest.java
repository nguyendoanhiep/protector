package vn.mk.protector4j.entity.request;

import lombok.Data;

@Data
public class YamlFileRequest {
    private String springBootJarFile;
    private String outputFolder;
    private String exeFileName;
    private String productName;
    private String productVersion;
}
