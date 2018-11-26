package importExcelS.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/10/31 15:05
 */
//@Configuration
public class WebJSPConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger=Logger.getLogger(WebJSPConfig.class);
    /**
     * 多模块的jsp访问，默认是src/main/webapp，但是多模块的目录只设置yml文件或propeerties文件不行
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        logger.info("WEB-INF/jsp/****");
        return viewResolver;
    }

    /** 指定默认文件的地址，jsp页面引入js和css的时候就不用管项目路径了 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/");
        super.addResourceHandlers(registry);
    }
}
