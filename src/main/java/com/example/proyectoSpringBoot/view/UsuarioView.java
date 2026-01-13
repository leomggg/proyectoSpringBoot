package com.example.proyectoSpringBoot.view;

import com.example.proyectoSpringBoot.entities.Usuario;
import com.example.proyectoSpringBoot.services.UsuarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;

@Route("")
public class UsuarioView extends VerticalLayout {
    private final UsuarioService usuarioService;

    private Grid<Usuario> grid = new Grid<>();

    public UsuarioView(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

        TextField nombreField = new TextField("Nombre");
        PasswordField contrasenaField = new PasswordField("Contraseña");
        Button guardarButton = new Button("Guardar Usuario");

        guardarButton.addClickListener(e -> {
            if (!nombreField.isEmpty() && !contrasenaField.isEmpty()) {
                Usuario usuario = new Usuario(nombreField.getValue(), contrasenaField.getValue());
                usuarioService.guardarUsuario(usuario);
                Notification.show("Usuario guardado correctamente");
                actualizarLista();
                nombreField.clear();
                contrasenaField.clear();
            }
        });

        grid.addColumn(Usuario::getId).setHeader("ID");
        grid.addColumn(Usuario::getNombre).setHeader("Nombre");
        grid.addColumn(Usuario::getContrasena).setHeader("Contraseña");
        actualizarLista();
        add(nombreField, contrasenaField, guardarButton, grid);
    }

    private void actualizarLista() {
        grid.setItems(usuarioService.obtenerUsuarios());
    }
}

