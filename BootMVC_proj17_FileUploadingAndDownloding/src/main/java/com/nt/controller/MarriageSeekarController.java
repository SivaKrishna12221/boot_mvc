package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.enitity.MarriageSeekarInfo;
import com.nt.model.MarriageSeekar;
import com.nt.service.IMarriageBureauServiceMgmt;

@Controller
public class MarriageSeekarController {

	@Autowired
	private Environment envi;

	@Autowired
	private IMarriageBureauServiceMgmt service;

	@Autowired
	private ServletContext sc;

	@GetMapping("/")
	public String displayHomePage() {
		return "marriage_bureau";
	}

	@GetMapping("/register")
	public String displayProfileForm(@ModelAttribute("seekar") MarriageSeekar seekar) {
		return "register_profile";
	}

	@PostMapping("/register")
	public String saveProfile(@ModelAttribute("seekar") MarriageSeekar seekar, Map<String, Object> map)
			throws Exception {
		String location = envi.getProperty("store.data");// location name
		File locationStore = new File(location);
		if (!locationStore.exists()) {
			locationStore.mkdir();
		}
		MultipartFile biodata = seekar.getBiodata();
		MultipartFile photo = seekar.getPhoto();
		String biodataFileName = biodata.getOriginalFilename();
		String photoFileName = photo.getOriginalFilename();
		InputStream biodataBytes = biodata.getInputStream();
		InputStream photoBytes = photo.getInputStream();
		OutputStream biodataOutStream = new FileOutputStream(location + "/" + biodataFileName);
		OutputStream photoOutStream = new FileOutputStream(location + "/" + photoFileName);
		IOUtils.copy(biodataBytes, biodataOutStream);
		IOUtils.copy(photoBytes, photoOutStream);
		biodataBytes.close();
		photoBytes.close();
		biodataOutStream.close();
		photoOutStream.close();

		MarriageSeekarInfo seekarInfo = new MarriageSeekarInfo();
		seekarInfo.setGender(seekar.getGender());
		seekarInfo.setName(seekar.getName());
		seekarInfo.setPhotoPath(location + "/" + photoFileName);
		seekarInfo.setResumePath(location + "/" + biodataFileName);
		String resultMessage = service.registerProfile(seekarInfo);
		map.put("message", resultMessage);
		map.put("photoFileName", photoFileName);
		map.put("biodataFileName", biodataFileName);
		return "result_profile";
	}

	// list of data
	@GetMapping("/download")
	public String displayProfiles(
			@PageableDefault(size = 3, page = 0, direction = Sort.Direction.ASC, sort = "name") Pageable pageable,
			Map<String, Object> map) {
		Page<MarriageSeekarInfo> info = service.getAllProfiles(pageable);
		map.put("profiles", info);
		return "list_of_profiles";
	}

	// downloading resume and photo

	@GetMapping("/download_info")
	public String downloadProfile(@RequestParam("file") String filepath, HttpServletResponse res) throws Exception {
		// create java file object pointing to the file to download
		File file = new File(filepath);
		// get the length and make it as the response content length
		res.setContentLengthLong(file.length());
		// get the MIME of the file to be download and make it as the response content
		// type
		String mimetype = sc.getMimeType(filepath);
		mimetype = mimetype != null ? mimetype : "application/octet-stream ";
		res.setContentType(mimetype);
		// create input stream pointing to file to be download;
		InputStream is = new FileInputStream(file);
		// create ouput stream pointing to response object
		OutputStream os = res.getOutputStream();
		// give instruction to the browser to make recevied content as downloadble
		// content
		res.setHeader("Content-Dispostion", "attachment;fileName=" + file.getName());
		// copy file to be download content to response object
		IOUtils.copy(is, os);
		is.close();
		os.close();
		return null;
	}

}
