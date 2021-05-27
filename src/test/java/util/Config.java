package util;

import java.io.File;
import java.io.IOException;

public class Config {

    private Config() {
    }

    private static Config conf;
    private static PropertiesUtil propertiesUtil;
    private static String pathToDriver;
    private static String url;
    private static ConfigParams params;
    private static YamlFileMapper yaml = new YamlFileMapper();
    private static File configFile;

    public static synchronized Config getInstance() {
        if (conf == null) {
            conf = new Config();
        }
        return conf;
    }

    public void setConfig(String[]args) throws IOException {

        //@TODO move /resources to target jar, update pom file (add plugin)
        configFile =  new File(ClassLoader.getSystemClassLoader().getResource("config").getFile());

        // to run via Environment variables
        // java -Durl=prod_url -jar automation-procamp2021-1.0-SNAPSHOT-tests.jar
        if (System.getProperty("url")!=null &&System.getProperty("driver")!=null){
            url = propertiesUtil.get("config.properties", System.getProperty("url"));
            pathToDriver = propertiesUtil.get("config.properties", System.getProperty("driver"));
        }

        // to run with external yaml config file from command line
        // example: java -jar automation-procamp2021-1.0-SNAPSHOT-tests.jar config.yaml
        // args[0] - config .yaml file
        else if (args.length > 0) {
            params = yaml.readYaml(args[0]);
        }

        // to run with local config settings
        else if (configFile.exists()){
            params = yaml.readYaml(configFile.getPath());
        }

        // to run with custom settings
        else {
            params.setUrl("prod_url");
            params.setBrowser("chrome");
        }

        propertiesUtil = PropertiesUtil.getInstance();
        url = propertiesUtil.get("config.properties", params.getUrl());
        pathToDriver = propertiesUtil.get("config.properties", params.getBrowser());
        System.setProperty("url", url);
        System.setProperty("webdriver.chrome.driver", pathToDriver);

    }
    }

