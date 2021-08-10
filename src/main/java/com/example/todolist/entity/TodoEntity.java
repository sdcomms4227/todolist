package com.example.todolist.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "TODO")
@Setter
@Getter
@NoArgsConstructor
@Entity
public class TodoEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String content;

    @Column
    private String doneYn;

    @Column
    private String deleteYn;

    @Builder
    public TodoEntity(String content, String doneYn, String deleteYn){
        this.content = content;
        this.doneYn = doneYn;
        this.deleteYn = deleteYn;
    }
}
