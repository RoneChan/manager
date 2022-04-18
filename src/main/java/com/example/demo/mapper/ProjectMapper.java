package com.example.demo.mapper;

import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//与数据库交互
@Mapper
public interface ProjectMapper {

    ProjectProfile getProjectProfile(@Param("id") String id, @Param("test_system") String test_system);

    List<ProjectProfile> searchProjectList(@Param("search_type") String search_type,@Param("keyword") String keyword);

    List<ProjectProfile> getProjectList(@Param("year")int year ,@Param("startNum")String startNum, @Param("endNum")String endNum);

    ProjectProgress getProjectProgress(@Param("id") String id);

    List<String> getTesterName(@Param("id") String id, @Param("test_system") String test_system);

    List<TesterWorkload> getTesterWorkload(@Param("id") String id ,@Param("year") int year);


}
