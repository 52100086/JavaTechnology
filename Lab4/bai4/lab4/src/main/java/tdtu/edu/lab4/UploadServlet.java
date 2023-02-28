package tdtu.edu.lab4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class UploadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            String name = request.getParameter("name");
            Part part = request.getPart("image");

            String realpath = request.getServletContext().getRealPath("/uploads");
            String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

            if(!Files.exists(Paths.get(realpath))){
                Files.createDirectory(Paths.get(realpath));
            }
            part.write(realpath + "/" + filename);
            PrintWriter out = response.getWriter();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}