package com.dmantz.ecapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

//import com.dmantz.ecapp.model.CatalogDirRow;
import com.dmantz.ecapp.request.CatalogRequestRo;
import com.dmantz.ecapp.response.CatalogDirRowResponseObj;
//import com.dmantz.ecapp.request.CatalogRequestRO;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.dmantz.ecapp.model.CatalogDirRow;
//import com.mysql.cj.xdevapi.JsonArray;

@Service
public class GetNavigationDataService implements NavigationserviceImpl {

	@Autowired
	private JdbcTemplate jt;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;
	

	public List<CatalogDirRowResponseObj> getCatalogDir(CatalogRequestRo catalogRequestRo) {

		//String query = "SELECT catalog_id,parent_catalog_id,catalog_level,catalog_name,catalog_desc,store_id FROM catalog_dir Where store_id=1 and catalog_level between 0 and 3";
		String query = "SELECT * FROM catalog_dir Where store_id=:storeId and  catalog_level between :startLevel and :endLevel";
		Map<String,Object>paramMap=new HashMap<String,Object>();
		paramMap.put("storeId", catalogRequestRo.getStoreId());
		paramMap.put("startLevel", catalogRequestRo.getStartLevel());
		paramMap.put("endLevel", catalogRequestRo.getEndLevel());
		paramMap.put("parentCatalogId", catalogRequestRo.getParentCatalogId());
		//paramMap.put("curCatalog", catalogRequestRo.getCurCatalog());
		
		
		List<CatalogDirRowResponseObj> results = namedParameterJdbcTemplate.query(query,paramMap, new BeanPropertyRowMapper<CatalogDirRowResponseObj>(CatalogDirRowResponseObj.class));
		System.out.println("values in " + results);
		return getCatalogDirR(catalogRequestRo.getStartLevel(),catalogRequestRo.getEndLevel(), null, 0, results);
		//return getCatalogDirR(null, 0, null, null, results, catalogRequestRo);
		//return results;
	}

	public List<CatalogDirRowResponseObj> getCatalogDirR(Integer startLevel, Integer endLevel, CatalogDirRowResponseObj parentCatalogRow,
			Integer parentCatalogId, List<CatalogDirRowResponseObj> catalogdirRowsDb) {
		final int levelChecker = startLevel;
		final int parentCatalogChecker = parentCatalogId;
		int childStartLevel;
		List<CatalogDirRowResponseObj> retCatalog;
		List<CatalogDirRowResponseObj> filteredCatalogdir = catalogdirRowsDb.stream().filter(
				res -> res.getCatalogLevel() == levelChecker && res.getParentCatalogId()== parentCatalogChecker)
				.collect(Collectors.toList());       
		System.out.println("stream:" + filteredCatalogdir);
	
		if (startLevel < endLevel) {

			childStartLevel = startLevel+1;			
			Iterator<CatalogDirRowResponseObj> catIterator = filteredCatalogdir.iterator();
			// for each entry in filteredCatalogdir
			// do nothing
			while(catIterator.hasNext()) {				 
			CatalogDirRowResponseObj curCatalogRow = catIterator.next();
				System.out.println("Recur Call: " + childStartLevel + ":" + endLevel + ":" + curCatalogRow.getCatalogId());
				retCatalog = getCatalogDirR(childStartLevel,endLevel,curCatalogRow,curCatalogRow.getCatalogId(),catalogdirRowsDb);
				curCatalogRow.setChildCatalog(retCatalog);				
			}
			return filteredCatalogdir;
		}
		else {
			System.out.println("start level is same as end level so returning with no recursive call");
			return filteredCatalogdir;
		}
		

		/*
		 * JsonArray obj=new JsonArray(); try {
		 * jsonfilteredCatalogdir=JsonUtility.convertJavaToJson(filteredCatalogdir);
		 * System.out.println("Json:"+jsonfilteredCatalogdir); } catch
		 * (JsonProcessingException e) { e.printStackTrace(); }
		 */
		// return jsonfilteredCatalogdir;
	
	}
	}

