package generatorXml.mybatis.dao;

import generatorXml.mybatis.entity.webSites;

public interface webSitesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(webSites record);

    int insertSelective(webSites record);

    webSites selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(webSites record);

    int updateByPrimaryKey(webSites record);
}