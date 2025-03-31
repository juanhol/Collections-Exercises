package Exercise3.Repositories;

import Exeptions.NotFoundException;
import Exercise2.Model.State;
import Exercise3.Interfaces.Inscriptable;
import Exercise3.Model.Inscription;

import java.util.HashSet;
import java.util.Set;

public class Inscriptions <T extends Inscription> implements Inscriptable {

    private Set<Inscription> inscriptionList;

    public Inscriptions(Inscription inscription) {
        this.inscriptionList=new HashSet<>();
    }

    @Override
    public boolean addName(Inscription inscription) {
        return inscriptionList.add(inscription);
    }

    @Override
    public boolean verifyInscript(Inscription inscription) {
        return inscriptionList.contains(inscription);
    }

    @Override
    public boolean softDeleteInscription(Inscription inscription) throws NotFoundException {
        Inscription inscriptionItem=inscriptionList.stream()
                .filter(t->t.equals(inscription))
                .findFirst()
                .orElseThrow(() ->new NotFoundException("The inscription isn't on the list"));

        inscriptionItem.setState(State.DELETED);
        return true;
    }

    @Override
    public void listAll() {
        inscriptionList.forEach(System.out::println);
    }
}
