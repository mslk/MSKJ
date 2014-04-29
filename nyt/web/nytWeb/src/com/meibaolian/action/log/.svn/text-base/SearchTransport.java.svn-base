package com.meibaolian.action.log;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.SearchLogTransportDto;
import com.meibaolian.entity.SearchLogTransport;
import com.meibaolian.service.log.ISearchLogTransportService;
import com.meibaolian.util.UtilHelp;

public class SearchTransport extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ISearchLogTransportService searchLogTransportService;
	private SearchLogTransportDto searchLogTransportDto = new SearchLogTransportDto();
	
	
	public SearchLogTransportDto getSearchLogTransportDto() {
		return searchLogTransportDto;
	}
	public void setSearchLogTransportDto(SearchLogTransportDto searchLogTransportDto) {
		this.searchLogTransportDto = searchLogTransportDto;
	}

	public void setSearchLogTransportService(
			ISearchLogTransportService searchLogTransportService) {
		this.searchLogTransportService = searchLogTransportService;
	}
	public String search(){
		
		searchLogTransportDto.setKeyword( UtilHelp.trimStr(searchLogTransportDto.getKeyword()));
		
		QueryResult<SearchLogTransport> qr = searchLogTransportService.searchList(searchLogTransportDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<SearchLogTransport>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("searchLogTransportDto", searchLogTransportDto);
		return SUCCESS;
		
	}
	
}
