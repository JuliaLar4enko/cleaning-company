package by.larchanka.tiptopcleaning.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class UploadFileHelper {

    /**
     * Loads image into tomcat package
     *
     * @param request a {@code HttpServletRequest} object to get parameters from
     * @return {@code Optional<String>} object containing image name
     */
    public Optional<String> uploadFile(HttpServletRequest request) {
        String root = request.getServletContext().getRealPath("/");
        String uploadPath = root + "img" + File.separator + "items";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        Optional<String> imageNameOptional;
        try {
            Part filePart = request.getPart("image");
            imageNameOptional = getFileName(filePart);

            String imageName = null;
            if (imageNameOptional.isPresent()) {
                imageName = imageNameOptional.get();
            }

            filePart.write(uploadPath + File.separator + imageName);
        } catch (IOException | ServletException e) {
            return Optional.empty();
        }

        return imageNameOptional;
    }

    /**
     * Gets file name from request part
     *
     * @param part a {@code Part} object to get image name from
     * @return {@code Optional<String>} object containing image name
     */
    private Optional<String> getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                String imageName = content.substring(content.lastIndexOf('=') + 2, content.length() - 1);
                return Optional.of(imageName);
            }
        }
        return Optional.empty();
    }
}
