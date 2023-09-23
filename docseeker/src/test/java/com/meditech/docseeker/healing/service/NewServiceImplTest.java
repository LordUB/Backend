package com.meditech.docseeker.healing.service;
import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.healing.domain.presistence.NewRepository;

import com.meditech.docseeker.security.domain.model.entity.User;
import com.meditech.docseeker.security.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NewServiceImplTest {

    UserServiceImpl _userServiceImpl;
    private ArrayList<New> ListNew;
    private User user;


    @BeforeEach
    public void setUp() {

        user = new User("Carlos23", "hola@hotmail.com", "123");


        ListNew = new ArrayList<New>(); // Inicializa la lista

        New New1 = new New(1L, "doctor-palma.png",//Iguales
                "Especialista en psiquiatria a cargo de ayudarte con tu ansiedad",
                "¿Sientes ansiedad constante? El doctor Palma está aquí para ayudarte a superar" +
                        " tus preocupaciones. Controla la ansiedad y recupera la paz mental.",
                "935465555", 123);
        New New2 = new New(2L, "doctor-lastra.jpg",
                "Especialista en depresion juvenil con el Doctor Lastra",
                "No estás solo en tu lucha contra la depresión. Con la ayuda adecuada, " +
                        "puedes volver a disfrutar de la vida. Contacta a con el psquiatra lastra " +
                        "especialistas en depresión y da el primer paso hacia la recuperación.",
                "584214543", 45);
        New New3 = new New(4L, "doctor-humboldt.jpeg",
                "El Doctor Humboldt te ayuda con tus adicciones",
                "La adicción puede ser devastadora, pero la recuperación es posible. " +
                        "Nuestros psiquiatras están especializados en el tratamiento de adicciones." +
                        " Toma el control de tu vida nuevamente.",
                "562228954", 201);

        user.getListNews().add(New1);
        user.getListNews().add(New2);
        user.getListNews().add(New3);

        _userServiceImpl = new UserServiceImpl();
    }

    @Test
    public void unsuccesfullCreate() {
        New newToCreate;
        newToCreate = new New(3L, "doctor-polo.jpeg",
                "Especialista en psiquiatria a cargo de ayudarte con tu ansiedad",
                "¿La ansiedad está afectando tu calidad de vida? ¡No estás solo! el" +
                        "psquiatra polo especialista en trastornos de ansiedad está aquí para " +
                        "ayudarte a recuperar el control y encontrar la tranquilidad que mereces.",
                "236471592", 64);


        boolean resultado = _userServiceImpl.createNew(newToCreate, user);

        // Verificar que la noticia se haya guardado correctamente
        assertEquals(false, resultado);
    }

    @Test
    public void succesfullCreate() {
        New newToCreate2;
        newToCreate2 = new New(3L, "doctor-polo.jpeg",
                "Especialista en medicina general para ansianos",
                "¿La ansiedad está afectando tu calidad de vida? ¡No estás solo! el" +
                        "psquiatra polo especialista en trastornos de ansiedad está aquí para " +
                        "ayudarte a recuperar el control y encontrar la tranquilidad que mereces.",
                "236471592", 64);


        boolean resultado = _userServiceImpl.createNew(newToCreate2, user);

        // Verificar que la noticia se haya guardado correctamente
        assertEquals(true, resultado);
    }

}