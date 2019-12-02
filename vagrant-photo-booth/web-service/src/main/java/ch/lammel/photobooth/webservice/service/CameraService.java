package ch.lammel.photobooth.webservice.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.lammel.photobooth.webservice.exception.CameraException;
import ch.lammel.photobooth.webservice.utils.CameraFile;
import ch.lammel.photobooth.webservice.utils.CameraGphoto;
import ch.lammel.photobooth.webservice.utils.CameraList;
import net.coobird.thumbnailator.Thumbnails;

@Service
public class CameraService {

	@Autowired
	PropertyService propertyService;
	
	private boolean isInitialized = false;
    private CameraGphoto camera;
	
	public CameraService() {
		System.out.println("##### CAMERA SERVICE ####");
	}

	@PostConstruct
	public void doLog() {
		
		
	}

	public void initialize() throws CameraException {
        if(isInitialized) return;

        try(CameraList cameraList = new CameraList()) {

            if (cameraList.getCount() == 0) throw new CameraException("No camera found");
            if (cameraList.getCount() > 1)
                throw new CameraException(cameraList.getCount() + " cameras found - there must be only one camera");

            camera = new CameraGphoto();
            camera.initialize();

            isInitialized = true;
        }
    }
	
	
	public String captureImage() throws CameraException, IOException {
		
		if(!isInitialized) initialize();

		try(CameraFile cameraFile = camera.captureImage()){

	        if (cameraFile == null) {
	        	throw new CameraException("camerafile is null");
	        }

	        String fileName = getFileName();
	        String imagePath = propertyService.getPictureFolderPath() + "/" + fileName;
	        String compImagePath = propertyService.getCompressedPictureFolderPath() + "/" + fileName;
	        cameraFile.save(imagePath);
	        compressPicture(imagePath, compImagePath);
	        
	        if(new File(compImagePath).exists()) {
	        	return fileName;
	        } else {
	        	throw new CameraException("Picture not saved");
	        }
	    }
		

//		this.cameraIsBlocked = true;
//		Camera c = new Camera();
//		c.initialize();
//		CameraFile cf2 = c.captureImage();
//
//		String fileName = getFileName();
//		cf2.save(pictureFolderPath + "/" + fileName);
//
//		try {
//			compressPicture(pictureFolderPath + "/" + fileName,
//					pictureFolderPath + "/" + compressedFolderName + "/" + fileName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		CameraUtils.closeQuietly(cf2);
//		CameraUtils.closeQuietly(c);
//		this.cameraIsBlocked = false;
//		return fileName;

	}

	private void compressPicture(String inputPathName, String outputPathName) throws IOException {
		Thumbnails.of(new File(inputPathName)).size(1024, 1024).outputQuality(0.8f).toFile(new File(outputPathName));
	}

	private String getFileName() {
		return new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss_SSS").format(new Date()) + ".jpg";
	}

}
