package amalysheva;

import java.io.File;

public final class Values {
    public static final File HTML_PAGE_GET = new File("C:\\Users\\real_\\IdeaProjects\\raw_web_server\\src\\main\\resources\\", "page1.html");
    public static final File HTML_PAGE_POST = new File("C:\\Users\\real_\\IdeaProjects\\raw_web_server\\src\\main\\resources\\", "playlist.html");
    public static final File STYLE_CSS_PAGE = new File("C:\\Users\\real_\\IdeaProjects\\raw_web_server\\src\\main\\resources\\", "style.css");

    public static final String PROTOCOL_VERSION = "HTTP/1.1";
    public static final String TEXT_CONTENT_TYPE = "Content-Type: text/html";
    public static final String CONNECTION_STATUS = "Connection: close";
    public static final String DELIMITER = " ";

    public static final String STATUS_CODE_OK = "200";
    public static final String STATUS_CODE_REDIRECTING = "300";
    public static final String STATUS_CODE_CLIENT_ERROR = "400";
    public static final String STATUS_CODE_SERVER_ERROR = "500";
}
