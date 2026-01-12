package com.example.proyectoSpringBoot.view;

import com.example.proyectoSpringBoot.entities.Perfil;
import com.example.proyectoSpringBoot.services.PerfilService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("perfil")
public class PerfilView extends VerticalLayout {
    private final PerfilService perfilService;
    private Grid<Perfil> grid = new Grid<>(Perfil.class);

    public PerfilView(PerfilService perfilService) {
        this.perfilService = perfilService;


    }

}
