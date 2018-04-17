package com.sunesoft.ecloud.files.api;


import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.files.biz.application.dtos.FileUploadDto;
import com.sunesoft.ecloud.files.biz.application.service.FileInfoService;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
public class FileController {


    @GetMapping("/infos")
    public String getinfo(){
        return "ceshijiekou";
    }

//    public TResult fileUpload(@PathParam("file") MultipartFile file, @PathParam("usage") String usage, @PathParam("sync") boolean sync){
//
//    }
    @Autowired
FileInfoService fileInfoService;
    @PostMapping(value = "/file_upload")
    public TResult uploadFile(@RequestParam("files") List<MultipartFile> files, FileUploadDto fileUploadDto) throws IOException {
        TResult result;
        //设置响应给前台内容的PrintWriter对象
        //上传文件的原名(即上传前的文件名字)
        String originalFilename = null;
        if(files==null){
            result = new TResult(false, "请选择要上传的文件！");
            return result;
        }
//        List<MultipartFile> myfiles = ((DefaultMultipartHttpServletRequest) request).getFiles("files");
        //如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
        //如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
        //上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
        for (MultipartFile myfile : files) {
            //if (myfile.isEmpty()) {
            if (myfile == null) {
                result = new TResult(false, "请选择要上传的文件！");
                return result;
            } else {
//                originalFilename = myfile.getOriginalFilename();
                try {
                    String fileName = myfile.getOriginalFilename();
                    String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    FileInfoDto fileInfoDto = new FileInfoDto();
                    fileInfoDto.setAgId(UUID.fromString(UserContext.getAgencyId()));
                    fileInfoDto.setDocType(fileUploadDto.getDocType());
                    fileInfoDto.setFileName(fileName);
                    fileInfoDto.setExtensions(extension);
                    fileInfoDto.setInputStream(myfile.getInputStream());
                    fileInfoService.upload(fileInfoDto);
                    //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
                    //此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
                    //FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, UUID.randomUUID().toString()));
                } catch (IOException e) {
                    System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
                    e.printStackTrace();
                    result = new TResult(false, "文件上传失败，请重试！！");
                    return result;
                }
            }
        }
        return ResultFactory.success();
    }
//
//    /**
//     * 修改文件下载无后缀，且文件名乱码
//     * edit by pxj
//     *
//     * @param request
//     * @param response
//     * @return
//     * @throws IOException
//     */
//
//    @RequestMapping(value = "/downloadFile")
//    public String downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String id = request.getParameter("id");
//
//        DownloadFileDto dto = fileInfoService.getFileById(id);
//        if (dto == null) return null;//xzl
//        InputStream in = dto.getInputStream();
//        //创建输出流
//        OutputStream out = response.getOutputStream();
//        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(dto.getFileName(), "UTF-8"));
//        // response.setHeader("content-disposition", "attachment;filename=" + new String(dto.getFileName().getBytes("gb2312"),"iso8859-1"));
//        //创建缓冲区
//        byte buffer[] = new byte[1024];
//        int len = 0;
//        //循环将输入流中的内容读取到缓冲区当中
//        while ((len = in.read(buffer)) > 0) {
//            //输出缓冲区的内容到浏览器，实现文件下载
//            out.write(buffer, 0, len);
//        }
//        //关闭文件输入流
//        in.close();
//        //关闭输出流
//        out.close();
//        return null;
//    }
//

    @RequestMapping(value = "/deleteFile")
    @ResponseBody
    public TResult deleteFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        TResult result = fileInfoService.delete(id);
        return result;
    }

    @RequestMapping(value = "/deleteFloder")
    @ResponseBody
    public TResult deleteFloder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        TResult result = fileInfoService.deleteFilePath(Long.parseLong(id));
        return result;
    }
}