package com.service;

import com.dto.ProjectList;
import com.pojo.Project;
import java.util.List;

/**
 * Created by chen on 2017/8/29.
 */
public interface ProjectService {
    /**
     * 增加一个新的项目
     * @param project 项目实体类
     * @return 返回0代表失败，1代表成功
     */
    Project addProject(Project project, List<Integer> uId);

    /**
     * 删除一个项目
     * @param project 根据什么来删除 （0代表ID，1代表项目名）
     * @return 返回0代表失败 1代表成功
     */
    int deleteProject(Project project);

    /**
     * 更新一个项目
     * @param project 项目实体类
     * @return
     */
    int updateProject(Project project);

    /**
     * 查找一个项目
     * @param project 项目实体类
     * @param i 根据什么来查找 （0代表ID，1代表项目名）
     * @return 返回0代表失败，1代表成功
     */
    List<Project> selectProject(Project project, int i);


    /**
     * 根据个人表对项目表进行遍历
     * @return
     */
    List<Project> QueryList(int tId);

    /**
     * 将一个项目的相关信息全部遍历出来
     */
     Project projectALL(int pId, int uId);
}
