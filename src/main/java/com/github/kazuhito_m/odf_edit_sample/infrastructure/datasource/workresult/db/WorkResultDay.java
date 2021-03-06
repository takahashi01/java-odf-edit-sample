package com.github.kazuhito_m.odf_edit_sample.infrastructure.datasource.workresult.db;

import com.github.kazuhito_m.odf_edit_sample.infrastructure.fw.util.DateUtils;
import org.seasar.doma.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
public class WorkResultDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "result_date")
    Date resultDate;

    @Column(name = "start_time")
    Time startTime;

    @Column(name = "end_time")
    Time endTime;

    @Column(name = "break_hour")
    BigDecimal breakHour;

    @Column(name = "description")
    String description;

    public com.github.kazuhito_m.odf_edit_sample.domain.workresult.WorkResultDay toDomain() {
        return new com.github.kazuhito_m.odf_edit_sample.domain.workresult.WorkResultDay(
                id,
                userId,
                // 9時間ズレ的なおかしなことになるので、日付整え処理。
                DateUtils.timeTruncate(resultDate),
                startTime,
                endTime,
                breakHour,
                description
        );
    }

}
