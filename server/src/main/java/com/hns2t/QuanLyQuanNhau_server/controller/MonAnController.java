package com.hns2t.QuanLyQuanNhau_server.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hns2t.QuanLyQuanNhau_server.dao.MonAnRepository;
import com.hns2t.QuanLyQuanNhau_server.exception.ResourceNotFoundException;
import com.hns2t.QuanLyQuanNhau_server.model.MonAn;
import com.hns2t.QuanLyQuanNhau_server.payload.MonAnRequest;
import com.hns2t.QuanLyQuanNhau_server.utils.FileUploadUtils;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
public class MonAnController {
	@Autowired
	private MonAnRepository repo;

	@GetMapping("/monans")
	public List<MonAn> getAll() {
		return repo.findAll();
	}

	@PostMapping(value = "/monans",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public MonAn createMonAn(@ModelAttribute MonAnRequest monAnRequest) throws IOException {
		
		System.out.println(monAnRequest.getMa_ten());

		MonAn monAn = new MonAn();
		monAn.setMa_ten(monAnRequest.getMa_ten());
		monAn.setMa_giaban(monAnRequest.getMa_giaban());
		monAn.setMa_donvitinh(monAnRequest.getMa_donvitinh());
		monAn.setMa_giavon(monAnRequest.getMa_giavon());
		monAn.setMa_motachitiet(monAnRequest.getMa_motachitiet());

		if (monAnRequest.getImage() != null) {
			String fileName = StringUtils.cleanPath(monAnRequest.getImage().getOriginalFilename());

			monAn.setMa_hinhanh(fileName);

			MonAn savedMonAn = repo.save(monAn);

			String uploadDir = "/mon-an/" + savedMonAn.getMa_id();

			FileUploadUtils.saveFile(uploadDir, fileName, monAnRequest.getImage());

			return savedMonAn;
		}

		return repo.save(monAn);
	}

	@GetMapping("/monans/{id}")
	public ResponseEntity<MonAn> getMonAn(@PathVariable Long id) {
		MonAn object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Mon an khong ton tai with: " + id));
		return ResponseEntity.ok(object);
	}

	@PutMapping("/monans/{id}")
	public ResponseEntity<MonAn> updateMonAn(@PathVariable Long id, @RequestBody MonAn monAnDetail) {
		MonAn object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Mon an khong ton tai with: " + id));
		object.setMa_ten(monAnDetail.getMa_ten());
		object.setMa_giaban(monAnDetail.getMa_giaban());
		object.setMa_donvitinh(monAnDetail.getMa_donvitinh());
		object.setMa_giavon(monAnDetail.getMa_giavon());
		object.setMa_hinhanh(monAnDetail.getMa_hinhanh());
		object.setMa_motachitiet(monAnDetail.getMa_motachitiet());
		MonAn updateMonAn = repo.save(object);
		return ResponseEntity.ok(updateMonAn);
	}

	@DeleteMapping("/monans/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMonAn(@PathVariable Long id) {
		MonAn monAn = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Mon an khong ton tai with: " + id));
		repo.delete(monAn);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
