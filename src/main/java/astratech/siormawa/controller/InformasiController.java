package astratech.siormawa.controller;

import astratech.siormawa.model.Informasi;
import astratech.siormawa.service.InformasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class InformasiController {

    @Autowired
    InformasiService informasiService;

    private final ResourceLoader resourceLoader;

    public InformasiController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/saveInformasi")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "judul") String judul,
                                     @RequestParam(name = "file") MultipartFile file,
                                     @RequestParam(name = "deskripsi") String deskripsi,
                                     @RequestParam(name = "jenis") String jenis) throws IOException {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        byte[] bytefile = file.getBytes();
        Informasi informasi = new Informasi(0, judul, bytefile, deskripsi, jenis, "Aktif", "a", date, null, null);
        informasiService.save(informasi);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Informasi/index.html")).build();
    }


    private String saveImageToServer(MultipartFile file) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/Content/Files/Gambar/");
        String uploadDirectory = resource.getFile().getAbsolutePath().replace("\\", "/");
        Informasi informasi = informasiService.getInformasiTerakhir();
        Integer id = informasi != null ? informasi.getIdInformasi() + 1 : 1;
        String fileName = "Gambar_"+ id + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9.-]", "_");
        Path filePath = Paths.get(uploadDirectory, fileName);

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        return fileName;
    }

    private String updateImageToServer(MultipartFile file, Integer idInformasi) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/Content/Files/Gambar/");
        String uploadDirectory = resource.getFile().getAbsolutePath().replace("\\", "/");
        String fileName = "Gambar_"+ idInformasi + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9.-]", "_");
        Path filePath = Paths.get(uploadDirectory, fileName);

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        return fileName;
    }


    @GetMapping("/getInformasi")
    public Informasi getInformasi(HttpServletResponse response, @RequestParam("id") Integer id){
        Informasi informasi = informasiService.getInformasi(id);
        return informasi;
    }

    @GetMapping("/getInformasis")
    public List<Informasi> getInformasis(HttpServletResponse response){
        List<Informasi> informasis = informasiService.getInformasis();
        return informasis;
    }

    @GetMapping("/getInformasisByCreated")
    public List<Informasi> getInformasisByCreated(HttpServletResponse response, @RequestParam("namacreated") String namacreated){
        List<Informasi> informasis = informasiService.getInformasisByCreated(namacreated);
        return informasis;
    }

    @PostMapping("/UpdateInformasi")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idInformasi") String idInformasi,
                                       @RequestParam(name = "judul") String judul,
                                       @RequestParam(name = "file", required = false) MultipartFile file ,
                                       @RequestParam(name = "deskripsi") String deskripsi,
                                       @RequestParam(name = "jenis") String jenis) throws IOException {

        Informasi informasi2 = informasiService.getInformasi(Integer.parseInt(idInformasi));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        byte[] bytefile = informasi2.getFile();

        if (file != null && !file.isEmpty()) { // Memeriksa apakah ada file baru yang diunggah
            bytefile = file.getBytes(); // Jika ada, gunakan file baru dan simpan di server
        }

        Informasi informasi = new Informasi(Integer.parseInt(idInformasi), judul, bytefile, deskripsi, jenis, informasi2.getStatus(), informasi2.getCreatedby(), informasi2.getCreateddate(), "b", date);
        informasiService.updateInformasi(Integer.parseInt(idInformasi), informasi);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/Informasi/index.html")).build();
    }

    @GetMapping("/deleteInformasi")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        informasiService.deleteInformasi(id);
        return ResponseEntity.ok("Informasi with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanInformasi")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        informasiService.AktifkanInformasi(id);
        return ResponseEntity.ok("Informasi with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanInformasi")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        informasiService.NonaktifkanInformasi(id);
        return ResponseEntity.ok("Informasi with ID: " + id + ". Deactivate Successfully");
    }
}
