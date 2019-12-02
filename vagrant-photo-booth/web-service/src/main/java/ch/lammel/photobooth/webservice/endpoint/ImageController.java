package ch.lammel.photobooth.webservice.endpoint;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ch.lammel.photobooth.webservice.service.ImageService;
import ch.lammel.photobooth.webservice.service.PropertyService;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	ImageService imageService;
	
	@Autowired
	PropertyService propertyService;

	@GetMapping(value = { "/all" })
	public List<String> getAllPictures() {
		String[] filenameFilterList = {".jpg", ".JPG"};
		try {
			return imageService.getFolderContent(this.propertyService.getCompressedPictureFolderPath(), filenameFilterList);
		} catch (IOException e) {
//			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error", e);
		}
	}
	
	@RequestMapping(
			value = "/loading",
			produces = MediaType.IMAGE_GIF_VALUE,
			method = RequestMethod.GET)
	public byte[] getLoadingPicture() {

		try {
			return imageService.getRandomLoadingPicture();
//			return imageService.fileToInputStream(propertyService.getLoadingPictureFolderPath()+"/pic17.gif");
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error", e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/get/{filename}", produces = MediaType.IMAGE_JPEG_VALUE, method = RequestMethod.GET)
	public byte[] getImageAsResource(@PathVariable("filename") String filename) {
		String fullPath = this.propertyService.getCompressedPictureFolderPath() + "/" + filename;

		try {
			return imageService.fileToInputStream(fullPath);
		} catch (IOException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "file not found", ex);
		}
	}

}
