package com.dmantz.ecapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.dmantz.ecapp.model.CatalogDirRow;
import com.dmantz.ecapp.request.CatalogRequestRo;
import com.dmantz.ecapp.response.CatalogDirRowResponseObj;
//import com.dmantz.ecapp.model.CatalogDirRow;
import com.dmantz.ecapp.service.GetNavigationDataService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/")
@EnableSwagger2
@CrossOrigin(origins = "http://192.168.100.27:4200")
public class CatalogNavigationController {

	@Autowired
	private GetNavigationDataService navigationService;

	@RequestMapping(value = "/catalog_dir", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogDirRowResponseObj> getCatalogDir(@RequestBody(required = true) @Valid CatalogRequestRo catalogRequestRo) {
		return navigationService.getCatalogDir(catalogRequestRo);
		// return navigationService.getCatalogDir(startLevel, endLevel,null,
		// parentCatalogId);
	}
}