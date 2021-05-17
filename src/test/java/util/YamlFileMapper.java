package util;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class YamlFileMapper {

    public static ConfigParams readYaml(String fileName) throws IOException {
        org.yaml.snakeyaml.Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream(fileName);
        return yaml.loadAs(inputStream, ConfigParams.class);

    }
}
