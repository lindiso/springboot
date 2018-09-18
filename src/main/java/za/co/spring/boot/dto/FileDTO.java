package za.co.spring.boot.dto;

public class FileDTO {
    private String dir;
    private String path;
    private long fileSize;

    public FileDTO() {
    }

    public FileDTO(String dir, String path, long fileSize) {
        this.dir = dir;
        this.path = path;
        this.fileSize = fileSize;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "dir='" + dir + '\'' +
                ", path='" + path + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
