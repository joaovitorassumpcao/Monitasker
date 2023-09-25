package com.monitasker.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_tasks")
public class Task extends AbstractEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "is_done", nullable = false)
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean isDone = false;

    @Column(name = "content")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String content;

}