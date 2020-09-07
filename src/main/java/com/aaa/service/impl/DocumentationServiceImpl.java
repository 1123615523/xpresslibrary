package com.aaa.service.impl;

import com.aaa.dao.DocumentationDao;
import com.aaa.entity.Customerinfo;
import com.aaa.entity.Documentation;
import com.aaa.service.DocumentationService;
import com.aaa.utils.PageModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lowagie.text.pdf.PdfReader;
import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jodconverter.DocumentConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DocumentationServiceImpl implements DocumentationService {

    @Resource
    DocumentationDao documentationDao;

    @Resource
    DocumentConverter documentConverter;

    @Override
    public List<Documentation> findTest() {
        System.out.println(documentationDao.findType(1));
        return documentationDao.findType(1);
    }

    /**收藏操作时，对收藏量进行修改*/
    @Override
    public Integer updatefavorites( Integer favorites,Integer did) {
        return documentationDao.updatefavorites(favorites,did);
    }

    @Override
    public Map<String, Object> findType() {
        HashMap<String, Object> map = new HashMap<>();
        List<Documentation> one = documentationDao.findType(1);
        List<Documentation> two = documentationDao.findType(2);
        List<Documentation> there = documentationDao.findType(3);
        List<Documentation> four = documentationDao.findType(4);
        map.put("one",one);
        map.put("two",two);
        map.put("there",there);
        map.put("four",four);
        return map;
    }

    @Override
    public List<Documentation> findNewDocument(Integer did) {
        return documentationDao.findNewDocument(did);
    }

    @Override
    public PageModel<Documentation> findDocumentByResorce(PageModel pm) {
        PageHelper.startPage(pm.getCurrentPage(),pm.getPageSize());
        String detasid = pm.getKeyWord().toString();
        List<Documentation> documentInfo = documentationDao.findDocumentByDetaisid(Integer.parseInt(detasid));
        pm.setRows(documentInfo);
        PageInfo<Documentation> pageInfo = new PageInfo<>(documentInfo);
        int pages = pageInfo.getPages();
        long total = pageInfo.getTotal();
        pm.setTotal(total);
        pm.setLastPage(pages);
        return pm;
    }

    @Override
    public Integer add(Documentation documentation) {
        return documentationDao.add(documentation);
    }

    @Override
    @Transactional
    public String upload(MultipartFile file, HttpSession session, String title, String essentialcode, Integer detaisid, String introduction, Integer previewpage, Integer allowdownload, Integer original, Integer sellingprice) {
        try {
            Customerinfo attribute = (Customerinfo) session.getAttribute("cus");
            //获取文件原名称
            String filename = file.getOriginalFilename();
            int dot = filename.lastIndexOf('.');
            // 获取文件名
            String NewFile =filename.substring(0, dot);
            //获取文件后缀(格式)
            String extension = FilenameUtils.getExtension(filename);
            //获取文件大小
            float size = file.getSize()/1024;
//            float sizes = size;
            //文档路径
            String libraryFile = "F:/libraryFile";
            File dataDir = new File(libraryFile);
            if (!dataDir.exists()){
                //创建目录(多级)
                dataDir.mkdirs();
            }
            file.transferTo(new File(dataDir,filename));
            String test = filename.substring(0,filename.lastIndexOf("."));
            //转成pdf格式
            String topdf = libraryFile+"/"+filename;
            File pdffile = new File(topdf);
            String libraryPdf = "F:/libraryPdf";
            String filepdf = libraryPdf+"/"+test+".pdf";
            File newfile = new File(libraryPdf);
            if (!newfile.exists()){
                newfile.mkdirs();
            }
            //文件转换
            documentConverter.convert(pdffile).to(new File(filepdf)).execute();
            //pdf转图片
            File files = new File(filepdf);
            String dstImgFolder = "F:/libraryImg";
            PDDocument pdDocument;
            int pages = 0;

            String imgPDFPath = files.getParent();
            String str = "1234567890";
            String imagePDFName = "";
            for(int i= 0;i<6;i++){
                int index = (int)(Math.random()*str.length());
                imagePDFName+=str.charAt(index);
            }
            String imgFolderPath = null;
            if (dstImgFolder.equals("")) {
                // 获取图片存放的文件夹路径
                imgFolderPath = imgPDFPath + File.separator + imagePDFName;
            } else {
                imgFolderPath = dstImgFolder + File.separator + imagePDFName;
            }
            //设置封面
            String filepath = "/image/"+imagePDFName+"/1.png";
            //获取图片文件夹路径
            String imgsname = "/image/"+imagePDFName;
            if (createDirectory(imgFolderPath)) {

                pdDocument = PDDocument.load(files);
                PDFRenderer renderer = new PDFRenderer(pdDocument);
                PdfReader reader = new PdfReader(filepdf);
                //转成图片后的页数
                pages = reader.getNumberOfPages();

                StringBuffer imgFilePath = null;
                for (int i = 0; i < pages; i++) {
                    String imgFilePathPrefix = imgFolderPath + File.separator;
                    imgFilePath = new StringBuffer();
                    imgFilePath.append(imgFilePathPrefix);
                    imgFilePath.append(String.valueOf(i + 1));
                    imgFilePath.append(".png");
                    File dstFile = new File(imgFilePath.toString());
                    /* dpi越大转换后越清晰，相对转换速度越慢 */
                    BufferedImage image = renderer.renderImageWithDPI(i, 200);
                    ImageIO.write(image, "png", dstFile);
                }
                System.out.println("PDF文档转PNG图片成功！");

            } else {
                System.out.println("PDF文档转PNG图片失败：" + "创建" + imgFolderPath + "失败");
            }
            //数据库添加
            Documentation hui = new Documentation();
            hui.setFilename(NewFile);
            hui.setTitle(title);
            hui.setEssentialcode(essentialcode);
            hui.setDetaisid(detaisid);
            hui.setIntroduction(introduction);
            if (previewpage > pages){
                hui.setPreviewpage(pages);
            }else {
                hui.setPreviewpage(previewpage);
            }
            hui.setPages(pages);
            hui.setAllowdownload(allowdownload);
            hui.setOriginal(original);
            hui.setSellingprice(sellingprice);
            hui.setReleasetime(new Date());
            hui.setDownloads(0);
            hui.setPageviews(0);
            hui.setFavorites(0);
            hui.setDocumentstatus(1);
            hui.setAuthored(attribute.getCustomerid());
            hui.setDocumentformat(extension);
            hui.setDocumentsize(size);
            hui.setFilepath(filepath);
            hui.setImgsname(imgsname);
            hui.setDocumentpath(libraryFile);
            Integer add = documentationDao.add(hui);
            if (add != null){
                return "1";
            }else {
                return "0";
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**今日特别推荐查询方法*/
    @Override
    public List<Documentation> documentationespecially() {
        return documentationDao.documentationespecially();
    }


    /**根据文档id值进行查询文档详细信息*/
    @Override
    public Map<String, Object> bydid(Integer did) {
        return documentationDao.bydid(did);
    }

    /**更具用户id获取自己的所有文档*/
    @Override
    public List<Documentation> findbyid(Integer authored) {
        return documentationDao.findbyid(authored);
    }

    /**根据文档id获取文档信息*/
    @Override
    public Documentation findbydid(Integer did) {
        return documentationDao.findbydid(did);
    }

    /**最近上传查询方法*/
    @Override
    public List<Documentation> documentationlatest() {
        return documentationDao.documentationlatest();
    }
    /**根据ppt格式进行查询随机14条数据*/
    @Override
    public List<Documentation> documentationppt() {
        return documentationDao.documentationppt();
    }

    /**根据用户个人上传的文档数量查询牛人榜*/
    @Override
    public List<Map<String, Object>> findbull() {
        return documentationDao.findbull();
    }

    /**该方法文件转换为pdf的时候进行调用*/
    private static boolean createDirectory(String folder) {
        File dir = new File(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }
}
