package com.meditech.docseeker.healing.domain.service;

import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.security.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    Page<New> getAll(Pageable pageable);

    New getById(Long newId);

    List<New> getAll();
    void create_reservation(Long id, String date, String time, New aNew, User user);

    New update(Long newId, New request);

    ResponseEntity<?> delete(Long newId);
}
