package com.meditech.docseeker.healing.service;

import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.healing.domain.model.entity.Reservation;
import com.meditech.docseeker.healing.domain.service.ReservationService;
import com.meditech.docseeker.security.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ReservationServiceImpl implements ReservationService {

    @Override
    public Page<New> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public New getById(Long newId) {
        return null;
    }

    @Override
    public List<New> getAll() {
        return null;
    }

    @Override
    public boolean create_reservation(String date, String time,New aNew, User user) {
        Reservation reservation = new Reservation(date, time, aNew);

        if (user.getList_reservation().stream().noneMatch(n-> Objects.equals(n.getDate(), reservation.getDate()))){
            user.getList_reservation().add(reservation);
            return true;
        }
        return false;
    }

    @Override
    public New update(Long newId, New request) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long newId) {
        return null;
    }
}
