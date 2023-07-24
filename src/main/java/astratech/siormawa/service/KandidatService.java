package astratech.siormawa.service;

import astratech.siormawa.model.Kandidat;
import astratech.siormawa.repository.KandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KandidatService {
    @Autowired
    KandidatRepository kandidatRepository;

    public boolean save(Kandidat kandidat){

        Kandidat result = kandidatRepository.save(kandidat);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Kandidat getKandidat(Integer idKandidat){
        Kandidat kandidat = kandidatRepository.getKandidatByIdKandidat(idKandidat);
        return kandidat;
    }

    public Kandidat getKandidatByUsername(Integer username, Integer idEvent){
        Kandidat kandidat = kandidatRepository.getKandidatByUsername(username, idEvent);
        return kandidat;
    }

    public Kandidat getKandidatByUsernameValidasi(Integer username, Integer idEvent){
        Kandidat kandidat = kandidatRepository.getKandidatByUsernameValidasi(username, idEvent);
        return kandidat;
    }

    public List<Kandidat> getKandidats(){
        List<Kandidat> kandidats = kandidatRepository.getKandidats();
        return kandidats;
    }

    public List<Kandidat> getKandidatsByIdEvent(Integer idEvent){
        List<Kandidat> kandidats = kandidatRepository.getKandidatsByIdEvent(idEvent);
        return kandidats;
    }

    public boolean updateKandidat(Integer idKandidat, Kandidat updatedKandidat){

        Kandidat kandidat = kandidatRepository.getKandidatByIdKandidat(idKandidat);
        if(kandidat == null){
            return false;
        }
        kandidat.setIdEvent(updatedKandidat.getIdEvent());
        kandidat.setNama(updatedKandidat.getNama());
        kandidat.setUsername(updatedKandidat.getUsername());
        kandidat.setProdi(updatedKandidat.getProdi());
        kandidat.setPendaftaran(updatedKandidat.getPendaftaran());
        kandidat.setStatus(updatedKandidat.getStatus());
        kandidat.setCreatedby(updatedKandidat.getCreatedby());
        kandidat.setCreateddate(updatedKandidat.getCreateddate());
        kandidat.setModifiedby(updatedKandidat.getModifiedby());
        kandidat.setModifieddate(updatedKandidat.getModifieddate());
        Kandidat result = kandidatRepository.save(kandidat);
        return result != null;
    }
//
    public boolean deleteKandidat(Integer idKandidat){
        try {
            kandidatRepository.DeleteStatus(idKandidat);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanKandidat(Integer idKandidat){
        try {
            kandidatRepository.AktifkanKandidat(idKandidat);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanKandidat(Integer idKandidat){
        try {
            kandidatRepository.NonaktifkanKandidat(idKandidat);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
