package com.poscodx.kanbanboard.controller;

import com.poscodx.kanbanboard.dto.JsonResult;
import com.poscodx.kanbanboard.service.KanbanService;
import com.poscodx.kanbanboard.vo.TaskVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final KanbanService kanbanService;

    @GetMapping("/cards")
    public JsonResult getAllCards(){
        return JsonResult.success(kanbanService.getAllCards());
    }

    @GetMapping("/tasks")
    public JsonResult findTaskByCardNo(@RequestParam Integer cardNo){
        return JsonResult.success(kanbanService.getTaskByCardNo(cardNo));
    }

    @PostMapping("/checkbox")
    public JsonResult toggleTask(@RequestBody TaskVo task){
        kanbanService.toggleTask(task.getNo());
       return JsonResult.success("success");
    }

    @PostMapping("/task")
    public JsonResult insertTask(@RequestBody TaskVo task){
        kanbanService.insertTask(task);
        return JsonResult.success(task);

    }

    @DeleteMapping("/task")
    public JsonResult deleteTask(@RequestParam Integer no){
        kanbanService.deleteTask(no);
        return JsonResult.success("success");

    }
}
