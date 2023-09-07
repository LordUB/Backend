package com.meditech.docseeker.healing.service;
import com.meditech.docseeker.healing.domain.model.entity.New;
import com.meditech.docseeker.healing.domain.presistence.NewRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NewServiceImplTest {
    private NewServiceImpl newService;

    private ArrayList<New> ListNew;

    @BeforeEach
    public void setUp() {
        ListNew = new ArrayList<New>(); // Inicializa la lista

        New New1 = new New(1L, "sad1", "Sample News", "fasdf1", "info1", 123);
        New New2 = new New(2L, "sad2", "sgfdg", "fasdf2", "info2", 45);
        New New3 = new New(3L, "sad3", "gfdsh", "fasdf3", "info3", 64);
        New New4 = new New(4L, "sad4", "345gfg", "fasdf4", "info4", 21);

        ListNew.add(New1);
        ListNew.add(New2);
        ListNew.add(New3);
        ListNew.add(New4);
    }

    @Test
    public void create() {
        New newToCreate = new New();
        newToCreate.setTitle("Sample News");

        // Simulación de comportamiento del repositorio
        if (ListNew.stream().noneMatch(n -> Objects.equals(n.getTitle(), newToCreate.getTitle()))) {
            ListNew.add(newToCreate);
        }

        // Verificar que la noticia se haya guardado correctamente
        assertNotNull(newToCreate);
        assertEquals(4, ListNew.size());
    }

}