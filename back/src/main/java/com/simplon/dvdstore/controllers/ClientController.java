package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.services.ClientService;
import com.simplon.dvdstore.services.ClientServiceModel;
import com.simplon.dvdstore.utils.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Client controller.
 */
@RestController
@RequestMapping("client")
public class ClientController {

    /**
     * The Client mapper.
     */
    ClientMapper clientMapper = ClientMapper.INSTANCE;
    @Autowired
    private ClientService clientService;

    /**
     * Add client.
     *
     * @param clientDTO the client dto
     */
    @PostMapping
    public void addClient(@RequestBody com.simplon.dvdstore.controllers.ClientDTO clientDTO) {
        clientService.add(clientMapper.clientDTOToClientServiceModel(clientDTO), null);
    }


    /**
     * Add all clients.
     *
     * @param clientDTOs the client dt os
     */
    @PostMapping("/bulk")
    public void addAllClients(@RequestBody List<com.simplon.dvdstore.controllers.ClientDTO> clientDTOs) {
        List<ClientServiceModel> clientServiceModels = new ArrayList<>();
        for (com.simplon.dvdstore.controllers.ClientDTO clientDTO : clientDTOs) {
            ClientServiceModel clientServiceModel =
                    clientMapper.clientDTOToClientServiceModel(clientDTO);
            clientServiceModels.add(clientServiceModel);
        }
        clientService.addAll(clientServiceModels, null);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<com.simplon.dvdstore.controllers.ClientDTO> findAll() {
        return clientMapper.listClientServiceModelToClientDTO(clientService.findAll());
    }

    /**
     * Update client.
     *
     * @param id        the id
     * @param ClientDTO the client dto
     */
    @PutMapping("/{id}")
    public void updateClient(@PathVariable("id") long id, @RequestBody com.simplon.dvdstore.controllers.ClientDTO ClientDTO) {
        clientService.add(clientMapper.clientDTOToClientServiceModel(ClientDTO), id);
    }

    /**
     * Delete client boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteClient(@PathVariable("id") long id) {
        return clientService.delete(id);
    }

}



