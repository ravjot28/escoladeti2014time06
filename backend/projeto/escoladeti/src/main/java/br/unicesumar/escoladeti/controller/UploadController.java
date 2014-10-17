package br.unicesumar.escoladeti.controller;

import br.unicesumar.escoladeti.comando.ComandoUpload;
import br.unicesumar.escoladeti.entity.Volume;
import br.unicesumar.escoladeti.repository.VolumeRepository;
import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.awt.geom.RectangularShape;
import java.io.*;

/**
 * Created by Jhonatan on 02/10/2014.
 */
@Controller
@RequestMapping(value = "/rest/upload")
public class UploadController {

    @Autowired
    private VolumeRepository volumeRepository;

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }



    @RequestMapping( value = "/{volumeId}",method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(
            @PathVariable Long volumeId,
            @RequestBody MultipartFile file){

        Volume volume = volumeRepository.findOne(volumeId);
        String name = file.getOriginalFilename();
        String rootPath = System.getProperty("catalina.home");
        String finalDir = rootPath + File.separator + "uploads";
        File dir = new File(finalDir);

        if (!dir.exists()) {
            dir.mkdir();
        }

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String fileDir = dir.getAbsolutePath() + File.separator + name;
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(fileDir)));
                stream.write(bytes);
                stream.close();
                volume.setCaminhoAnexo(fileDir);
                volumeRepository.save(volume);
                return "Upload success";
            } catch (Exception e) {
                throw new RuntimeException("Erro ao fazer upload do arquivo");
            }
        } else {
            throw new RuntimeException("Erro ao fazer upload, arquivo esta vazio");
        }
    }

    @RequestMapping(value = "/{volumeId}", method = RequestMethod.GET)
    @ResponseBody
    public void getFile(@PathVariable Long volumeId, HttpServletResponse response) {
        Volume volume = volumeRepository.findOne(volumeId);

        if (volume == null) {
            throw new RuntimeException("Volume não encontrado");
        }

        try{
            File file = new File(volume.getCaminhoAnexo());
            response.reset();
            response.setBufferSize(ASCIIReader.DEFAULT_BUFFER_SIZE);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
            response.getOutputStream().write(IOUtils.toByteArray( new FileInputStream(file)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao realizar download do arquivo. "+e.getMessage());
        }

    }


}
