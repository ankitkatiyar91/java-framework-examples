package com;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

 
public class EmployeeImageUpload extends ActionSupport implements
        ServletRequestAware {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
    private String fileContentType;
    private String fileFileName;
 
    public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private HttpServletRequest servletRequest;
 
    public String execute() {
        try {
        	 
            String filePath = servletRequest.getSession().getServletContext().getRealPath("/files/");
            System.out.println("Server path:" + filePath);
            File fileToCreate = new File(filePath,this.fileFileName.substring(this.fileFileName.lastIndexOf(".")));
            FileUtils.copyFile(this.file, fileToCreate);
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
 
            return INPUT;
        }
        return SUCCESS;
    }
 
   
}