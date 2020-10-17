package br.com.tdgrocha.service;

import br.com.tdgrocha.pojos.ClientIn;
import br.com.tdgrocha.pojos.ClientOut;
import br.com.tdgrocha.entities.Client;
import br.com.tdgrocha.repositories.ClientRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientService {

    public void save(ClientIn in) {
        try {
            ClientRepository.getInstance().persist(new Client(null, in.getNome()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ClientOut> listAll() {
        try {
            return ClientRepository.getInstance().findAll().parallelStream().map(entity -> new ClientOut(entity.getId(), entity.getNome())).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
