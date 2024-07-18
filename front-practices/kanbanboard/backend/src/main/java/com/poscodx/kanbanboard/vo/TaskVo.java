package com.poscodx.kanbanboard.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TaskVo {
    private Integer no;
    private String name;
    private String done;
    private Integer cardNo;

}

/*

    CREATE TABLE IF NOT EXISTS `task` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `done` ENUM('Y', 'N') NOT NULL DEFAULT 'N',
  `card_no` INT NOT NULL,
  PRIMARY KEY (`no`),
  CONSTRAINT `fk_task_card`
    FOREIGN KEY (`card_no`)
    REFERENCES `card` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



 */