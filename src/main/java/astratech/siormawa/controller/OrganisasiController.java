package astratech.siormawa.controller;

import astratech.siormawa.model.Organisasi;
import astratech.siormawa.model.Periode;
import astratech.siormawa.service.OrganisasiService;
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
public class OrganisasiController {
    @Autowired
    OrganisasiService organisasiService;

    @GetMapping("/saveOrganisasi")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "nama") String nama) {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Organisasi organisasi = new Organisasi(0, nama, "Aktif", "a", date, null, null);
        organisasiService.save(organisasi);
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Organisasi/index.html")).build();
    }

    @GetMapping("/getOrganisasi")
    public Organisasi getOrganisasi(HttpServletResponse response, @RequestParam("id") Integer id){
        Organisasi organisasi = organisasiService.getOrganisasi(id);
        return organisasi;
    }

    @GetMapping("/getOrganisasis")
    public List<Organisasi> getOrganisasis(HttpServletResponse response){
        List<Organisasi> organisasis = organisasiService.getOrganisasis();
        return organisasis;
    }

    @GetMapping("/getOrganisasisAktif")
    public List<Organisasi> getOrganisasisAktif(HttpServletResponse response){
        List<Organisasi> organisasis = organisasiService.getOrganisasisAktif();
        return organisasis;
    }

    @GetMapping("/updateOrganisasi")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idOrganisasi") String idOrganisasi,
                                       @RequestParam(name = "nama") String nama) {

        Organisasi organisasi2 = organisasiService.getOrganisasi(Integer.parseInt(idOrganisasi));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Organisasi organisasi = new Organisasi(Integer.parseInt(idOrganisasi), nama, organisasi2.getStatus(), organisasi2.getCreatedby(), organisasi2.getCreateddate(), "b", date);
        organisasiService.updateOrganisasi(Integer.parseInt(idOrganisasi), organisasi);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Organisasi/index.html")).build();
    }

    @GetMapping("/deleteOrganisasi")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        organisasiService.deleteOrganisasi(id);
        return ResponseEntity.ok("Organisasi with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanOrganisasi")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        organisasiService.AktifkanOrganisasi(id);
        return ResponseEntity.ok("Organisasi with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanOrganisasi")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        organisasiService.NonaktifkanOrganisasi(id);
        return ResponseEntity.ok("Organisasi with ID: " + id + ". Deactivate Successfully");
    }

}
