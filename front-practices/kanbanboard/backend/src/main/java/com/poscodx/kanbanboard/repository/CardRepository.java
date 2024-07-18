package com.poscodx.kanbanboard.repository;

import com.poscodx.kanbanboard.vo.CardVo;

import java.util.List;

public interface CardRepository {
    List<CardVo> getAllCards();
}
