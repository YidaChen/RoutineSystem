package com.javasj.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.map.ObjectMapper;

public class UploadServlet extends HttpServlet {
	private PrintWriter writer = null;
	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final long serialVersionUID = 1L;
    public UploadServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getSession().getServletContext();
        String savePath = application.getRealPath("/") + "upload/";
        // 文件保存目录URL
        String saveUrl = request.getContextPath() + "/upload/";
        // 定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
  
        // 最大文件大小
        long maxSize = 100000;
  
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        writer = response.getWriter();
        if (!ServletFileUpload.isMultipartContent(request)) {
            writer.println(objectMapper.writeValueAsString(getError("请选择文件。")));
            return;
  
        }
        // 检查目录
        File uploadDir = new File(savePath);
        if (!uploadDir.isDirectory()) {
            writer.println(objectMapper.writeValueAsString(getError("上传目录不存在。")));
            return;
        }
        // 检查目录写权限
        if (!uploadDir.canWrite()) {
            writer.println(objectMapper.writeValueAsString(getError("上传目录没有写权限。")));
            return;
        }
  
        String dirName = request.getParameter("dir");
        if (dirName == null) {
            dirName = "image";
        }
        if (!extMap.containsKey(dirName)) {
            writer.println(objectMapper.writeValueAsString(getError("目录名不正确。")));
            return;
        }
        // 创建文件夹
        savePath += dirName + "/";
        saveUrl += dirName + "/";
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
        savePath += ymd + "/";
        saveUrl += ymd + "/";
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
  
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
		List items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Iterator itr = items.iterator();
        while (itr.hasNext()) {
            FileItem item = (FileItem) itr.next();
            String fileName = item.getName();
            if (!item.isFormField()) {
                // 检查文件大小
                if (item.getSize() > maxSize) {
                    writer.println(objectMapper.writeValueAsString(getError("上传文件大小超过限制。")));
                    return;
                }
                // 检查扩展名
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
                    writer.println(objectMapper.writeValueAsString(getError("上传文件扩展名是不允许的扩展名。\n只允许"+ extMap.get(dirName) + "格式。")));
                    return;
                }
  
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                String newFileName =df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
                try {
                    File uploadedFile = new File(savePath, newFileName);
                    item.write(uploadedFile);
                } catch (Exception e) {
                    writer.println(objectMapper.writeValueAsString(getError("上传文件失败。")));
                }
  
                Map<String, Object> msg = new HashMap<String, Object>();
                msg.put("error", 0);
                msg.put("url", saveUrl + newFileName);
                writer.println(objectMapper.writeValueAsString(msg));
                return;
            }
        }
        return;
	}
 
	private Map<String, Object> getError(String message) {
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("error", 1);
        msg.put("message", message);
        return msg;
    }

}
