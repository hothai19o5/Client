package model;

import io.socket.client.Socket;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Model_File_Sender {
    private Model_Send_Message message;
    private int fileID;
    private String fileExtension;   // Phần mở rộng của file
    private File file;
    private long fileSize;    
    //RandomAccessFile được sử dụng để đọc và ghi dữ liệu từ và đến một tập tin theo cách không tuần tự
    private RandomAccessFile accessFile;   
    private Socket socket;

    public Model_File_Sender() {
    }

    public Model_File_Sender(Model_Send_Message message, File file, Socket socket) throws IOException{
        this.message = message;
        this.file = file;
        // RandomAccessFile đặt ở chế độ mở file chỉ đọc
        this.accessFile = new RandomAccessFile(file, "r");
        this.fileExtension = getExtension(file.getAbsolutePath().toLowerCase());
        this.fileSize = accessFile.length();
        this.socket = socket;
    }
    
    private String getExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }
    
    public Model_Send_Message getModel_Send_Message() {
        return message;
    }

    public void setModel_Send_Message(Model_Send_Message message) {
        this.message = message;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public RandomAccessFile getAccessFile() {
        return accessFile;
    }

    public void setAccessFile(RandomAccessFile accessFile) {
        this.accessFile = accessFile;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
