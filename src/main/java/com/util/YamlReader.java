package com.util;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlReader {

	Yaml yaml = new Yaml();
	InputStream inS = this.getClass()
			.getClassLoader().getResourceAsStream("const.yaml");
	Map<String, Object> obj = yaml.load(inS);
}
