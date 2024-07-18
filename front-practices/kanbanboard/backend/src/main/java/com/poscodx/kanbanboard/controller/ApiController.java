package com.poscodx.kanbanboard.controller;

import com.poscodx.kanbanboard.dto.JsonResult;
import com.poscodx.kanbanboard.repository.CardRepository;
import com.poscodx.kanbanboard.repository.TaskRepository;
import com.poscodx.kanbanboard.service.TaskService;
import com.poscodx.kanbanboard.vo.TaskVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final CardRepository cardRepository;

    private final TaskRepository taskRepository;

    private final TaskService taskService;

    @GetMapping("/cards")
    public JsonResult getAllCards(){
        return JsonResult.success(cardRepository.getAllCards());
    }

    @GetMapping("/tasks")
    public JsonResult findTaskByCardNo(@RequestParam Integer cardNo){
        return JsonResult.success(taskRepository.getTaskByCardNo(cardNo));
    }

    @PostMapping("/checkbox")
    public JsonResult toggleTask(@RequestBody TaskVo task){
       taskRepository.toggleTask(task.getNo());
       return JsonResult.success("success");
    }

    @PostMapping("/task")
    public JsonResult insertTask(@RequestBody TaskVo task){
        taskService.insertTask(task);
        return JsonResult.success(task);

    }

    @DeleteMapping("/task")
    public JsonResult deleteTask(@RequestParam Integer no){
        taskRepository.deleteTask(no);
        return JsonResult.success("success");

    }
}
