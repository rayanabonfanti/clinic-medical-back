package com.clinical.medical.crud.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LOGS")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private int logId;

    @Column(name = "TABLE_NAME", nullable = false)
    private String tableName;

    @Column(name = "ACTION_TYPE", nullable = false)
    private String actionType;

    @Column(name = "OLD_VALUE")
    private String oldValue;

    @Column(name = "NEW_VALUE")
    private String newValue;

    @Column(name = "OBSERVATION")
    private String observation;

    @Column(name = "USER_INFO", nullable = false)
    private String userInfo;

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="CREATED_TIME")
    private Date creationTime;
}
