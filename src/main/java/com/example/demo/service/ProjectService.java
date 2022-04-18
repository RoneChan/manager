package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.mapper.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务逻辑层，操作数据
@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public ProjectProfile getProjectProfile(String id,String test_system){
        ProjectProfile  projectProfile= projectMapper.getProjectProfile(id,test_system);
        return projectProfile;
    }


    public List<ProjectProfile> searchProjectList(int search_type, String keyword){
        List<ProjectProfile>  list = null;
        /*
        search_type:
        0:根据编号查询
        1：根据项目名字查询
        2：根据年份查询
        3：根据项目类型查询
        4：根据测试经理查询
         */
        switch (search_type){
            case 0:
                list= projectMapper.searchProjectList("id",keyword);
                break;
            case 1:
                list= projectMapper.searchProjectList("name",keyword);
                break;
            case 2:
                list= projectMapper.searchProjectList("year",keyword);
                break;
            case 3:
                list= projectMapper.searchProjectList("project_type",keyword);
                break;
            case 4:
                list= projectMapper.searchProjectList("manager",keyword);
            default:
                list = null;
                break;
        }
        return list;
    }

    public List<ProjectProfile> getProjectList(int year , String startNum,String endNum){
        List<ProjectProfile>  list= projectMapper.getProjectList(year,startNum, endNum);
        return list;
    }

    public ProjectProgress getProjectProgress(String id){
        ProjectProgress  projectProgress= projectMapper.getProjectProgress(id);
        return projectProgress;
    }

    public List<String> getTesterName(String id,String test_system){
        List<String>  nameList= projectMapper.getTesterName(id,test_system);
        return nameList;
    }

    public List<TesterWorkload> getTesterWorkload(String id, int year){
        List<TesterWorkload> testerWorkloadList=projectMapper.getTesterWorkload(id,year);
        return testerWorkloadList;
    }

}
