package importExcelS.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/20 11:05
 */
@Configuration
@AutoConfigureAfter(MybatisTableConfig.class)
public class MybatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer()throws Exception{
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("importExcelS.mapper.*;com.gitee.sunchenbin.mybatis.actable.dao.*");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
