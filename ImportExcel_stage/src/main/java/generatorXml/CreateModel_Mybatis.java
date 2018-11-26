package generatorXml;

import generotor.GenMain;
import generotor.Model;
import generotor.UpdateJdbc;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.*;
import java.sql.*;
import java.util.*;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/11/16 15:58
 */
public class CreateModel_Mybatis {
    public static void main(String []args) throws Exception {
        Map<String,String> map=getMaps();
        UpdateJdbc jdbc=new UpdateJdbc();
        String path=System.getProperty("user.dir")+"\\ImportExcel_stage\\src\\main\\resources\\jdbc.properties";
        Model model=jdbc.initModel(map);

        String str_AllTar=System.getProperty("user.dir")+"\\ImportExcel_stage\\src\\main\\java";
        str_AllTar=new CreateModel_Mybatis().ChangeIt(str_AllTar);

        model.setAllTargeProject(str_AllTar);
        //  jdbc.CreateJdbc(model,path);
        new CreateModel_Mybatis().createM();
    }

    private  String ChangeIt(String str_allTar) {//修改“\"成"/"
        String result=str_allTar.replace('\\','/');
        return result;
    }

    private static Map<String, String> getMaps() {
        Map<String ,String>result=new HashMap<>();
        result.put("u","jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useSSL=false");
        result.put("uN","root");
        result.put("p","1234xy");
        result.put("t","websites");
        result.put("mN","webSites");

        result.put("nT","generatorXml.mybatis.entity");
        result.put("mT","generatorXml.mybatis.mapper");
        result.put("dT","generatorXml.mybatis.dao");
        return result;
    }
    private void createM(){
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //如果这里出现空指针，直接写绝对路径即可。
        String genCfg = "/mbgConfiguration.xml";
        InputStream is=GenMain.class.getResourceAsStream(genCfg);
        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = null;
        try {
            config = cp.parseConfiguration(is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test() throws Exception {
        Properties properties=new Properties();
        InputStream is=this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);
        String driver=properties.getProperty("jdbc.driver");
        String url=properties.getProperty("jdbc.url");
        String userName=properties.getProperty("jdbc.userName");
        String passwd=properties.getProperty("jdbc.passwd");
        String table=properties.getProperty("jdbc.table");
        Class.forName(driver);

        Connection connection= DriverManager.getConnection(url,userName,passwd);
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery("select * from "+table);
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        stmt.close();
        connection.close();
        is.close();
//        Class.forName("${jdbc.driver}");

    }
    @Test
    public void Test1() throws IOException {
        Properties properties=new Properties();
        InputStream is=this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);
        String str_AllTar=System.getProperty("user.dir")+"\\ImportExcel_stage\\src\\main\\java";
        System.out.println(new CreateModel_Mybatis().ChangeIt(str_AllTar));
        System.out.println(properties.getProperty("jdbc.AllTargeProject"));
    }

}
