package com.meditech.docseeker.healing.service;
import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.healing.domain.presistence.NewRepository;

import com.meditech.docseeker.security.domain.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationServiceImplTest {

    private ArrayList<New> ListNew;

    private ReservationServiceImpl reservationService;
    private New New1;
    private New New2;
    private New New3;
    private New New4;

    @BeforeEach
    public void setUp() {
        ListNew = new ArrayList<New>(); // Inicializa la lista

        New1 = new New(1L, "sad1", "Sample News", "fasdf1", "info1", 123);
        New2 = new New(2L, "sad2", "sgfdg", "fasdf2", "info2", 45);
        New3 = new New(3L, "sad3", "gfdsh", "fasdf3", "info3", 64);
        New4 = new New(4L, "sad4", "345gfg", "fasdf4", "info4", 21);

        ListNew.add(New1);
        ListNew.add(New2);
        ListNew.add(New3);
        ListNew.add(New4);

        reservationService = new ReservationServiceImpl();
    }
    @Test
    public void create() {
        User user = new User( "Orlando", "orlando@email.com", "password");
        if(user.getList_reservation().isEmpty()){
            reservationService.create_reservation(11545L, "nas", "sdsd",New1, user);
        }

        // Verificar que la noticia se haya guardado correctamente
        assertNotNull(user.getList_reservation());
        assertEquals(1, user.getList_reservation().size());
    }

}