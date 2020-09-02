package com.aaa.frontcontroller;

import com.aaa.entity.Customerinfo;
import com.aaa.service.CustomerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @ResponseBody
    @RequestMapping("updPassword")
    public Integer updPassword(Integer id,String pwd,HttpSession session){
        Integer res = customerService.updPassword(id, pwd);
        if(res > 0){
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("updSignature")
    public Integer updSignature(Integer id,String meno,HttpSession session){
        Integer res = customerService.updSignature(id, meno);
        if(res > 0){
            session.removeAttribute("cus");
            Customerinfo customerinfo = customerService.updLogin(id);
            session.setAttribute("cus",customerinfo);
            return 1;
        }
        return 0;
    }

    @RequestMapping("upd")
    @ResponseBody
    public Integer upd(@RequestBody Customerinfo customerinfo){
        System.out.println(customerinfo.toString());
        Integer updCustomer = customerService.updCustomer(customerinfo);
        if(updCustomer > 0){
            return 1;
        }
        return 0;
    }

    @RequestMapping("updLogin")
    @ResponseBody
    public Integer updLogin(Integer id,HttpSession session){
        session.removeAttribute("cus");
        Customerinfo customerinfo = customerService.updLogin(id);
        if(null != customerinfo){
            session.setAttribute("cus",customerinfo);
            return 1;
        }
        return 0;
    }

    @RequestMapping("add")
    @ResponseBody
    public Object add(Customerinfo customerinfo){
        customerinfo.setCustomerstate(1);
        customerinfo.setCustomermoney(0.00);
        customerinfo.setCustomerpic("/static/wd/avatar_small.gif");
        return customerService.add(customerinfo);
    }

    @RequestMapping("bypwd")
    @ResponseBody
    public Integer bypwd(String customertel, String customeremail, String customerpwd, HttpSession session){
        Customerinfo bypwd = customerService.bypwd(customertel, customeremail, customerpwd);
        if(null != bypwd){
            session.setAttribute("cus",bypwd);
            return 1;
        }
        return 0;
    }

    @RequestMapping("editFile")
    @ResponseBody
    public Object editFile(@RequestParam("file") MultipartFile file,Integer customerid){
        Customerinfo customerinfo = new Customerinfo();
        customerinfo.setCustomerid(customerid);
        //文件原名称
        String filename = file.getOriginalFilename();
        //文件新名称
        String newFilename = UUID.randomUUID().toString().replace("-","")+"."+ FilenameUtils.getExtension(filename);
        try {
            //获取图片的绝对路径
            String s = ResourceUtils.getURL("classpath:").getPath() + "/static/images";
            System.out.println("绝对路径:"+s);
            //获取存放图片的相对路径
            String news = "/static/images/" +newFilename;
            customerinfo.setCustomerpic(news);
            File fileDir = new File(s);
            System.out.println("我为创建文件夹"+fileDir);
            if (!fileDir.exists()){
                System.out.println("我进来了");
                //创建目录(多级)
                fileDir.mkdirs();
            }
            file.transferTo(new File(fileDir,newFilename));

        }catch (Exception e){
            e.printStackTrace();
        }
        return customerService.editFile(customerinfo);
    }

}
