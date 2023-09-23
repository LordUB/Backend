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

    public New(Long id, String image, String title, String description, String info, float price) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.info = info;
        this.views = views;
        this.price = price;
    }
}
