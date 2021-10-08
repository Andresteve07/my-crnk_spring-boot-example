package com.example.helloworldproj;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@EnableAutoConfiguration
@ComponentScan("com.example.helloworldproj")
@Import(TestDataLoader.class)
//@EnableConfigurationProperties(ExampleProperties.class)
public class HelloworldprojConfigurator {
}
