package com.meditech.docseeker.healing.service;
import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.healing.domain.model.entity.Reservation;
import com.meditech.docseeker.healing.domain.presistence.NewRepository;

import com.meditech.docseeker.security.domain.model.entity.CreditCard;
import com.meditech.docseeker.security.domain.model.entity.User;
import com.meditech.docseeker.security.service.UserServiceImpl;
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

    private User user;

    private UserServiceImpl userService;

    private CreditCard card;

    @BeforeEach
    public void setUp() {
        /*Se crean anuncios*/
        New1 = new New(1L, "sad1", "Sample News", "fasdf1", "info1", 123, 50);
        New2 = new New(2L, "sad2", "sgfdg", "fasdf2", "info2", 45, 80);
        New3 = new New(3L, "sad3", "gfdsh", "fasdf3", "info3", 64, 45);
        New4 = new New(4L, "sad4", "345gfg", "fasdf4", "info4", 21, 72);
        /*Se crean anuncios*/

        /*Se crea un objeto user y card*/
        user = new User( "Orlando", "orlando@email.com", "password");
        card = new CreditCard(5, 20);
        /*Se crea un objeto user y card*/

        /*Se instancian los servicios*/
        reservationService = new ReservationServiceImpl();
        userService = new UserServiceImpl();
        /*Se instancian los servicios*/

        /*Se guarda una reserva en la lista reservas del usuario*/
        user.getList_reservation().add(new Reservation(154L, "7/09/2023", "7:30", New1));
        /*Se guarda una reserva en la lista reservas del usuario*/
    }

    @Test
    public void reservation () {
        if(userService.payment(card,New1)){
            reservationService.create_reservation(11545L, "7/09/2023", "2:30",New1, user);
        }
        assertEquals(2, user.getList_reservation().size());
    }

}