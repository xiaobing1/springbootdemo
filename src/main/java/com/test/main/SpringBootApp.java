package com.test.main;

import com.test.domain.Category;
import com.test.linecommand.RunLine;
import com.test.properties.MysqlProperties;
import com.test.service.CategoryService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaobin.wang
 * @date 2018/3/15
 */
@SpringBootApplication(scanBasePackages = {"com"})
@Controller
@RequestMapping("start")
@MapperScan("com.test.mapper")
@EnableConfigurationProperties(MysqlProperties.class)
public class SpringBootApp {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MysqlProperties mysqlProperties;

    @ResponseBody
    @RequestMapping("hello")
    public Map hello() {
        Map map = new HashMap();
        map.put("root", "hello world");
        return map;
    }

    @ResponseBody
    @RequestMapping("find")
    public Map find() {
        Map map = new HashMap();
        map.put("list", categoryService.findAll());
        map.put("props", mysqlProperties);
        return map;
    }

    @ResponseBody
    @RequestMapping("findById")
    public Category findById(@RequestParam("id") Integer id) {
        return categoryService.findById(id);
    }

    @Bean
    public CommandLineRunner get() {
        return new RunLine();
    }

    @ResponseBody
    @RequestMapping("file")
    public Map upload(MultipartFile file) throws IOException {
        Map map = new HashMap();
        if (file != null) {
            file.transferTo(new File("D://demo.txt"));
            map.put("isSuccess", true);
        } else {
            map.put("isSuccess", false);
        }
        return map;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
