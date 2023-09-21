package com.meditech.docseeker.healing.domain.model.entity;


import com.meditech.docseeker.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="news")
public class New extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="image")
    private String image;

    @Column(name = "title")
    private String title;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "info")
    private String info;

    @Column(name = "views")
    private Integer views;

    private float price;

    public New(long id, String image, String title, String descripcion, String info, int views) {
        super();
    }
}
