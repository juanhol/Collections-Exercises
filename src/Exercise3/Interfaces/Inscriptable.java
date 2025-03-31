package Exercise3.Interfaces;

import Exeptions.NotFoundException;
import Exercise3.Model.Inscription;

public interface Inscriptable {
    boolean addName(Inscription inscription);
    boolean verifyInscript(Inscription inscription);
    boolean softDeleteInscription(Inscription inscription)throws NotFoundException;
    void listAll();
}
