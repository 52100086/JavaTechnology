package tdtu.edu.lab4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String fileName = request.getParameter("file");

        if (fileName == null || fileName.equals("")) {
            response.setContentType("text/plain");
            response.getWriter().write("File not found");
            return;
        }

        File file = new File(getServletContext().getRealPath("/") + "files/" + fileName);

        if (!file.exists()) {
            response.setContentType("text/plain");
            response.getWriter().write("File not found");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        FileInputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();

    }
}
