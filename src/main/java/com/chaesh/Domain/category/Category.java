package com.chaesh.Domain.category;

import com.chaesh.Domain.member.Member;
import com.chaesh.Domain.toDo.ToDo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private Enum categoryType;

    private Long countByToDo;

    private Long successCount;
}
