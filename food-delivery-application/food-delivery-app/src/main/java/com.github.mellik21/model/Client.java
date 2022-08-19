package com.github.mellik21.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@Table(name = "\"client\"")
@AllArgsConstructor
public class Client {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

/*    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "client")
    List<Order> orders;*/
}
