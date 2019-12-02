package ch.lammel.photobooth.webservice.endpoint;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import ch.lammel.photobooth.webservice.exception.CameraException;
import ch.lammel.photobooth.webservice.model.InformationModel;
import ch.lammel.photobooth.webservice.model.PictureModel;
import ch.lammel.photobooth.webservice.service.CameraService;

@RestController
@RequestMapping("/camera")
public class CameraController {
	
	@Autowired
	CameraService cameraService;

    @GetMapping(value = {"/info"})
    public InformationModel info() {
    	
    	InformationModel info = new InformationModel();
    	info.setVersion("blabla");
    	
        return info;
    }
    
    @GetMapping(value = {"/capture"})
    public PictureModel captureImage () {
    	
    	try {
			return new PictureModel(cameraService.captureImage());
		} catch (CameraException e) {
			throw new ResourceAccessException("Camera resource is busy right now, please try again later");
		} catch (IOException e) {
			throw new ResourceAccessException("Camera could not save picture");
		}
    }
    
    
}
