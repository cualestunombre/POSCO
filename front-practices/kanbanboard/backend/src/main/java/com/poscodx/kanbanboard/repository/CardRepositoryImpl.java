package com.poscodx.kanbanboard.repository;

import com.poscodx.kanbanboard.vo.CardVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository {

    private final SqlSession sqlSession;




    @Override
    public List<CardVo> getAllCards() {
        return sqlSession.selectList("card.findAll");
    }
}
