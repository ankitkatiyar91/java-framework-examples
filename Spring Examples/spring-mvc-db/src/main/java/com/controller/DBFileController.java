package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.domain.FileModel;

@Controller
@RequestMapping("/dbfile")
public class DBFileController {

	@Autowired
	public SessionFactory sessionFactory;

	@RequestMapping("")
	public String showForm() {
		System.out.println("sessionFactory->>" + sessionFactory);
		return "dbfile/index";
	}

	@RequestMapping("/upload")
	public ModelAndView uploadFile(ModelAndView model,
			@RequestParam(required = false) MultipartFile file,
			@RequestParam(required = false) String name, FileModel command,
			HttpServletRequest request) throws IOException {
		System.out.println("FileUpload.uploadFile()");
		System.out.println("name-" + name + " File->" + file + " command->"
				+ command);

		if (file != null) {
			System.out.println("file->" + file.getOriginalFilename() + "  "
					+ file.getName());
			System.out.println("sessionFactory->" + sessionFactory);

			
				Session session = sessionFactory.openSession();
				/*
				 * session.beginTransaction(); FileModel fileModel=new
				 * FileModel(); fileModel.setFile(new blob);
				 * session.save(fileModel); session.getTransaction().commit();
				 */
				FileModel fileModel = new FileModel();
				fileModel.setFile(file.getBytes());
				session.save(fileModel);

				model.addObject("image", fileModel.getId());
			
		}

		model.setViewName("dbfile/index");
		return model;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// Convert multipart object to byte[]
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@RequestMapping(value = "/image/{id}")
	public @ResponseBody
	byte[] showImage(@PathVariable Integer id) {
		System.out.println("Display image with Id->" + id);
		FileModel model = (FileModel) sessionFactory.openSession().get(
				FileModel.class, id);
		return model.getFile();
	}

	/**
	 * Error Controller
	 */

	@ExceptionHandler
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
		System.out.println("DBFileController.handleError() "+req.getRequestURL());
		//ExceptionHandlerExceptionResolver resolver=(ExceptionHandlerExceptionResolver)handler;
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
}
