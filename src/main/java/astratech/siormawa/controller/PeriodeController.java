package astratech.siormawa.controller;

import astratech.siormawa.model.Pengguna;
import astratech.siormawa.model.Periode;
import astratech.siormawa.service.PenggunaService;
import astratech.siormawa.service.PeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class PeriodeController {
    @Autowired
    PeriodeService periodeService;

    @GetMapping("/savePeriode")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "tahun") String tahun) {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Periode periode = new Periode(0, tahun, "Aktif", "a", date, null, null);
        periodeService.save(periode);
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Periode/index.html")).build();
    }

    @GetMapping("/getPeriode")
    public Periode getPeriode(HttpServletResponse response, @RequestParam("id") Integer id){
        Periode periode = periodeService.getPeriode(id);
        return periode;
    }

    @GetMapping("/getPeriodes")
    public List<Periode> getPeriodes(HttpServletResponse response){
        List<Periode> periodes = periodeService.getPeriodes();
        return periodes;
    }

    @GetMapping("/getPeriodesAktif")
    public List<Periode> getPeriodesAktif(HttpServletResponse response){
        List<Periode> periodes = periodeService.getPeriodesAktif();
        return periodes;
    }

    @GetMapping("/updatePeriode")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idPeriode") String idPeriode,
                                       @RequestParam(name = "tahun") String tahun) {

        Periode periode2 = periodeService.getPeriode(Integer.parseInt(idPeriode));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Periode periode = new Periode(Integer.parseInt(idPeriode), tahun, periode2.getStatus(), periode2.getCreatedby(), periode2.getCreateddate(), "b", date);
        periodeService.updatePeriode(Integer.parseInt(idPeriode), periode);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Periode/index.html")).build();
    }

    @GetMapping("/deletePeriode")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        periodeService.deletePeriode(id);
        return ResponseEntity.ok("Periode with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanPeriode")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        periodeService.AktifkanPeriode(id);
        return ResponseEntity.ok("Periode with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanPeriode")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        periodeService.NonaktifkanPeriode(id);
        return ResponseEntity.ok("Periode with ID: " + id + ". Deactivate Successfully");
    }

}
