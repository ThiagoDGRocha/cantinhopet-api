package br.com.tdgrocha.service;

import br.com.tdgrocha.models.ClientEntity;
import br.com.tdgrocha.models.ClientIn;
import br.com.tdgrocha.models.ClientOut;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class ClientService {

    @Inject
    EntityManager em;

    public void save(ClientIn in) {
        try {
            em.persist(new ClientEntity(null, in.getNome()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ClientOut> listAll() {
        try {
            return em.createQuery("FROM " + ClientEntity.class.getName(), ClientEntity.class).
                    getResultList().
                    parallelStream().
                    map(entity -> new ClientOut(entity.getId(), entity.getNome())).
                    collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
