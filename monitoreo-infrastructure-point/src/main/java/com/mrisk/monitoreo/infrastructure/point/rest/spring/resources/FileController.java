package com.mrisk.monitoreo.infrastructure.point.rest.spring.resources;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.chemistry.opencmis.client.api.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    
    @Autowired
    CmisService cmisService;
    
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/points/{pointId}/uploadFile")
    public UploadFileResponse uploadFile(@PathVariable Integer pointId, @RequestParam("file") MultipartFile file) {
    	
    	log.info("--Creating documents...");
        Document docA = cmisService.createDocument(cmisService.getRootFolder(), file);
        log.info("\tcreated document A " + docA.getId());
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        log.info("OriginalFilename: "+file.getOriginalFilename());
//        String fileName = fileStorageService.storeFile(file);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();

        return new UploadFileResponse( fileName, file.getContentType(), file.getSize() );
    }

    @PostMapping("/points/{pointId}/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@PathVariable Integer pointId, @RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(pointId, file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        	log.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    
    
    @DeleteMapping("/points/{pointId}/storages/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer pointId, @PathVariable String id) {
    	
    	cmisService.deleteByObjectId(id);

        return ResponseEntity.ok().build();
    }
    

}
