package com.sunesoft.ecloud.files.api;


import com.sunesoft.ecloud.auth.UserContext;
import com.sunesoft.ecloud.common.result.ListResult;
import com.sunesoft.ecloud.common.result.TResult;
import com.sunesoft.ecloud.common.result.resultFactory.ResultFactory;
import com.sunesoft.ecloud.files.biz.application.criterias.FileCriteria;
import com.sunesoft.ecloud.files.biz.application.dtos.DownloadFileDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FileInfoDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FileRelateDto;
import com.sunesoft.ecloud.files.biz.application.dtos.FileUploadDto;
import com.sunesoft.ecloud.files.biz.application.query.FileQueryService;
import com.sunesoft.ecloud.files.biz.application.service.FileInfoService;
import com.sunesoft.ecloud.files.biz.application.service.FilePathService;
import com.sunesoft.ecloud.files.biz.domain.FilePath;
import com.sunesoft.ecloud.files.biz.domain.enums.PathType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;


@RestController
public class FileController {


    @Autowired
    FileInfoService fileInfoService;


    @Autowired
    FilePathService filePathService;


    @Autowired
    FileQueryService fileQueryService;


    private static Map<UUID, String> fileDynmicId = new HashMap<>();

    @PostMapping(value = "/simple_file_relate")

    public TResult simpleFileRelate(List<FileRelateDto> fileRelateDtos) throws IOException {
        UUID agId = UUID.fromString(UserContext.getAgencyId());

        for (FileRelateDto relateDto : fileRelateDtos) {
            if (relateDto.getPathId() == null) {
                FilePath pathByType = filePathService.getPathByType(agId,
                        relateDto.getBaseRoot(),
                        relateDto.getDocType(),
                        relateDto.getRequirePathType());
                if (pathByType != null) {
                    fileRelateDtos.stream().filter(x ->
                            x.getBaseRoot().equals(relateDto.getBaseRoot()) &&
                                    x.getDocType().equals(relateDto.getDocType()))
                            .forEach(x -> x.setPathId(pathByType.getId()));
                }
            }
        }
        return fileInfoService.fileRelate(agId, fileRelateDtos);
    }


    @PostMapping(value = "/simple_file_upload")
    public TResult simpleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        TResult result;
        String originalFilename = null;
        if (file == null) {
            result = new TResult(false, "请选择要上传的文件！");
            return result;
        }
        try {
            String fileName = file.getOriginalFilename();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            FileInfoDto fileInfoDto = new FileInfoDto();
            fileInfoDto.setAgId(agId);
            fileInfoDto.setDocType("temp");
            fileInfoDto.setBizType("temp");
            fileInfoDto.setFileSize(file.getSize());
            fileInfoDto.setFileName(fileName);
            fileInfoDto.setBaseRoot("temp");
            fileInfoDto.setExtensions(extension);
            fileInfoDto.setInputStream(file.getInputStream());
            fileInfoDto.setRequirePathType(PathType.Temp);
            fileInfoService.upload(fileInfoDto);
        } catch (IOException e) {
            System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
            e.printStackTrace();
            result = new TResult(false, "文件上传失败，" + e.getMessage());
            return result;
        }
        return ResultFactory.error("no file found");
    }


    @PostMapping(value = "/file_upload")
    public TResult uploadFile(@RequestParam("files") List<MultipartFile> files, FileUploadDto fileUploadDto) throws IOException {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        TResult result;
        //设置响应给前台内容的PrintWriter对象
        //上传文件的原名(即上传前的文件名字)
        String originalFilename = null;
        if (files == null || files.size() == 0) {
            result = new TResult(false, "请选择要上传的文件！");
            return result;
        }

        List<UUID> upId = new ArrayList<>();
//        List<MultipartFile> myfiles = ((DefaultMultipartHttpServletRequest) request).getFiles("files");
        //如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
        //如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
        //上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
        for (MultipartFile myfile : files) {
            try {
                String fileName = myfile.getOriginalFilename();
                String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                FileInfoDto fileInfoDto = new FileInfoDto();
                if (fileUploadDto.getId() != null) {
                    fileInfoDto.setId(fileUploadDto.getId());
                }
                fileInfoDto.setAgId(agId);
                fileInfoDto.setDocType(fileUploadDto.getDocType());
                fileInfoDto.setBizType(fileUploadDto.getBizType());
                fileInfoDto.setFileSize(myfile.getSize());
                fileInfoDto.setFileName(fileName);
                fileInfoDto.setBaseRoot(fileUploadDto.getBaseRoot());
                fileInfoDto.setExtensions(extension);
                fileInfoDto.setInputStream(myfile.getInputStream());
                fileInfoDto.setRequirePathType(fileUploadDto.getRequirePathType());
                FilePath pathByType = filePathService.getPathByType(agId,
                        fileUploadDto.getBaseRoot(),
                        fileUploadDto.getDocType(),
                        fileUploadDto.getRequirePathType());
                fileInfoDto.setFile_path_id(pathByType.getId());
                TResult upload = fileInfoService.upload(fileInfoDto);
                upId.add((UUID) upload.getResult());

                //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
                //此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
                //FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, UUID.randomUUID().toString()));
            } catch (IOException e) {
                System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
                e.printStackTrace();
                result = new TResult(false, "文件上传失败，" + e.getMessage());
                return result;
            }
        }
        return ResultFactory.success(upId);
    }


    @GetMapping("/get_file_list/{baseRoot}/{docType}")
    public ListResult getFileList(@PathVariable("baseRoot") String baseRoot, @PathVariable("docType") String docType) throws IOException {

        UUID agId = UUID.fromString(UserContext.getAgencyId());
        FileCriteria fileCriteria = new FileCriteria();
        fileCriteria.setAgId(agId);
        fileCriteria.setBaseRoot(baseRoot);
        fileCriteria.setDocType(docType);

        List<FileInfoDto> fileInfoDtos = fileQueryService.GetFileInfo(fileCriteria);
        return new ListResult(fileInfoDtos);
    }


    @GetMapping(value = "/pre_download/{id}")
    public TResult preDownload(@PathVariable("id") UUID id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        UUID dynamicId = UUID.randomUUID();
        fileDynmicId.put(dynamicId, id.toString() + "," + UserContext.getAgencyId());
        return ResultFactory.success("/downloadFile/" + dynamicId);


    }

    @GetMapping(value = "/dyn_downloadFile/{id}")
    public String dynDownloadFile(@PathVariable("id") UUID id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileId = fileDynmicId.get(id);
        if (fileId == null) {
            return "文件不存在，或路径已失效（下载路径只能使用一次）！";//xzl
        }
        String[] ids = fileId.split(",");
        fileDynmicId.remove(id);

        DownloadFileDto dto = fileQueryService.getFileById(UUID.fromString(ids[1]), UUID.fromString(ids[0]));
        if (dto == null)
            return "文件不存在，或路径已失效（下载路径只能使用一次）！";//xzl
        InputStream in = dto.getInputStream();
        //创建输出流
        OutputStream out = response.getOutputStream();
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(dto.getFileName(), "UTF-8"));
         //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
        return null;
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
    @GetMapping(value = "/downloadFile/{id}")
    public ResponseEntity downloadFile(@PathVariable("id") UUID id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID agId = UUID.fromString(UserContext.getAgencyId());
        return getFile(agId, id);
    }


    private ResponseEntity getFile(UUID agId, UUID id) throws UnsupportedEncodingException {
        DownloadFileDto dto = fileQueryService.getFileById(agId, id);
        if (dto == null)
            return null;//xzl
        //设置response返回头部信息
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(dto.getFileName(), "UTF-8") + "\"");

        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        FileInputStream input = null;
        long len = 0L;

        try {
            input = dto.getInputStream();
            len = dto.getFileLength();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置返回实体的头部、长度及类型
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(len)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(input));


    }

    @RequestMapping(value = "/deleteFile")
    @ResponseBody
    public TResult deleteFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        UUID agId = UUID.fromString(UserContext.getAgencyId());

        TResult result = fileInfoService.delete(agId, UUID.fromString(id));
        return result;
    }

    @GetMapping(value = "/public/{id}")
    public ResponseEntity getWebImag(@PathVariable("id") UUID id) throws IOException {
        DownloadFileDto dto = fileQueryService.getPublicFile(id);
        if (dto == null)
            return null;//xzl
        //设置response返回头部信息
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(dto.getFileName(), "UTF-8") + "\"");

        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        FileInputStream input = null;
        long len = 0L;

        try {
            input = dto.getInputStream();
            len = dto.getFileLength();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置返回实体的头部、长度及类型
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(len)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(input));



    }

    @GetMapping(value = "/globle/{baseRoot}/{docType}")
    public ListResult getWebImag(@PathVariable("baseRoot") String baseRoot, @PathVariable("docType") String docType) throws IOException {

        FileCriteria criteria = new FileCriteria();
        criteria.setBaseRoot(baseRoot);
        criteria.setDocType(docType);
        List<FileInfoDto> fileInfoDtos = fileQueryService.GetFileInfo(criteria);
        return new ListResult(fileInfoDtos);

    }


}