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

        ListNew.add(New1);
        ListNew.add(New2);
        ListNew.add(New3);

    }
    public boolean sonTitulosDistintos(ArrayList<New> lista) {
        int n = lista.size();

        // Crear un ArrayList auxiliar para almacenar los títulos únicos
        ArrayList<String> titulosUnicos = new ArrayList<>();

        for (New item : lista) {
            if (titulosUnicos.contains(item.getTitle())) {
                // Si el título ya existe en el ArrayList de títulos únicos, devuelve false
                return false;
            }
            titulosUnicos.add(item.getTitle());
        }

        // Si no se encontraron títulos iguales, devuelve true
        return true;
    }

    @Test
    public void create() {
        New newToCreate;
        newToCreate = new New(3L, "doctor-polo.jpeg",
                "Especialista en psiquiatria a cargo de ayudarte con tu ansiedad",
                "¿La ansiedad está afectando tu calidad de vida? ¡No estás solo! el" +
                        "psquiatra polo especialista en trastornos de ansiedad está aquí para " +
                        "ayudarte a recuperar el control y encontrar la tranquilidad que mereces.",
                "236471592", 64);

        ListNew.add(newToCreate);

        boolean resultado = sonTitulosDistintos(ListNew);

        // Verificar que la noticia se haya guardado correctamente
        assertEquals(false, resultado);
    }

}