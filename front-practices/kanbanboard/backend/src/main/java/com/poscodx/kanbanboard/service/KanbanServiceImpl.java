package com.poscodx.kanbanboard.service;

import com.poscodx.kanbanboard.repository.CardRepository;
import com.poscodx.kanbanboard.repository.TaskRepository;
import com.poscodx.kanbanboard.vo.CardVo;
import com.poscodx.kanbanboard.vo.TaskVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class KanbanServiceImpl implements KanbanService {
    private final TaskRepository taskRepository;

    private final CardRepository cardRepository;

    @Override
    public void insertTask(TaskVo vo){
        taskRepository.insertTask(vo);
    }

    @Override
    public void deleteTask(Integer taskNo) {
        taskRepository.deleteTask(taskNo);
    }

    @Override
    public void toggleTask(Integer taskNo){
        taskRepository.toggleTask(taskNo);
    }

    @Override
    public List<TaskVo> getTaskByCardNo(Integer no) {
        return taskRepository.getTaskByCardNo(no);
    }

    @Override
    public List<CardVo> getAllCards() {
        return cardRepository.getAllCards();
    }


}
