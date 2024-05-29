package com.emergentes.controller;

import com.emergentes.Contacto;
import com.emergentes.bean.BeanContacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diman
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Estamos dentro del GET");
        System.out.println("Mostramos el registro");
        mostrar();
        System.out.println("Eliminamos el registro 3");
        eliminar();
        System.out.println("Eliminado con exito");
        System.out.println("Mostramos el registro");
        mostrar();
        System.out.println("Editamos el registro 2");
        editar();
        System.out.println("Editado con exito");
        System.out.println("Mostramos el registro");
        mostrar();
        System.out.println("Agregamos un nuevo registro");
        nuevo();
        System.out.println("Nuevo registro agregado con exito");
        System.out.println("Mostramos el registro");
        mostrar();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void eliminar() {
        BeanContacto dao = new BeanContacto();
        dao.eliminar(3);
    }

    private void editar() {
        BeanContacto dao = new BeanContacto();
        Contacto c = dao.buscar(2);
        c.setNombre("Rodrigo Mamani Mamani");
        c.setTelefono("11223344");
        dao.editar(c);
    }

    private void nuevo() {
        Contacto c = new Contacto();
        c.setNombre("Maria Antonieta");
        c.setTelefono("11223311");
        c.setCorreo("maria@gmail.com");

        BeanContacto dao = new BeanContacto();
        dao.insertar(c);
    }

    private void mostrar() {
        BeanContacto dao = new BeanContacto();
        List<Contacto> lista = dao.listarTodos();
        for (Contacto item : lista) {
            System.out.println("----------------------------");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Telefono: " + item.getTelefono());
            System.out.println("Correo: " + item.getCorreo());
            System.out.println("----------------------------");
        }
    }

}
