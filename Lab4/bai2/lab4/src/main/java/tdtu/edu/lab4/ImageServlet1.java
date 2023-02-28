package tdtu.edu.lab4;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImageServlet1 extends HttpServlet {

    public void doGet(HttpServletRequest reqest, HttpServletResponse response) throws IOException, ServletException {
        String filePath = getServletContext().getRealPath("/images/meo1.jpg");
        File imageFile = new File(filePath);

        response.setContentType("image/jpg");
        response.setContentLength((int) imageFile.length());
        response.setHeader("Content-Disposition", "inline; filename=meo1.jpg");

        FileInputStream in = new FileInputStream(imageFile);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int numRead = 0;
        while ((numRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, numRead);
        }
        in.close();
        out.close();
    }
}
