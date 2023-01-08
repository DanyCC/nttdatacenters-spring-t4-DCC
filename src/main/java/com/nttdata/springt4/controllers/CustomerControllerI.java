package com.nttdata.springt4.controllers;

import com.nttdata.springt4.repositories.Customer;
import org.springframework.ui.Model;

/**
 * Taller 4 - Spring
 *
 * Interfaz del controlador de clientes
 *
 * @author Daniel Alberto Cosa Cosias
 */

public interface CustomerControllerI {

    /**
     * Recibe la peticion y muestra la pagina principal
     *
     * @return String
     */
    public String mainPage();

    /**
     * Recibe la peticion y muestra los clientes
     *
     * @return String
     * @param
     */
    public String showCustomers(Model allCustomersModel);

    /**
     * Recibe la peticion y muestra la pagina para insertar clientes
     *
     * @return String
     * @param
     */
    public String addCustomerPage(Model newCustomerModel);

    /**
     * Recibe la peticion e inserta un nuevo cliente
     *
     * @return String
     */
    public String addNewClient(Customer insertCustomer);

    /**
     * Recibe la peticion y muestra la pagina buscar clientes por sus nombres
     *
     * @return String
     * @param
     */
    public String getCustomersByNamePage(Model getCustomersByNameModel);

    /**
     * Recibe la peticion y muestra los clientes por nombre
     *
     * @return String
     * @param
     */
    public String getCustomersByName(String name, Model getCustomersByNameModel);
}
