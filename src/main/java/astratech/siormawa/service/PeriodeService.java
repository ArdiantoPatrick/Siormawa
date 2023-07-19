package astratech.siormawa.service;

import astratech.siormawa.model.Periode;
import astratech.siormawa.repository.PeriodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodeService {
    @Autowired
    PeriodeRepository periodeRepository;

    public boolean save(Periode periode){

        Periode result = periodeRepository.save(periode);
        boolean isSuccess = true;
        if (result == null){
            isSuccess = false;
        }
        return isSuccess;
    }

    public Periode getPeriode(Integer idPeriode){
        Periode periode = periodeRepository.getPeriodeByIdPeriode(idPeriode);
        return periode;
    }

    public List<Periode> getPeriodes(){
        List<Periode> periodes = periodeRepository.getPeriodes();
        return periodes;
    }

    public List<Periode> getPeriodesAktif(){
        List<Periode> periodes = periodeRepository.getPeriodesAktif();
        return periodes;
    }

    public boolean updatePeriode(Integer idPeriode, Periode updatedPeriode){

        Periode periode = periodeRepository.getPeriodeByIdPeriode(idPeriode);
        if(periode == null){
            return false;
        }
        periode.setTahun(updatedPeriode.getTahun());
        periode.setStatus(updatedPeriode.getStatus());
        periode.setCreatedby(updatedPeriode.getCreatedby());
        periode.setCreateddate(updatedPeriode.getCreateddate());
        periode.setModifiedby(updatedPeriode.getModifiedby());
        periode.setModifieddate(updatedPeriode.getModifieddate());
        Periode result = periodeRepository.save(periode);
        return result != null;
    }
//
    public boolean deletePeriode(Integer idPeriode){
        try {
            periodeRepository.DeleteStatus(idPeriode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AktifkanPeriode(Integer idPeriode){
        try {
            periodeRepository.AktifkanPeriode(idPeriode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean NonaktifkanPeriode(Integer idPeriode){
        try {
            periodeRepository.NonaktifkanPeriode(idPeriode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
