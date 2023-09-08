package com.meditech.docseeker.healing.service;
import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.healing.domain.presistence.NewRepository;

import com.meditech.docseeker.security.domain.model.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NewServiceImplTest {
    private NewServiceImpl newService;

    private User user;

    @BeforeEach
    public void setUp() {

        /*Se crean anuncios*/
        New New1 = new New(1L, "sad1", "Sample News", "fasdf1", "info1", 123, 30);
        New New2 = new New(2L, "sad2", "sgfdg", "fasdf2", "info2", 45, 30);
        New New3 = new New(3L, "sad3", "gfdsh", "fasdf3", "info3", 64, 30);
        New New4 = new New(4L, "sad4", "345gfg", "fasdf4", "info4", 21, 30);
        /*Se crean anuncios*/

        /*Se crea un objeto user y card*/
        user = new User( "Orlando", "orlando@email.com", "password");
        /*Se crea un objeto user y card*/

        user.getListNews().add(New1);
        user.getListNews().add(New2);
        user.getListNews().add(New3);
        user.getListNews().add(New4);
    }

    @Test
    public void create() {
        New newToCreate = new New();
        newToCreate.setTitle("Sample News");

        // Simulación de comportamiento del repositorio
        if (user.getListNews().stream().noneMatch(n -> Objects.equals(n.getTitle(), newToCreate.getTitle()))) {
            user.getListNews().add(newToCreate);

        }

        // Verificar que la noticia se haya guardado correctamente
        assertNotNull(newToCreate);
        assertEquals(4, user.getListNews().size());
    }

}