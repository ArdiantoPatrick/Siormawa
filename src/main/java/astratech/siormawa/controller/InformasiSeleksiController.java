package astratech.siormawa.controller;

import astratech.siormawa.model.InformasiSeleksi;
import astratech.siormawa.service.InformasiSeleksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

@RestController
public class InformasiSeleksiController {

    @Autowired
    InformasiSeleksiService informasiSeleksiService;

    private final ResourceLoader resourceLoader;

    public InformasiSeleksiController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("/saveInformasiSeleksi")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "judul") String judul,
                                     @RequestParam(name = "file") MultipartFile file,
                                     @RequestParam(name = "deskripsi") String deskripsi) throws IOException {

        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        byte[] bytefile = file.getBytes();
            InformasiSeleksi informasiSeleksi = new InformasiSeleksi(0, judul, bytefile, deskripsi, "Aktif", "a", date, null, null);
        informasiSeleksiService.save(informasiSeleksi);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/InformasiSeleksi/index.html")).build();
    }


    private String saveImageToServer(MultipartFile file) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/Content/Files/Gambar/");
        String uploadDirectory = resource.getFile().getAbsolutePath().replace("\\", "/");
        InformasiSeleksi informasiSeleksi = informasiSeleksiService.getInformasiSeleksiTerakhir();
        Integer id = informasiSeleksi != null ? informasiSeleksi.getIdInfseleksi() + 1 : 1;
        String fileName = "Gambar_"+ id + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9.-]", "_");
        Path filePath = Paths.get(uploadDirectory, fileName);

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        return fileName;
    }

    private String updateImageToServer(MultipartFile file, Integer idInformasiSeleksi) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:static/Content/Files/Gambar/");
        String uploadDirectory = resource.getFile().getAbsolutePath().replace("\\", "/");
        String fileName = "Gambar_"+ idInformasiSeleksi + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9.-]", "_");
        Path filePath = Paths.get(uploadDirectory, fileName);

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        return fileName;
    }


    @GetMapping("/getInformasiSeleksi")
    public InformasiSeleksi getInformasiSeleksi(HttpServletResponse response, @RequestParam("id") Integer id){
        InformasiSeleksi informasiSeleksi = informasiSeleksiService.getInformasiSeleksi(id);
        return informasiSeleksi;
    }

    @GetMapping("/getInformasiSeleksis")
    public List<InformasiSeleksi> getInformasiSeleksis(HttpServletResponse response){
        List<InformasiSeleksi> informasiSeleksi = informasiSeleksiService.getInformasiSeleksis();
        return informasiSeleksi;
    }

    @GetMapping("/getInformasiSeleksisByCreated")
    public List<InformasiSeleksi> getInformasiSeleksisByCreated(HttpServletResponse response, @RequestParam("namacreated") String namacreated){
        List<InformasiSeleksi> informasiSeleksi = informasiSeleksiService.getInformasiSeleksisByCreated(namacreated);
        return informasiSeleksi;
    }

    @PostMapping("/UpdateInformasiSeleksi")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idInformasiSeleksi") String idInformasiSeleksi,
                                       @RequestParam(name = "judul") String judul,
                                       @RequestParam(name = "file", required = false) MultipartFile file ,
                                       @RequestParam(name = "deskripsi") String deskripsi) throws IOException {

        InformasiSeleksi informasiSeleksi2 = informasiSeleksiService.getInformasiSeleksi(Integer.parseInt(idInformasiSeleksi));
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        byte[] bytefile = informasiSeleksi2.getFile();

        if (file != null && !file.isEmpty()) { // Memeriksa apakah ada file baru yang diunggah
            bytefile = file.getBytes(); // Jika ada, gunakan file baru dan simpan di server
        }

        InformasiSeleksi informasiSeleksi = new InformasiSeleksi(Integer.parseInt(idInformasiSeleksi), judul, bytefile, deskripsi, informasiSeleksi2.getStatus(), informasiSeleksi2.getCreatedby(), informasiSeleksi2.getCreateddate(), "b", date);
        informasiSeleksiService.updateInformasiSeleksi(Integer.parseInt(idInformasiSeleksi), informasiSeleksi);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/InformasiSeleksi/index.html")).build();
    }

    @GetMapping("/deleteInformasiSeleksi")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        informasiSeleksiService.deleteInformasi(id);
        return ResponseEntity.ok("Informasi with ID: " + id + ". Deleted Successfully");
    }

    @GetMapping("/aktifkanInformasiSeleksi")
    public ResponseEntity<String> aktifkanById(@RequestParam("id") Integer id) {
        informasiSeleksiService.AktifkanInformasiSeleksi(id);
        return ResponseEntity.ok("Informasi Seleksi with ID: " + id + ". Activate Successfully");
    }

    @GetMapping("/nonaktifkanInformasiSeleksi")
    public ResponseEntity<String> nonaktifkanById(@RequestParam("id") Integer id) {
        informasiSeleksiService.NonaktifkanInformasiSeleksi(id);
        return ResponseEntity.ok("Informasi Seleksi with ID: " + id + ". Deactivate Successfully");
    }
}
