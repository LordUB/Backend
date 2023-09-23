package com.meditech.docseeker.healing.domain.model.entity;

import com.meditech.docseeker.security.domain.model.entity.User;
import com.meditech.docseeker.shared.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class Reservation extends AuditModel {


    private String date;

    private String time;

    private New aNew;


    public Reservation(String date, String time, New aNew) {
        this.date = date;
        this.time = time;
        this.aNew = aNew;
    }
}
