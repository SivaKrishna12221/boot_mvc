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

import com.nt.entity.JobSeekar;
import com.nt.model.JobSeekarInfo;
import com.nt.service.IJobPortalMgmtService;

@Controller
public class JobSeekarController {
	@Autowired
	private Environment envi;

	@Autowired
	private IJobPortalMgmtService service;

	@Autowired
	private ServletContext sc;

	@GetMapping("/")
	public String showJobPortal() {
		return "carrers";
	}

	@GetMapping("/register_job_seekar")
	public String displayRegisterPage(@ModelAttribute("seekar") JobSeekarInfo seekar) {
		return "job_seekar_registration";
	}

	@PostMapping("/register_job_seekar")
	public String registerProfileUsingMultipart(@ModelAttribute("seekar") JobSeekarInfo seekar, Map<String, Object> map)
			throws Exception {
		String location = envi.getProperty("store.data");

		File locationStore = new File(location);
		if (!locationStore.exists()) {
			locationStore.mkdir();
		}

		MultipartFile photoFile = seekar.getPhoto();
		MultipartFile resumeFile = seekar.getResume();
		String photoPath = photoFile.getOriginalFilename();
		String resumePath = resumeFile.getOriginalFilename();
		InputStream photoIos = photoFile.getInputStream();
		InputStream resumeIos = resumeFile.getInputStream();
		OutputStream photoOs = new FileOutputStream(location + "/" + photoPath);
		OutputStream resumeOs = new FileOutputStream(location + "/" + resumePath);
		IOUtils.copy(photoIos, photoOs);
		IOUtils.copy(resumeIos, resumeOs);
		JobSeekar jseekar = new JobSeekar();
		jseekar.setName(seekar.getName());
		jseekar.setGender(seekar.getGender());
		jseekar.setPhoto(location + "/" + photoPath);
		jseekar.setResume(location + "/" + resumePath);
		String message = service.registerJobProfile(jseekar);
		map.put("message", message);
		photoIos.close();
		resumeIos.close();
		photoOs.close();
		resumeOs.close();
		return "result_page";
	}

	@GetMapping("/list_of_profiles")
	public String getListOfProfilesTwoDownload(Map<String, Object> map,
			@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC, sort = "name") Pageable pageable) {

		Page<JobSeekar> pagedata = service.fetchListOfProfiles(pageable);
		map.put("pageData", pagedata);
		return "list_of_profiles";
	}

	@GetMapping("/download_info")
	public String downloadInfo(@RequestParam("file") String path, HttpServletResponse res) throws Exception {

		File file = new File(path);
		res.setContentLengthLong(file.length());
		String mimetype = sc.getMimeType(path);
		mimetype = mimetype != null ? mimetype : "application/octet-stream";
		res.setContentType(mimetype);
		InputStream is = new FileInputStream(file);
		OutputStream os = res.getOutputStream();
		res.setHeader("Content-Disposition", "attachment;fileName=" + file.getName());
		IOUtils.copy(is, os);
		is.close();
		os.close();
		return null;
	}
}
