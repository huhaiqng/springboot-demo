package com.hhq.uploadingfiles;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hhq.uploadingfiles.storage.StroageService;

@Controller
public class FileUploadController {
	private final StroageService stroageService;
	
	@Autowired
	public FileUploadController(StroageService stroageService) {
		this.stroageService = stroageService;
	}
	
	@GetMapping("/")
	public String listUploadFiles(Model model) throws IOException {
		model.addAttribute("files", stroageService.loadAll().map(path -> MvcUriComponentsBuilder
				.fromMethodName(
						FileUploadController.class, 
						"serveFile", 
						path.getFileName().toString())
				.build().toUri().toString())
				.collect(Collectors.toList()));
		return "uploadForm";
	}
	
	@GetMapping("/files/{filename:.*}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = stroageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		stroageService.store(file);
		redirectAttributes.addFlashAttribute("message", "You successfully uploaded" + file.getOriginalFilename() + "!");
		return "redirect:/";
	}
//	@ExceptionHandler(StorageFileNotFoundException.class)
//	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotfoundException exc) {
//		return ResponseEntity.notFound().build();
//	}
}
