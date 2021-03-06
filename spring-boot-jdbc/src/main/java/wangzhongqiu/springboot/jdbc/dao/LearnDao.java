package wangzhongqiu.springboot.jdbc.dao;

import wangzhongqiu.springboot.jdbc.domain.LearnResouce;
import wangzhongqiu.springboot.jdbc.tools.Page;

import java.util.Map;

/**
 * Created by tengj on 2017/4/8.
 */
public interface LearnDao {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String ids);
    LearnResouce queryLearnResouceById(Long id);
    Page queryLearnResouceList(Map<String, Object> params);
}
