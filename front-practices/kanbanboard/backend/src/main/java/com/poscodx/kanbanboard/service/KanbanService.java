package com.poscodx.kanbanboard.service;

import com.poscodx.kanbanboard.vo.CardVo;
import com.poscodx.kanbanboard.vo.TaskVo;

import java.util.List;

public interface KanbanService {
    void insertTask(TaskVo taskVo);

    void deleteTask(Integer taskNo);

    void toggleTask(Integer taskNo);

    List<TaskVo> getTaskByCardNo(Integer no);

    List<CardVo> getAllCards();
}
