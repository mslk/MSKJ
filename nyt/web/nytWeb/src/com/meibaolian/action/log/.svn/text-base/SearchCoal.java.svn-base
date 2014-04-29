package com.meibaolian.action.log;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.SearchLogCoalDto;
import com.meibaolian.entity.SearchLogCoal;
import com.meibaolian.service.log.ISearchLogCoalService;
import com.meibaolian.util.UtilHelp;

public class SearchCoal extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ISearchLogCoalService searchLogCoalService;
	private SearchLogCoalDto searchLogCoalDto = new SearchLogCoalDto();

	public SearchLogCoalDto getSearchLogCoalDto() {
		return searchLogCoalDto;
	}

	public void setSearchLogCoalDto(SearchLogCoalDto searchLogCoalDto) {
		this.searchLogCoalDto = searchLogCoalDto;
	}
	
	public void setSearchLogCoalService(ISearchLogCoalService searchLogCoalService) {
		this.searchLogCoalService = searchLogCoalService;
	}
	
	
	public String search(){
		
		searchLogCoalDto.setKeyword( UtilHelp.trimStr(searchLogCoalDto.getKeyword()));
		
		QueryResult<SearchLogCoal> qr = searchLogCoalService.searchList(searchLogCoalDto, getPage(),PAGESIZE, null);
		savePageView(new PageView<SearchLogCoal>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("searchLogCoalDto", searchLogCoalDto);
		return SUCCESS;
		
	}
	
}
