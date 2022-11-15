/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.c.idcard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author asus
 */
@Controller
public class controller {
    @ResponseBody
    @RequestMapping ("/getData")
    public String getDate(@RequestParam("nama")String text,
                          @RequestParam("image")MultipartFile file,
                          @RequestParam("tanggal")@DateTimeFormat(pattern="yyyy-MM-dd")Date date)
                          throws IOException{ 
        SimpleDateFormat tanggal = new SimpleDateFormat("EE, dd MMMM yyyy");
        String newTanggal = tanggal.format(date);
        
        String blob = Base64.encodeBase64String(file.getBytes());
        
       return "<fieldset><div align=center>ID CARD</div><hr>"+text+"<br><img width=100 src='data:image/jpeg;base64,"+blob+"'/><br>"+newTanggal+"</fieldset>";
    }
}
