package com.hns2t.QuanLyQuanNhau_server.config;

import java.nio.file.Paths;
import java.nio.file.Path;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		exposeDirectory("assets", registry);
	}

	private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get(dirName);
		String uploadPath = uploadDir.toFile().getAbsolutePath();

		if (dirName.startsWith("../"))
			dirName = dirName.replace("../", "");

		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
	}
}
