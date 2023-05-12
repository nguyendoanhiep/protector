package vn.mk.protector4j.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "YAML_FILE")
public class YamlFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Lob
    @Column(name = "YAML_CONTENT")
    private byte[] yamlContent;
}
