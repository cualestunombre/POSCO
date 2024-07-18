package com.poscodx.kanbanboard.service;

import com.poscodx.kanbanboard.repository.TaskRepository;
import com.poscodx.kanbanboard.vo.TaskVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class TaskService {
    private final TaskRepository taskRepository;


    @Transactional
    public int insertTask(TaskVo vo){
        return taskRepository.insertTask(vo);
    }
}
