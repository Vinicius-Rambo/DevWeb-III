package com.example.estudantes.Services;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

    public String upload(MultipartFile arquivo) throws IOException{

        String pastaUploads = "src/main/resources/static/uploads";  //Localidade da pasta de uploads (igual a do propriedades)
        String nomeArquivo = UUID.randomUUID() + "_" + arquivo.getOriginalFilename(); //Nome do arquivo = RandomUUID concatenado com o nome dele para evitar sobreescrever

        Path path = Paths.get(pastaUploads + nomeArquivo); //Define aonde ele vai ficar

        Files.createDirectories(path.getParent()); //Se não houver pasta ele cria uma.

        Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING); //Copia o arquivo para o caminho.

        return nomeArquivo;
    }
}
