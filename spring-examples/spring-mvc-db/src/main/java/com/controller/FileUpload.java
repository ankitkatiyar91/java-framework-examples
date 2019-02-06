package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class FileUpload implements Validator, ApplicationContextAware {
	
	@RequestMapping("")
	public String uploadForm(HttpServletRequest servletBean) {
		System.out.println("FileUpload.uploadForm()");
		return "fileuploadform";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadFile(ModelAndView model,
			@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) String name, Object command,HttpServletRequest request) {
		System.out.println("FileUpload.uploadFile()");
		System.out.println("name-" + name + " File->" + file + " command->"
				+ command);

		
		if (file != null && !StringUtils.isEmpty(file.getOriginalFilename())) {
			System.out.println("file->" + file.getOriginalFilename() + "  "
					+ file.getName());
			@SuppressWarnings("deprecation")
			File newFile = new File(request.getRealPath("/images")+File.separator+file.getOriginalFilename());
			try {
				OutputStream outputStream=FileUtils.openOutputStream(newFile);
				IOUtils.copy(file.getInputStream(),outputStream);
				System.out.println("New File->" + newFile.getAbsolutePath());
				outputStream.close();
				model.addObject("file", newFile.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		model.setViewName("fileuploadform");
		return model;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		System.out.println("FileUpload.initBinder()");
		// Convert multipart object to byte[]
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());

	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	public void validate(Object target, Errors errors) {
		System.out.println("FileUpload.validate()");

	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}

	private ApplicationContext applicationContext;
}
