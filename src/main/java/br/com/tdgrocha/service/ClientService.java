package br.com.tdgrocha.service;

import br.com.tdgrocha.pojos.ClientIn;
import br.com.tdgrocha.pojos.ClientOut;
import br.com.tdgrocha.entities.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    EntityManager em;

    public void save(ClientIn in) {
        try {
            em.persist(new Client(null, in.getNome()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ClientOut> listAll() {
        try {
            return em.createQuery("FROM " + Client.class.getName(), ClientOut.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
