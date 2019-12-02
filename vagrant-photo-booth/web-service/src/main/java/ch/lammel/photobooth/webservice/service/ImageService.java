package ch.lammel.photobooth.webservice.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ImageService {
	
	
//	@Value("${config.picture-folder-path}")
//	private String pictureFolderPath;
//	
//	@Value("${config.compressed-folder-name}")
//	private String compressedFolderName;
	
	@Autowired
	PropertyService propertyService;
	
	
	public ImageService() {
		System.out.println("##### IMAGE SERVICE ####");
	}
	
	
	@PostConstruct
    public void postConstruct() {
    }


	public byte[] getRandomLoadingPicture() throws IOException {
		String[] filenameFilterList = {".gif", ".GIF"};
		List<String> fileNameList = getFolderContent(propertyService.getLoadingPictureFolderPath(), filenameFilterList);
		String fileName = getRandomElementFromList(fileNameList);
		return fileToInputStream(propertyService.getLoadingPictureFolderPath() +"/" +fileName);
	}


	public byte[] fileToInputStream(String pathToFile) throws IOException {
		InputStream targetStream = new FileInputStream(pathToFile);
		return IOUtils.toByteArray(targetStream);
	}


	private String getRandomElementFromList(List<String> list) {
		Random rand = new Random(); 
        return list.get(rand.nextInt(list.size()));
	}
	
	public List<String> getFolderContent(String folderPath, String[] filenameFilterList) throws IOException {
		List<String> resultSet = new LinkedList<String>();
		
		Files.list(new File(folderPath).toPath()).forEach(path -> {
			if(Arrays.stream(filenameFilterList).anyMatch(entry -> path.getFileName().toString().endsWith(entry))) {
//				System.out.println(path.getFileName().toString());
				resultSet.add(path.getFileName().toString());
			}
		});
		return resultSet;
	}

}
