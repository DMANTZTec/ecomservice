package com.dmantz.ecapp.service;

import java.util.List;

//import com.dmantz.ecapp.model.CatalogDirRow;
import com.dmantz.ecapp.request.CatalogRequestRo;
import com.dmantz.ecapp.response.CatalogDirRowResponseObj;

public interface NavigationserviceImpl {

	//List<CatalogDirRow> getCatalogDir(Integer startLevel,Integer endLevel,List<CatalogDirRow> curCatalog, Integer parentCatalogId);
	List<CatalogDirRowResponseObj> getCatalogDir(CatalogRequestRo catalogRequestRo);
	List<CatalogDirRowResponseObj> getCatalogDirR(Integer startLevel,Integer endLevel,CatalogDirRowResponseObj parentCatalogRow, Integer parentCatalogId, List<CatalogDirRowResponseObj> catalogdirRow);
	//List<CatalogDirRow> getCatalogDirR(CatalogDirRow parentCatalogRow, Integer parentCatalogId, List<CatalogDirRow> catalogdirRow,CatalogRequestRo catalogRequestRo);
}
