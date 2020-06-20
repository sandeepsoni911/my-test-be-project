package com.sandeep.dto;

import java.util.List;

/**
 * Loan details Response
 * @author sandeepsoni
 *
 */
public class LoanListResponse {
	
	private String message;
	
	private String status;
	
	private List<LoanDetailsDto> data;
	
	private Integer perPage;
	
	private Integer pageNumber;
	
	private Integer totalCount;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the data
	 */
	public List<LoanDetailsDto> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<LoanDetailsDto> data) {
		this.data = data;
	}

	/**
	 * @return the perPage
	 */
	public Integer getPerPage() {
		return perPage;
	}

	/**
	 * @param perPage the perPage to set
	 */
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
