package com.example.proyectoSpringBoot.view;

import com.example.proyectoSpringBoot.entities.Perfil;
import com.example.proyectoSpringBoot.services.PerfilService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import java.awt.*;
import org.springframework.dao.DataIntegrityViolationException;
import java.lang.NumberFormatException;

@Route("perfil")
public class PerfilView extends VerticalLayout {
    private final PerfilService perfilService;
    private Grid<Perfil> grid = new Grid<>(Perfil.class);

    public PerfilView(PerfilService perfilService) {
        this.perfilService = perfilService;

        TextField dirField = new TextField("Dirección");
        TextField tlfField = new TextField("Teléfono");
        TextField nacDate = new TextField("Fecha de nacimiento");
        Button guardarButton = new Button("Guardar perfil");

        guardarButton.addClickListener(e -> {
            try {
                if (!dirField.isEmpty() && !tlfField.isEmpty()) {

                    Long tlf = Long.parseLong(tlfField.getValue());

                    if (validarFecha(nacDate.getValue())) {

                        Perfil perfil = new Perfil(dirField.getValue(), tlf, nacDate.getValue());
                        perfilService.guardarPerfil(perfil);

                        Notification.show("Perfil guardado correctamente");

                        actualizarLista();
                        dirField.clear();
                        tlfField.clear();
                        nacDate.clear();
                    }
                }
            } catch (NumberFormatException ex) {
                Notification.show("Error: El teléfono debe ser un número válido sin letras");
                tlfField.setInvalid(true);
            } catch (DataIntegrityViolationException ex) {
                Notification.show("Error de persistencia: Los datos no cumplen las reglas de la base de datos");
            } catch(Exception ex) {
                Notification.show("Error al guardar el perfil: " + ex.getMessage());
            }
        });

        grid.addColumn(Perfil::getId).setHeader("ID");
        grid.addColumn(Perfil::getDireccion).setHeader("Dirección");
        grid.addColumn(Perfil::getTelefono).setHeader("Teléfono");
        grid.addColumn(Perfil::getFechaNacimiento).setHeader("Fecha de nacimiento");
        actualizarLista();
        add(dirField, tlfField, nacDate, guardarButton, grid);
    }

    private boolean validarFecha(String fecha) {
        return fecha != null && fecha.matches("^\\d{2}[/-]\\d{2}[/-]\\d{4}$");
    }

    private void actualizarLista() {
        grid.setItems(perfilService.obtenerPerfiles());
    }
}


