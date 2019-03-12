package com.dmantz.ecapp.service;

import java.util.List;

import com.dmantz.ecapp.model.CatalogDirRow;
import com.dmantz.ecapp.request.CatalogRequestRo;

public interface NavigationserviceImpl {

	//List<CatalogDirRow> getCatalogDir(Integer startLevel,Integer endLevel,List<CatalogDirRow> curCatalog, Integer parentCatalogId);
	List<CatalogDirRow> getCatalogDir(CatalogRequestRo catalogRequestRo);
	List<CatalogDirRow> getCatalogDirR(Integer startLevel,Integer endLevel,CatalogDirRow parentCatalogRow, Integer parentCatalogId, List<CatalogDirRow> catalogdirRow);
	//List<CatalogDirRow> getCatalogDirR(CatalogDirRow parentCatalogRow, Integer parentCatalogId, List<CatalogDirRow> catalogdirRow,CatalogRequestRo catalogRequestRo);
}
