package ch.lammel.photobooth.webservice.service;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@Service
public class PropertyService {
	
	@Value("${config.picture-folder-path}")
	private String pictureFolderPath;
	
	@Value("${config.compressed-picture-folder-path}")
	private String compressedPictureFolderPath;
	
	@Value("${config.loading-picture-folder-path}")
	private String loadingPictureFolderPath;
	
	public PropertyService() {
		System.out.println("##### PROPERTY SERVICE ####");
	}
	
	
	@PostConstruct
    public void postConstruct() {
		System.out.println("pictureFolderPath " +pictureFolderPath);
		System.out.println("compressedPictureFolderPath " +compressedPictureFolderPath);
		System.out.println("loadingPictureFolderPath " +loadingPictureFolderPath);
		folderCheck();
    }
	
	
	private void folderCheck() {
		List<String> folderList = new LinkedList<String>();
		folderList.add(loadingPictureFolderPath);
		folderList.add(pictureFolderPath);
		folderList.add(compressedPictureFolderPath);
		
		createFolderIfNotExist(folderList);
	}


	private void createFolderIfNotExist(List<String> folderList) {
		
		folderList.forEach((folderPathItem) -> {
			File tempFolder = new File(folderPathItem);
			if (!tempFolder.exists()) {
				tempFolder.mkdir();
			}
		});
	}

}
