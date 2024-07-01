package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    //@NotEmpty : DTO 활용할것
    private String name;

    @Embedded
    private Address address;

    //@JsonIgnore : DTO 활용할것, 하나의 엔티티로 다양한 api가 개발되므로 화면에 종속적이면 안된다.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
