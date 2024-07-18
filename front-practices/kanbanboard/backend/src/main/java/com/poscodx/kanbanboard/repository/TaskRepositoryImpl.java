package com.poscodx.kanbanboard.repository;

import com.poscodx.kanbanboard.vo.TaskVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final SqlSession sqlSession;
    @Override
    public List<TaskVo> getTaskByCardNo(Integer no) {
        return sqlSession.selectList("task.findByCardNo", Map.of("no",no));
    }

    @Override
    public void toggleTask(Integer no) {

        sqlSession.update("task.toggleTask",Map.of("no",no));
    }

    @Override
    public Integer insertTask(TaskVo vo) {
        return sqlSession.insert("task.insertTask",vo);
    }

    @Override
    public void deleteTask(Integer no) {
        sqlSession.delete("task.deleteTask",no);
    }
}
