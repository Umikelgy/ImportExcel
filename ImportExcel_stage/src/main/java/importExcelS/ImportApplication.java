package importExcelS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/31 11:16
 */
@RestController
@SpringBootApplication
public class ImportApplication  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ImportApplication.class);
    }

    public static void main (String[] args){
        SpringApplication.run(ImportApplication.class);
    }
}
