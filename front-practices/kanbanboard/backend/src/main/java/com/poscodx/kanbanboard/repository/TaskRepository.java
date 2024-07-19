package com.poscodx.kanbanboard.repository;

import com.poscodx.kanbanboard.vo.TaskVo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TaskRepository {

    List<TaskVo> getTaskByCardNo(Integer no);

    void toggleTask(Integer no);

    Integer insertTask(TaskVo vo);

    void deleteTask(Integer no);
}
