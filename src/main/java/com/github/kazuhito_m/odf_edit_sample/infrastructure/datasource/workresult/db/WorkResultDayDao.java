package com.github.kazuhito_m.odf_edit_sample.infrastructure.datasource.workresult.db;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@ConfigAutowireable
@Dao
public interface WorkResultDayDao {

    @Select
    List<WorkResultDay> selectAll();

    /**
     * 勤怠履歴データをユーザと日付で絞り込んで取得する。
     *
     * @param userId ユーザID。
     * @param from   開始日(当日含む)
     * @param to     終了日(当日含む)
     * @return 絞りこまれた履歴データ
     */
    @Select
    List<WorkResultDay> selectByUserAndDay(Integer userId, Date from, Date to);

    /**
     * 勤怠履歴データをユーザで絞り込んで取得する。
     *
     * @param userId ユーザID。
     */
    @Select
    List<WorkResultDay> selectByUser(Integer userId);

    @Insert
    @Transactional
    int insert(WorkResultDay day);

}
