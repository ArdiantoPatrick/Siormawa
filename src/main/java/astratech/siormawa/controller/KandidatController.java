package astratech.siormawa.controller;

import astratech.siormawa.model.Kandidat;
import astratech.siormawa.service.KandidatService;
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
public class KandidatController {
    @Autowired
    KandidatService kandidatService;

    @GetMapping("/saveKandidat")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "idEvent") Integer idEvent,
                                     @RequestParam(name = "nama") String nama,
                                     @RequestParam(name = "username") String username,
                                     @RequestParam(name = "prodi") String prodi,
                                     @RequestParam(name = "pendaftaran") String pendaftaran) {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Kandidat kandidat = new Kandidat(0, idEvent, nama, username, prodi, pendaftaran, "Menunggu Disetujui", "a", date, null, null);
        kandidatService.save(kandidat);
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Kandidat/index.html")).build();
    }

    @GetMapping("/getKandidat")
    public Kandidat getKandidat(HttpServletResponse response, @RequestParam("id") Integer id){
        Kandidat kandidat = kandidatService.getKandidat(id);
        return kandidat;
    }


    @GetMapping("/getKandidatByUsername")
    public Kandidat getKandidatByUsername(HttpServletResponse response,
                                          @RequestParam("username") Integer username,
                                          @RequestParam("idEvent") Integer idEvent){
        Kandidat kandidat = kandidatService.getKandidatByUsername(username, idEvent);
        return kandidat;
    }

    @GetMapping("/getKandidatByUsernameValidasi")
    public Kandidat getKandidatByUsernameValidasi(HttpServletResponse response,
                                          @RequestParam("username") Integer username,
                                          @RequestParam("idEvent") Integer idEvent){
        Kandidat kandidat = kandidatService.getKandidatByUsernameValidasi(username, idEvent);
        return kandidat;
    }

    @GetMapping("/getKandidats")
    public List<Kandidat> getKandidats(HttpServletResponse response){
        List<Kandidat> kandidats = kandidatService.getKandidats();
        return kandidats;
    }

    @GetMapping("/getKandidatsByIdEvent")
    public List<Kandidat> getKandidats(HttpServletResponse response, @RequestParam("id") Integer id){
        List<Kandidat> kandidats = kandidatService.getKandidatsByIdEvent(id);
        return kandidats;
    }

    @GetMapping("/UpdateKandidat")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idKandidat") String idKandidat,
                                       @RequestParam(name = "idEvent") Integer idEvent,
                                       @RequestParam(name = "nama") String nama,
                                       @RequestParam(name = "username") String username,
                                       @RequestParam(name = "prodi") String prodi,
                                       @RequestParam(name = "pendaftaran") String pendaftaran) {

        Kandidat kandidat2 = kandidatService.getKandidat(Integer.parseInt(idKandidat));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        Kandidat kandidat = new Kandidat(Integer.parseInt(idKandidat), idEvent, nama, username, prodi, pendaftaran, kandidat2.getStatus(), kandidat2.getCreatedby(), kandidat2.getCreateddate(), "b", date);
        kandidatService.updateKandidat(Integer.parseInt(idKandidat), kandidat);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Kandidat/index.html")).build();
    }

    @GetMapping("/deleteKandidat")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        kandidatService.deleteKandidat(id);
        return ResponseEntity.ok("Kandidat with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanKandidat")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        kandidatService.AktifkanKandidat(id);
        return ResponseEntity.ok("Kandidat with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanKandidat")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        kandidatService.NonaktifkanKandidat(id);
        return ResponseEntity.ok("Kandidat with ID: " + id + ". Deactivate Successfully");
    }
}
