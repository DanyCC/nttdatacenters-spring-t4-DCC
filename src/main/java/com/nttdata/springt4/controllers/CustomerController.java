package com.nttdata.springt4.controllers;

import com.nttdata.springt4.repositories.Customer;
import com.nttdata.springt4.services.CustomerManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Taller 4 - Spring
 *
 * Implementacion del controlador de clientes
 *
 * @author Daniel Alberto Cosa Cosias
 */

@Controller
@RequestMapping("/")
public class CustomerController implements CustomerControllerI {

    //Servicio que sera consumido
    @Autowired
    private CustomerManagementServiceI customerService;


    @Override
    @GetMapping("/")
    public String mainPage() {
        //Devuelve la vista de la pagina principal
        return "mainPage";
    }
    @Override
    @GetMapping("/showCustomers")
    public String showCustomers(Model allCustomersModel) {
        //Se añade un atributo de nombre clientes con la lista de todos los clientes
        allCustomersModel.addAttribute("clientes", customerService.findAll());
        //Devuelve la vista mostrando los clientes
        return "mostrarClientes";
    }

    @Override
    @GetMapping("/addCustomer")
    public String addCustomerPage(Model newCustomerModel) {
        //Se añade un atributo de nombre insertCustomer con un cliente vacio que rellenara el cliente en la vista
        newCustomerModel.addAttribute("insertCustomer", new Customer());
        //Devuelve la vista de insertarCliente
        return "insertarCliente";
    }

    @Override
    @PostMapping("/addCustomer/add")
    public String addNewClient(@ModelAttribute("insertCustomer") Customer insertCustomer) {
        //Importa el atributo insertCustomer del metodo addCustomerPage y este se inserta
        customerService.insertCustomer(insertCustomer);
        //Devuelve la vista creado
        return "creado";
    }

    @Override
    @GetMapping("/getCustomersByName")
    public String getCustomersByNamePage(Model getCustomersByNameModel) {
        //Se añade un atributo de nombre findCustomers con un string vacio que rellenara el cliente en la vista
        getCustomersByNameModel.addAttribute("findCustomers", new String());
        //Devuelve la vista buscarClientesPorNombre
        return "buscarClientesPorNombre";
    }

    @Override
    @RequestMapping(value = "/getCustomersByName/find", params = "name")
    public String getCustomersByName(@RequestParam String name, Model getCustomersByNameModel) {
        //Se añade un atributo de nombre customers con una lista de los nombres filtrados
        getCustomersByNameModel.addAttribute("customers", customerService.findByName(name));
        //Devuelve la vista mostrarClientesPorNombre
        return "mostrarClientesPorNombre";
    }
}
